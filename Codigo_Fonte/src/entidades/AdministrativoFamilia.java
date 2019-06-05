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
@Table(name = "administrativo_familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdministrativoFamilia.findAll", query = "SELECT a FROM AdministrativoFamilia a")
    , @NamedQuery(name = "AdministrativoFamilia.findByCodAdministrativo", query = "SELECT a FROM AdministrativoFamilia a WHERE a.administrativoFamiliaPK.codAdministrativo = :codAdministrativo")
    , @NamedQuery(name = "AdministrativoFamilia.findByCodFamilia", query = "SELECT a FROM AdministrativoFamilia a WHERE a.administrativoFamiliaPK.codFamilia = :codFamilia")
    , @NamedQuery(name = "AdministrativoFamilia.findByEndereco", query = "SELECT a FROM AdministrativoFamilia a WHERE a.endereco = :endereco")
    , @NamedQuery(name = "AdministrativoFamilia.findByNome", query = "SELECT a FROM AdministrativoFamilia a WHERE a.nome = :nome")
    , @NamedQuery(name = "AdministrativoFamilia.findByFuncao", query = "SELECT a FROM AdministrativoFamilia a WHERE a.funcao = :funcao")})
public class AdministrativoFamilia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministrativoFamiliaPK administrativoFamiliaPK;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "funcao")
    private String funcao;
    @JoinColumn(name = "codAdministrativo", referencedColumnName = "codAdministrativo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Administrativo administrativo;
    @JoinColumn(name = "codFamilia", referencedColumnName = "codFamilia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Familia familia;

    public AdministrativoFamilia() {
    }

    public AdministrativoFamilia(AdministrativoFamiliaPK administrativoFamiliaPK) {
        this.administrativoFamiliaPK = administrativoFamiliaPK;
    }

    public AdministrativoFamilia(AdministrativoFamiliaPK administrativoFamiliaPK, String endereco, String nome, String funcao) {
        this.administrativoFamiliaPK = administrativoFamiliaPK;
        this.endereco = endereco;
        this.nome = nome;
        this.funcao = funcao;
    }

    public AdministrativoFamilia(int codAdministrativo, int codFamilia) {
        this.administrativoFamiliaPK = new AdministrativoFamiliaPK(codAdministrativo, codFamilia);
    }

    public AdministrativoFamiliaPK getAdministrativoFamiliaPK() {
        return administrativoFamiliaPK;
    }

    public void setAdministrativoFamiliaPK(AdministrativoFamiliaPK administrativoFamiliaPK) {
        this.administrativoFamiliaPK = administrativoFamiliaPK;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Administrativo getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administrativoFamiliaPK != null ? administrativoFamiliaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministrativoFamilia)) {
            return false;
        }
        AdministrativoFamilia other = (AdministrativoFamilia) object;
        if ((this.administrativoFamiliaPK == null && other.administrativoFamiliaPK != null) || (this.administrativoFamiliaPK != null && !this.administrativoFamiliaPK.equals(other.administrativoFamiliaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AdministrativoFamilia[ administrativoFamiliaPK=" + administrativoFamiliaPK + " ]";
    }
    
}
