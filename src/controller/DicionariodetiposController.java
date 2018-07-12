package controller;

import dao.DicionariodetiposDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Dicionariodetipos;
import view.DicionariodetiposView;

public class DicionariodetiposController {

    private DicionariodetiposView viewDicionariodetipos;
    private Dicionariodetipos tipo = new Dicionariodetipos();
    private List<Dicionariodetipos> listaDicionariodetiposs;
    private boolean alterarTrue;
    private String formato;

    public DicionariodetiposController(DicionariodetiposView viewDicionariodetipos) {
        this.viewDicionariodetipos = viewDicionariodetipos;
    }

    public void salvarDicionariodetipos() {
        if (alterarTrue == false) {
            if (validarSalvar()) {

                if (this.viewDicionariodetipos.getJcbFormato().getSelectedIndex() == 1) {
                    this.formato = "NUMERICO";
                } else {
                    this.formato = "ALFANUMERICO";
                }
                if (this.viewDicionariodetipos.getJtfDecimal().getText().toUpperCase().equals("")) {
                    this.tipo.setTamanhoCampoDecimal(0);                    
                }else{
                    this.tipo.setTamanhoCampoDecimal(Integer.parseInt(this.viewDicionariodetipos.getJtfDecimal().getText().toUpperCase()));
                }

                this.tipo.setFormatoCampo(this.formato);
                this.tipo.setTipoCampo(this.viewDicionariodetipos.getJtfTipoCampo().getText().toUpperCase());
                this.tipo.setTamanhoMinimoCampo(Integer.parseInt(this.viewDicionariodetipos.getJtfTamanhoMinimo().getText().toUpperCase()));
                this.tipo.setTamanhoMaximoCampo(Integer.parseInt(this.viewDicionariodetipos.getJtfTamanhoMaximo().getText().toUpperCase()));
                this.tipo.setDescricaoCampo(this.viewDicionariodetipos.getJtfDescricaoTipo().getText().toUpperCase());

                try {
                    new DicionariodetiposDAO().salvar(this.tipo);
                    JOptionPane.showMessageDialog(null, "Tipo salvo com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir tipo!");
                    Logger.getLogger(DicionariodetiposView.class.getName()).log(Level.SEVERE, null, ex);
                }

                limparCampos();
                listarDicionariodetipos();
                bloqueioInicial();
                alterarTrue = false;
            }
        } else {
            if (validarSalvar()) {

                if (this.viewDicionariodetipos.getJcbFormato().getSelectedIndex() == 1) {
                    this.formato = "NUMERICO";
                } else {
                    this.formato = "ALFANUMERICO";
                }

                this.tipo.setTipoCampo(this.viewDicionariodetipos.getJtfTipoCampo().getText().toUpperCase());
                this.tipo.setTamanhoMinimoCampo(Integer.parseInt(this.viewDicionariodetipos.getJtfTamanhoMinimo().getText().toUpperCase()));
                this.tipo.setTamanhoMaximoCampo(Integer.parseInt(this.viewDicionariodetipos.getJtfTamanhoMaximo().getText().toUpperCase()));
                this.tipo.setTamanhoCampoDecimal(Integer.parseInt(this.viewDicionariodetipos.getJtfDecimal().getText().toUpperCase()));
                this.tipo.setDescricaoCampo(this.viewDicionariodetipos.getJtfDescricaoTipo().getText().toUpperCase());
                this.tipo.setFormatoCampo(this.formato);

                try {
                    new DicionariodetiposDAO().salvar(this.tipo);
                    JOptionPane.showMessageDialog(null, "Tipo alterado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar tipo!");
                    Logger.getLogger(DicionariodetiposView.class.getName()).log(Level.SEVERE, null, ex);
                }
                limparCampos();
                listarDicionariodetipos();
                bloqueioInicial();
                alterarTrue = false;
            }
        }
    }

    public void alterarDicionariodetipos() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewDicionariodetipos.getTabelaTipos().getModel();
        if (this.viewDicionariodetipos.getTabelaTipos().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um tipo!");
        } else {
            this.tipo = listaDicionariodetiposs.get(this.viewDicionariodetipos.getTabelaTipos().getSelectedRow());
            this.viewDicionariodetipos.getJtfTipoCampo().setText(this.tipo.getTipoCampo());
            this.viewDicionariodetipos.getJtfTamanhoMinimo().setText(this.tipo.getTamanhoMinimoCampo() + "");
            this.viewDicionariodetipos.getJtfTamanhoMaximo().setText(this.tipo.getTamanhoMaximoCampo() + "");
            this.viewDicionariodetipos.getJtfDecimal().setText(this.tipo.getTamanhoCampoDecimal() + "");

            if (this.tipo.getFormatoCampo() == "NUMERICO") {
                this.viewDicionariodetipos.getJcbFormato().setSelectedIndex(2);
            } else {
                this.viewDicionariodetipos.getJcbFormato().setSelectedIndex(2);
            }
            alterarTrue = true;
            acaoBotaoAlterar();
        }
    }

    public void excluirDicionariodetipos() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewDicionariodetipos.getTabelaTipos().getModel();
        if (this.viewDicionariodetipos.getTabelaTipos().getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um tipo!");
        } else {
            this.tipo = listaDicionariodetiposs.get(this.viewDicionariodetipos.getTabelaTipos().getSelectedRow());
            int x = JOptionPane.showConfirmDialog(null, "Confirma em excluir este registro?", "Atenção",
                    JOptionPane.YES_OPTION,
                    JOptionPane.CANCEL_OPTION);
            if ((x == JOptionPane.YES_OPTION)) {
                try {
                    new DicionariodetiposDAO().excluir(this.tipo);
                    JOptionPane.showMessageDialog(null, "Tipo excluído com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir tipo!");
                    Logger.getLogger(DicionariodetiposView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void pesquisarDicionariodetipos() {
        DicionariodetiposDAO dao = new DicionariodetiposDAO();
        try {
            listaDicionariodetiposs = dao.buscarPorNome(this.viewDicionariodetipos.getJtfPesquisarNome().getText());
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(DicionariodetiposView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarDicionariodetipos() {
        try {
            listaDicionariodetiposs = new DicionariodetiposDAO().buscarTodos();
            carregarTabela();
        } catch (Exception ex) {
            Logger.getLogger(DicionariodetiposView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.viewDicionariodetipos.getTabelaTipos().getModel();
        modelo.setRowCount(0);
        for (Dicionariodetipos tipo : listaDicionariodetiposs) {
            modelo.addRow(new String[]{tipo.getTipoCampo(), tipo.getFormatoCampo(), tipo.getTamanhoMinimoCampo() + "", tipo.getTamanhoMaximoCampo() + ""});
        }
    }

    public boolean validarSalvar() {
        if (this.viewDicionariodetipos.getJtfTipoCampo().equals(null) || this.viewDicionariodetipos.getJtfTipoCampo().equals("") || this.viewDicionariodetipos.getJtfTipoCampo().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe o tipo, campo obrigatório!");
            return false;
        } else {
            if (this.viewDicionariodetipos.getJtfTamanhoMinimo().equals(null) || this.viewDicionariodetipos.getJtfTamanhoMinimo().equals("") || this.viewDicionariodetipos.getJtfTamanhoMinimo().equals(" ")) {
                JOptionPane.showMessageDialog(null, "Informe o endereço, campo obrigatório!");
                return false;
            } else {
                if (this.viewDicionariodetipos.getJtfTamanhoMaximo().equals(null) || this.viewDicionariodetipos.getJtfTamanhoMaximo().equals("") || this.viewDicionariodetipos.getJtfTamanhoMaximo().equals(" ")) {
                    JOptionPane.showMessageDialog(null, "Informe o bairro, campo obrigatório!");
                    return false;
                } else {
                    if (this.viewDicionariodetipos.getJtfDecimal().equals(null) || this.viewDicionariodetipos.getJtfDecimal().equals("") || this.viewDicionariodetipos.getJtfDecimal().equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Informe a cidade, campo obrigatório!");
                        return false;
                    } else {
                        if (this.viewDicionariodetipos.getJcbFormato().getSelectedIndex() == 0) {
                            JOptionPane.showMessageDialog(null, "Informe o formato, campo obrigatório!");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void bloqueioInicial() {
        this.viewDicionariodetipos.getJbtNovo().setEnabled(true);
        this.viewDicionariodetipos.getJbtAlterar().setEnabled(true);
        this.viewDicionariodetipos.getJbtExcluir().setEnabled(true);
        this.viewDicionariodetipos.getJbtSair().setEnabled(true);
        this.viewDicionariodetipos.getJbtConfirmar().setEnabled(false);
        this.viewDicionariodetipos.getJbtCancelar().setEnabled(false);
        bloquearCampos();
    }

    public void acaoBotaoCancelar() {
        limparCampos();
        this.viewDicionariodetipos.getJbtConfirmar().setEnabled(false);
        this.viewDicionariodetipos.getJbtCancelar().setEnabled(false);
        this.viewDicionariodetipos.getJbtNovo().setEnabled(true);
        this.viewDicionariodetipos.getJbtAlterar().setEnabled(true);
        this.viewDicionariodetipos.getJbtExcluir().setEnabled(true);
        this.viewDicionariodetipos.getJbtSair().setEnabled(true);
        this.viewDicionariodetipos.getJtfPesquisarNome().setEditable(true);
        this.viewDicionariodetipos.getJtfPesquisarNome().grabFocus();
    }

    public void acaoBotaoAlterar() {
        this.viewDicionariodetipos.getJbtNovo().setEnabled(false);
        this.viewDicionariodetipos.getJbtAlterar().setEnabled(false);
        this.viewDicionariodetipos.getJbtExcluir().setEnabled(false);
        this.viewDicionariodetipos.getJbtSair().setEnabled(false);
        this.viewDicionariodetipos.getJbtConfirmar().setEnabled(true);
        this.viewDicionariodetipos.getJbtCancelar().setEnabled(true);
        liberarCampos();
        this.viewDicionariodetipos.getJtfTipoCampo().setEditable(false);
    }

    public void acaoBotaoNovo() {
        this.viewDicionariodetipos.getJbtNovo().setEnabled(false);
        this.viewDicionariodetipos.getJbtAlterar().setEnabled(false);
        this.viewDicionariodetipos.getJbtExcluir().setEnabled(false);
        this.viewDicionariodetipos.getJbtSair().setEnabled(false);
        this.viewDicionariodetipos.getJbtConfirmar().setEnabled(true);
        this.viewDicionariodetipos.getJbtCancelar().setEnabled(true);
        this.viewDicionariodetipos.getJtfPesquisarNome().setEditable(false);
        liberarCampos();
        alterarTrue = false;
    }

    public void bloquearCampos() {
        this.viewDicionariodetipos.getJtfTipoCampo().grabFocus();
        this.viewDicionariodetipos.getJtfTipoCampo().setEditable(false);
        this.viewDicionariodetipos.getJcbFormato().setEditable(false);
        this.viewDicionariodetipos.getJtfTamanhoMinimo().setEditable(false);
        this.viewDicionariodetipos.getJtfTamanhoMaximo().setEditable(false);
        this.viewDicionariodetipos.getJtfDecimal().setEditable(false);
        this.viewDicionariodetipos.getJtfDescricaoTipo().setEditable(false);
        this.viewDicionariodetipos.getJtfPesquisarNome().setEditable(true);
        this.viewDicionariodetipos.getJtfPesquisarNome().grabFocus();
    }

    public void liberarCampos() {
        this.viewDicionariodetipos.getJtfTipoCampo().grabFocus();
        this.viewDicionariodetipos.getJtfTipoCampo().setEditable(true);
        this.viewDicionariodetipos.getJcbFormato().setEditable(true);
        this.viewDicionariodetipos.getJtfTamanhoMinimo().setEditable(true);
        this.viewDicionariodetipos.getJtfTamanhoMaximo().setEditable(true);
        this.viewDicionariodetipos.getJtfDecimal().setEditable(true);
        this.viewDicionariodetipos.getJtfDescricaoTipo().setEditable(true);
    }

    public void limparCampos() {
        this.viewDicionariodetipos.getJtfTipoCampo().setText(null);
        this.viewDicionariodetipos.getJcbFormato().setSelectedIndex(0);
        this.viewDicionariodetipos.getJtfTamanhoMinimo().setText(null);
        this.viewDicionariodetipos.getJtfTamanhoMaximo().setText(null);
        this.viewDicionariodetipos.getJtfDecimal().setText(null);
        this.viewDicionariodetipos.getJtfDescricaoTipo().setText(null);
    }
}