package roletaComando.tela;

import java.util.Scanner;

import roletaComando.thread.Blaze;
import roletaComando.thread.Relogio;

public class Tela {
	
	

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		String entrada = "";
		boolean entradaManual = false;
		
		System.out.println("Digite m para entrada manual \nDigite a para entrada site");
		entrada = ler.next();
		
		if(entrada.equals("m")) {
			entradaManual = true;
		}
		
		Relogio relogio = new Relogio();
		relogio.start();
		
		Blaze blaze = new Blaze(entradaManual);
		blaze.start();

	}

}
