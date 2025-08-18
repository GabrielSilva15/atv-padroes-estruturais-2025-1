package br.edu.ifpb.padroes.atv3.musicas.DecoratorServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.HashMap;
import java.util.Map;

public class ContarMusicasTocadasDecorator extends TocarMusicaDecorator{


    private Map<String, Integer> listaMusicasTocadas = new HashMap<>();


    public ContarMusicasTocadasDecorator(TocarMusica tocarMusicaDecorado) {
        super(tocarMusicaDecorado);
    }

    @Override
    public void tocar(Musica musica) {
        super.tocar(musica);
        listaMusicasTocadas.put(musica.titulo(), listaMusicasTocadas.getOrDefault(musica.titulo(), 0) + 1);
        System.out.println("\n\uD83D\uDDD2\uFE0F Lista de Musicas mais Tocadas:");
        listaMusicasTocadas.forEach((nomeMusica,VezesTocada) -> System.out.println("•" + nomeMusica + " - " + "Quantidade:" + VezesTocada));
    }
}
