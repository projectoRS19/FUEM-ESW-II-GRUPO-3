/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "campa_operario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CampaOperario.findAll", query = "SELECT c FROM CampaOperario c")
    , @NamedQuery(name = "CampaOperario.findByCodCampa", query = "SELECT c FROM CampaOperario c WHERE c.campaOperarioPK.codCampa = :codCampa")
    , @NamedQuery(name = "CampaOperario.findByCodOperario", query = "SELECT c FROM CampaOperario c WHERE c.campaOperarioPK.codOperario = :codOperario")
    , @NamedQuery(name = "CampaOperario.findByZona", query = "SELECT c FROM CampaOperario c WHERE c.zona = :zona")
    , @NamedQuery(name = "CampaOperario.findByQuarteirao", query = "SELECT c FROM CampaOperario c WHERE c.quarteirao = :quarteirao")
    , @NamedQuery(name = "CampaOperario.findByQuantidade", query = "SELECT c FROM CampaOperario c WHERE c.quantidade = :quantidade")
    , @NamedQuery(name = "CampaOperario.findByParticipacao", query = "SELECT c FROM CampaOperario c WHERE c.participacao = :participacao")})
public class CampaOperario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampaOperarioPK campaOperarioPK;
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
    @Column(name = "participacao")
    private String participacao;
    @JoinColumn(name = "codCampa", referencedColumnName = "codCampa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campa campa;
    @JoinColumn(name = "codOperario", referencedColumnName = "codOperario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Operario operario;

    public CampaOperario() {
    }

    public CampaOperario(CampaOperarioPK campaOperarioPK) {
        this.campaOperarioPK = campaOperarioPK;
    }

    public CampaOperario(CampaOperarioPK campaOperarioPK, String zona, int quarteirao, int quantidade, String participacao) {
        this.campaOperarioPK = campaOperarioPK;
        this.zona = zona;
        this.quarteirao = quarteirao;
        this.quantidade = quantidade;
        this.participacao = participacao;
    }

    public CampaOperario(int codCampa, int codOperario) {
        this.campaOperarioPK = new CampaOperarioPK(codCampa, codOperario);
    }

    public CampaOperarioPK getCampaOperarioPK() {
        return campaOperarioPK;
    }

    public void setCampaOperarioPK(CampaOperarioPK campaOperarioPK) {
        this.campaOperarioPK = campaOperarioPK;
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

    public String getParticipacao() {
        return participacao;
    }

    public void setParticipacao(String participacao) {
        this.participacao = participacao;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campaOperarioPK != null ? campaOperarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampaOperario)) {
            return false;
        }
        CampaOperario other = (CampaOperario) object;
        if ((this.campaOperarioPK == null && other.campaOperarioPK != null) || (this.campaOperarioPK != null && !this.campaOperarioPK.equals(other.campaOperarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CampaOperario[ campaOperarioPK=" + campaOperarioPK + " ]";
    }
    
}
