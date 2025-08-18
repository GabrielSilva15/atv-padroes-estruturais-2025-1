package br.edu.ifpb.padroes.atv3.musicas.ServiceMusicaFacade;

import br.edu.ifpb.padroes.atv3.musicas.AdapterServicos.AdaptadorServicoABCD;
import br.edu.ifpb.padroes.atv3.musicas.AdapterServicos.AdaptadorServicoXPTO;
import br.edu.ifpb.padroes.atv3.musicas.AdapterServicos.ServicoMusicaAdapter;
import br.edu.ifpb.padroes.atv3.musicas.DecoratorServicos.*;
import br.edu.ifpb.padroes.atv3.musicas.ProxyServicos.GetMusicasESongsProxy;
import br.edu.ifpb.padroes.atv3.musicas.abcd.ClienteHttpABCD;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.servico.TocadorMusica;
import br.edu.ifpb.padroes.atv3.musicas.xpto.ClientHttpXPTO;
import br.edu.ifpb.padroes.atv3.musicas.xpto.Song;

import java.util.List;

public class ServiceMusicaFacade {

    private final ClienteHttpABCD clienteABCD;
    private final ClientHttpXPTO clienteXPTO;
    private final TocadorMusica tocadorMusica;
    private TocarMusica tocadorDecorado;

    public ServiceMusicaFacade() {
        GetMusicasESongsProxy proxy = new GetMusicasESongsProxy();
        this.clienteABCD = new ClienteHttpABCD(proxy);
        this.clienteXPTO = new ClientHttpXPTO(proxy);
        this.tocadorMusica = new TocadorMusica();


        TocarMusica tocadorBase = new TocarMusica() {
            @Override
            public void tocar(Musica musica) {
                tocadorMusica.tocarMusica(musica);
            }
        };

        this.tocadorDecorado = new GeneroMaisTocadoDecoratorServicoMusica(
                new ArtistasMaisTocadosDecorator(
                        new ContarMusicasTocadasDecorator(
                                new QuantidadeMusicasTocadaDecorator(tocadorBase)
                        )
                )
        );

    }


    public List<Musica> listarMusicasABCD() {
        return clienteABCD.listarMusicas();
    }

    public List<Song> listarMusicasXPTO() {
        return clienteXPTO.findAll();
    }

    public void tocarMusica(Musica musica) {
        tocadorDecorado.tocar(musica);
    }


    public Musica buscarMusicaABCDPorTitulo(String titulo) {

        List<Musica> musicasABCD = listarMusicasABCD();
        AdaptadorServicoABCD adaptadorServicoABCD = new AdaptadorServicoABCD(musicasABCD);
        return adaptadorServicoABCD.buscarPorTitulo(titulo);

    }

    public Musica buscarMusicaXPTOPorTitulo(String titulo) {

        List<Song> musicasXPTO = listarMusicasXPTO();
        AdaptadorServicoXPTO adaptadorServicoXPTO = new AdaptadorServicoXPTO(musicasXPTO);
        return adaptadorServicoXPTO.buscarPorTitulo(titulo);

    }

    public List<Musica> buscarMusicasArtistaABCD(String artista){
        List<Musica> musicasABCD = listarMusicasABCD();
        AdaptadorServicoABCD adaptadorServicoABCD = new AdaptadorServicoABCD(musicasABCD);
        return adaptadorServicoABCD.buscarMusicasArtista(artista);
    }

    public List<Musica> buscarMusicasArtistaXPTO(String artista){
        List<Song> musicasXPTO = listarMusicasXPTO();
        AdaptadorServicoXPTO adaptadorServicoXPTO = new AdaptadorServicoXPTO(musicasXPTO);
        return adaptadorServicoXPTO.buscarMusicasArtista(artista);
    }

    public List<Musica> buscarMusicasGeneroXPTO(String genero){
        List<Song> musicasXPTO = listarMusicasXPTO();
        AdaptadorServicoXPTO adaptadorServicoXPTO = new AdaptadorServicoXPTO(musicasXPTO);
        return adaptadorServicoXPTO.buscarMusicasGenero(genero);
    }

    public List<Musica> buscarMusicasGeneroABCD(String genero){
        List<Musica> musicasABCD = listarMusicasABCD();
        AdaptadorServicoABCD adaptadorServicoABCD = new AdaptadorServicoABCD(musicasABCD);
        return adaptadorServicoABCD.buscarMusicasGenero(genero);
    }

}