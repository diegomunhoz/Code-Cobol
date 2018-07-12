/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmunhoz
 */
@Entity
@Table(name = "dicionariodetipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dicionariodetipos.findAll", query = "SELECT d FROM Dicionariodetipos d"),
    @NamedQuery(name = "Dicionariodetipos.findByTipoCampo", query = "SELECT d FROM Dicionariodetipos d WHERE d.tipoCampo = :tipoCampo"),
    @NamedQuery(name = "Dicionariodetipos.findByFormatoCampo", query = "SELECT d FROM Dicionariodetipos d WHERE d.formatoCampo = :formatoCampo"),
    @NamedQuery(name = "Dicionariodetipos.findByTamanhoMinimoCampo", query = "SELECT d FROM Dicionariodetipos d WHERE d.tamanhoMinimoCampo = :tamanhoMinimoCampo"),
    @NamedQuery(name = "Dicionariodetipos.findByTamanhoMaximoCampo", query = "SELECT d FROM Dicionariodetipos d WHERE d.tamanhoMaximoCampo = :tamanhoMaximoCampo"),
    @NamedQuery(name = "Dicionariodetipos.findByTamanhoCampoDecimal", query = "SELECT d FROM Dicionariodetipos d WHERE d.tamanhoCampoDecimal = :tamanhoCampoDecimal"),
    @NamedQuery(name = "Dicionariodetipos.findByDescricaoCampo", query = "SELECT d FROM Dicionariodetipos d WHERE d.descricaoCampo = :descricaoCampo")})
public class Dicionariodetipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TipoCampo")
    private String tipoCampo;
    @Basic(optional = false)
    @Column(name = "FormatoCampo")
    private String formatoCampo;
    @Basic(optional = false)
    @Column(name = "TamanhoMinimoCampo")
    private int tamanhoMinimoCampo;
    @Basic(optional = false)
    @Column(name = "TamanhoMaximoCampo")
    private int tamanhoMaximoCampo;
    @Basic(optional = false)
    @Column(name = "TamanhoCampoDecimal")
    private int tamanhoCampoDecimal;
    @Column(name = "DescricaoCampo")
    private String descricaoCampo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dicionarioDeTiposTipoCampo")
    private List<Dicionariodecampos> dicionariodecamposList;

    public Dicionariodetipos() {
    }

    public Dicionariodetipos(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public Dicionariodetipos(String tipoCampo, String formatoCampo, int tamanhoMinimoCampo, int tamanhoMaximoCampo, int tamanhoCampoDecimal) {
        this.tipoCampo = tipoCampo;
        this.formatoCampo = formatoCampo;
        this.tamanhoMinimoCampo = tamanhoMinimoCampo;
        this.tamanhoMaximoCampo = tamanhoMaximoCampo;
        this.tamanhoCampoDecimal = tamanhoCampoDecimal;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }

    public String getFormatoCampo() {
        return formatoCampo;
    }

    public void setFormatoCampo(String formatoCampo) {
        this.formatoCampo = formatoCampo;
    }

    public int getTamanhoMinimoCampo() {
        return tamanhoMinimoCampo;
    }

    public void setTamanhoMinimoCampo(int tamanhoMinimoCampo) {
        this.tamanhoMinimoCampo = tamanhoMinimoCampo;
    }

    public int getTamanhoMaximoCampo() {
        return tamanhoMaximoCampo;
    }

    public void setTamanhoMaximoCampo(int tamanhoMaximoCampo) {
        this.tamanhoMaximoCampo = tamanhoMaximoCampo;
    }

    public int getTamanhoCampoDecimal() {
        return tamanhoCampoDecimal;
    }

    public void setTamanhoCampoDecimal(int tamanhoCampoDecimal) {
        this.tamanhoCampoDecimal = tamanhoCampoDecimal;
    }

    public String getDescricaoCampo() {
        return descricaoCampo;
    }

    public void setDescricaoCampo(String descricaoCampo) {
        this.descricaoCampo = descricaoCampo;
    }

    @XmlTransient
    public List<Dicionariodecampos> getDicionariodecamposList() {
        return dicionariodecamposList;
    }

    public void setDicionariodecamposList(List<Dicionariodecampos> dicionariodecamposList) {
        this.dicionariodecamposList = dicionariodecamposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCampo != null ? tipoCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dicionariodetipos)) {
            return false;
        }
        Dicionariodetipos other = (Dicionariodetipos) object;
        if ((this.tipoCampo == null && other.tipoCampo != null) || (this.tipoCampo != null && !this.tipoCampo.equals(other.tipoCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dicionariodetipos[ tipoCampo=" + tipoCampo + " ]";
    }
    
}
