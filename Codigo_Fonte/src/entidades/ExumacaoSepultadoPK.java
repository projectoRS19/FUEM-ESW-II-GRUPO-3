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
public class ExumacaoSepultadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codMalogrado")
    private int codMalogrado;
    @Basic(optional = false)
    @Column(name = "codCampa")
    private int codCampa;
    @Basic(optional = false)
    @Column(name = "codOperario")
    private int codOperario;

    public ExumacaoSepultadoPK() {
    }

    public ExumacaoSepultadoPK(int codMalogrado, int codCampa, int codOperario) {
        this.codMalogrado = codMalogrado;
        this.codCampa = codCampa;
        this.codOperario = codOperario;
    }

    public int getCodMalogrado() {
        return codMalogrado;
    }

    public void setCodMalogrado(int codMalogrado) {
        this.codMalogrado = codMalogrado;
    }

    public int getCodCampa() {
        return codCampa;
    }

    public void setCodCampa(int codCampa) {
        this.codCampa = codCampa;
    }

    public int getCodOperario() {
        return codOperario;
    }

    public void setCodOperario(int codOperario) {
        this.codOperario = codOperario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codMalogrado;
        hash += (int) codCampa;
        hash += (int) codOperario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExumacaoSepultadoPK)) {
            return false;
        }
        ExumacaoSepultadoPK other = (ExumacaoSepultadoPK) object;
        if (this.codMalogrado != other.codMalogrado) {
            return false;
        }
        if (this.codCampa != other.codCampa) {
            return false;
        }
        if (this.codOperario != other.codOperario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ExumacaoSepultadoPK[ codMalogrado=" + codMalogrado + ", codCampa=" + codCampa + ", codOperario=" + codOperario + " ]";
    }
    
}
