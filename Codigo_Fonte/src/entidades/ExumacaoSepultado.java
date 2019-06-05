/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Edson
 */
@Entity
@Table(name = "exumacao_sepultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExumacaoSepultado.findAll", query = "SELECT e FROM ExumacaoSepultado e")
    , @NamedQuery(name = "ExumacaoSepultado.findByCodMalogrado", query = "SELECT e FROM ExumacaoSepultado e WHERE e.exumacaoSepultadoPK.codMalogrado = :codMalogrado")
    , @NamedQuery(name = "ExumacaoSepultado.findByCodCampa", query = "SELECT e FROM ExumacaoSepultado e WHERE e.exumacaoSepultadoPK.codCampa = :codCampa")
    , @NamedQuery(name = "ExumacaoSepultado.findByCodOperario", query = "SELECT e FROM ExumacaoSepultado e WHERE e.exumacaoSepultadoPK.codOperario = :codOperario")
    , @NamedQuery(name = "ExumacaoSepultado.findByDataEnterro", query = "SELECT e FROM ExumacaoSepultado e WHERE e.dataEnterro = :dataEnterro")
    , @NamedQuery(name = "ExumacaoSepultado.findByHora", query = "SELECT e FROM ExumacaoSepultado e WHERE e.hora = :hora")})
public class ExumacaoSepultado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExumacaoSepultadoPK exumacaoSepultadoPK;
    @Basic(optional = false)
    @Column(name = "dataEnterro")
    @Temporal(TemporalType.DATE)
    private Date dataEnterro;
    @Basic(optional = false)
    @Column(name = "hora")
    private int hora;
    @JoinColumn(name = "codCampa", referencedColumnName = "codCampa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campa campa;
    @JoinColumn(name = "codOperario", referencedColumnName = "codOperario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Operario operario;
    @JoinColumn(name = "codMalogrado", referencedColumnName = "codMalogrado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Malogrado malogrado;

    public ExumacaoSepultado() {
    }

    public ExumacaoSepultado(ExumacaoSepultadoPK exumacaoSepultadoPK) {
        this.exumacaoSepultadoPK = exumacaoSepultadoPK;
    }

    public ExumacaoSepultado(ExumacaoSepultadoPK exumacaoSepultadoPK, Date dataEnterro, int hora) {
        this.exumacaoSepultadoPK = exumacaoSepultadoPK;
        this.dataEnterro = dataEnterro;
        this.hora = hora;
    }

    public ExumacaoSepultado(int codMalogrado, int codCampa, int codOperario) {
        this.exumacaoSepultadoPK = new ExumacaoSepultadoPK(codMalogrado, codCampa, codOperario);
    }

    public ExumacaoSepultadoPK getExumacaoSepultadoPK() {
        return exumacaoSepultadoPK;
    }

    public void setExumacaoSepultadoPK(ExumacaoSepultadoPK exumacaoSepultadoPK) {
        this.exumacaoSepultadoPK = exumacaoSepultadoPK;
    }

    public Date getDataEnterro() {
        return dataEnterro;
    }

    public void setDataEnterro(Date dataEnterro) {
        this.dataEnterro = dataEnterro;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Campa getCampa() {
        return campa;
    }

    public void setCampa(Campa campa) {
        this.campa = campa;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public Malogrado getMalogrado() {
        return malogrado;
    }

    public void setMalogrado(Malogrado malogrado) {
        this.malogrado = malogrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exumacaoSepultadoPK != null ? exumacaoSepultadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExumacaoSepultado)) {
            return false;
        }
        ExumacaoSepultado other = (ExumacaoSepultado) object;
        if ((this.exumacaoSepultadoPK == null && other.exumacaoSepultadoPK != null) || (this.exumacaoSepultadoPK != null && !this.exumacaoSepultadoPK.equals(other.exumacaoSepultadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ExumacaoSepultado[ exumacaoSepultadoPK=" + exumacaoSepultadoPK + " ]";
    }
    
}
