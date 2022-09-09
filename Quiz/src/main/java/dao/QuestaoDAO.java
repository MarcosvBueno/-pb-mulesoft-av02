package dao;

import java.util.List;

import javax.persistence.EntityManager;

import Controller.QuestaoController;
import Modelo.Questao;
import Util.JPAUtil;

public class QuestaoDAO {
	private EntityManager em = JPAUtil.getEntityManager();
	
	QuestaoController questaoController = new QuestaoController();

	public QuestaoDAO() {
		
	}
	
	
	public List<Questao> ListarQuestoesAtivas () {
		return questaoController.ListarQuestoesAtivas(em);
	}
	
	public void fechaGerenciador() {
		em.close();
	}
	
}
