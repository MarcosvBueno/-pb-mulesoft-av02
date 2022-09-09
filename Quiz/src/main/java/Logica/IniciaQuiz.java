package Logica;



import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import Controller.QuestaoController;
import Modelo.Questao;
import Modelo.Resultado;
import Util.EntradaMenu;
import dao.QuestaoDAO;
import dao.ResultadoDAO;

public class IniciaQuiz {

public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	EntradaMenu entradaMenu = new EntradaMenu();
	Resultado resultado = new Resultado();
	ResultadoDAO resultadoDao = new ResultadoDAO(); 
 
	int opcao = 0;
	do {
		System.out.println("  ************************************** ");
		System.out.println("|                                        |");
		System.out.println("|          Seja bem vindo ao Quiz:       |");
		System.out.println("|         Conhecimentos Artisticos!      |");
		System.out.println("|                                        |");
		System.out.println("  ************************************** ");
		System.out.println("");
		
		System.out.println("                    MENU:");
		System.out.println("\n");
		System.out.println(" 1 - Jogar novamente");
		System.out.println(" 2 - Ver placar");
		System.out.println(" 0 - Sair\n");
		System.out.println("Qual opção deseja escolher:");
		opcao = entradaMenu.lerMenu();
		
		if(opcao == 1 ) {
			System.out.println("Digite o seu nome de jogador : ");
			
			String nome = sc.nextLine();
			resultado.setJogador(nome);	
			
			System.out.println("Olá " + resultado.getJogador() + ", vamos iniciar o Quiz...");
			resultado.setAcertos(0l);
			resultado.setErros(0l);
			
			QuestaoDAO questaoDao = new QuestaoDAO();
			List<Questao> ListarQuestoesAtivas = questaoDao.ListarQuestoesAtivas();
			
			ListarQuestoesAtivas.forEach(q -> {
				System.out.println(q.getPergunta());
				System.out.println("Insira sua Resposta :");
				String resposta = entradaMenu.lerResposta();
				boolean converte;
				
				if("verdadeiro".equals(resposta)) {
					converte = true;
				}else {
					converte = false;
				}
				
				
				if(converte == q.isVerdadeira()) {
					resultado.setAcertos(resultado.getAcertos() + 1l);
					resultado.Correto();
				}else {
					resultado.setErros(resultado.getErros() + 1l);
					resultado.Errado();
				}
			});
			resultadoDao.CadastraRespostaNoBanco(resultado);
			questaoDao.fechaGerenciador();
			
			resultado.MostraResultados();
			System.out.println("JOGADOR: " + resultado.getJogador() + "  ACERTOS: " + resultado.getAcertos() + " ERROS: " + resultado.getErros() );
		}
		
		
		if(opcao == 2) {
			List<Resultado> listaResultado = resultadoDao.resultadoPlacar();
			System.out.println("");
			System.out.println("PLACAR :");
            listaResultado.forEach(System.out::println);
            System.out.println("");
        }
    
		
			
	}while (opcao != 0);
	resultadoDao.fechaGerenciador();
	}
}
	



