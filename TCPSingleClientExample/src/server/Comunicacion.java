package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable {
	
	private Socket s;
	private ServerSocket ss;	
	private InputStream entrada;
	private OutputStream salida;
	
	public Comunicacion(int port) {		
		try {
			ss = new ServerSocket(port);
			s = ss.accept();
			entrada = s.getInputStream();
			salida = s.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void run() {		
		try {
			recibir();
			Thread.sleep(1000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	private void recibir() throws IOException {
		byte[] buf = new byte[128];
		entrada.read(buf);
		setChanged();
		notifyObservers(new String(buf).trim());
		clearChanged();
	}
	
	public void enviar(String mensaje){
		try {
			salida.write(mensaje.getBytes());
			salida.flush();
			System.out.println("Se env�a: " + mensaje);
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}
}
