package com.thiago.wooza.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ddds")
public class DDD implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_area", nullable = false)
    private int codigoArea;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DDD)) return false;
        DDD ddd = (DDD) o;
        return codigoArea == ddd.codigoArea &&
                Objects.equals(id, ddd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoArea);
    }
}
