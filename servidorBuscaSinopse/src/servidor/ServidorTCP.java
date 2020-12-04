package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Servidor ouvindo a porta 12345");

        Socket cliente;
        while (true) {
            cliente = servidor.accept();

            Thread t = new Thread(new TratarCliente(cliente));
            t.start();
        }
    }
}
