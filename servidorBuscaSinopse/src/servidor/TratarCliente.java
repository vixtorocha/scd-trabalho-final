package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.net.Socket;
import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.concurrent.ExecutionException;

public class TratarCliente implements Runnable {

    private Socket cliente;
    public TratarCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        Scanner ouvirCliente = null;
        try {
            while (true) {
                ouvirCliente = new Scanner(cliente.getInputStream());
                String filme = ouvirCliente.nextLine();
                String resposta = " ";
                System.out.println("Cliente pesquisando o filme: " + filme);
                try{
                    resposta = getResponseFromAPI(filme);
                }
                catch (UncheckedIOException erro){
                    resposta = "Filme não encontrado";
                }

                PrintStream enviarParaCliente = new PrintStream(cliente.getOutputStream());
                enviarParaCliente.println(resposta);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getResponseFromAPI(String movieTitle) throws IOException, ExecutionException, InterruptedException {
        movieTitle = movieTitle.replaceAll("\\s+","+");
        // Cria um client
        var client = HttpClient.newHttpClient();
        // Cria um request na API omdbapi
        var request = HttpRequest.newBuilder(
            URI.create("http://www.omdbapi.com/?i=tt3896198&apikey=180dc1e7&t=" + movieTitle + "&type=movie"))
            .header("accept", "application/json")
            .build();

        // Manda um request no client.
        var responseFuture = client.sendAsync(request, new JsonBodyHandler<>(Filme.class));
        // Pausa até o request concluir.
        var respostaFilme = responseFuture.get().body().get();

        String respostaDoMetodo = "Filme: " + respostaFilme.Title + ". Lançado em: " + respostaFilme.Year + ". Sinopse em inglês: " + respostaFilme.Plot;
        return respostaDoMetodo;
    }
}
