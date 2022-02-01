package com.psp.ejercicio10.galletas;

public class ComeGalletas implements Runnable {
	private final BandejaGalletas bandejaGalletas;
	private final String id;

	public ComeGalletas(BandejaGalletas bandejaGalletas, String id) {
		this.bandejaGalletas = bandejaGalletas;
		this.id = id;
	}

	public void run() {

		while(Boolean.TRUE) {
			System.out.println("El pitufo ha comido " + id + " ha comido " + bandejaGalletas.getGalletas());
		}
		
	}
}
