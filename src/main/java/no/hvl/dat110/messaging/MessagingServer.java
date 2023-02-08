package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;
import org.apache.maven.surefire.shared.utils.logging.MessageUtils;

public class MessagingServer {

	// server-side socket for accepting incoming TCP connections
	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public MessageConnection accept() {

		MessageConnection connection = null;

		try {
				Socket connectionSocket = welcomeSocket.accept();
				connection = new MessageConnection(connectionSocket);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		// TODO - START
		// accept TCP connection on welcome socket and create messaging connection to be returned
  //connection = new MessageConnection();

		// TODO - END
		
		return connection;

	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
