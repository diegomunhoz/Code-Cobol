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
@Table(name = "bookauxiliar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookauxiliar.findAll", query = "SELECT b FROM Bookauxiliar b"),
    @NamedQuery(name = "Bookauxiliar.findByNomeBookAuxiliar", query = "SELECT b FROM Bookauxiliar b WHERE b.nomeBookAuxiliar = :nomeBookAuxiliar"),
    @NamedQuery(name = "Bookauxiliar.findByDataCriacao", query = "SELECT b FROM Bookauxiliar b WHERE b.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "Bookauxiliar.findByDataAtualizacao", query = "SELECT b FROM Bookauxiliar b WHERE b.dataAtualizacao = :dataAtualizacao"),
    @NamedQuery(name = "Bookauxiliar.findByTamanho", query = "SELECT b FROM Bookauxiliar b WHERE b.tamanho = :tamanho")})
public class Bookauxiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NomeBookAuxiliar")
    private String nomeBookAuxiliar;
    @Column(name = "DataCriacao")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    @Column(name = "DataAtualizacao")
    @Temporal(TemporalType.DATE)
    private Date dataAtualizacao;
    @Basic(optional = false)
    @Column(name = "Tamanho")
    private int tamanho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookAuxiliarNomeBookAuxiliar")
    private List<Linhabookauxiliar> linhabookauxiliarList;

    public Bookauxiliar() {
    }

    public Bookauxiliar(String nomeBookAuxiliar) {
        this.nomeBookAuxiliar = nomeBookAuxiliar;
    }

    public Bookauxiliar(String nomeBookAuxiliar, int tamanho) {
        this.nomeBookAuxiliar = nomeBookAuxiliar;
        this.tamanho = tamanho;
    }

    public String getNomeBookAuxiliar() {
        return nomeBookAuxiliar;
    }

    public void setNomeBookAuxiliar(String nomeBookAuxiliar) {
        this.nomeBookAuxiliar = nomeBookAuxiliar;
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
    public List<Linhabookauxiliar> getLinhabookauxiliarList() {
        return linhabookauxiliarList;
    }

    public void setLinhabookauxiliarList(List<Linhabookauxiliar> linhabookauxiliarList) {
        this.linhabookauxiliarList = linhabookauxiliarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeBookAuxiliar != null ? nomeBookAuxiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookauxiliar)) {
            return false;
        }
        Bookauxiliar other = (Bookauxiliar) object;
        if ((this.nomeBookAuxiliar == null && other.nomeBookAuxiliar != null) || (this.nomeBookAuxiliar != null && !this.nomeBookAuxiliar.equals(other.nomeBookAuxiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bookauxiliar[ nomeBookAuxiliar=" + nomeBookAuxiliar + " ]";
    }
    
}
