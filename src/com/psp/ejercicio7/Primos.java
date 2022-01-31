package com.psp.ejercicio7;

public class Primos implements Runnable{
	private Contador contador;
	private int x, y, n;

	public Primos(int x, int y, Contador contador) {
		this.x = x;
		this.y = y;
		this.contador= contador;
	}
	
	public void run() {
		for (int i = x; i <= y; i++) {
			if (esPrimo(i) == true) {
				contador.incrementa();
				n++;
			}
		}
		System.out.println(Thread.currentThread().getName() + " ha contado "+ getN()+ " en el intervalo " + x +" - " + y);
	}

	public static boolean esPrimo(int numero) {
		  if (numero == 0 || numero == 1 || numero == 4) {
		    return false;
		  }
		  for (int x = 2; x < numero / 2; x++) {
		    if (numero % x == 0)
		      return false;
		  }
		  return true;
		}
	
	public int getN() {
		return n;
	}
}