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
@Table(name = "linhacodigoprogramacobol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhacodigoprogramacobol.findAll", query = "SELECT l FROM Linhacodigoprogramacobol l"),
    @NamedQuery(name = "Linhacodigoprogramacobol.findByCodigoLinhaCodigoProgramaCobol", query = "SELECT l FROM Linhacodigoprogramacobol l WHERE l.codigoLinhaCodigoProgramaCobol = :codigoLinhaCodigoProgramaCobol"),
    @NamedQuery(name = "Linhacodigoprogramacobol.findByLinhaCodigo", query = "SELECT l FROM Linhacodigoprogramacobol l WHERE l.linhaCodigo = :linhaCodigo")})
public class Linhacodigoprogramacobol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoLinhaCodigoProgramaCobol")
    private Integer codigoLinhaCodigoProgramaCobol;
    @Basic(optional = false)
    @Column(name = "LinhaCodigo")
    private String linhaCodigo;
    @JoinColumn(name = "ProgramaCobolCip_NomeProgramaCobolCip", referencedColumnName = "NomeProgramaCobolCip")
    @ManyToOne(optional = false)
    private Programacobolcip programaCobolCipNomeProgramaCobolCip;

    public Linhacodigoprogramacobol() {
    }

    public Linhacodigoprogramacobol(Integer codigoLinhaCodigoProgramaCobol) {
        this.codigoLinhaCodigoProgramaCobol = codigoLinhaCodigoProgramaCobol;
    }

    public Linhacodigoprogramacobol(Integer codigoLinhaCodigoProgramaCobol, String linhaCodigo) {
        this.codigoLinhaCodigoProgramaCobol = codigoLinhaCodigoProgramaCobol;
        this.linhaCodigo = linhaCodigo;
    }

    public Integer getCodigoLinhaCodigoProgramaCobol() {
        return codigoLinhaCodigoProgramaCobol;
    }

    public void setCodigoLinhaCodigoProgramaCobol(Integer codigoLinhaCodigoProgramaCobol) {
        this.codigoLinhaCodigoProgramaCobol = codigoLinhaCodigoProgramaCobol;
    }

    public String getLinhaCodigo() {
        return linhaCodigo;
    }

    public void setLinhaCodigo(String linhaCodigo) {
        this.linhaCodigo = linhaCodigo;
    }

    public Programacobolcip getProgramaCobolCipNomeProgramaCobolCip() {
        return programaCobolCipNomeProgramaCobolCip;
    }

    public void setProgramaCobolCipNomeProgramaCobolCip(Programacobolcip programaCobolCipNomeProgramaCobolCip) {
        this.programaCobolCipNomeProgramaCobolCip = programaCobolCipNomeProgramaCobolCip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLinhaCodigoProgramaCobol != null ? codigoLinhaCodigoProgramaCobol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhacodigoprogramacobol)) {
            return false;
        }
        Linhacodigoprogramacobol other = (Linhacodigoprogramacobol) object;
        if ((this.codigoLinhaCodigoProgramaCobol == null && other.codigoLinhaCodigoProgramaCobol != null) || (this.codigoLinhaCodigoProgramaCobol != null && !this.codigoLinhaCodigoProgramaCobol.equals(other.codigoLinhaCodigoProgramaCobol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Linhacodigoprogramacobol[ codigoLinhaCodigoProgramaCobol=" + codigoLinhaCodigoProgramaCobol + " ]";
    }
    
}
