package br.edu.ifpb.padroes.atv1.streamflix;

import br.edu.ifpb.padroes.atv1.streamflix.services.AW3Adapter;
import br.edu.ifpb.padroes.atv1.streamflix.services.AWSS3Service;
import br.edu.ifpb.padroes.atv1.streamflix.services.StorageService;

public class StreamflixClient {
    public static void main(String[] args) {

        StorageService storage = new AW3Adapter(new AWSS3Service());

        StreamflixFacade facade = new StreamflixFacade(storage);

        facade.watchVideo("user1", "token123", "video1");
        facade.watchVideo("user1", "token123", "video1");
    }

}
