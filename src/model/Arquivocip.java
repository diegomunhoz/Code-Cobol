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
@Table(name = "arquivocip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arquivocip.findAll", query = "SELECT a FROM Arquivocip a"),
    @NamedQuery(name = "Arquivocip.findByNomeArquivoCip", query = "SELECT a FROM Arquivocip a WHERE a.nomeArquivoCip = :nomeArquivoCip"),
    @NamedQuery(name = "Arquivocip.findByDescricaoArquivoCip", query = "SELECT a FROM Arquivocip a WHERE a.descricaoArquivoCip = :descricaoArquivoCip")})
public class Arquivocip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeArquivoCip")
    private String nomeArquivoCip;
    @Column(name = "DescricaoArquivoCip")
    private String descricaoArquivoCip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arquivoCipNomeArquivoCip")
    private List<Camposarquivocip> camposarquivocipList;
    @JoinColumn(name = "BookTag_NomeBookTag", referencedColumnName = "NomeBookTag")
    @ManyToOne
    private Booktag bookTagNomeBookTag;
    @JoinColumn(name = "BookRetorno_NomeBookRetorno", referencedColumnName = "NomeBookRetorno")
    @ManyToOne
    private Bookretorno bookRetornoNomeBookRetorno;
    @JoinColumn(name = "BookEnvio_NomeBookEnvio", referencedColumnName = "NomeBookEnvio")
    @ManyToOne
    private Bookenvio bookEnvioNomeBookEnvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arquivoCipNomeArquivoCip")
    private List<Programacobolcip> programacobolcipList;

    public Arquivocip() {
    }

    public Arquivocip(String nomeArquivoCip) {
        this.nomeArquivoCip = nomeArquivoCip;
    }

    public String getNomeArquivoCip() {
        return nomeArquivoCip;
    }

    public void setNomeArquivoCip(String nomeArquivoCip) {
        this.nomeArquivoCip = nomeArquivoCip;
    }

    public String getDescricaoArquivoCip() {
        return descricaoArquivoCip;
    }

    public void setDescricaoArquivoCip(String descricaoArquivoCip) {
        this.descricaoArquivoCip = descricaoArquivoCip;
    }

    @XmlTransient
    public List<Camposarquivocip> getCamposarquivocipList() {
        return camposarquivocipList;
    }

    public void setCamposarquivocipList(List<Camposarquivocip> camposarquivocipList) {
        this.camposarquivocipList = camposarquivocipList;
    }

    public Booktag getBookTagNomeBookTag() {
        return bookTagNomeBookTag;
    }

    public void setBookTagNomeBookTag(Booktag bookTagNomeBookTag) {
        this.bookTagNomeBookTag = bookTagNomeBookTag;
    }

    public Bookretorno getBookRetornoNomeBookRetorno() {
        return bookRetornoNomeBookRetorno;
    }

    public void setBookRetornoNomeBookRetorno(Bookretorno bookRetornoNomeBookRetorno) {
        this.bookRetornoNomeBookRetorno = bookRetornoNomeBookRetorno;
    }

    public Bookenvio getBookEnvioNomeBookEnvio() {
        return bookEnvioNomeBookEnvio;
    }

    public void setBookEnvioNomeBookEnvio(Bookenvio bookEnvioNomeBookEnvio) {
        this.bookEnvioNomeBookEnvio = bookEnvioNomeBookEnvio;
    }

    @XmlTransient
    public List<Programacobolcip> getProgramacobolcipList() {
        return programacobolcipList;
    }

    public void setProgramacobolcipList(List<Programacobolcip> programacobolcipList) {
        this.programacobolcipList = programacobolcipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeArquivoCip != null ? nomeArquivoCip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivocip)) {
            return false;
        }
        Arquivocip other = (Arquivocip) object;
        if ((this.nomeArquivoCip == null && other.nomeArquivoCip != null) || (this.nomeArquivoCip != null && !this.nomeArquivoCip.equals(other.nomeArquivoCip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Arquivocip[ nomeArquivoCip=" + nomeArquivoCip + " ]";
    }
    
}
