package semaforo;

public class Programa {

	public static void main(String[] args) {
		// Ejecución del semáforo
		new Liberador();
		new ReservaUnidades();
	}

}
