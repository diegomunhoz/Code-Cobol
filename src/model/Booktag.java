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
@Table(name = "booktag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booktag.findAll", query = "SELECT b FROM Booktag b"),
    @NamedQuery(name = "Booktag.findByNomeBookTag", query = "SELECT b FROM Booktag b WHERE b.nomeBookTag = :nomeBookTag"),
    @NamedQuery(name = "Booktag.findByDataCriacao", query = "SELECT b FROM Booktag b WHERE b.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Booktag.findByDataAtualizacao", query = "SELECT b FROM Booktag b WHERE b.dataAtualizacao = :dataAtualizacao"),
    @NamedQuery(name = "Booktag.findByTamanho", query = "SELECT b FROM Booktag b WHERE b.tamanho = :tamanho")})
public class Booktag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeBookTag")
    private String nomeBookTag;
    @Column(name = "DataCriacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Column(name = "DataAtualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
    @Basic(optional = false)
    @Column(name = "Tamanho")
    private int tamanho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookTagNomeBookTag")
    private List<Linhabooktag> linhabooktagList;
    @OneToMany(mappedBy = "bookTagNomeBookTag")
    private List<Arquivocip> arquivocipList;

    public Booktag() {
    }

    public Booktag(String nomeBookTag) {
        this.nomeBookTag = nomeBookTag;
    }

    public Booktag(String nomeBookTag, int tamanho) {
        this.nomeBookTag = nomeBookTag;
        this.tamanho = tamanho;
    }

    public String getNomeBookTag() {
        return nomeBookTag;
    }

    public void setNomeBookTag(String nomeBookTag) {
        this.nomeBookTag = nomeBookTag;
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
    public List<Linhabooktag> getLinhabooktagList() {
        return linhabooktagList;
    }

    public void setLinhabooktagList(List<Linhabooktag> linhabooktagList) {
        this.linhabooktagList = linhabooktagList;
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
        hash += (nomeBookTag != null ? nomeBookTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booktag)) {
            return false;
        }
        Booktag other = (Booktag) object;
        if ((this.nomeBookTag == null && other.nomeBookTag != null) || (this.nomeBookTag != null && !this.nomeBookTag.equals(other.nomeBookTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Booktag[ nomeBookTag=" + nomeBookTag + " ]";
    }
    
}
