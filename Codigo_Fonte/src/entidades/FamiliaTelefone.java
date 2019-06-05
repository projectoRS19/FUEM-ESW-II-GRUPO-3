/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
 * @author Edson
 */
@Entity
@Table(name = "familia_telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamiliaTelefone.findAll", query = "SELECT f FROM FamiliaTelefone f")
    , @NamedQuery(name = "FamiliaTelefone.findByTelefoneFamilia", query = "SELECT f FROM FamiliaTelefone f WHERE f.telefoneFamilia = :telefoneFamilia")})
public class FamiliaTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telefone_familia")
    private Integer telefoneFamilia;
    @JoinColumn(name = "codFamilia", referencedColumnName = "codFamilia")
    @ManyToOne(optional = false)
    private Familia codFamilia;

    public FamiliaTelefone() {
    }

    public FamiliaTelefone(Integer telefoneFamilia) {
        this.telefoneFamilia = telefoneFamilia;
    }

    public Integer getTelefoneFamilia() {
        return telefoneFamilia;
    }

    public void setTelefoneFamilia(Integer telefoneFamilia) {
        this.telefoneFamilia = telefoneFamilia;
    }

    public Familia getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(Familia codFamilia) {
        this.codFamilia = codFamilia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefoneFamilia != null ? telefoneFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamiliaTelefone)) {
            return false;
        }
        FamiliaTelefone other = (FamiliaTelefone) object;
        if ((this.telefoneFamilia == null && other.telefoneFamilia != null) || (this.telefoneFamilia != null && !this.telefoneFamilia.equals(other.telefoneFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FamiliaTelefone[ telefoneFamilia=" + telefoneFamilia + " ]";
    }
    
}
