package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		// TODO - START
		
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] bytes = RPCUtils.marshallString(message);
		byte[] newbytes = rpcclient.call((byte)Common.WRITE_RPCID, bytes);
		String result = RPCUtils.unmarshallString(bytes);

		// TODO - END
		
	}
}
