/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edson
 */
@Entity
@Table(name = "campa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campa.findAll", query = "SELECT c FROM Campa c")
    , @NamedQuery(name = "Campa.findByCodCampa", query = "SELECT c FROM Campa c WHERE c.codCampa = :codCampa")
    , @NamedQuery(name = "Campa.findByZona", query = "SELECT c FROM Campa c WHERE c.zona = :zona")
    , @NamedQuery(name = "Campa.findByQuarteirao", query = "SELECT c FROM Campa c WHERE c.quarteirao = :quarteirao")
    , @NamedQuery(name = "Campa.findByQuantidade", query = "SELECT c FROM Campa c WHERE c.quantidade = :quantidade")})
public class Campa implements Serializable {

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
    @JoinColumn(name = "codCemiterio", referencedColumnName = "codCemiterio")
    @ManyToOne(optional = false)
    private Cemiterio codCemiterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCampa")
    private Collection<Malogrado> malogradoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campa")
    private Collection<ExumacaoSepultado> exumacaoSepultadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campa")
    private Collection<CampaOperario> campaOperarioCollection;

    public Campa() {
    }

    public Campa(Integer codCampa) {
        this.codCampa = codCampa;
    }

    public Campa(Integer codCampa, String zona, int quarteirao, int quantidade) {
        this.codCampa = codCampa;
        this.zona = zona;
        this.quarteirao = quarteirao;
        this.quantidade = quantidade;
    }

    public Integer getCodCampa() {
        return codCampa;
    }

    public void setCodCampa(Integer codCampa) {
        this.codCampa = codCampa;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(int quarteirao) {
        this.quarteirao = quarteirao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cemiterio getCodCemiterio() {
        return codCemiterio;
    }

    public void setCodCemiterio(Cemiterio codCemiterio) {
        this.codCemiterio = codCemiterio;
    }

    @XmlTransient
    public Collection<Malogrado> getMalogradoCollection() {
        return malogradoCollection;
    }

    public void setMalogradoCollection(Collection<Malogrado> malogradoCollection) {
        this.malogradoCollection = malogradoCollection;
    }

    @XmlTransient
    public Collection<ExumacaoSepultado> getExumacaoSepultadoCollection() {
        return exumacaoSepultadoCollection;
    }

    public void setExumacaoSepultadoCollection(Collection<ExumacaoSepultado> exumacaoSepultadoCollection) {
        this.exumacaoSepultadoCollection = exumacaoSepultadoCollection;
    }

    @XmlTransient
    public Collection<CampaOperario> getCampaOperarioCollection() {
        return campaOperarioCollection;
    }

    public void setCampaOperarioCollection(Collection<CampaOperario> campaOperarioCollection) {
        this.campaOperarioCollection = campaOperarioCollection;
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
        if (!(object instanceof Campa)) {
            return false;
        }
        Campa other = (Campa) object;
        if ((this.codCampa == null && other.codCampa != null) || (this.codCampa != null && !this.codCampa.equals(other.codCampa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Campa[ codCampa=" + codCampa + " ]";
    }
    
}
