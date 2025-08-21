package br.edu.ifpb.padroes.atv3.questao02.Prato;

import br.edu.ifpb.padroes.atv3.questao02.item.Item;

public class Prato extends Item {


    public Prato(String nome, double preco, String descricao) {
        super(nome, preco, descricao);
    }

    @Override
    public String getNome() {
        return "- Prato: " + nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void exibir() {
        System.out.println(getNome() + " - R$" + getPreco());
        System.out.println("Descrição: " + getDescricao());

    }
}
