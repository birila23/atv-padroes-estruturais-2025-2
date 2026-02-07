package br.edu.ifpb.padroes.atv1.streamflix.services;

// Serviço AWS S3
public class AWSS3Service {

    public byte[] downloadFromS3(String bucketName, String key) {
        System.out.println("Downloading from S3: " + bucketName + "/" + key);
        // Simulação de download
        return new byte[1024];
    }

    public void uploadToS3(String bucketName, String key, byte[] data) {
        System.out.println("Uploading to S3: " + bucketName + "/" + key);
    }

}
