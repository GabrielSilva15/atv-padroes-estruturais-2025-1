package br.edu.ifpb.padroes.atv3.musicas.DecoratorServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtistasMaisTocadosDecorator extends TocarMusicaDecorator {


    private Map<String,Integer> listaArtistas = new HashMap<>();

    public ArtistasMaisTocadosDecorator(TocarMusica tocarMusicaDecorado) {
        super(tocarMusicaDecorado);
    }

    @Override
    public void tocar(Musica musica) {
        super.tocar(musica);
        listaArtistas.put(musica.artista(), listaArtistas.getOrDefault(musica.artista(), 0) + 1);
        System.out.println("\nArtistas mais tocados: " );
        listaArtistas.forEach((nomeArtista,VezesTocada) -> System.out.println("•" + nomeArtista + " - " + "Quantidade:" + VezesTocada));
    }


}
