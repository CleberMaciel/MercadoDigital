/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author cleber
 */
@SuppressWarnings("serial")
@Entity
public class ItemVenda extends GenericDomain {

    @Column(nullable = false)
    private short quantidade;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Venda venda;

    @Column(nullable = false, precision = 7, scale = 2)
    private double precoParcial;

    
    
    
    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public double getPrecoParcial() {
        return precoParcial;
    }

    public void setPrecoParcial(double precoParcial) {
        this.precoParcial = precoParcial;
    }

}
