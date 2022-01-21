package com.psp.ejercicio6;

import java.util.List;

public class DeterminaPar implements Runnable{
	private final List<Integer> listaPares;
	
	public DeterminaPar(List<Integer> listaParesCompartida) {
		this.listaPares = listaParesCompartida;
	}

	@Override
	public void run() {	
		for (int i = 1; i <= 1000; i++) { 
			esPar(i);
		}
	}
	
	private void esPar(int num) {
	      synchronized (listaPares) {
	         if (num % 2 == 0) {
	        	System.out.println(num +" es par");
	        	listaPares.add(num);
	        	listaPares.notifyAll();
	         }
	      }
	   }
}
