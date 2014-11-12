package com.gmv.siec;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WieleWatkowNaSerwerze {

	public static void main(String[] args) {
		try {
			int i =1;
			ServerSocket server = new ServerSocket(8080);
			while(true){

				Socket s = server.accept();
				Runnable r = new ThreadEchoHandler(s,i);
				Thread t = new Thread(r);
				System.out.println("Polaczenie nr: " + i);
				t.start();
				i++;
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
