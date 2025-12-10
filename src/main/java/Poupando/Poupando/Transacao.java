package Poupando.Poupando;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double valor;
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo; 

    public enum TipoTransacao {
        RECEITA_SALARIO, RECEITA_EXTRA,
        DESPESA_FIXA, DESPESA_VARIAVEL
    }

    public Transacao() {}

    public Transacao(String descricao, Double valor, LocalDate data, TipoTransacao tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public Double getValor() { return valor; }
    public LocalDate getData() { return data; }
    public TipoTransacao getTipo() { return tipo; }
}