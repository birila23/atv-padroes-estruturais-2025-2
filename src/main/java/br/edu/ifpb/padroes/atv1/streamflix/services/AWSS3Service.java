package br.edu.ifpb.padroes.atv1.streamflix.services;

// Serviço AWS S3
public class AWSS3Service implements StorageService{

    private final AWSS3Service s3service;

    public AWSS3Service(AWSS3Service s3service) {
        this.s3service = s3service;
    }

    @Override
    public byte[] downloadFromS3(String bucketName, String fileId) {
        return s3service.downloadFromS3(bucketName, fileId);
    }
    @Override
    public void uploadToS3(String bucketName, String fileId, byte[] data) {
        s3service.uploadToS3(bucketName, fileId, data);
    }
}
