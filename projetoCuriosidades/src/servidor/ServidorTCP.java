package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServidorTCP {

    static Map<String, String> curiosidades = new HashMap<String, String>();
    static {
        curiosidades.put("firefox", "O mascote do Mozilla Firefox não é uma raposa, na verdade ele é um panda vermelho");
        curiosidades.put("camera", "A primeira câmera do mundo levou oito horas para tirar uma foto, em 1826");
        curiosidades.put("email", "O e-mail foi criado antes da internet, ele era um programa chamado Mailbox e ficava em computadores do Instituto de Tecnologia de Massachusetts");
        curiosidades.put("site", "A primeira página web do mundo continua intacta no ar desde 1991, trata-se de um sumário apresentando a própria world wide web");
        curiosidades.put("memoria", "Um disco rígido de 5 MB pesava uma tonelada em 1956");
        curiosidades.put("boieng", "Um Boeing 747 levaria 120 bilhões de anos para cruzar a Via Láctea.");
        curiosidades.put("neve", "Cerca de 2/3 dos habitantes da Terra nunca viram neve na vida.");
        curiosidades.put("lua", "As pegadas dos astronautas ainda estão na Lua, por conta da lua não possuir atmosfera");
        curiosidades.put("obra", "A obra de arte mais cara do mundo é Salvator Mundi, de Leonardo da Vinci (1452-1519). Esse quadro foi leiloado em 2017 e arrematado por U$ 450.3 milhões");
        curiosidades.put("despertador", "Na lista das profissões que não existem mais, é a de despertador humano. Essa profissão surgiu na Europa durante a Revolução Industrial. Um das formas de bater na janela do cliente era lançando ervilhas com um canudinho.");
        curiosidades.put("oceano", "O lugar mais profundo dos oceanos é a Fossa das Marianas, localizada no Pacífico Ocidental. O ponto mais profundo da Fossa chega a 11.034 metros.");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Servidor ouvindo a porta 12345");

        Socket cliente;

        while (true) {
            cliente = servidor.accept();

            Thread t = new Thread(new TratarCliente(cliente, curiosidades));
            t.start();
        }
    }
}
