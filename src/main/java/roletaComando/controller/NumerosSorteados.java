package roletaComando.controller;

public class NumerosSorteados {

	private String numeros = "";

	// funcao para monitorar os sorteios
	public void monitoraSorteios(int numeroSorteado) {
		try {

			this.numeros += String.valueOf(numeroSorteado);

			System.out.println(this.numeros);

			if (numeroSorteado == 0) {

				System.out.println(this.numeros + " saida");

				this.numeros = "";
			} else {

				this.numeros += ",";
			}
		} catch (Exception e) {
			System.out.println("Erro monitoraSorteios");
		}

	}

}
