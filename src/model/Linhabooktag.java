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
@Table(name = "linhabooktag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhabooktag.findAll", query = "SELECT l FROM Linhabooktag l"),
    @NamedQuery(name = "Linhabooktag.findByCodigoLinhaBookTag", query = "SELECT l FROM Linhabooktag l WHERE l.codigoLinhaBookTag = :codigoLinhaBookTag"),
    @NamedQuery(name = "Linhabooktag.findByLinhaCodigo", query = "SELECT l FROM Linhabooktag l WHERE l.linhaCodigo = :linhaCodigo")})
public class Linhabooktag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoLinhaBookTag")
    private Integer codigoLinhaBookTag;
    @Basic(optional = false)
    @Column(name = "LinhaCodigo")
    private String linhaCodigo;
    @JoinColumn(name = "BookTag_NomeBookTag", referencedColumnName = "NomeBookTag")
    @ManyToOne(optional = false)
    private Booktag bookTagNomeBookTag;

    public Linhabooktag() {
    }

    public Linhabooktag(Integer codigoLinhaBookTag) {
        this.codigoLinhaBookTag = codigoLinhaBookTag;
    }

    public Linhabooktag(Integer codigoLinhaBookTag, String linhaCodigo) {
        this.codigoLinhaBookTag = codigoLinhaBookTag;
        this.linhaCodigo = linhaCodigo;
    }

    public Integer getCodigoLinhaBookTag() {
        return codigoLinhaBookTag;
    }

    public void setCodigoLinhaBookTag(Integer codigoLinhaBookTag) {
        this.codigoLinhaBookTag = codigoLinhaBookTag;
    }

    public String getLinhaCodigo() {
        return linhaCodigo;
    }

    public void setLinhaCodigo(String linhaCodigo) {
        this.linhaCodigo = linhaCodigo;
    }

    public Booktag getBookTagNomeBookTag() {
        return bookTagNomeBookTag;
    }

    public void setBookTagNomeBookTag(Booktag bookTagNomeBookTag) {
        this.bookTagNomeBookTag = bookTagNomeBookTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLinhaBookTag != null ? codigoLinhaBookTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhabooktag)) {
            return false;
        }
        Linhabooktag other = (Linhabooktag) object;
        if ((this.codigoLinhaBookTag == null && other.codigoLinhaBookTag != null) || (this.codigoLinhaBookTag != null && !this.codigoLinhaBookTag.equals(other.codigoLinhaBookTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Linhabooktag[ codigoLinhaBookTag=" + codigoLinhaBookTag + " ]";
    }
    
}
