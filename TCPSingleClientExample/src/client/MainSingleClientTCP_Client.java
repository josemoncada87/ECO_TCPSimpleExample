package client;

public class MainSingleClientTCP_Client {
	
	static Logica appClient;
	
	public static void main(String[] args) {
		System.out.println("[Iniciando Servidor...");
		
		appClient = new Logica();
		
		Thread t = new Thread(appClient);
		t.start();
		
		System.out.println("...Cliente Iniciado]");
	}
}
