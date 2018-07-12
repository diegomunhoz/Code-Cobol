package modelos;

import java.util.ArrayList;
import java.util.List;

import perfis.PerfilBradesco;
import util.UtilProjeto;

public class DataDivision {

	private List<String> linhaData = new ArrayList<String>();

	private PerfilBradesco perfil = new PerfilBradesco();
	private UtilProjeto objUtil = new UtilProjeto();

	private String linhaAux;
	private String nomeBookEnvio;
	private String nomeBookTag;
	private String nomePrograma;
	private String nomeArquivoCip;
	private String spaces;
	private int tamanhoFD;
	
	private int lreclArquivoEnvio;
	private int tamanhoLinhaAux;

	public List<String> getLinhaData() {
		return linhaData;
	}

	public void gerarDataDivision(String programa, String book1, String book2,
			String arquivoCip, int tamanhoArquivo, int tamanhoFD) {

		this.nomeBookEnvio = book1;
		this.nomeBookTag = book2;
		this.nomePrograma = programa;
		this.nomeArquivoCip = arquivoCip;
		this.lreclArquivoEnvio = tamanhoArquivo;
		this.tamanhoFD = tamanhoFD;

		this.linhaData
				.add("      *================================================================*");
		this.linhaData.add("       DATA                            DIVISION.");
		this.linhaData
				.add("      *================================================================*");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add("       FILE                            SECTION.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("      *    INPUT  :  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX      *");

		this.linhaAux = "      *              ORG. SEQUENCIAL   -   LRECL = " + this.lreclArquivoEnvio;
		this.tamanhoLinhaAux = this.linhaAux.length();
		
		this.tamanhoLinhaAux = (this.perfil.coluna72 - this.tamanhoLinhaAux) - 1;
		this.spaces = this.objUtil.getEspacos(this.tamanhoLinhaAux);
		this.linhaAux = this.linhaAux + this.spaces+ "*";
		
		this.linhaData.add(this.linhaAux);

		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       FD  EARQSEQ");
		this.linhaData.add("           RECORDING MODE IS F");
		this.linhaData.add("           LABEL RECORD   IS STANDARD");
		this.linhaData.add("           BLOCK CONTAINS  0 RECORDS.");
		this.linhaData.add(" ");
		this.linhaData
				.add("       01  FD-EARQSEQ                  PIC  X("+ this.lreclArquivoEnvio + ").");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add("      *    OUTPUT :  ARQUIVO DE ENVIO "
				+ this.nomeArquivoCip + "                          *");
		this.linhaData
				.add("      *              ORG. SEQUENCIAL   -   XML                         *");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       FD  SARQXML");
		this.linhaData.add("           RECORDING MODE IS V");
		this.linhaData.add("           LABEL RECORD   IS STANDARD");
		this.linhaData.add("           BLOCK CONTAINS  0 RECORDS.");
		this.linhaData.add(" ");

		for (int j = 1; j <= this.tamanhoFD ; j++) {
			if (j < 10) {
				this.linhaData.add("       01  FD-SARQXML-00" + j
						+ "              PIC  N(00" + j + ")  USAGE NATIONAL.");
			} else if (j < 100) {
				this.linhaData.add("       01  FD-SARQXML-0" + j
						+ "              PIC  N(0" + j + ")  USAGE NATIONAL.");
			} else {
				this.linhaData.add("       01  FD-SARQXML-" + j
						+ "              PIC  N(" + j + ")  USAGE NATIONAL.");
			}
		}

		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("      *    OUTPUT :  ARQUIVO PARA GERACAO DO RELATORIO DE CONTROLE     *");
		this.linhaData
				.add("      *              ORG. SEQUENCIAL   -   LRECL = 080                 *");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       FD  SRELCTRL");
		this.linhaData.add("           RECORDING MODE IS F");
		this.linhaData.add("           LABEL RECORD   IS STANDARD");
		this.linhaData.add("           BLOCK CONTAINS  0 RECORDS.");
		this.linhaData.add(" ");
		this.linhaData
				.add("       01  FD-SRELCTRL                 PIC  X(080).");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add("       WORKING-STORAGE                 SECTION.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       77  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** INICIO DA WORKING - "
				+ this.nomePrograma + " ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       77  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** AREA DE ACUMULADORES ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData
				.add("       77  ACU-LIDOS-EARQSEQ           PIC  9(009) COMP-3  VALUE ZEROS.");
		this.linhaData
				.add("       77  ACU-GRAVA-SARQXML           PIC  9(009) COMP-3  VALUE ZEROS.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       77  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** AREA DE FILE-STATUS ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData
				.add("       77  WRK-FS-EARQSEQ              PIC  X(002)         VALUE SPACES.");
		this.linhaData
				.add("       77  WRK-FS-SARQXML              PIC  X(002)         VALUE SPACES.");
		this.linhaData
				.add("       77  WRK-FS-SRELCTRL             PIC  X(002)         VALUE SPACES.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       77  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** AREA VARIAVEIS AUXILIARES ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData
				.add("       77  WRK-PROGRAMA                PIC  X(008)         VALUE SPACES.");
		this.linhaData
				.add("       77  WRK-BATCH                   PIC  X(008)         VALUE");
		this.linhaData.add("           'BATCH'.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData
				.add("           '*** AREA DE FLAGS PARA CONTROLE DE GRAVACAO ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData
				.add("       01  WRK-ABERTURA                PIC  X(013)         VALUE");
		this.linhaData.add("           ' NA ABERTURA'.");
		this.linhaData
				.add("       01  WRK-LEITURA                 PIC  X(013)         VALUE");
		this.linhaData.add("           ' NA  LEITURA'.");
		this.linhaData
				.add("       01  WRK-GRAVACAO                PIC  X(013)         VALUE");
		this.linhaData.add("           ' NA GRAVACAO'.");
		this.linhaData
				.add("       01  WRK-FECHAMENTO              PIC  X(013)         VALUE");
		this.linhaData.add("           'NO FECHAMENTO'.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData
				.add("           '*** AUXILIAR PARA ERROS DE FILE-STATUS ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-MSG-FS-ERRO.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(009)         VALUE");
		this.linhaData.add("               '*** ERRO '.");
		this.linhaData
				.add("           05  WRK-OPERACAO            PIC  X(013)         VALUE SPACES.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(012)         VALUE");
		this.linhaData.add("               ' DO ARQUIVO '.");
		this.linhaData
				.add("           05  WRK-NOME-ARQ            PIC  X(008)         VALUE SPACES.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(017)         VALUE");
		this.linhaData.add("               ' - FILE-STATUS = '.");
		this.linhaData
				.add("           05  WRK-FILE-STATUS         PIC  X(002)         VALUE SPACES.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(004)         VALUE ' ***'.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** LAYOUT DO SRELCTRL ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-CABEC1.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE '1'.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(015)         VALUE");
		this.linhaData.add("               'BRADESCO'.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(054)         VALUE");
		this.linhaData
				.add("               '           SCC3 - CONTROLE XML CIP (C3)         '.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(010)         VALUE");
		this.linhaData.add("               'FOL. UNICA'.");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-CABEC2.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE ' '.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(010)         VALUE");
		this.linhaData.add("               'SCC36001'.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(059)         VALUE SPACES.");
		this.linhaData
				.add("           05  CB2-DIA                 PIC  9(002)         VALUE ZEROS.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE '/'.");
		this.linhaData
				.add("           05  CB2-MES                 PIC  9(002)         VALUE ZEROS.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE '/'.");
		this.linhaData
				.add("           05  CB2-ANO                 PIC  9(004)         VALUE ZEROS.");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-CABEC3.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE ' '.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(017)         VALUE SPACES.");
		this.linhaData
				.add("           05  CB3-TITULO              PIC  X(044)         VALUE");
		this.linhaData
				.add("               ' ARQUIVO DE CONFIRMACAO DE CESSAO - ACCC600 '.");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-CABEC4.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE '-'.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(029)         VALUE SPACES.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(033)         VALUE");
		this.linhaData.add("               'CONTROLE OPERACIONAL'.");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-LINDET1.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE ' '.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(079)         VALUE SPACES.");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-LINTOT1.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE ' '.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(013)         VALUE SPACES.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(042)         VALUE");
		this.linhaData
				.add("               'TOTAL DE REGISTROS LIDOS (EARQSEQ ).....: '.");
		this.linhaData
				.add("           05  WRK-LT1-LIDOS-EARQSEQ   PIC  ZZZ.ZZZ.ZZ9    VALUE ZEROS.");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-LINTOT2.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(001)         VALUE ' '.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(013)         VALUE SPACES.");
		this.linhaData
				.add("           05  FILLER                  PIC  X(042)         VALUE");
		this.linhaData
				.add("               'TOTAL DE REGISTROS GRAVADOS (SARQXML )..: '.");
		this.linhaData
				.add("           05  WRK-LT2-GRAVA-SARQXML   PIC  ZZZ.ZZZ.ZZ9    VALUE ZEROS.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** AREA DA BRAD7600 ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       01  WRK-DATA-HORA.");
		this.linhaData
				.add("           05  WRK-DATA-JULIANA        PIC  9(005) COMP-3  VALUE ZEROS.");
		this.linhaData
				.add("           05  WRK-DATA-AAMMDD         PIC  9(007) COMP-3  VALUE ZEROS.");
		this.linhaData
				.add("           05  WRK-DATA-AAAAMMDD       PIC  9(009) COMP-3  VALUE ZEROS.");
		this.linhaData
				.add("           05  WRK-HORA-HHMMSS         PIC  9(007) COMP-3  VALUE ZEROS.");
		this.linhaData
				.add("           05  WRK-HORA-HHMMSSMMMMMM   PIC  9(013) COMP-3  VALUE ZEROS.");
		this.linhaData.add("           05  WRK-TIMESTAMP.");
		this.linhaData
				.add("               10  WRK-ANO-7600        PIC  9(004)         VALUE ZEROS.");
		this.linhaData
				.add("               10  WRK-MES-7600        PIC  9(002)         VALUE ZEROS.");
		this.linhaData
				.add("               10  WRK-DIA-7600        PIC  9(002)         VALUE ZEROS.");
		this.linhaData
				.add("               10  WRK-HOR-7600        PIC  9(002)         VALUE ZEROS.");
		this.linhaData
				.add("               10  WRK-MIN-7600        PIC  9(002)         VALUE ZEROS.");
		this.linhaData
				.add("               10  WRK-SEG-7600        PIC  9(002)         VALUE ZEROS.");
		this.linhaData
				.add("               10  WRK-MIL-7600        PIC  9(006)         VALUE ZEROS.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** AREA DA BRAD7100 ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       COPY 'I#BRAD7C'.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** AREA DA BOOK DE TAGS ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       COPY 'SCC3W000'.");
		this.linhaData.add(" ");
		this.linhaData.add("       COPY '" + this.nomeBookTag + "'.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** AREA DA BOOK DOS ARQUIVOS ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
		this.linhaData.add("       COPY '" + this.nomeBookEnvio + "'.");
		this.linhaData.add(" ");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData
				.add("       01  FILLER                      PIC  X(050)         VALUE");
		this.linhaData.add("           '*** FINAL DA WORKING - "
				+ this.nomePrograma + " ***'.");
		this.linhaData
				.add("      *----------------------------------------------------------------*");
		this.linhaData.add(" ");
	}
}