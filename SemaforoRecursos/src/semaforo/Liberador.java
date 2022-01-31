package semaforo;

import java.util.Random;

public class Liberador extends Thread {
	public Liberador() {
		start();
	}

	@SuppressWarnings("unused")
	private void produce() {

		// Tiempo que tarda en liberar el elemento de manera random
		Random rdmNum = new Random();
		int sleepTime = rdmNum.nextInt(250 - 25 + 1) + 25;

		try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Posici�n elemento consumido
		int consumedNumber = Buffer.getStore().poll();
		System.out.println("Recursos: N�mero " + consumedNumber + " requerido.");
	}

	// Ejecutar sem�foro para liberar cuando tenga reservas nuevas
	public void run() {
		while (true) {
			if (Buffer.getStore().size() == 0) {
				System.out.println("Recursos: El buffer est� vac�o, esperando a que el liberador trabaje.");
			}
			try {
				Buffer.getsNoVacio().acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			reserva();
			Buffer.getsNoLleno().release();
		}
	}

	private void reserva() {
		// TODO Auto-generated method stub

	}

}
