package br.edu.ifpb.padroes.atv1.streamflix.services;

public class AW3Adapter implements StorageService{
    private final AWSS3Service s3Service;

    public AW3Adapter(AWSS3Service s3Service) {
        this.s3Service = s3Service;
    }

    @Override
    public byte[] download(String bucketName, String fieldId) {
        return s3Service.downloadFromS3(bucketName, fieldId);
    }

    @Override
    public void upload(String bucketName, String fieldId, byte[] data) {
        s3Service.uploadToS3(bucketName, fieldId, data);
    }
}
