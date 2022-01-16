package com.psp.ejercicio2;

public class EjemploRunnable implements Runnable {	
	public static void main(String[] args) {
		EjemploRunnable runnable = new EjemploRunnable();
		
		Thread hilo1 = new Thread(runnable, "Blanco");
		Thread hilo2 = new Thread(runnable, "Negro");
		hilo1.start();
		hilo2.start();
	}
	
	@Override
	public void run() {
		System.out.println("Nombre del hilo: " + Thread.currentThread().getName()+ "; ID: "+Thread.currentThread().getId());
	}
}
