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
@Table(name = "cemiterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cemiterio.findAll", query = "SELECT c FROM Cemiterio c")
    , @NamedQuery(name = "Cemiterio.findByCodCemiterio", query = "SELECT c FROM Cemiterio c WHERE c.codCemiterio = :codCemiterio")
    , @NamedQuery(name = "Cemiterio.findByNome", query = "SELECT c FROM Cemiterio c WHERE c.nome = :nome")})
public class Cemiterio implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codCemiterio")
    private Integer codCemiterio;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCemiterio")
    private Collection<Campa> campaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCemiterio")
    private Collection<CemiterioLocalizacao> cemiterioLocalizacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCemiterio")
    private Collection<Funcionario> funcionarioCollection;

    public Cemiterio() {
    }

    public Cemiterio(Integer codCemiterio) {
        this.codCemiterio = codCemiterio;
    }

    public Cemiterio(Integer codCemiterio, String nome) {
        this.codCemiterio = codCemiterio;
        this.nome = nome;
    }

    public Integer getCodCemiterio() {
        return codCemiterio;
    }

    public void setCodCemiterio(Integer codCemiterio) {
        Integer oldCodCemiterio = this.codCemiterio;
        this.codCemiterio = codCemiterio;
        changeSupport.firePropertyChange("codCemiterio", oldCodCemiterio, codCemiterio);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    @XmlTransient
    public Collection<Campa> getCampaCollection() {
        return campaCollection;
    }

    public void setCampaCollection(Collection<Campa> campaCollection) {
        this.campaCollection = campaCollection;
    }

    @XmlTransient
    public Collection<CemiterioLocalizacao> getCemiterioLocalizacaoCollection() {
        return cemiterioLocalizacaoCollection;
    }

    public void setCemiterioLocalizacaoCollection(Collection<CemiterioLocalizacao> cemiterioLocalizacaoCollection) {
        this.cemiterioLocalizacaoCollection = cemiterioLocalizacaoCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCemiterio != null ? codCemiterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cemiterio)) {
            return false;
        }
        Cemiterio other = (Cemiterio) object;
        if ((this.codCemiterio == null && other.codCemiterio != null) || (this.codCemiterio != null && !this.codCemiterio.equals(other.codCemiterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cemiterio[ codCemiterio=" + codCemiterio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
