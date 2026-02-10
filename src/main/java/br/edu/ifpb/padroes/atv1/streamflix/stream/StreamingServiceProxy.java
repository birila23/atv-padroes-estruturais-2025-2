package br.edu.ifpb.padroes.atv1.streamflix.stream;

import java.util.HashMap;
import java.util.Map;

public class StreamingServiceProxy {

    private StreamingService realService;
    private Map<String, byte[]> cache = new HashMap<>();

    public StreamingServiceProxy(StreamingService realService) {
        this.realService = realService;
    }

    public void startStream(String videoId, byte[] videoData) {

        if (cache.containsKey(videoId)) {
            System.out.println("Usando vídeo do cache: " + videoId);
            realService.startStream(cache.get(videoId));
            return;
        }

        System.out.println("Buscando vídeo no serviço externo: " + videoId);
        cache.put(videoId, videoData);
        realService.startStream(videoData);
    }
}
