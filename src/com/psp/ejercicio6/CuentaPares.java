package com.psp.ejercicio6;

public class CuentaPares implements Runnable{
	Contador cont = new Contador();
	DeterminaPar dp = new DeterminaPar();
	
	public CuentaPares(Contador c) {
		this.cont = c;
	}
	
	@Override
	public void run() {	
		for (int i = 1; i <= 1000; i++) { 
			if (dp.isPar() == true) {
				cont.incrementaPares();
			}
			else if (dp.isPar() == false) {
				try {
					wait();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}