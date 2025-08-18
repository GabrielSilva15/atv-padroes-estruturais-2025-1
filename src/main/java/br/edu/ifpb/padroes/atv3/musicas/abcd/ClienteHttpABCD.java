package br.edu.ifpb.padroes.atv3.musicas.abcd;

import br.edu.ifpb.padroes.atv3.musicas.ProxyServicos.GetMusicasESongsProxy;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class ClienteHttpABCD {

    public static final String URI_SERVICO = "http://localhost:3000/musicas";


    private GetMusicasESongsProxy getMusicasESongsProxy;

    public ClienteHttpABCD(GetMusicasESongsProxy getMusicasESongsProxy) {
        this.getMusicasESongsProxy = getMusicasESongsProxy;
    }


    public List<Musica> listarMusicas() {

        try {
            HttpResponse<String> response = getMusicasESongsProxy.generatorMusicasESongs(URI_SERVICO);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Musica> musicas = objectMapper.readValue(response.body(), objectMapper.getTypeFactory().constructCollectionType(List.class, Musica.class));
            return musicas;
        }
         catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }

}
