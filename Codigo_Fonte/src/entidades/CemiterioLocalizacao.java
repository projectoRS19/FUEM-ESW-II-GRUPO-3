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
@Table(name = "cemiterio_localizacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CemiterioLocalizacao.findAll", query = "SELECT c FROM CemiterioLocalizacao c")
    , @NamedQuery(name = "CemiterioLocalizacao.findByLocalizacao", query = "SELECT c FROM CemiterioLocalizacao c WHERE c.localizacao = :localizacao")})
public class CemiterioLocalizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "localizacao")
    private String localizacao;
    @JoinColumn(name = "codCemiterio", referencedColumnName = "codCemiterio")
    @ManyToOne(optional = false)
    private Cemiterio codCemiterio;

    public CemiterioLocalizacao() {
    }

    public CemiterioLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Cemiterio getCodCemiterio() {
        return codCemiterio;
    }

    public void setCodCemiterio(Cemiterio codCemiterio) {
        this.codCemiterio = codCemiterio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localizacao != null ? localizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CemiterioLocalizacao)) {
            return false;
        }
        CemiterioLocalizacao other = (CemiterioLocalizacao) object;
        if ((this.localizacao == null && other.localizacao != null) || (this.localizacao != null && !this.localizacao.equals(other.localizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CemiterioLocalizacao[ localizacao=" + localizacao + " ]";
    }
    
}
