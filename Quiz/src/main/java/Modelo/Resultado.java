package Modelo;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "resultados")
public class Resultado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String jogador;
	private Long acertos;
	private Long erros;
	private Date dataPartida = Date.valueOf(LocalDate.now());
	
	

	
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	
	public Long getAcertos() {
		return acertos;
	}
	public void setAcertos(Long acertos) {
		this.acertos = acertos;
	}
	public Long getErros() {
		return erros;
	}
	public void setErros(Long erros) {
		this.erros = erros;
	}
	
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
		
	
	public void Errado() {
		System.out.println("");
		 System.out.println("Infelizmente, você errou.");
		 System.out.println("");
	}
	public void Correto() {
		System.out.println("");
		System.out.println("Parabéns, você acertou!!!.");
		System.out.println("");
	}
	
	public void MostraResultados() {
		System.out.println("");
		System.out.println("FIM DE JOGO !");
		System.out.println("");
		System.out.println("RESULTADOS:");
		System.out.println("");
		

	}
	
	public String toString() {
		return "JOGADOR: " + this.getJogador() + "    ACERTOS:" +this.getAcertos() + "   DATA:" + this.getDataPartida();
	}

		
}

