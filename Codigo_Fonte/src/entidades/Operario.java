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
@Table(name = "operario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operario.findAll", query = "SELECT o FROM Operario o")
    , @NamedQuery(name = "Operario.findByCodOperario", query = "SELECT o FROM Operario o WHERE o.codOperario = :codOperario")
    , @NamedQuery(name = "Operario.findByParticipacao", query = "SELECT o FROM Operario o WHERE o.participacao = :participacao")})
public class Operario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codOperario")
    private Integer codOperario;
    @Basic(optional = false)
    @Column(name = "participacao")
    private String participacao;
    @JoinColumn(name = "codAdministrativo", referencedColumnName = "codAdministrativo")
    @ManyToOne(optional = false)
    private Administrativo codAdministrativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operario")
    private Collection<ExumacaoSepultado> exumacaoSepultadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operario")
    private Collection<CampaOperario> campaOperarioCollection;

    public Operario() {
    }

    public Operario(Integer codOperario) {
        this.codOperario = codOperario;
    }

    public Operario(Integer codOperario, String participacao) {
        this.codOperario = codOperario;
        this.participacao = participacao;
    }

    public Integer getCodOperario() {
        return codOperario;
    }

    public void setCodOperario(Integer codOperario) {
        this.codOperario = codOperario;
    }

    public String getParticipacao() {
        return participacao;
    }

    public void setParticipacao(String participacao) {
        this.participacao = participacao;
    }

    public Administrativo getCodAdministrativo() {
        return codAdministrativo;
    }

    public void setCodAdministrativo(Administrativo codAdministrativo) {
        this.codAdministrativo = codAdministrativo;
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
        hash += (codOperario != null ? codOperario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operario)) {
            return false;
        }
        Operario other = (Operario) object;
        if ((this.codOperario == null && other.codOperario != null) || (this.codOperario != null && !this.codOperario.equals(other.codOperario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Operario[ codOperario=" + codOperario + " ]";
    }
    
}
