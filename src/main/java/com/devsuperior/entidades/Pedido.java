package com.devsuperior.entidades;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido(){    }
    public Pedido(Long id, Instant momentoDoPedido, StatusPedido status, Usuario cliente, Pagamento pagamento) {
        this.id = id;
        this.momentoDoPedido = momentoDoPedido;
        this.status = status;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
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

    public Set<ItemPedido> getItens() {
        return itens;
    }
    public List<Produto> getProdutos(){
        return itens.stream().map(ItemPedido::getProduto).toList();
    }
}

