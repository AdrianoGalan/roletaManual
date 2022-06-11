package roletaComando.DAO;

import java.util.List;

import javax.persistence.EntityManager;


import roletaComando.model.Sorteio;
import roletaComando.principal.Principal;



public class SorteioDAO {
	
	private EntityManager em;

	public SorteioDAO() {
		em = Principal.factory.createEntityManager();
	}
	
	public List<Sorteio> findAll() {

		try {

			return em.createQuery("from sorteio s").getResultList();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {
			em.close();

		}

		return null;
	}
	
	

}
