package intera��o;

import java.util.concurrent.Semaphore;
import controle.Ex01;

public class Main_Ex01 {
	
	public static void main(String[] args) {
		
		Semaphore semaforoBD = new Semaphore(1);
		for(int i = 1; i <= 21; i++) {
			Thread tTransa��o = new Ex01(i,semaforoBD);
			tTransa��o.start();
		}
		
		
	}

}
