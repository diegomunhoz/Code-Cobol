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
@Table(name = "linhabookauxiliar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhabookauxiliar.findAll", query = "SELECT l FROM Linhabookauxiliar l"),
    @NamedQuery(name = "Linhabookauxiliar.findByCodigoLinhaBookAuxiliar", query = "SELECT l FROM Linhabookauxiliar l WHERE l.codigoLinhaBookAuxiliar = :codigoLinhaBookAuxiliar"),
    @NamedQuery(name = "Linhabookauxiliar.findByLinhaCodigo", query = "SELECT l FROM Linhabookauxiliar l WHERE l.linhaCodigo = :linhaCodigo")})
public class Linhabookauxiliar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoLinhaBookAuxiliar")
    private Integer codigoLinhaBookAuxiliar;
    @Basic(optional = false)
    @Column(name = "LinhaCodigo")
    private String linhaCodigo;
    @JoinColumn(name = "BookAuxiliar_NomeBookAuxiliar", referencedColumnName = "NomeBookAuxiliar")
    @ManyToOne(optional = false)
    private Bookauxiliar bookAuxiliarNomeBookAuxiliar;

    public Linhabookauxiliar() {
    }

    public Linhabookauxiliar(Integer codigoLinhaBookAuxiliar) {
        this.codigoLinhaBookAuxiliar = codigoLinhaBookAuxiliar;
    }

    public Linhabookauxiliar(Integer codigoLinhaBookAuxiliar, String linhaCodigo) {
        this.codigoLinhaBookAuxiliar = codigoLinhaBookAuxiliar;
        this.linhaCodigo = linhaCodigo;
    }

    public Integer getCodigoLinhaBookAuxiliar() {
        return codigoLinhaBookAuxiliar;
    }

    public void setCodigoLinhaBookAuxiliar(Integer codigoLinhaBookAuxiliar) {
        this.codigoLinhaBookAuxiliar = codigoLinhaBookAuxiliar;
    }

    public String getLinhaCodigo() {
        return linhaCodigo;
    }

    public void setLinhaCodigo(String linhaCodigo) {
        this.linhaCodigo = linhaCodigo;
    }

    public Bookauxiliar getBookAuxiliarNomeBookAuxiliar() {
        return bookAuxiliarNomeBookAuxiliar;
    }

    public void setBookAuxiliarNomeBookAuxiliar(Bookauxiliar bookAuxiliarNomeBookAuxiliar) {
        this.bookAuxiliarNomeBookAuxiliar = bookAuxiliarNomeBookAuxiliar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLinhaBookAuxiliar != null ? codigoLinhaBookAuxiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhabookauxiliar)) {
            return false;
        }
        Linhabookauxiliar other = (Linhabookauxiliar) object;
        if ((this.codigoLinhaBookAuxiliar == null && other.codigoLinhaBookAuxiliar != null) || (this.codigoLinhaBookAuxiliar != null && !this.codigoLinhaBookAuxiliar.equals(other.codigoLinhaBookAuxiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Linhabookauxiliar[ codigoLinhaBookAuxiliar=" + codigoLinhaBookAuxiliar + " ]";
    }
    
}
