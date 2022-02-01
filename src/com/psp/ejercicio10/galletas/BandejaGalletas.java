
package com.psp.ejercicio10.galletas;

public class BandejaGalletas {
	private int numeroGalletas;
	private boolean bandejaLlena = Boolean.FALSE;

	public synchronized int getGalletas() {

		while(!bandejaLlena) {
			try {
				wait();
			} catch (Exception e) {
				
			}
		}
		bandejaLlena = false;
		notify();
		return numeroGalletas;
	}

	public synchronized void putGalletas(int value) {

		while(bandejaLlena) {
			try {
				wait();
			} catch(Exception e) {
				
			}			
		}
		numeroGalletas = value;
		bandejaLlena = true;
		notify();
	}
}
