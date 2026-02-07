package br.edu.ifpb.padroes.atv1.streamflix.services;

public interface StorageService {
    byte[] downloadFromS3(String location, String fileId);

    void uploadToS3(String location, String fileId, byte[] content);
}
