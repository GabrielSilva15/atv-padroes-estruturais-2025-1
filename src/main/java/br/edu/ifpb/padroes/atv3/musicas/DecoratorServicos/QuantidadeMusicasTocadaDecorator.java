package br.edu.ifpb.padroes.atv3.musicas.DecoratorServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

public class QuantidadeMusicasTocadaDecorator extends TocarMusicaDecorator {

    private int quantidade;

    public QuantidadeMusicasTocadaDecorator(TocarMusica tocarMusicaDecorado) {
        super(tocarMusicaDecorado);
        this.quantidade = 0;
    }


   public void tocar(Musica musica){
        super.tocar(musica);
        quantidade=quantidade+1;
        System.out.println("\nQuantidade de musicas tocadas: " + quantidade);
   }


}
