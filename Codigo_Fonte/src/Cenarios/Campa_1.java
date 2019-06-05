/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cenarios;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Edson
 */
@Entity
@Table(name = "campa", catalog = "cemiterio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Campa_1.findAll", query = "SELECT c FROM Campa_1 c")
    , @NamedQuery(name = "Campa_1.findByCodCampa", query = "SELECT c FROM Campa_1 c WHERE c.codCampa = :codCampa")
    , @NamedQuery(name = "Campa_1.findByZona", query = "SELECT c FROM Campa_1 c WHERE c.zona = :zona")
    , @NamedQuery(name = "Campa_1.findByQuarteirao", query = "SELECT c FROM Campa_1 c WHERE c.quarteirao = :quarteirao")
    , @NamedQuery(name = "Campa_1.findByQuantidade", query = "SELECT c FROM Campa_1 c WHERE c.quantidade = :quantidade")
    , @NamedQuery(name = "Campa_1.findByCodCemiterio", query = "SELECT c FROM Campa_1 c WHERE c.codCemiterio = :codCemiterio")})
public class Campa_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codCampa")
    private Integer codCampa;
    @Basic(optional = false)
    @Column(name = "zona")
    private String zona;
    @Basic(optional = false)
    @Column(name = "quarteirao")
    private int quarteirao;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "codCemiterio")
    private int codCemiterio;

    public Campa_1() {
    }

    public Campa_1(Integer codCampa) {
        this.codCampa = codCampa;
    }

    public Campa_1(Integer codCampa, String zona, int quarteirao, int quantidade, int codCemiterio) {
        this.codCampa = codCampa;
        this.zona = zona;
        this.quarteirao = quarteirao;
        this.quantidade = quantidade;
        this.codCemiterio = codCemiterio;
    }

    public Integer getCodCampa() {
        return codCampa;
    }

    public void setCodCampa(Integer codCampa) {
        Integer oldCodCampa = this.codCampa;
        this.codCampa = codCampa;
        changeSupport.firePropertyChange("codCampa", oldCodCampa, codCampa);
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        String oldZona = this.zona;
        this.zona = zona;
        changeSupport.firePropertyChange("zona", oldZona, zona);
    }

    public int getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(int quarteirao) {
        int oldQuarteirao = this.quarteirao;
        this.quarteirao = quarteirao;
        changeSupport.firePropertyChange("quarteirao", oldQuarteirao, quarteirao);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        int oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public int getCodCemiterio() {
        return codCemiterio;
    }

    public void setCodCemiterio(int codCemiterio) {
        int oldCodCemiterio = this.codCemiterio;
        this.codCemiterio = codCemiterio;
        changeSupport.firePropertyChange("codCemiterio", oldCodCemiterio, codCemiterio);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCampa != null ? codCampa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campa_1)) {
            return false;
        }
        Campa_1 other = (Campa_1) object;
        if ((this.codCampa == null && other.codCampa != null) || (this.codCampa != null && !this.codCampa.equals(other.codCampa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cenarios.Campa_1[ codCampa=" + codCampa + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
