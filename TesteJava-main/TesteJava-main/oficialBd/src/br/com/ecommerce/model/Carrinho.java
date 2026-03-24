package br.com.ecommerce.model;
import br.com.ecommerce.exception.CarrinhoException;

import java.util.List;
import java.util.ArrayList;

public class Carrinho {

    private int id;
    private List<Produto> produtos;

    public Carrinho(int id) {
        this.id = id;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) throws CarrinhoException {
        if (produto == null)
            throw new CarrinhoException("Produto inválido");
        else {
            this.produtos.add(produto);
            System.out.println("Produto adicionado com sucesso!");

        }
    }

    public double calcularTotal(Cupom cupom) throws CarrinhoException {
        if (this.produtos.isEmpty())
            throw new CarrinhoException("Sem produtos no carrinho");

        double total = 0;

        for (Produto p : this.produtos) {
            total = total + p.getValor();
        }

        if (cupom != null) {
            double desconto = total * cupom.getValorDesconto() / 100.0;
            total = total - desconto;
        }

        System.out.println("Total do carrinho: $" + total);
        return total;
    }

    public void removerProduto(int idProduto) throws CarrinhoException {
        if (this.produtos.isEmpty())
            throw new CarrinhoException("Carrinho vazio!");

        Produto produtoParaRemover = null;

        for (Produto p : this.produtos) {
            if (p.getId() == idProduto) {
                produtoParaRemover = p;
                break;
            }
        }

        if (produtoParaRemover == null)
            throw new CarrinhoException("Produto não encontrado no carrinho!");

        this.produtos.remove(produtoParaRemover);
        System.out.println("Produto removido com sucesso!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
