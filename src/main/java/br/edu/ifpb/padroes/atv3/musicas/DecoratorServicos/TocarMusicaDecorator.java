package br.edu.ifpb.padroes.atv3.musicas.DecoratorServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

public abstract class TocarMusicaDecorator extends TocarMusica{

    private TocarMusica tocarMusicaDecorado;

    public TocarMusicaDecorator(TocarMusica tocarMusicaDecorado) {
        this.tocarMusicaDecorado = tocarMusicaDecorado;
    }


    @Override
    public void tocar(Musica musica) {
        tocarMusicaDecorado.tocar(musica);
    }
}
