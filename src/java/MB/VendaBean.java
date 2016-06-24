/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import DAO.ProdutoDAO;
import DAO.VendaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import modelo.ItemVenda;
import modelo.Produto;
import modelo.Venda;
import org.omnifaces.util.Messages;

/**
 *
 * @author cleber
 */
@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class VendaBean implements Serializable {

    private Venda venda;
    private List<Produto> listaProdutos;
    private List<ItemVenda> itensVenda;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @PostConstruct
    public void listar() {
        try {

            venda = new Venda();

            venda.setPrecoTotal(0);

            ProdutoDAO pDAO = new ProdutoDAO();
            listaProdutos = pDAO.listar();

            itensVenda = new ArrayList<>();
        } catch (RuntimeException e) {
            Messages.addGlobalError("Erro ao listar o produto");
        }
    }//fim do listar

    public void adicionar(ActionEvent e) {
        Produto p = (Produto) e.getComponent().getAttributes().get("produtoSelecionado");

        //-1 = Não encontrou resultado
        int encontrou = -1;

        //percorre ArrayList
        for (int pos = 0; pos < itensVenda.size(); pos++) {
            if (itensVenda.get(pos).getProduto().equals(p)) {
                encontrou = pos;
            }
        }

        if (encontrou < 0) {

            ItemVenda iv = new ItemVenda();

            iv.setPrecoParcial(p.getValor());
            iv.setProduto(p);
            iv.setQuantidade(new Short("1"));
            itensVenda.add(iv);
            Messages.addGlobalInfo("Produto Adicionado ao carrinho de compras");
        } else {
            ItemVenda iv = itensVenda.get(encontrou);
            iv.setQuantidade(new Short(iv.getQuantidade() + 1 + ""));
            iv.setPrecoParcial(p.getValor() * iv.getQuantidade());
            Messages.addGlobalInfo("Produto Adicionado ao carrinho de compras");
        }

        calcular();
    }

    public void remover(ActionEvent e) {
        ItemVenda iv = (ItemVenda) e.getComponent().getAttributes().get("itemSelecionado");

        int encontrou = -1;

        for (int pos = 0; pos < itensVenda.size(); pos++) {
            if (itensVenda.get(pos).getProduto().equals(iv.getProduto())) {
                encontrou = pos;
            }
        }
        if (encontrou > -1) {
            itensVenda.remove(encontrou);
        }
        calcular();
    }

    public void calcular() {
        venda.setPrecoTotal(0);

        for (int pos = 0; pos < itensVenda.size(); pos++) {
            ItemVenda iv = itensVenda.get(pos);
            double total = venda.getPrecoTotal() + iv.getPrecoParcial();
            venda.setPrecoTotal(total);
        }
    }

    public void salvar() {
        try {

            if (venda.getPrecoTotal() == 0) {
                Messages.addGlobalError("Carrinho vazio!");
                return;
            }
            VendaDAO vendaDAO = new VendaDAO();
            ProdutoDAO pDAO = new ProdutoDAO();
            
            vendaDAO.salvar(venda, itensVenda);

        } catch (RuntimeException e) {

        }
    }

}
