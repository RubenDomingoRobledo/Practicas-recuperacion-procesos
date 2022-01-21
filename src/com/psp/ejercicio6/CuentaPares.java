package com.psp.ejercicio6;

import java.util.List;

public class CuentaPares implements Runnable{
	Contador cont = new Contador();
	private final List<Integer> listaPares;
	
	public CuentaPares(List<Integer> listaParesCompartida, Contador cont) {
		this.listaPares = listaParesCompartida;
		this.cont = cont;
	}
	
	@Override
	public void run() {	
		contarPar();
	}
	
	private void contarPar() {
		synchronized (listaPares) {
			while (listaPares.isEmpty()) {
				try {
					listaPares.wait();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
			    }
			}
			for (int i= 0 ; i< listaPares.size(); i++) {
				cont.incrementaPares();
			}
		}
	}
}