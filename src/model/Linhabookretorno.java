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
@Table(name = "linhabookretorno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhabookretorno.findAll", query = "SELECT l FROM Linhabookretorno l"),
    @NamedQuery(name = "Linhabookretorno.findByCodigoLinhaBookRetorno", query = "SELECT l FROM Linhabookretorno l WHERE l.codigoLinhaBookRetorno = :codigoLinhaBookRetorno"),
    @NamedQuery(name = "Linhabookretorno.findByLinhaCodigo", query = "SELECT l FROM Linhabookretorno l WHERE l.linhaCodigo = :linhaCodigo")})
public class Linhabookretorno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodigoLinhaBookRetorno")
    private Integer codigoLinhaBookRetorno;
    @Basic(optional = false)
    @Column(name = "LinhaCodigo")
    private String linhaCodigo;
    @JoinColumn(name = "BookRetorno_NomeBookRetorno", referencedColumnName = "NomeBookRetorno")
    @ManyToOne(optional = false)
    private Bookretorno bookRetornoNomeBookRetorno;

    public Linhabookretorno() {
    }

    public Linhabookretorno(Integer codigoLinhaBookRetorno) {
        this.codigoLinhaBookRetorno = codigoLinhaBookRetorno;
    }

    public Linhabookretorno(Integer codigoLinhaBookRetorno, String linhaCodigo) {
        this.codigoLinhaBookRetorno = codigoLinhaBookRetorno;
        this.linhaCodigo = linhaCodigo;
    }

    public Integer getCodigoLinhaBookRetorno() {
        return codigoLinhaBookRetorno;
    }

    public void setCodigoLinhaBookRetorno(Integer codigoLinhaBookRetorno) {
        this.codigoLinhaBookRetorno = codigoLinhaBookRetorno;
    }

    public String getLinhaCodigo() {
        return linhaCodigo;
    }

    public void setLinhaCodigo(String linhaCodigo) {
        this.linhaCodigo = linhaCodigo;
    }

    public Bookretorno getBookRetornoNomeBookRetorno() {
        return bookRetornoNomeBookRetorno;
    }

    public void setBookRetornoNomeBookRetorno(Bookretorno bookRetornoNomeBookRetorno) {
        this.bookRetornoNomeBookRetorno = bookRetornoNomeBookRetorno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLinhaBookRetorno != null ? codigoLinhaBookRetorno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhabookretorno)) {
            return false;
        }
        Linhabookretorno other = (Linhabookretorno) object;
        if ((this.codigoLinhaBookRetorno == null && other.codigoLinhaBookRetorno != null) || (this.codigoLinhaBookRetorno != null && !this.codigoLinhaBookRetorno.equals(other.codigoLinhaBookRetorno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Linhabookretorno[ codigoLinhaBookRetorno=" + codigoLinhaBookRetorno + " ]";
    }
    
}
