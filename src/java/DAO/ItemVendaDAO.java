/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ItemVenda;
import modelo.Produto;
import modelo.Venda;
import util.Conexao;

/**
 *
 * @author zod
 */
public class ItemVendaDAO {

    public List<ItemVenda> listar() {
        String sql = "select itemvenda.quantidade, produto.produtonome, venda.precototal, itemvenda.precoparcial\n"
                + "from venda join itemvenda \n"
                + "on venda.id = itemvenda.venda_id\n"
                + "inner join produto\n"
                + "on produto.id = itemvenda.produto_id";

        List<ItemVenda> retorno = new ArrayList<ItemVenda>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ItemVenda item = new ItemVenda();
                Produto produto = new Produto();
                Venda venda = new Venda();

                produto.setProdutoNome(res.getString("produtonome"));
                ArrayList<Produto> produtos = new ArrayList<>();
                produtos.add(produto);

                venda.setPrecoTotal(res.getDouble("precototal"));
                ArrayList<Venda> vendas = new ArrayList<>();
                vendas.add(venda);

                item.setQuantidade(res.getShort("quantidade"));
                item.setPrecoParcial(res.getDouble("precoparcial"));
                item.setProduto(produto);
                item.setVenda(venda);

                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }
}
