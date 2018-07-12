/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmunhoz
 */
@Entity
@Table(name = "camposarquivocip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camposarquivocip.findAll", query = "SELECT c FROM Camposarquivocip c"),
    @NamedQuery(name = "Camposarquivocip.findByCodigoCamposArquivoCip", query = "SELECT c FROM Camposarquivocip c WHERE c.codigoCamposArquivoCip = :codigoCamposArquivoCip"),
    @NamedQuery(name = "Camposarquivocip.findByOcorrenciaCampoCip", query = "SELECT c FROM Camposarquivocip c WHERE c.ocorrenciaCampoCip = :ocorrenciaCampoCip"),
    @NamedQuery(name = "Camposarquivocip.findByObrigatoriedadeCampoCip", query = "SELECT c FROM Camposarquivocip c WHERE c.obrigatoriedadeCampoCip = :obrigatoriedadeCampoCip")})
public class Camposarquivocip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoCamposArquivoCip")
    private Integer codigoCamposArquivoCip;
    @Basic(optional = false)
    @Column(name = "OcorrenciaCampoCip")
    private Character ocorrenciaCampoCip;
    @Basic(optional = false)
    @Column(name = "ObrigatoriedadeCampoCip")
    private Character obrigatoriedadeCampoCip;
    @JoinColumn(name = "DicionarioDeCampos_TagCampo", referencedColumnName = "TagCampo")
    @ManyToOne(optional = false)
    private Dicionariodecampos dicionarioDeCamposTagCampo;
    @JoinColumn(name = "ArquivoCip_NomeArquivoCip", referencedColumnName = "NomeArquivoCip")
    @ManyToOne(optional = false)
    private Arquivocip arquivoCipNomeArquivoCip;

    public Camposarquivocip() {
    }

    public Camposarquivocip(Integer codigoCamposArquivoCip) {
        this.codigoCamposArquivoCip = codigoCamposArquivoCip;
    }

    public Camposarquivocip(Integer codigoCamposArquivoCip, Character ocorrenciaCampoCip, Character obrigatoriedadeCampoCip) {
        this.codigoCamposArquivoCip = codigoCamposArquivoCip;
        this.ocorrenciaCampoCip = ocorrenciaCampoCip;
        this.obrigatoriedadeCampoCip = obrigatoriedadeCampoCip;
    }

    public Integer getCodigoCamposArquivoCip() {
        return codigoCamposArquivoCip;
    }

    public void setCodigoCamposArquivoCip(Integer codigoCamposArquivoCip) {
        this.codigoCamposArquivoCip = codigoCamposArquivoCip;
    }

    public Character getOcorrenciaCampoCip() {
        return ocorrenciaCampoCip;
    }

    public void setOcorrenciaCampoCip(Character ocorrenciaCampoCip) {
        this.ocorrenciaCampoCip = ocorrenciaCampoCip;
    }

    public Character getObrigatoriedadeCampoCip() {
        return obrigatoriedadeCampoCip;
    }

    public void setObrigatoriedadeCampoCip(Character obrigatoriedadeCampoCip) {
        this.obrigatoriedadeCampoCip = obrigatoriedadeCampoCip;
    }

    public Dicionariodecampos getDicionarioDeCamposTagCampo() {
        return dicionarioDeCamposTagCampo;
    }

    public void setDicionarioDeCamposTagCampo(Dicionariodecampos dicionarioDeCamposTagCampo) {
        this.dicionarioDeCamposTagCampo = dicionarioDeCamposTagCampo;
    }

    public Arquivocip getArquivoCipNomeArquivoCip() {
        return arquivoCipNomeArquivoCip;
    }

    public void setArquivoCipNomeArquivoCip(Arquivocip arquivoCipNomeArquivoCip) {
        this.arquivoCipNomeArquivoCip = arquivoCipNomeArquivoCip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCamposArquivoCip != null ? codigoCamposArquivoCip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camposarquivocip)) {
            return false;
        }
        Camposarquivocip other = (Camposarquivocip) object;
        if ((this.codigoCamposArquivoCip == null && other.codigoCamposArquivoCip != null) || (this.codigoCamposArquivoCip != null && !this.codigoCamposArquivoCip.equals(other.codigoCamposArquivoCip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Camposarquivocip[ codigoCamposArquivoCip=" + codigoCamposArquivoCip + " ]";
    }
    
}
