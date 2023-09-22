package com.devsuperior.entidades;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant momentoDoPedido;
    private StatusPedido status;

    @ManyToOne //relacionamento muitos para um."(Um Usuario pode ter varios pedidos)"
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    public Pedido(){

    }

    public Pedido(Long id, Instant momentoDoPedido, StatusPedido status, Usuario cliente) {
        this.id = id;
        this.momentoDoPedido = momentoDoPedido;
        this.status = status;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentoDoPedido() {
        return momentoDoPedido;
    }

    public void setMomentoDoPedido(Instant momentoDoPedido) {
        this.momentoDoPedido = momentoDoPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}

