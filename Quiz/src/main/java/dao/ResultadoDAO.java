package dao;

import java.util.List;

import javax.persistence.EntityManager;

import Controller.ResultadoController;
import Modelo.Resultado;
import Util.JPAUtil;

public class ResultadoDAO {
	private EntityManager em = JPAUtil.getEntityManager();
	
	ResultadoController resultadoController = new ResultadoController();

	public ResultadoDAO() {
		
	}
	
	public void CadastraRespostaNoBanco( Resultado resultado) {
		resultadoController.CadastraNoBancoDeDados(em, resultado); 
		
	}
	
	public List<Resultado>  resultadoPlacar(){
		return resultadoController.listarResultadoPlacar(em);
	}
	
	public void fechaGerenciador() {
		em.close();
	}
	

}
