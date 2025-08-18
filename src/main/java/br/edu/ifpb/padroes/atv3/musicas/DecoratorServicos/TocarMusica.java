package br.edu.ifpb.padroes.atv3.musicas.DecoratorServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.servico.TocadorMusica;

public abstract class TocarMusica {

    private TocadorMusica tocadorMusica;

    public TocarMusica() {
        this.tocadorMusica = new TocadorMusica();
    }

    public abstract void tocar(Musica musica);
}
