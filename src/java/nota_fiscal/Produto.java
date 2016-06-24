/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nota_fiscal;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matheus
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByProdutocor", query = "SELECT p FROM Produto p WHERE p.produtocor = :produtocor"),
    @NamedQuery(name = "Produto.findByProdutodescricao", query = "SELECT p FROM Produto p WHERE p.produtodescricao = :produtodescricao"),
    @NamedQuery(name = "Produto.findByProdutonome", query = "SELECT p FROM Produto p WHERE p.produtonome = :produtonome"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Produto.findByValor", query = "SELECT p FROM Produto p WHERE p.valor = :valor")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "produtocor")
    private String produtocor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "produtodescricao")
    private String produtodescricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "produtonome")
    private String produtonome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private Collection<Itemvenda> itemvendaCollection;
    @JoinColumn(name = "produtocategoria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria produtocategoriaId;

    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(Long id, String produtocor, String produtodescricao, String produtonome, int quantidade, double valor) {
        this.id = id;
        this.produtocor = produtocor;
        this.produtodescricao = produtodescricao;
        this.produtonome = produtonome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdutocor() {
        return produtocor;
    }

    public void setProdutocor(String produtocor) {
        this.produtocor = produtocor;
    }

    public String getProdutodescricao() {
        return produtodescricao;
    }

    public void setProdutodescricao(String produtodescricao) {
        this.produtodescricao = produtodescricao;
    }

    public String getProdutonome() {
        return produtonome;
    }

    public void setProdutonome(String produtonome) {
        this.produtonome = produtonome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<Itemvenda> getItemvendaCollection() {
        return itemvendaCollection;
    }

    public void setItemvendaCollection(Collection<Itemvenda> itemvendaCollection) {
        this.itemvendaCollection = itemvendaCollection;
    }

    public Categoria getProdutocategoriaId() {
        return produtocategoriaId;
    }

    public void setProdutocategoriaId(Categoria produtocategoriaId) {
        this.produtocategoriaId = produtocategoriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nota_fiscal.Produto[ id=" + id + " ]";
    }
    
}
