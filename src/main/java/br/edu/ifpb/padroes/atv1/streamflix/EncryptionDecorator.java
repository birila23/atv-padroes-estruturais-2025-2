package br.edu.ifpb.padroes.atv1.streamflix;

public class EncryptionDecorator extends VideoDecorator {

    public EncryptionDecorator(VideoComponent video) {
        super(video);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Criptografando o vídeo.");
    }
}
