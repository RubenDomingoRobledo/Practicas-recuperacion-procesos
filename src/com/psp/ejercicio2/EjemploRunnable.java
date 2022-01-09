package com.psp.ejercicio2;

public class EjemploRunnable implements Runnable {
	String nombre;

	EjemploRunnable(String nombre){
        this.nombre=nombre;
    }
	
	public static void main(String[] args) {
		EjemploRunnable hilo1 = new EjemploRunnable("hiloPrimero");
		EjemploRunnable hilo2 = new EjemploRunnable("hiloSegundo");
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName()+ Thread.currentThread().getId());
			try {
				Thread.sleep((long)(Math.random() * 1000));
			}
			catch (InterruptedException e){}
		}
	}
}
