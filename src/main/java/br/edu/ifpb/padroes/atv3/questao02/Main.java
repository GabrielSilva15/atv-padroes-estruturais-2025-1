package br.edu.ifpb.padroes.atv3.questao02;

import br.edu.ifpb.padroes.atv3.questao02.Bebida.Bebida;
import br.edu.ifpb.padroes.atv3.questao02.Prato.Prato;
import br.edu.ifpb.padroes.atv3.questao02.Sobremesa.Sobremesa;
import br.edu.ifpb.padroes.atv3.questao02.cardapio.Cardapio;
import br.edu.ifpb.padroes.atv3.questao02.combo.Combo;
import br.edu.ifpb.padroes.atv3.questao02.item.Item;

public class Main {

    public static void main(String[] args) {
        // Itens simples
        Item pizza = new Prato("Pizza", 30.0,"Pizza de calabresa com catupiry");
        Item refri = new Bebida("Refrigerante", 8.0,"Refrigerante de 750ml");
        Item sobremesa = new Sobremesa("Pudim", 12.0,"Pudim de chocolate");

        System.out.println("=============================================");

        // Combo 1
        Combo comboAlmoco = new Combo("Almoço Executivo", 5.0,"Novo combo de almoço",0);
        comboAlmoco.adicionar(pizza);
        comboAlmoco.adicionar(refri);
        comboAlmoco.adicionar(sobremesa);


        // Combo 2 que contém outro combo
        Combo superCombo = new Combo("Super Combo", 10.0,"Novo super combo",0);
        superCombo.adicionar(comboAlmoco);
        superCombo.adicionar(new Prato("Batata Frita", 15.0,"Batata frita com queijo"));



        // Cardápio do restaurante
        Cardapio cardapio = new Cardapio();
        cardapio.adicionar(pizza);
        cardapio.adicionar(refri);
        cardapio.adicionar(comboAlmoco);
        cardapio.adicionar(superCombo);

        // Exibir tudo
        cardapio.exibir();
    }
}
