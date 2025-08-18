package br.edu.ifpb.padroes.atv3.musicas.DecoratorServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.HashMap;
import java.util.Map;

public class GeneroMaisTocadoDecoratorServicoMusica extends TocarMusicaDecorator {

    private Map<String,Integer> listaGeneros = new HashMap<>();

    public GeneroMaisTocadoDecoratorServicoMusica(TocarMusica tocarMusicaDecorado) {
        super(tocarMusicaDecorado);
    }

    @Override
    public void tocar(Musica musica) {
        super.tocar(musica);
        listaGeneros.put(musica.genero(), listaGeneros.getOrDefault(musica.genero(), 0) + 1);
        System.out.println("\nGêneros mais tocado: " );
        listaGeneros.forEach((nomeGenero,VezesTocada) -> System.out.println("•" + nomeGenero + " - " + "Quantidade:" + VezesTocada));
    }

}
