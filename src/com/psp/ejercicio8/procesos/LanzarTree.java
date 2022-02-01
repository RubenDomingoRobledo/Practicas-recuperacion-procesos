package com.psp.ejercicio8.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzarTree {
	public static void main(String[] args) {
		String[] comando = {"cmd.exe","/c","tree C:\\Users\\rubir"};
		ProcessBuilder pb = new ProcessBuilder(comando);
		File directorio = new File(System.getProperty("user.home"));
		pb.directory(directorio);
		Process p = null ;
		try {
			p = pb.start();
			BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea = null;
			while((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			
			lector.close();
		} catch (IOException e) {
			System.out.println("Error de entrada o de salida");
			System.out.println("Valor de salida del proceso : " + p.exitValue());
		}
		System.out.println("Valor de salida del proceso : " + p.exitValue());
		
	}
}
