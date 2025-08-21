package br.edu.ifpb.padroes.atv3.questao02.cardapio;

import br.edu.ifpb.padroes.atv3.questao02.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private List<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
    }

    public void exibir() {
        System.out.println("=== CARDÁPIO DO RESTAURANTE ===");
        for (Item item : itens) {
            item.exibir();
            System.out.println(" ");
        }
    }
}
