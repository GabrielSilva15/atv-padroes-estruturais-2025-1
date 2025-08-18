package br.edu.ifpb.padroes.atv3.musicas.AdapterServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorServicoABCD implements ServicoMusicaAdapter {

    private List<Musica> musicas;

    public AdaptadorServicoABCD(List<Musica> musicas) {
        this.musicas = musicas;
    }


    @Override
    public Musica buscarPorTitulo(String titulo) {

        for (Musica musica : musicas) {
            if(musica.titulo().equals(titulo)){
                return musica;
            }
        }
        return null;
    }

    @Override
    public List<Musica> buscarMusicasArtista(String Artista) {

        List<Musica> musicasArtista = new ArrayList<>();

        for (Musica musica : musicas) {
            if(musica.artista().equals(Artista)){
                musicasArtista.add(musica);
            }
        }

        return musicasArtista;
    }

    @Override
    public List<Musica> buscarMusicasGenero(String genero) {

        List<Musica> musicasGenero = new ArrayList<>();

        for (Musica musica : musicas) {
            if(musica.genero().equals(genero)){
                musicasGenero.add(musica);
            }
        }

        return musicasGenero;
    }
}
