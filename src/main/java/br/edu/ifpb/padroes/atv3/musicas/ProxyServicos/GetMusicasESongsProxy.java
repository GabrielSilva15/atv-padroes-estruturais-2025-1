package br.edu.ifpb.padroes.atv3.musicas.ProxyServicos;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.xpto.Song;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMusicasESongsProxy {

    private Map<String, HttpResponse<String>> cache = new HashMap<>();



    public HttpResponse<String> generatorMusicasESongs(String URI) {

        if(cache.containsKey(URI)){
            return cache.get(URI);
        }

        try {
            HttpRequest musicasESongsRequest = HttpRequest.newBuilder(new URI(URI)).GET().build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(musicasESongsRequest, HttpResponse.BodyHandlers.ofString());
            cache.put(URI,response);
            return response;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
