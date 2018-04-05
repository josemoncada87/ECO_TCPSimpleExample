package server;

import java.util.Observable;
import java.util.Observer;

public class Logica implements Observer, Runnable{
	
	private Comunicacion com;
	
	public Logica() {
		com = new Comunicacion(5000);
		com.addObserver(this);	
		
		Thread t = new Thread(com);
		t.start();
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
	
	@Override
	public void update(Observable quien, Object que) {
		System.out.println("llegó un nuevo mensaje..." + (String)que);
		com.enviar("respuesta ..." + (String)que);		
	}
	
}
