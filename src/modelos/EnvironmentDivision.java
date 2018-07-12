package modelos;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentDivision {

	private List<String> linhaEnvironment = new ArrayList<String>();

	public List<String> getLinhaEnvironment() {
		return linhaEnvironment;
	}

	public void gerarEnvironmentDivision() {

		this.linhaEnvironment
				.add("      *================================================================*");
		this.linhaEnvironment
				.add("       ENVIRONMENT                     DIVISION.");
		this.linhaEnvironment
				.add("      *================================================================*");
		this.linhaEnvironment.add(" ");
		this.linhaEnvironment
				.add("      *----------------------------------------------------------------*");
		this.linhaEnvironment
				.add("       CONFIGURATION                   SECTION.");
		this.linhaEnvironment
				.add("      *----------------------------------------------------------------*");
		this.linhaEnvironment.add(" ");
		this.linhaEnvironment.add("       SPECIAL-NAMES.");
		this.linhaEnvironment
				.add("           DECIMAL-POINT               IS COMMA.");
		this.linhaEnvironment.add(" ");
		this.linhaEnvironment
				.add("      *----------------------------------------------------------------*");
		this.linhaEnvironment
				.add("       INPUT-OUTPUT                    SECTION.");
		this.linhaEnvironment
				.add("      *----------------------------------------------------------------*");
		this.linhaEnvironment.add(" ");
		this.linhaEnvironment.add("       FILE-CONTROL.");
		this.linhaEnvironment.add(" ");
		this.linhaEnvironment
				.add("           SELECT EARQSEQ  ASSIGN      TO UT-S-EARQSEQ");
		this.linhaEnvironment
				.add("                      FILE STATUS      IS WRK-FS-EARQSEQ.");
		this.linhaEnvironment.add(" ");
		this.linhaEnvironment
				.add("           SELECT SARQXML  ASSIGN      TO UT-S-SARQXML");
		this.linhaEnvironment
				.add("                      FILE STATUS      IS WRK-FS-SARQXML.");
		this.linhaEnvironment.add(" ");
		this.linhaEnvironment
				.add("           SELECT SRELCTRL ASSIGN      TO UT-S-SRELCTRL");
		this.linhaEnvironment
				.add("                      FILE STATUS      IS WRK-FS-SRELCTRL.");
		this.linhaEnvironment.add(" ");
	}
}
