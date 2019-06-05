/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Edson
 */
@Embeddable
public class AdministrativoFamiliaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codAdministrativo")
    private int codAdministrativo;
    @Basic(optional = false)
    @Column(name = "codFamilia")
    private int codFamilia;

    public AdministrativoFamiliaPK() {
    }

    public AdministrativoFamiliaPK(int codAdministrativo, int codFamilia) {
        this.codAdministrativo = codAdministrativo;
        this.codFamilia = codFamilia;
    }

    public int getCodAdministrativo() {
        return codAdministrativo;
    }

    public void setCodAdministrativo(int codAdministrativo) {
        this.codAdministrativo = codAdministrativo;
    }

    public int getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(int codFamilia) {
        this.codFamilia = codFamilia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codAdministrativo;
        hash += (int) codFamilia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministrativoFamiliaPK)) {
            return false;
        }
        AdministrativoFamiliaPK other = (AdministrativoFamiliaPK) object;
        if (this.codAdministrativo != other.codAdministrativo) {
            return false;
        }
        if (this.codFamilia != other.codFamilia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AdministrativoFamiliaPK[ codAdministrativo=" + codAdministrativo + ", codFamilia=" + codFamilia + " ]";
    }
    
}
