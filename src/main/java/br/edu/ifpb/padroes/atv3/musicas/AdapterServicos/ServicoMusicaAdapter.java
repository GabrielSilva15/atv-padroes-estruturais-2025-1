package br.edu.ifpb.padroes.atv3.musicas.AdapterServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.List;


public interface ServicoMusicaAdapter {

    Musica buscarPorTitulo(String titulo);

    List<Musica> buscarMusicasArtista(String Artista);

    List<Musica> buscarMusicasGenero(String genero);

}
