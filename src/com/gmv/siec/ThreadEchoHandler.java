package com.gmv.siec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadEchoHandler implements Runnable {
	private Socket s;
	private int i;

	public ThreadEchoHandler(Socket s, int i) {
		this.s = s;
		this.i = i;
	}

	@Override
	public void run() {
		try {
			try {
				InputStream inStream = s.getInputStream();
				OutputStream outStream = s.getOutputStream();

				Scanner scan = new Scanner(inStream);
				PrintWriter pw = new PrintWriter(outStream, true);
				boolean done = false;
				pw.println("Wpisz BYE zeby wyjsc");
				while (!done && scan.hasNextLine()) {
					String line = scan.nextLine();
					pw.println("Echo: " + line);
					if (line.trim().equals("BYE")) {
						done = true;
					}
				}
			} finally {
				s.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
