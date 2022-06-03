package roletaComando.controller;

import roletaComando.algoritmos.SequenciaCor;
import roletaComando.algoritmos.Soma;

public class NumerosSorteados {

	private String saidaTelaNumeroSoreados = "";
	

	//algoritmos
	private SequenciaCor sCor;
	private Soma soma;


	public NumerosSorteados() {

	
		this.sCor = new SequenciaCor();
		this.soma = new Soma();
	}

	// funcao para monitorar os sorteios
	public void monitoraSorteios(int numeroSorteado) {

		//saida tela
		//this.saidaTelaNumeroSoreados += String.valueOf(numeroSorteado);
		
		System.out.print(numeroSorteado + ", ");
		
		//this.saidaTelaNumeroSoreados += ", ";

		try {
			
			//chama algoritimos passando o numero
		//	this.sCor.verificaCor(numeroSorteado);

			if (numeroSorteado == 0) {
			
				//this.saidaTelaNumeroSoreados = "";
				System.out.println("");
			} 

				
			

		} catch (Exception e) {
			System.out.println("Erro monitoraSorteios");
		}

	}

}
