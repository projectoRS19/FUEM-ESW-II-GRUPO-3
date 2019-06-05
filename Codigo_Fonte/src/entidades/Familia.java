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
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f")
    , @NamedQuery(name = "Familia.findByCodFamilia", query = "SELECT f FROM Familia f WHERE f.codFamilia = :codFamilia")
    , @NamedQuery(name = "Familia.findByNome", query = "SELECT f FROM Familia f WHERE f.nome = :nome")
    , @NamedQuery(name = "Familia.findByEndereco", query = "SELECT f FROM Familia f WHERE f.endereco = :endereco")})
public class Familia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codFamilia")
    private Integer codFamilia;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familia")
    private Collection<AdministrativoFamilia> administrativoFamiliaCollection;
    @OneToMany(mappedBy = "codFamilia")
    private Collection<Malogrado> malogradoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFamilia")
    private Collection<FamiliaTelefone> familiaTelefoneCollection;

    public Familia() {
    }

    public Familia(Integer codFamilia) {
        this.codFamilia = codFamilia;
    }

    public Familia(Integer codFamilia, String nome, String endereco) {
        this.codFamilia = codFamilia;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(Integer codFamilia) {
        this.codFamilia = codFamilia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @XmlTransient
    public Collection<AdministrativoFamilia> getAdministrativoFamiliaCollection() {
        return administrativoFamiliaCollection;
    }

    public void setAdministrativoFamiliaCollection(Collection<AdministrativoFamilia> administrativoFamiliaCollection) {
        this.administrativoFamiliaCollection = administrativoFamiliaCollection;
    }

    @XmlTransient
    public Collection<Malogrado> getMalogradoCollection() {
        return malogradoCollection;
    }

    public void setMalogradoCollection(Collection<Malogrado> malogradoCollection) {
        this.malogradoCollection = malogradoCollection;
    }

    @XmlTransient
    public Collection<FamiliaTelefone> getFamiliaTelefoneCollection() {
        return familiaTelefoneCollection;
    }

    public void setFamiliaTelefoneCollection(Collection<FamiliaTelefone> familiaTelefoneCollection) {
        this.familiaTelefoneCollection = familiaTelefoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFamilia != null ? codFamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.codFamilia == null && other.codFamilia != null) || (this.codFamilia != null && !this.codFamilia.equals(other.codFamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Familia[ codFamilia=" + codFamilia + " ]";
    }
    
}
