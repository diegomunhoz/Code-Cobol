/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmunhoz
 */
@Entity
@Table(name = "programacobolcip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programacobolcip.findAll", query = "SELECT p FROM Programacobolcip p"),
    @NamedQuery(name = "Programacobolcip.findByNomeProgramaCobolCip", query = "SELECT p FROM Programacobolcip p WHERE p.nomeProgramaCobolCip = :nomeProgramaCobolCip"),
    @NamedQuery(name = "Programacobolcip.findByDataCriacao", query = "SELECT p FROM Programacobolcip p WHERE p.dataCriacao = :dataCriacao")})
public class Programacobolcip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeProgramaCobolCip")
    private String nomeProgramaCobolCip;
    @Column(name = "DataCriacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @JoinColumn(name = "ArquivoCip_NomeArquivoCip", referencedColumnName = "NomeArquivoCip")
    @ManyToOne(optional = false)
    private Arquivocip arquivoCipNomeArquivoCip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programaCobolCipNomeProgramaCobolCip")
    private List<Linhacodigoprogramacobol> linhacodigoprogramacobolList;

    public Programacobolcip() {
    }

    public Programacobolcip(String nomeProgramaCobolCip) {
        this.nomeProgramaCobolCip = nomeProgramaCobolCip;
    }

    public String getNomeProgramaCobolCip() {
        return nomeProgramaCobolCip;
    }

    public void setNomeProgramaCobolCip(String nomeProgramaCobolCip) {
        this.nomeProgramaCobolCip = nomeProgramaCobolCip;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Arquivocip getArquivoCipNomeArquivoCip() {
        return arquivoCipNomeArquivoCip;
    }

    public void setArquivoCipNomeArquivoCip(Arquivocip arquivoCipNomeArquivoCip) {
        this.arquivoCipNomeArquivoCip = arquivoCipNomeArquivoCip;
    }

    @XmlTransient
    public List<Linhacodigoprogramacobol> getLinhacodigoprogramacobolList() {
        return linhacodigoprogramacobolList;
    }

    public void setLinhacodigoprogramacobolList(List<Linhacodigoprogramacobol> linhacodigoprogramacobolList) {
        this.linhacodigoprogramacobolList = linhacodigoprogramacobolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeProgramaCobolCip != null ? nomeProgramaCobolCip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programacobolcip)) {
            return false;
        }
        Programacobolcip other = (Programacobolcip) object;
        if ((this.nomeProgramaCobolCip == null && other.nomeProgramaCobolCip != null) || (this.nomeProgramaCobolCip != null && !this.nomeProgramaCobolCip.equals(other.nomeProgramaCobolCip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Programacobolcip[ nomeProgramaCobolCip=" + nomeProgramaCobolCip + " ]";
    }
    
}
