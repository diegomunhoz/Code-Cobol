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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "dicionariodecampos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dicionariodecampos.findAll", query = "SELECT d FROM Dicionariodecampos d"),
    @NamedQuery(name = "Dicionariodecampos.findByTagCampo", query = "SELECT d FROM Dicionariodecampos d WHERE d.tagCampo = :tagCampo"),
    @NamedQuery(name = "Dicionariodecampos.findByNomeCampo", query = "SELECT d FROM Dicionariodecampos d WHERE d.nomeCampo = :nomeCampo"),
    @NamedQuery(name = "Dicionariodecampos.findByDescricaoCampo", query = "SELECT d FROM Dicionariodecampos d WHERE d.descricaoCampo = :descricaoCampo")})
public class Dicionariodecampos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TagCampo")
    private String tagCampo;
    @Basic(optional = false)
    @Column(name = "NomeCampo")
    private String nomeCampo;
    @Column(name = "DescricaoCampo")
    private String descricaoCampo;
    @JoinColumn(name = "DicionarioDeTipos_TipoCampo", referencedColumnName = "TipoCampo")
    @ManyToOne(optional = false)
    private Dicionariodetipos dicionarioDeTiposTipoCampo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dicionarioDeCamposTagCampo")
    private List<Camposarquivocip> camposarquivocipList;

    public Dicionariodecampos() {
    }

    public Dicionariodecampos(String tagCampo) {
        this.tagCampo = tagCampo;
    }

    public Dicionariodecampos(String tagCampo, String nomeCampo) {
        this.tagCampo = tagCampo;
        this.nomeCampo = nomeCampo;
    }

    public String getTagCampo() {
        return tagCampo;
    }

    public void setTagCampo(String tagCampo) {
        this.tagCampo = tagCampo;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }

    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    public String getDescricaoCampo() {
        return descricaoCampo;
    }

    public void setDescricaoCampo(String descricaoCampo) {
        this.descricaoCampo = descricaoCampo;
    }

    public Dicionariodetipos getDicionarioDeTiposTipoCampo() {
        return dicionarioDeTiposTipoCampo;
    }

    public void setDicionarioDeTiposTipoCampo(Dicionariodetipos dicionarioDeTiposTipoCampo) {
        this.dicionarioDeTiposTipoCampo = dicionarioDeTiposTipoCampo;
    }

    @XmlTransient
    public List<Camposarquivocip> getCamposarquivocipList() {
        return camposarquivocipList;
    }

    public void setCamposarquivocipList(List<Camposarquivocip> camposarquivocipList) {
        this.camposarquivocipList = camposarquivocipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagCampo != null ? tagCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dicionariodecampos)) {
            return false;
        }
        Dicionariodecampos other = (Dicionariodecampos) object;
        if ((this.tagCampo == null && other.tagCampo != null) || (this.tagCampo != null && !this.tagCampo.equals(other.tagCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dicionariodecampos[ tagCampo=" + tagCampo + " ]";
    }
    
}
