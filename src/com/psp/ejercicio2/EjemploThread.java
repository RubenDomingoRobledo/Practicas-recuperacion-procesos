package com.psp.ejercicio2;

public class EjemploThread extends Thread {	
	public static void main(String[] args) {
		EjemploThread thread = new EjemploThread();
		
		Thread hilo1 = new Thread(thread, "Blanco");
		Thread hilo2 = new Thread(thread, "Negro");
		
		hilo1.start();
		hilo2.start();
	}
	
	@Override
	public void run() {
		System.out.println("Nombre del hilo: " + Thread.currentThread().getName()+ "; ID: "+Thread.currentThread().getId());
	}
}
