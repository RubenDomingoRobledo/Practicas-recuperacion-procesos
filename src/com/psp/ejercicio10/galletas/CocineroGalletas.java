package com.psp.ejercicio10.galletas;

import java.util.Random;

public class CocineroGalletas implements Runnable {
	private final Random aleatorio;
	private final BandejaGalletas bandejaGalletas;
	private final String id;
	private final int TIEMPOESPERA = 1500;

	public CocineroGalletas(BandejaGalletas bandeja, String id) {
		this.bandejaGalletas = bandeja;
		this.id = id;
		aleatorio = new Random();
	}

	public void run() {
		while (Boolean.TRUE) {
			int numeroGalletas = aleatorio.nextInt(30);
			bandejaGalletas.putGalletas(numeroGalletas);
			System.out.println(id + " cocina " + numeroGalletas + " galletas.");

			try {
				Thread.sleep(TIEMPOESPERA);
			} catch (InterruptedException e) {

			}
		}
	}
}
