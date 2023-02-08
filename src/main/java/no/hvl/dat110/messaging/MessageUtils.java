package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;

		// TODO - START
		if(message.getData() == null){
			return segment;
		}
		data = message.getData();

		segment = new byte[SEGMENTSIZE];

		byte header = (byte)data.length;

		segment[0] = header;

		for (int i = 0; i < header; i++) {
			segment[i+1] = data[i];
		}
		return segment;
		}

		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer

		// TODO - END



	public static Message decapsulate(byte[] segment) {

		Message message = null;


		int length = segment[0];
		System.out.println(length + "lenght");
		byte[] data = new byte[length];
		// TODO - START
		// decapsulate segment and put received payload data into a message

		for (int i = 0; i < length; i++) {
			data[i] = segment[i+1];
		}

		message = new Message(data);

		// TODO - END
		
		return message;
		
	}
	
}
