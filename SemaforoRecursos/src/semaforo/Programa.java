package semaforo;

public class Programa {

	public static void main(String[] args) {
		// Ejecuci�n del sem�foro
		new Liberador();
		new ReservaUnidades();
	}

}
