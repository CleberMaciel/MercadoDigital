/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
public class Produto extends GenericDomain {

    @Column(length = 50, nullable = false)
    private String produtoNome;
   
    @Column(length = 255, nullable = false)
    private String produtoDescricao;

    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria produtoCategoria;

    
    
    @Column(length = 50, nullable = false)
    private String produtoCor;
  
    @Column(length = 50, nullable = false, precision = 6, scale = 2)
    private double valor;
  
    @Column(length = 50, nullable = false)
    private int quantidade;

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public Categoria getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(Categoria produtoCategoria) {
        this.produtoCategoria = produtoCategoria;
    }

    public String getProdutoCor() {
        return produtoCor;
    }

    public void setProdutoCor(String produtoCor) {
        this.produtoCor = produtoCor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    
}
