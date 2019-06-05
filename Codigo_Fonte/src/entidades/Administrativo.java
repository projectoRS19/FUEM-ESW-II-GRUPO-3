/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edson
 */
@Entity
@Table(name = "administrativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrativo.findAll", query = "SELECT a FROM Administrativo a")
    , @NamedQuery(name = "Administrativo.findByCodAdministrativo", query = "SELECT a FROM Administrativo a WHERE a.codAdministrativo = :codAdministrativo")
    , @NamedQuery(name = "Administrativo.findByFuncao", query = "SELECT a FROM Administrativo a WHERE a.funcao = :funcao")})
public class Administrativo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codAdministrativo")
    private Integer codAdministrativo;
    @Basic(optional = false)
    @Column(name = "funcao")
    private String funcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administrativo")
    private Collection<AdministrativoFamilia> administrativoFamiliaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAdministrativo")
    private Collection<Operario> operarioCollection;

    public Administrativo() {
    }

    public Administrativo(Integer codAdministrativo) {
        this.codAdministrativo = codAdministrativo;
    }

    public Administrativo(Integer codAdministrativo, String funcao) {
        this.codAdministrativo = codAdministrativo;
        this.funcao = funcao;
    }

    public Integer getCodAdministrativo() {
        return codAdministrativo;
    }

    public void setCodAdministrativo(Integer codAdministrativo) {
        Integer oldCodAdministrativo = this.codAdministrativo;
        this.codAdministrativo = codAdministrativo;
        changeSupport.firePropertyChange("codAdministrativo", oldCodAdministrativo, codAdministrativo);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        String oldFuncao = this.funcao;
        this.funcao = funcao;
        changeSupport.firePropertyChange("funcao", oldFuncao, funcao);
    }

    @XmlTransient
    public Collection<AdministrativoFamilia> getAdministrativoFamiliaCollection() {
        return administrativoFamiliaCollection;
    }

    public void setAdministrativoFamiliaCollection(Collection<AdministrativoFamilia> administrativoFamiliaCollection) {
        this.administrativoFamiliaCollection = administrativoFamiliaCollection;
    }

    @XmlTransient
    public Collection<Operario> getOperarioCollection() {
        return operarioCollection;
    }

    public void setOperarioCollection(Collection<Operario> operarioCollection) {
        this.operarioCollection = operarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAdministrativo != null ? codAdministrativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrativo)) {
            return false;
        }
        Administrativo other = (Administrativo) object;
        if ((this.codAdministrativo == null && other.codAdministrativo != null) || (this.codAdministrativo != null && !this.codAdministrativo.equals(other.codAdministrativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Administrativo[ codAdministrativo=" + codAdministrativo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
