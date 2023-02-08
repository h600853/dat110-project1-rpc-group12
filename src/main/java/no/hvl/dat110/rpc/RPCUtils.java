package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.MessageUtils;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {

		byte[] rpcmsg = null;

		if(payload == null){
			rpcmsg = new byte[1];
			rpcmsg[0] = rpcid;
			return rpcmsg;
		}
		rpcmsg = new byte[payload.length+1];
		
		// TODO - START
		
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		
	rpcmsg[0] = rpcid;
		for (int i = 0; i < payload.length ; i++) {
			rpcmsg[i+1] = payload[i];
		}
		// TODO - END
		
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] payload = new byte[rpcmsg.length-1];
		// TODO - START
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		for (int i = 0; i < payload.length; i++) {
			payload[i] = rpcmsg[i+1];
		}

		// TODO - END
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		
		byte[] encoded = null;
		
		// TODO - START
		encoded = str.getBytes();
		// TODO - END
		
		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {

		String decoded = null;

		// TODO - START

	decoded = new String(data);
		
		// TODO - END
		
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		

		return null;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		

		
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;
	encoded = Integer.toString(x).getBytes();
		
		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		int decoded = 0;
		
		decoded = Integer.parseInt(new String(data));
		
		return decoded;
		
	}
}
