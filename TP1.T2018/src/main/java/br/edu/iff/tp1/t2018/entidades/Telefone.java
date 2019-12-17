/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iff.tp1.t2018.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t")
    , @NamedQuery(name = "Telefone.findByIdTel", query = "SELECT t FROM Telefone t WHERE t.idTel = :idTel")
    , @NamedQuery(name = "Telefone.findByDdd", query = "SELECT t FROM Telefone t WHERE t.ddd = :ddd")
    , @NamedQuery(name = "Telefone.findByNumero", query = "SELECT t FROM Telefone t WHERE t.numero = :numero")
    , @NamedQuery(name = "Telefone.findByOperadora", query = "SELECT t FROM Telefone t WHERE t.operadora = :operadora")})
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tel")
    private BigDecimal idTel;
    @Column(name = "ddd")
    private Integer ddd;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 30)
    @Column(name = "operadora")
    private String operadora;
    @JoinColumn(name = "id_usuario_tel", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioTel;

    public Telefone() {
    }

    public Telefone(BigDecimal idTel) {
        this.idTel = idTel;
    }

    public BigDecimal getIdTel() {
        return idTel;
    }

    public void setIdTel(BigDecimal idTel) {
        this.idTel = idTel;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Usuario getIdUsuarioTel() {
        return idUsuarioTel;
    }

    public void setIdUsuarioTel(Usuario idUsuarioTel) {
        this.idUsuarioTel = idUsuarioTel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTel != null ? idTel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.idTel == null && other.idTel != null) || (this.idTel != null && !this.idTel.equals(other.idTel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.iff.tp1.t2018.entidades.Telefone[ idTel=" + idTel + " ]";
    }
    
}
