package roletaComando.principal;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import roletaComando.thread.Blaze;
import roletaComando.thread.Relogio;

public class Principal {

	public static EntityManagerFactory factory;

	public Principal() {
		this.iniciaBanco();
	}

	public static void main(String[] args) {

		Relogio relogio = new Relogio();
		relogio.start();

		Blaze blaze = new Blaze();
		blaze.start();

	}

	private void iniciaBanco() {

		try {
			factory = Persistence.createEntityManagerFactory("mariadb");
		} catch (Exception e) {
			System.out.println("Erro ao conectar no banco " + e.getMessage());
			factory.close();
		}

	}

}
