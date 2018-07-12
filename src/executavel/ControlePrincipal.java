package executavel;

import io.ArquivoInputCPY;
import io.ArquivoOutput;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelos.ArquivoCblTO;
import modelos.BookTO;
import modelos.DataDivision;
import modelos.EnvironmentDivision;
import modelos.IdentificationDivision;
import modelos.ProcedureDivision;
import modelos.VariavelTO;
import util.Calendario;
import analisadores.AnalisaBook;

public class ControlePrincipal {

    ArquivoOutput out = new ArquivoOutput();
    ArquivoCblTO to = new ArquivoCblTO();
    StringBuffer b = new StringBuffer();
    private List<String> linhaIdentification = new ArrayList<String>();
    private List<String> linhaEnvironment = new ArrayList<String>();
    private List<String> linhaData = new ArrayList<String>();
    private List<String> linhaProcedure = new ArrayList<String>();
    private List<VariavelTO> var = new ArrayList<VariavelTO>();
    List<String> arrayList = new ArrayList<String>();
    private IdentificationDivision identification = new IdentificationDivision();
    private EnvironmentDivision environment = new EnvironmentDivision();
    private DataDivision data = new DataDivision();
    private ProcedureDivision procedure = new ProcedureDivision();
    private Calendario objCalendario = new Calendario();
    private BookTO book1 = new BookTO();
    private BookTO book2 = new BookTO();
    private String dataAtual;
    private String nomePrograma;
    private String nomeBookEnvio;
    private String nomeBookTag;
    private String nomeArquivoCip;
    private int lreclArquivoEnvio;
    private int tamanhoFD;
    private int envio;
    private int retorno;
    private int tamanhoBook;
    private int maior;
    private int inteiro;
    private int decimais;
    private int elementoTeste;
    private int elementoTesteBook;

    public void processar() {

        ArquivoCblTO arquivo1 = new ArquivoInputCPY().arquivoUpado();
        ArquivoCblTO arquivo2 = new ArquivoInputCPY().arquivoUpado();

        try {
            this.book1 = new AnalisaBook().ler(arquivo1.getNomeArquivo(),
                    arquivo1.getProcedimentos());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.book2 = new AnalisaBook().ler(arquivo2.getNomeArquivo(),
                    arquivo2.getProcedimentos());
        } catch (Exception e) {
            e.printStackTrace();
        }

        preencherCampos();

        imprimirIdentificationDivision();
        imprimirEnvironmentDivision();
        imprimirDataDivision();
        imprimirProcedureDivision();

        gravarSaida();

    }

    public void imprimirIdentificationDivision() {
        this.identification.gerarIdentificationDivision(this.dataAtual,
                this.nomePrograma, this.nomeBookEnvio, this.nomeBookTag);
        this.linhaIdentification = identification.getLinhaIdentification();
        for (String a : this.linhaIdentification) {
            this.b.append(a + "\n");
        }
    }

    public void imprimirEnvironmentDivision() {
        this.environment.gerarEnvironmentDivision();
        this.linhaEnvironment = environment.getLinhaEnvironment();
        for (String a : this.linhaEnvironment) {
            this.b.append(a + "\n");
        }
    }

    public void imprimirDataDivision() {
        this.data.gerarDataDivision(this.nomePrograma, this.nomeBookEnvio,
                this.nomeBookTag, this.nomeArquivoCip, this.lreclArquivoEnvio,
                this.tamanhoFD);
        this.linhaData = data.getLinhaData();
        for (String a : this.linhaData) {
            this.b.append(a + "\n");
        }
    }

    public void imprimirProcedureDivision() {
        this.procedure.gerarProcedureDivision(this.nomePrograma);
        this.linhaProcedure = procedure.getLinhaProcedure();
        for (String a : this.linhaProcedure) {
            // this.gravador.println(a);
            this.b.append(a + "\n");
        }
    }

    public int encontrarMaiorEnvio() {
        this.var = this.book1.getVariaveis();
        for (VariavelTO a : this.var) {
            if (!a.isItenDeGrupo()) {
                if (a.getInteiro() != null) {
                    this.inteiro = a.getInteiro();
                } else {
                    this.inteiro = 0;
                }
                if (a.getDecimais() != null) {
                    this.decimais = a.getDecimais();
                } else {
                    this.decimais = 0;
                }
                this.elementoTeste = inteiro + decimais;
                if (this.maior < this.elementoTeste) {
                    this.maior = this.elementoTeste;
                }
            } else {
                this.elementoTesteBook = a.getInteiro();
                if (this.tamanhoBook < this.elementoTesteBook) {
                    this.tamanhoBook = elementoTesteBook;
                }
            }
        }
        return maior;
    }

    public int encontrarMaiorTag() {
        this.var = this.book2.getVariaveis();
        for (VariavelTO a : this.var) {
            if (!a.isItenDeGrupo()) {
                if (a.getDecimais() != null) {
                    this.decimais = a.getDecimais();
                } else {
                    this.decimais = 0;
                }
                if (a.getInteiro() != null) {
                    this.inteiro = a.getInteiro();
                } else {
                    this.inteiro = 0;
                }
                this.elementoTeste = inteiro + decimais;

                if (this.maior < this.elementoTeste) {
                    this.maior = this.elementoTeste;
                }
            }
        }
        return maior;
    }

    public void preencherCampos() {
        this.nomePrograma = "SCC36001";
        this.nomeArquivoCip = "ACCC600";
        this.dataAtual = (this.objCalendario.getData()).replace("-", "/");
        this.nomeBookEnvio = this.book1.getNome();
        this.nomeBookTag = this.book2.getNome();
        this.lreclArquivoEnvio = this.tamanhoBook;
        this.envio = encontrarMaiorEnvio();
        this.retorno = encontrarMaiorTag();
        if (envio > retorno) {
            this.tamanhoFD = envio;
        } else {
            this.tamanhoFD = retorno;
        }
    }

    public void gravarSaida() {
        this.to.setArquivoEmString(b);
        this.to.setNomeArquivo(this.nomePrograma + ".CBL");
        ArrayList<ArquivoCblTO> listArquivoCblTO = new ArrayList<ArquivoCblTO>();
        listArquivoCblTO.add(to);
        try {
            this.out.salvarArquivo(listArquivoCblTO);
            JOptionPane.showMessageDialog(null,
                    "Processamento Conclu�do com Sucesso.");
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}