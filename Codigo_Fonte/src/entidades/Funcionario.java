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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByCodFuncionario", query = "SELECT f FROM Funcionario f WHERE f.codFuncionario = :codFuncionario")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codFuncionario")
    private Integer codFuncionario;
    @JoinColumn(name = "codCemiterio", referencedColumnName = "codCemiterio")
    @ManyToOne(optional = false)
    private Cemiterio codCemiterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFuncionario")
    private Collection<FuncionarioTelefone> funcionarioTelefoneCollection;

    public Funcionario() {
    }

    public Funcionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Cemiterio getCodCemiterio() {
        return codCemiterio;
    }

    public void setCodCemiterio(Cemiterio codCemiterio) {
        this.codCemiterio = codCemiterio;
    }

    @XmlTransient
    public Collection<FuncionarioTelefone> getFuncionarioTelefoneCollection() {
        return funcionarioTelefoneCollection;
    }

    public void setFuncionarioTelefoneCollection(Collection<FuncionarioTelefone> funcionarioTelefoneCollection) {
        this.funcionarioTelefoneCollection = funcionarioTelefoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFuncionario != null ? codFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codFuncionario == null && other.codFuncionario != null) || (this.codFuncionario != null && !this.codFuncionario.equals(other.codFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Funcionario[ codFuncionario=" + codFuncionario + " ]";
    }
    
}
