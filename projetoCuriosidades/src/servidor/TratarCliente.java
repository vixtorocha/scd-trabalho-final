package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class TratarCliente implements Runnable {

    private Socket cliente;
    private Map<String, String> curiosidades;
    public TratarCliente(Socket cliente, Map<String, String> curiosidades) {
        this.cliente = cliente;
        this.curiosidades = curiosidades;
    }

    @Override
    public void run() {
        Scanner ouvirCliente = null;
        try {
            while (true) {
                ouvirCliente = new Scanner(cliente.getInputStream());
                String curiosidade = ouvirCliente.nextLine();
                System.out.println("Cliente pesquisando curiosidade sobre: " + curiosidade);
                String resposta = "";

                if (curiosidades.containsKey(curiosidade)) {
                    resposta = curiosidades.get(curiosidade);
                } else {
                    resposta = "Nenhuma curiosidade relevante encontrada!";
                }

                PrintStream enviarParaCliente = new PrintStream(cliente.getOutputStream());
                enviarParaCliente.println(resposta);
            }
            } catch(IOException e){
                e.printStackTrace();
            }

    }
}
