/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "funcionario_telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionarioTelefone.findAll", query = "SELECT f FROM FuncionarioTelefone f")
    , @NamedQuery(name = "FuncionarioTelefone.findByTelefone", query = "SELECT f FROM FuncionarioTelefone f WHERE f.telefone = :telefone")})
public class FuncionarioTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "telefone")
    private Integer telefone;
    @JoinColumn(name = "codFuncionario", referencedColumnName = "codFuncionario")
    @ManyToOne(optional = false)
    private Funcionario codFuncionario;

    public FuncionarioTelefone() {
    }

    public FuncionarioTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Funcionario getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Funcionario codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefone != null ? telefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioTelefone)) {
            return false;
        }
        FuncionarioTelefone other = (FuncionarioTelefone) object;
        if ((this.telefone == null && other.telefone != null) || (this.telefone != null && !this.telefone.equals(other.telefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FuncionarioTelefone[ telefone=" + telefone + " ]";
    }
    
}
