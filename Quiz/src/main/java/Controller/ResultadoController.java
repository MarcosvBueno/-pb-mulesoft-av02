package Controller;

import java.util.List;

import javax.persistence.EntityManager;

import Modelo.Resultado;


public class ResultadoController {

	
	public void CadastraNoBancoDeDados(EntityManager em, Resultado resultado) {
		em.getTransaction().begin();
		em.persist(resultado);
		em.getTransaction().commit();
		
	}
	
	public  List<Resultado>  listarResultadoPlacar(EntityManager em){
	    String jpql = "Select r from Resultado r order by r.acertos desc";
		return em.createQuery(jpql, Resultado.class)
                .getResultList();
	}
	
	public void fechaGerenciador(EntityManager em) {
		em.close();
	}
}