package controle;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Ex01 extends Thread {

	int ThreadID;
	Semaphore semaforoBD;
	
	public Ex01(int ThreadID, Semaphore semaforoBD) {
		
		this.ThreadID = ThreadID;
		this.semaforoBD = semaforoBD;
		
	}
	
	public void run() {

		int j = 0;
		if ((ThreadID % 3) == 1) {
			j = 2;
		}else {
			j = 3;
		}
		for (int i = 0; i < j; i++) {
			Calculo();
			try {
				semaforoBD.acquire();
				Transação();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			} finally {
				semaforoBD.release();
			}
		}

	}
	
	private void Calculo() {
		Random rand = new Random();
		int tempo = 0;
		switch (ThreadID % 3) {
		case 1:
			 tempo = rand.nextInt(800 + 1) + 200;
			System.out.println("#" + ThreadID + " » realizando calculo de " + tempo + "milseg.");
			try {
				sleep(tempo);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			break;
		case 2:
			 tempo = rand.nextInt(1000 + 1) + 500;
			System.out.println("#" + ThreadID + " » realizando calculo de " + tempo + "milseg.");
			try {
				sleep(tempo);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		case 0:
			 tempo = rand.nextInt(1000 + 1) + 1000;
			System.out.println("#" + ThreadID + " » realizando calculo de " + tempo + "milseg.");
			try {
				sleep(tempo);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		default:
			break;
		}
	}
	
	private void Transação() {
		int tempo = 0;
		switch (ThreadID % 3) {
		case 1: 
			 tempo = 1000;
				System.out.println("#" + ThreadID + " » realizando transação  em banco de dados de " + (tempo/1000) + "seg.");
				try {
					sleep(tempo);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			break;
		case 2:
			 tempo = 1500;
				System.out.println("#" + ThreadID + " » realizando transação  em banco de dados de " + (tempo/1000) + "seg.");
				try {
					sleep(tempo);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			break;
		case 0:
			 tempo = 1500;
				System.out.println("#" + ThreadID + " » realizando transação  em banco de dados de " + (tempo/1000) + "seg.");
				try {
					sleep(tempo);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			break;
		default:
			break;
		}
	}

}
