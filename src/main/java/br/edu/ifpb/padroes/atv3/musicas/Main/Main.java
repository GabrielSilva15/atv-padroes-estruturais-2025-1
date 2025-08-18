package br.edu.ifpb.padroes.atv3.musicas.Main;

import br.edu.ifpb.padroes.atv3.musicas.ServiceMusicaFacade.ServiceMusicaFacade;

public class Main {
    public static void main(String[] args) {
        ServiceMusicaFacade musicaFacade = new ServiceMusicaFacade();

        System.out.println("\uD83D\uDDD2 \uD83C\uDDE7\uD83C\uDDF7 Listando Musicas Brasileiras \uD83D\uDDD2\uFE0F \uD83C\uDDE7\uD83C\uDDF7 ---");

        musicaFacade.listarMusicasABCD().forEach(musica -> {
           System.out.println(musica.titulo() + " - " + musica.artista());
        });

        System.out.println(" ");

        System.out.println("\uD83D\uDDD2\uFE0F \uD83C\uDF0F Listando Musicas Internacionais \uD83D\uDDD2\uFE0F \uD83C\uDF0F ----");

        musicaFacade.listarMusicasXPTO().forEach(musica -> {
            System.out.println(musica.title() + " - " + musica.artist());
        });

        System.out.println(" ");

        System.out.println("\uD83D\uDD0D \uD83C\uDDE7\uD83C\uDDF7 Buscando Musica Brasileira por Titulo: ");
        System.out.println("Musica :" + musicaFacade.buscarMusicaABCDPorTitulo("Garota de Ipanema").titulo());
        System.out.println("Artista :" + musicaFacade.buscarMusicaABCDPorTitulo("Garota de Ipanema").artista());
        System.out.println("Ano :" + musicaFacade.buscarMusicaABCDPorTitulo("Garota de Ipanema").ano());
        System.out.println("Genero :" + musicaFacade.buscarMusicaABCDPorTitulo("Garota de Ipanema").genero());

        System.out.println(" ");

        System.out.println("\uD83D\uDD0D \uD83C\uDF0F Buscando Musica Internacional por Titulo: ");
        System.out.println("Musica :" + musicaFacade.buscarMusicaXPTOPorTitulo("Billie Jean").titulo());
        System.out.println("Artista :" + musicaFacade.buscarMusicaXPTOPorTitulo("Billie Jean").artista());
        System.out.println("Ano :" + musicaFacade.buscarMusicaXPTOPorTitulo("Billie Jean").ano());
        System.out.println("Genero :" + musicaFacade.buscarMusicaXPTOPorTitulo("Billie Jean").genero());

        System.out.println(" ");

        System.out.println("----------------------------------------------");

        System.out.println("Tocando Musica Brasileira \uD83D\uDD0A \uD83C\uDDE7\uD83C\uDDF7");
        musicaFacade.tocarMusica(musicaFacade.buscarMusicaABCDPorTitulo("Garota de Ipanema"));

        System.out.println("----------------------------------------------");

        System.out.println("Tocando Musica Internacional \uD83D\uDD0A \uD83C\uDF0F");
        musicaFacade.tocarMusica(musicaFacade.buscarMusicaXPTOPorTitulo("Stairway to Heaven"));

        System.out.println("----------------------------------------------");
        System.out.println(" ");


        System.out.println("\uD83D\uDD0D \uD83C\uDDE7\uD83C\uDDF7 Buscando músicas brasileiras por artista: ");
        musicaFacade.buscarMusicasArtistaABCD("Tom Jobim").forEach(musica -> {
            System.out.println("•" + musica.titulo());
            System.out.println(" " + musica.ano());
            System.out.println(" " + musica.genero());
            System.out.println(" ");
        });

        System.out.println("\uD83D\uDD0D \uD83C\uDF0F Buscando músicas internacionais por artista: ");
        musicaFacade.buscarMusicasArtistaXPTO("Led Zeppelin").forEach(musica -> {
            System.out.println("•" + musica.titulo());
            System.out.println(" " + musica.ano());
            System.out.println(" " + musica.genero());
            System.out.println(" ");
        });

        System.out.println("\uD83D\uDD0D \uD83C\uDDE7\uD83C\uDDF7 Buscando músicas brasileiras por gênero: ");
        musicaFacade.buscarMusicasGeneroABCD("MPB").forEach(musica -> {
            System.out.println("•" + musica.titulo());
            System.out.println(" " + musica.ano());
            System.out.println(" " + musica.genero());
            System.out.println(" ");
        });

        System.out.println("\uD83D\uDD0D \uD83C\uDF0F Buscando músicas internacionais por gênero: ");
        musicaFacade.buscarMusicasGeneroXPTO("Rock").forEach(musica -> {
            System.out.println("•" + musica.titulo());
            System.out.println(" " + musica.ano());
            System.out.println(" " + musica.genero());
            System.out.println(" ");
        });

    }
}
