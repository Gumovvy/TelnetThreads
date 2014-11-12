package com.gmv.siec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestKlienta {

	public static void main(String[] args) {

		try {
			ServerSocket s = new ServerSocket(8081);
			Socket incoming = s.accept();

			try {
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();

				Scanner skaner = new Scanner(inStream);
				PrintWriter pw = new PrintWriter(outStream, true);
				pw.println("WItam na serwerze.");
				pw.println("Jesli chcesz wyjsc wpisz BYE.");
				boolean done = false;

				while (!done && skaner.hasNextLine()) {
					String line = skaner.nextLine();
					pw.println("Echo: " + line);
					if (line.trim().equals("BYE")) {
						done = true;
					}

				}

			} finally {

				incoming.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
