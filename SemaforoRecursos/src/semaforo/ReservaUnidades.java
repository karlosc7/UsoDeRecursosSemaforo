package semaforo;

import java.util.Random;

public class ReservaUnidades extends Thread {

	public ReservaUnidades() {
		start();
	}

	private void vaacomsumir() {
		Random rdmNum = new Random();
		int numP = rdmNum.nextInt(4) + 1;
		int sleepTime = rdmNum.nextInt(250 - 25 + 1) + 25;

		try {
			sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(numP + " se requieren para consumir.");
		Buffer.getStore().add(numP);
	}

	public void run() {
		while (true) {
			if (Buffer.getStore().size() == Buffer.bSize)
				System.out.println("Recursos: El buffer está lleno, esperando a que se liberen por el productor.");

			try {
				Buffer.getsNoLleno().acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			vaacomsumir();
			Buffer.getsNoVacio().release();
		}

	}
}
