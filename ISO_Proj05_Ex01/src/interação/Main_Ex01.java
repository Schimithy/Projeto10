package interação;

import java.util.concurrent.Semaphore;
import controle.Ex01;

public class Main_Ex01 {
	
	public static void main(String[] args) {
		
		Semaphore semaforoBD = new Semaphore(1);
		for(int i = 1; i <= 21; i++) {
			Thread tTransação = new Ex01(i,semaforoBD);
			tTransação.start();
		}
		
		
	}

}
