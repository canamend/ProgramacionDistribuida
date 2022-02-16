package ProgramacionDistribuida.Practica2.src;

//package ProgramacionDistribuida.Practica2.src;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Servidor {

	//Crear un socket servidor
	//sino se logra abortar programa
	
	private static ServerSocket creaListenSocket(int serverSockNum){
		ServerSocket server = null;

		try{
    		server = new ServerSocket(serverSockNum);
  		} catch (IOException e) {
   			System.err.println("Problems in port: " + serverSockNum);
   			System.exit(-1);
   		}
   		return server;
  	}

  	//Establecer conexi�n con el servidor y devolver socket
  	//sino se logra abortar programa
  	
	private static Socket creaClientSocket(ServerSocket server){
  		Socket res = null;

  		try {
			res = server.accept();
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}
		return res;
  	}

  	//Devuelve la cantidad de vocales de la frase
	
	



	public static void main(String[] args) throws IOException {
	    int SERVER_PORT = Integer.parseInt(args[0]);
			// El servidor escuchar� peticiones en local
			// en el puerto SERVER_PORT (>= 1024)
		ServerSocket serverSocket = null; 	//para escuchar
		Socket clientSocket = null;       	//uno por cliente

		// Inicializar el socket del cliente con el que se va
		// a comunicar el servidor, es decir se acepta la
		// conexi�n de un cliente al servidor mediante
		// el m�todo accept()
		serverSocket = creaListenSocket(SERVER_PORT);

		// En este ejemplo, s�lo uno. En un caso general
		// un servidor tendr�a esto en un ciclo, creando
		// uno por cada nuevo cliente
		while (true) {
            clientSocket = creaClientSocket(serverSocket);
            // new thread for a client
		 	EchoThread et = new EchoThread(clientSocket, serverSocket);
			et.start();
        }




		// Inicializar los canales de comunicaci�n utilizados en
		// el socket para comunicarse con el cliente.
		// El OutputStream permite enviar mensajes al cliente
		// El InputStream permite recibir mensajes emitidos
		// por el proceso cliente
	}
}

class EchoThread extends Thread {
    protected Socket clientSocket;
    protected ServerSocket serverSocket;

    public EchoThread(Socket clientSocket, ServerSocket serverSocket) {
        this.clientSocket = clientSocket;
        this.serverSocket = serverSocket;
    }

    public void run() {
        PrintWriter salHaciaCliente = null;
		BufferedReader entDesdeCliente = null;

		try{
			salHaciaCliente = new PrintWriter(clientSocket.getOutputStream(), true);
			entDesdeCliente = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		}catch (IOException e) {
   			System.err.println(e);
   			System.exit(-1);
   		}

		// Contar las vocales de las frases enviadas por el cliente
		String inputLine = "";
		try{
			inputLine = entDesdeCliente.readLine();

			while ((inputLine != null) && (!inputLine.equals("END OF SERVICE"))) {
				// Contar la cantidad de vocales que

                int res = 0;
                String fraseMin = inputLine.toLowerCase();

                for (int i = 0; i < fraseMin.length(); ++i) {
                    switch(fraseMin.charAt(i)) {
                        case 'a': //case 'á':
                        case 'e': //case 'é':
                        case 'i': //case 'í':
                        case 'o': //case 'ó':
                        case 'u': //case 'ú':
                            res++;
                            break;
                        default:
                            // se ignoran las dem�s letras
                    }
                }

				String respuesta = "'" + inputLine + "' has " + + res + " vowels";

				// Enviar la respuesta al cliente
				salHaciaCliente.println(respuesta);

				// Recibir nueva petici�n del cliente
				inputLine = entDesdeCliente.readLine();
			}
			// Al cerrar cualquier canal de comunicaci�n
			// utilizado por un socket, �ste se cierra.
			// Para asegurarse que se env�en las respuestas que
			// est�n en el buffer se cierra el OutputStream.
			salHaciaCliente.close();

			// se cierra el socket
			serverSocket.close();
		}catch (IOException e) {
   			System.err.println(e);
   			System.exit(-1);
   		}
    }
}

