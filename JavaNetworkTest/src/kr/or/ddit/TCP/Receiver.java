package kr.or.ddit.TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver extends Thread {

	private DataInputStream dis;

	public Receiver(Socket socket) {

		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (dis != null) {
			try {
				System.out.println(dis.readUTF());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
