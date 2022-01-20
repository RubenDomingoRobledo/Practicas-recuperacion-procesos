package com.psp.ejercicio6;

public class DeterminaPar implements Runnable{
	boolean par;
	
	public boolean isPar() {
		return par;
	}

	@Override
	public void run() {	
		for (int i = 1; i <= 1000; i++) { 
			if (i % 2 == 0) {
				System.out.println(i +" es par");
				par = true;
			}
			else {
				par = false;
			}
		}
	}
}
