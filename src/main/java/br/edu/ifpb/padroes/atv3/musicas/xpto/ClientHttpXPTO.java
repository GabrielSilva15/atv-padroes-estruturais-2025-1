package br.edu.ifpb.padroes.atv3.musicas.xpto;

import br.edu.ifpb.padroes.atv3.musicas.ProxyServicos.GetMusicasESongsProxy;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class ClientHttpXPTO {

    public static final String SERVICE_URI = "http://localhost:4000/musics";

    private GetMusicasESongsProxy getMusicasESongsProxy;

    public ClientHttpXPTO(GetMusicasESongsProxy getMusicasESongsProxy) {
        this.getMusicasESongsProxy = getMusicasESongsProxy;
    }

    public List<Song> findAll() {
        try {
            HttpResponse<String> response = getMusicasESongsProxy.generatorMusicasESongs(SERVICE_URI);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Song> songsRetrieved = objectMapper.readValue(response.body(), objectMapper.getTypeFactory().constructCollectionType(List.class, Song.class));
            return songsRetrieved;
        }
        catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }

}
