package com.psp.ejercicio9.dalmatas;

import java.util.Random;

public class FugaDalmatas {
	public static void main(String[] args) {
		for(int i = 1;i<=20;i++) {
			Thread t = new Thread(new Dalmata(i));
			t.start();
		}
	}
}
class Dalmata implements Runnable{
	int id;
	public Dalmata(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		Random r = new Random();
		int random = r.nextInt(2);
		System.out.println("El cachorro " + id + " corre");
		if(random == 0) {
			System.out.println("El cachorro " + id + " consigue escapar!");
		} else {
			System.out.println("Cruela de Vil atrapa a " + id );
		}
	}
	
}
