package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class buscaFilme {

    public static void main(String[] args) throws  IOException {
        Socket consulta = new Socket("localhost", 12345);
        System.out.println("Servidor ouvindo a porta 12345");

        Scanner leitor = new Scanner(System.in);
        System.out.println("Usuário, digite seu nome!");
        String nome = leitor.nextLine();
        System.out.println("Olá " + nome + "!");

        while (true) {
            System.out.println("Digite um filme a ser pesquisado, lembre-se que o título deve ser em inglês: ");
            String texto = leitor.nextLine();

            PrintStream enviaPerguntaAoServidor = new PrintStream(consulta.getOutputStream());
            enviaPerguntaAoServidor.println(texto);

            Scanner ouvirRespostaDoServidor = new Scanner(consulta.getInputStream());
            String resposta = ouvirRespostaDoServidor.nextLine();

            System.out.println(resposta);
        }
    }
}
