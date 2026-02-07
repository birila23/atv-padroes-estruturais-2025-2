package br.edu.ifpb.padroes.atv1.streamflix.services;

public interface StorageService {
    byte[] download(String location, String fileId);

    void upload(String location, String fileId, byte[] content);
}
