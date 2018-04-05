package client;

import java.util.Observable;
import java.util.Observer;

public class Logica implements Observer, Runnable{
	
	private Comunicacion com;
	
	public Logica() {
		
		com = new Comunicacion("127.0.0.1", 5000);		
		com.addObserver(this);		
		
		Thread t = new Thread(com);
		t.start();
		
		com.enviar("cliente saluda a servidor");
	}	

	@Override
	public void update(Observable o, Object arg) {		
		System.out.println("Mensaje recibido en cliente: " + (String)arg);
	}

	@Override
	public void run() {
		while(true){
			try {
				/***
				 * Si la logica manera otros proceso, interfaz de usuario comunicacion
				 * con Arduino, BT o similar se puede gestionar desde este punto. 
				 */
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}		
	}
}
