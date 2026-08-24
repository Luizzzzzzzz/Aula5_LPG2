package org.example.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

//Essa é a classe POJO, para representar os negócios e objetos para a Java Persistance API
@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 120, nullable = false)
    private String nome;
    @Column
    private Character sexo;
    @Column
    private boolean PCD;
    @Column(scale = 1, precision = 3)
    private BigDecimal IRA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public boolean isPCD() {
        return PCD;
    }

    public void setPCD(boolean PCD) {
        this.PCD = PCD;
    }

    public BigDecimal getIRA() {
        return IRA;
    }

    public void setIRA(BigDecimal IRA) {
        this.IRA = IRA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Estudante other = null;
        if (getClass() != obj.getClass())
            return Objects.equals(id, other.id);

        other = (Estudante) obj;
        return Objects.equals(id, other.id);
    }
}
