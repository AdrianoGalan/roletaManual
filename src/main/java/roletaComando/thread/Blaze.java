package roletaComando.thread;

import java.util.Scanner;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import roletaComando.controller.NumerosSorteados;

public class Blaze extends Thread {

	private Scanner ler = new Scanner(System.in);

	private boolean primeiraBolaBranca = true;
	private NumerosSorteados ns;
	

	public Blaze() {
		this.ns = new NumerosSorteados();
	}

	@Override
	public void run() {

		try {

				this.monitoraNumeros();
		
		} catch (Exception e) {

		}

	}


	private void monitoraNumeros() {

		try {

			try (Playwright playwright = Playwright.create()) {
				Browser browser = playwright.chromium()
						.launch(new BrowserType.LaunchOptions().setHeadless(true).setSlowMo(50));
				Page page = browser.newPage();

				System.out.println("Conectando ao site ...");

				page.navigate("https://blaze.com/pt/games/double");

				String saida = "";
				int numeroSorteado;

				System.out.println("Esperando primeira bola ");

				while (true) {

					try {

						saida = page.locator("#roulette-timer > div.time-left").textContent();

					} catch (Exception e) {
						System.out.println("erro");
					}

					if (saida.contains("Girou")) {

						if (saida.length() == 15) {
							saida = saida.substring(12, 14);
						} else {
							saida = saida.substring(12, 13);
						}

						numeroSorteado = Integer.parseInt(saida);

						if (this.primeiraBolaBranca) {

							this.ns.monitoraSorteios(numeroSorteado);

						} else {

							if (numeroSorteado == 0) {
								this.primeiraBolaBranca = true;
							}

							System.out.println("Esperando primeira numero 0 ...Numero sorteado = " + numeroSorteado);
						}

						page.waitForTimeout(9000);
					}

					page.waitForTimeout(2000);

				}

			}

		} catch (Exception e) {
			System.out.println("Erro moniorar numero " + e.getMessage());
		}

	}

}
