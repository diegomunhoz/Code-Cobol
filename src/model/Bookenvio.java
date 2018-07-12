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
@Table(name = "bookenvio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookenvio.findAll", query = "SELECT b FROM Bookenvio b"),
    @NamedQuery(name = "Bookenvio.findByNomeBookEnvio", query = "SELECT b FROM Bookenvio b WHERE b.nomeBookEnvio = :nomeBookEnvio"),
    @NamedQuery(name = "Bookenvio.findByDataCriacao", query = "SELECT b FROM Bookenvio b WHERE b.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Bookenvio.findByDAtaAtualizacao", query = "SELECT b FROM Bookenvio b WHERE b.dAtaAtualizacao = :dAtaAtualizacao"),
    @NamedQuery(name = "Bookenvio.findByTamanho", query = "SELECT b FROM Bookenvio b WHERE b.tamanho = :tamanho")})
public class Bookenvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeBookEnvio")
    private String nomeBookEnvio;
    @Column(name = "DataCriacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Column(name = "DAtaAtualizacao")
    @Temporal(TemporalType.DATE)
    private Date dAtaAtualizacao;
    @Basic(optional = false)
    @Column(name = "Tamanho")
    private int tamanho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookEnvioNomeBookEnvio")
    private List<Linhabookenvio> linhabookenvioList;
    @OneToMany(mappedBy = "bookEnvioNomeBookEnvio")
    private List<Arquivocip> arquivocipList;

    public Bookenvio() {
    }

    public Bookenvio(String nomeBookEnvio) {
        this.nomeBookEnvio = nomeBookEnvio;
    }

    public Bookenvio(String nomeBookEnvio, int tamanho) {
        this.nomeBookEnvio = nomeBookEnvio;
        this.tamanho = tamanho;
    }

    public String getNomeBookEnvio() {
        return nomeBookEnvio;
    }

    public void setNomeBookEnvio(String nomeBookEnvio) {
        this.nomeBookEnvio = nomeBookEnvio;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDAtaAtualizacao() {
        return dAtaAtualizacao;
    }

    public void setDAtaAtualizacao(Date dAtaAtualizacao) {
        this.dAtaAtualizacao = dAtaAtualizacao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @XmlTransient
    public List<Linhabookenvio> getLinhabookenvioList() {
        return linhabookenvioList;
    }

    public void setLinhabookenvioList(List<Linhabookenvio> linhabookenvioList) {
        this.linhabookenvioList = linhabookenvioList;
    }

    @XmlTransient
    public List<Arquivocip> getArquivocipList() {
        return arquivocipList;
    }

    public void setArquivocipList(List<Arquivocip> arquivocipList) {
        this.arquivocipList = arquivocipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeBookEnvio != null ? nomeBookEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookenvio)) {
            return false;
        }
        Bookenvio other = (Bookenvio) object;
        if ((this.nomeBookEnvio == null && other.nomeBookEnvio != null) || (this.nomeBookEnvio != null && !this.nomeBookEnvio.equals(other.nomeBookEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bookenvio[ nomeBookEnvio=" + nomeBookEnvio + " ]";
    }
    
}
