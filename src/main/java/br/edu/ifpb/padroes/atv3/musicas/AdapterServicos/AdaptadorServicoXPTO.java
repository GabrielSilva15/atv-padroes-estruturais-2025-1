package br.edu.ifpb.padroes.atv3.musicas.AdapterServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import br.edu.ifpb.padroes.atv3.musicas.xpto.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorServicoXPTO implements ServicoMusicaAdapter {

    private List<Song> songs;


    public AdaptadorServicoXPTO(List<Song> songs) {
        this.songs = songs;
    }


    @Override
    public Musica buscarPorTitulo(String titulo) {
        List<Musica> listaMusica = converterSongsEmMusica();

        for(Musica musica : listaMusica){
            if(musica.titulo().equals(titulo)){
                return musica;
            }
        }
        return null;
    }

    @Override
    public List<Musica> buscarMusicasArtista(String Artista) {
        List<Musica> listaMusica = converterSongsEmMusica();

        List<Musica> listaMusicaArtista = new ArrayList<>();

        for(Musica musica : listaMusica){
            if(musica.artista().equals(Artista)){
                listaMusicaArtista.add(musica);
            }
        }

        return listaMusicaArtista;
    }

    @Override
    public List<Musica> buscarMusicasGenero(String genero) {
        List<Musica> listaMusica = converterSongsEmMusica();

        List<Musica> listaMusicaGenero = new ArrayList<>();

        for(Musica musica : listaMusica){
            if(musica.genero().equals(genero)){
                listaMusicaGenero.add(musica);
            }
        }
        return listaMusicaGenero;
    }

    private List<Musica> converterSongsEmMusica(){
        return songs.stream()
                .map(song -> new Musica(
                        song.id(),
                        song.title(),
                        song.artist(),
                        song.year(),
                        song.genre()
                ))
                .collect(Collectors.toList());

    }

}
