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
@Table(name = "linhabookenvio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhabookenvio.findAll", query = "SELECT l FROM Linhabookenvio l"),
    @NamedQuery(name = "Linhabookenvio.findByCodigoLinhaBookEnvio", query = "SELECT l FROM Linhabookenvio l WHERE l.codigoLinhaBookEnvio = :codigoLinhaBookEnvio"),
    @NamedQuery(name = "Linhabookenvio.findByLinhaCodigo", query = "SELECT l FROM Linhabookenvio l WHERE l.linhaCodigo = :linhaCodigo")})
public class Linhabookenvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoLinhaBookEnvio")
    private Integer codigoLinhaBookEnvio;
    @Basic(optional = false)
    @Column(name = "LinhaCodigo")
    private String linhaCodigo;
    @JoinColumn(name = "BookEnvio_NomeBookEnvio", referencedColumnName = "NomeBookEnvio")
    @ManyToOne(optional = false)
    private Bookenvio bookEnvioNomeBookEnvio;

    public Linhabookenvio() {
    }

    public Linhabookenvio(Integer codigoLinhaBookEnvio) {
        this.codigoLinhaBookEnvio = codigoLinhaBookEnvio;
    }

    public Linhabookenvio(Integer codigoLinhaBookEnvio, String linhaCodigo) {
        this.codigoLinhaBookEnvio = codigoLinhaBookEnvio;
        this.linhaCodigo = linhaCodigo;
    }

    public Integer getCodigoLinhaBookEnvio() {
        return codigoLinhaBookEnvio;
    }

    public void setCodigoLinhaBookEnvio(Integer codigoLinhaBookEnvio) {
        this.codigoLinhaBookEnvio = codigoLinhaBookEnvio;
    }

    public String getLinhaCodigo() {
        return linhaCodigo;
    }

    public void setLinhaCodigo(String linhaCodigo) {
        this.linhaCodigo = linhaCodigo;
    }

    public Bookenvio getBookEnvioNomeBookEnvio() {
        return bookEnvioNomeBookEnvio;
    }

    public void setBookEnvioNomeBookEnvio(Bookenvio bookEnvioNomeBookEnvio) {
        this.bookEnvioNomeBookEnvio = bookEnvioNomeBookEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLinhaBookEnvio != null ? codigoLinhaBookEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhabookenvio)) {
            return false;
        }
        Linhabookenvio other = (Linhabookenvio) object;
        if ((this.codigoLinhaBookEnvio == null && other.codigoLinhaBookEnvio != null) || (this.codigoLinhaBookEnvio != null && !this.codigoLinhaBookEnvio.equals(other.codigoLinhaBookEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Linhabookenvio[ codigoLinhaBookEnvio=" + codigoLinhaBookEnvio + " ]";
    }
    
}
