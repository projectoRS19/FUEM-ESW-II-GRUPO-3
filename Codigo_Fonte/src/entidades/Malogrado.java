/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Edson
 */
@Entity
@Table(name = "malogrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Malogrado.findAll", query = "SELECT m FROM Malogrado m")
    , @NamedQuery(name = "Malogrado.findByCodMalogrado", query = "SELECT m FROM Malogrado m WHERE m.codMalogrado = :codMalogrado")
    , @NamedQuery(name = "Malogrado.findByDataNascimento", query = "SELECT m FROM Malogrado m WHERE m.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Malogrado.findByDataMorte", query = "SELECT m FROM Malogrado m WHERE m.dataMorte = :dataMorte")})
public class Malogrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codMalogrado")
    private Integer codMalogrado;
    @Basic(optional = false)
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "dataMorte")
    @Temporal(TemporalType.DATE)
    private Date dataMorte;
    @JoinColumn(name = "codFamilia", referencedColumnName = "codFamilia")
    @ManyToOne
    private Familia codFamilia;
    @JoinColumn(name = "codCampa", referencedColumnName = "codCampa")
    @ManyToOne(optional = false)
    private Campa codCampa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "malogrado")
    private Collection<ExumacaoSepultado> exumacaoSepultadoCollection;

    public Malogrado() {
    }

    public Malogrado(Integer codMalogrado) {
        this.codMalogrado = codMalogrado;
    }

    public Malogrado(Integer codMalogrado, Date dataNascimento, Date dataMorte) {
        this.codMalogrado = codMalogrado;
        this.dataNascimento = dataNascimento;
        this.dataMorte = dataMorte;
    }

    public Integer getCodMalogrado() {
        return codMalogrado;
    }

    public void setCodMalogrado(Integer codMalogrado) {
        this.codMalogrado = codMalogrado;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Date dataMorte) {
        this.dataMorte = dataMorte;
    }

    public Familia getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(Familia codFamilia) {
        this.codFamilia = codFamilia;
    }

    public Campa getCodCampa() {
        return codCampa;
    }

    public void setCodCampa(Campa codCampa) {
        this.codCampa = codCampa;
    }

    @XmlTransient
    public Collection<ExumacaoSepultado> getExumacaoSepultadoCollection() {
        return exumacaoSepultadoCollection;
    }

    public void setExumacaoSepultadoCollection(Collection<ExumacaoSepultado> exumacaoSepultadoCollection) {
        this.exumacaoSepultadoCollection = exumacaoSepultadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMalogrado != null ? codMalogrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Malogrado)) {
            return false;
        }
        Malogrado other = (Malogrado) object;
        if ((this.codMalogrado == null && other.codMalogrado != null) || (this.codMalogrado != null && !this.codMalogrado.equals(other.codMalogrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Malogrado[ codMalogrado=" + codMalogrado + " ]";
    }
    
}
