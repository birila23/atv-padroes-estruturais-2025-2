package br.edu.ifpb.padroes.atv1.streamflix.services;

public class GoogleCloudAdapter implements StorageService{
    private final GoogleCloudStorage gcsService;

    public GoogleCloudAdapter(GoogleCloudStorage gcsService) {
        this.gcsService = gcsService;
    }

    @Override
    public byte[] download(String projectId, String fileId) {
        return gcsService.retrieveFile(projectId, fileId);
    }

    @Override
    public void upload(String projectId, String fileId, byte[] data) {
        gcsService.storeFile(projectId, fileId, data);
    }

}
