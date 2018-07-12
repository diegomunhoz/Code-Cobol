package modelos;

import java.util.ArrayList;
import java.util.List;

public class IdentificationDivision {

	private List<String> linhaIdentification = new ArrayList<String>();
	private String dataAtual;
	private String nomePrograma;
	private String nomeBookEnvio;
	private String nomeBookTag;

	public List<String> getLinhaIdentification() {
		return linhaIdentification;
	}

	public void gerarIdentificationDivision(String data, String programa,
			String bookEnvio, String bookTab) {

		this.dataAtual = data.replace('-', '/');
		this.nomePrograma = programa.toUpperCase();
		this.nomeBookEnvio = bookEnvio.toUpperCase();
		this.nomeBookTag = bookTab.toUpperCase();

		this.linhaIdentification
				.add("      *================================================================*");
		this.linhaIdentification
				.add("       IDENTIFICATION                  DIVISION.");
		this.linhaIdentification
				.add("      *================================================================*");
		this.linhaIdentification.add("       PROGRAM-ID. " + this.nomePrograma
				+ ".");
		this.linhaIdentification.add("       AUTHOR.     BSI TECNOLOGIA.");
		this.linhaIdentification
				.add("      *================================================================*");
		this.linhaIdentification
				.add("      *                  B S I  -  T E C N O L O G I A                 *");
		this.linhaIdentification
				.add("      *----------------------------------------------------------------*");
		this.linhaIdentification.add("      *    PROGRAMA....:   "
				+ this.nomePrograma + "                                    *");
		this.linhaIdentification
				.add("      *    PROGRAMADOR.:   BSI TECNOLOGIA - BSI                        *");
		this.linhaIdentification
				.add("      *    ANALISTA....:   BSI TECNOLOGIA - BSI                        *");
		this.linhaIdentification.add("      *    DATA........:   "
				+ this.dataAtual + "                                  *");
		this.linhaIdentification
				.add("      *----------------------------------------------------------------*");
		this.linhaIdentification
				.add("      *    OBJETIVO....:   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   *");
		this.linhaIdentification
				.add("      *----------------------------------------------------------------*");
		this.linhaIdentification
				.add("      *    ARQUIVOS....:                                               *");
		this.linhaIdentification
				.add("      *      DDNAME                                INCLUDE/BOOK        *");
		this.linhaIdentification
				.add("      *    EARQSEQ                                   "
						+ this.nomeBookEnvio + "          *");
		this.linhaIdentification
				.add("      *    SARQXML                                     ----            *");
		this.linhaIdentification
				.add("      *    SRELCTRL                                    ----            *");
		this.linhaIdentification
				.add("      *----------------------------------------------------------------*");
		this.linhaIdentification
				.add("      *    INC'S.......:                                               *");
		this.linhaIdentification.add("      *    " + this.nomeBookEnvio
				+ " - BOOK DO ARQUIVO DE ENTRADA                       *");
		this.linhaIdentification.add("      *    " + this.nomeBookTag
				+ " - BOOK DE TAG'S DE ENVIO E RETORNO                 *");
		this.linhaIdentification
				.add("      *    I#BRAD7C - BOOK DE COMUNICACAO COM O MODULO BRAD7100        *");
		this.linhaIdentification
				.add("      *----------------------------------------------------------------*");
		this.linhaIdentification
				.add("      *    MODULOS.....:                                               *");
		this.linhaIdentification
				.add("      *    BRAD7100 - MODULO PARA TRATAMENTO DE ERROS                  *");
		this.linhaIdentification
				.add("      *    BRAD7600 - MODULO PARA OBTER DATA E HORA DO SISTEMA         *");
		this.linhaIdentification
				.add("      *================================================================*");
		this.linhaIdentification.add("");

	}

}
