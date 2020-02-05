package com.thiago.wooza.entities;

import com.thiago.wooza.enums.PlanoTipoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "planos")
public class Plano implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_plano", nullable = false, length = 30)
    private String codigoPlano;

    @Column(name = "minutos", nullable = false)
    private Integer minutos;

    @Column(name = "franquia_internet", nullable = false)
    private Integer franquiaInternet;

    @Column(name = "valor", nullable = false, precision = 15, scale = 2)
    private Double valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private PlanoTipoEnum tipo;

    @Column(name = "operadora", nullable = false, length = 10)
    private String operadora;

    @ManyToMany
    @JoinTable(name = "plano_ddd",
                joinColumns = {@JoinColumn(name = "fk_plano")},
                inverseJoinColumns = {@JoinColumn(name = "fk_ddd")})
    private Set<DDD> ddds = new HashSet<DDD>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(String codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }

    public Integer getFranquiaInternet() {
        return franquiaInternet;
    }

    public void setFranquiaInternet(Integer franquiaInternet) {
        this.franquiaInternet = franquiaInternet;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public PlanoTipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(PlanoTipoEnum tipo) {
        this.tipo = tipo;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Set<DDD> getDdds() {
        return ddds;
    }

    public void setDdds(Set<DDD> ddds) {
        this.ddds = ddds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plano)) return false;
        Plano plano = (Plano) o;
        return Objects.equals(id, plano.id) &&
                Objects.equals(codigoPlano, plano.codigoPlano) &&
                Objects.equals(minutos, plano.minutos) &&
                Objects.equals(franquiaInternet, plano.franquiaInternet) &&
                Objects.equals(valor, plano.valor) &&
                tipo == plano.tipo &&
                Objects.equals(operadora, plano.operadora) &&
                Objects.equals(ddds, plano.ddds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoPlano, minutos, franquiaInternet, valor, tipo, operadora, ddds);
    }

    @Override
    public String toString() {
        return "Plano{" +
                "id=" + id +
                ", codigoPlano='" + codigoPlano + '\'' +
                ", minutos=" + minutos +
                ", franquiaInternet=" + franquiaInternet +
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", operadora='" + operadora + '\'' +
                ", ddds=" + ddds +
                '}';
    }
}
