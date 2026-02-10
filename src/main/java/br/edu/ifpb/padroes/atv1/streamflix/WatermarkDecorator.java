package br.edu.ifpb.padroes.atv1.streamflix;

public class WatermarkDecorator extends VideoDecorator {

    public WatermarkDecorator(VideoComponent video) {
        super(video);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Aplicando marca d'água no vídeo.");
    }
}
