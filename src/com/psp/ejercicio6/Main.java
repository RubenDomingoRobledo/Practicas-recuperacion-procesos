package com.psp.ejercicio6;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	 public static void main(String[] args) {
	      VariableCompartida variableCompartida = new VariableCompartida();

	      AtomicInteger numeroDeProductoresCorriendo = new AtomicInteger(0);

	      // a los productores y consumidores les pasamos la misma referencia al objeto variables compartida
	      // todos modificaran los valores de la misma instancia variableCompartida
	      Producer p1 = new Producer(variableCompartida, 1, 1000, numeroDeProductoresCorriendo);
	      Producer p2 = new Producer(variableCompartida, 1001, 2000, numeroDeProductoresCorriendo);

	      Consumer c1 = new Consumer(variableCompartida, numeroDeProductoresCorriendo);
	      Consumer c2 = new Consumer(variableCompartida, numeroDeProductoresCorriendo);

	      p1.start();
	      p2.start();
	      c1.start();
	      c2.start();

	   }
}
