package roletaComando.thread;



public class Relogio extends Thread {


	private int hora = 0;
	private int minuto = 0;
	private int segundo = 0;

	public Relogio() {


	}

	@Override
	public void run() {

		try {

			this.inicio();

		} catch (Exception e) {

		}

	}

	private void inicio() {

		while (true) {
			try {
				segundo += 1;

				if (segundo == 60) {
					segundo = 0;
					minuto += 1;
					if (minuto == 60) {
						minuto = 0;
						hora += 1;
					}
				}

				// saida relogio

				sleep(1000);

			} catch (Exception e) {
				System.out.println("Erro Relogio");
			}

		}

	}

}
