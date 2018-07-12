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
@Table(name = "bookretorno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookretorno.findAll", query = "SELECT b FROM Bookretorno b"),
    @NamedQuery(name = "Bookretorno.findByNomeBookRetorno", query = "SELECT b FROM Bookretorno b WHERE b.nomeBookRetorno = :nomeBookRetorno"),
    @NamedQuery(name = "Bookretorno.findByDataCriacao", query = "SELECT b FROM Bookretorno b WHERE b.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Bookretorno.findByDataAtualizacao", query = "SELECT b FROM Bookretorno b WHERE b.dataAtualizacao = :dataAtualizacao"),
    @NamedQuery(name = "Bookretorno.findByTamanho", query = "SELECT b FROM Bookretorno b WHERE b.tamanho = :tamanho")})
public class Bookretorno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeBookRetorno")
    private String nomeBookRetorno;
    @Column(name = "DataCriacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Column(name = "DataAtualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
    @Basic(optional = false)
    @Column(name = "Tamanho")
    private int tamanho;
    @OneToMany(mappedBy = "bookRetornoNomeBookRetorno")
    private List<Arquivocip> arquivocipList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookRetornoNomeBookRetorno")
    private List<Linhabookretorno> linhabookretornoList;

    public Bookretorno() {
    }

    public Bookretorno(String nomeBookRetorno) {
        this.nomeBookRetorno = nomeBookRetorno;
    }

    public Bookretorno(String nomeBookRetorno, int tamanho) {
        this.nomeBookRetorno = nomeBookRetorno;
        this.tamanho = tamanho;
    }

    public String getNomeBookRetorno() {
        return nomeBookRetorno;
    }

    public void setNomeBookRetorno(String nomeBookRetorno) {
        this.nomeBookRetorno = nomeBookRetorno;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @XmlTransient
    public List<Arquivocip> getArquivocipList() {
        return arquivocipList;
    }

    public void setArquivocipList(List<Arquivocip> arquivocipList) {
        this.arquivocipList = arquivocipList;
    }

    @XmlTransient
    public List<Linhabookretorno> getLinhabookretornoList() {
        return linhabookretornoList;
    }

    public void setLinhabookretornoList(List<Linhabookretorno> linhabookretornoList) {
        this.linhabookretornoList = linhabookretornoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeBookRetorno != null ? nomeBookRetorno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookretorno)) {
            return false;
        }
        Bookretorno other = (Bookretorno) object;
        if ((this.nomeBookRetorno == null && other.nomeBookRetorno != null) || (this.nomeBookRetorno != null && !this.nomeBookRetorno.equals(other.nomeBookRetorno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bookretorno[ nomeBookRetorno=" + nomeBookRetorno + " ]";
    }
    
}
