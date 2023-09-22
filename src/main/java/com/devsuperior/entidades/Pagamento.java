package com.devsuperior.entidades;

import jakarta.persistence.*;

import java.time.Instant;
@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant momentoDoPagamento;
    @OneToOne
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }
    public Pagamento(Long id, Instant momentoDoPagamento, Pedido pedido) {
        this.id = id;
        this.momentoDoPagamento = momentoDoPagamento;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentoDoPagamento() {
        return momentoDoPagamento;
    }

    public void setMomentoDoPagamento(Instant momentoDoPagamento) {
        this.momentoDoPagamento = momentoDoPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
