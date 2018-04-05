package server;

public class MainSingleClientTCP_Server  {	
	
	static Logica app;
	
	public static void main(String[] args) {
		System.out.println("[Iniciando Servidor...");		
		
		app = new Logica();		
		Thread t = new Thread(app);
		t.start();
		
		System.out.println("...Servidor Iniciado]");
	}
	
	
}
