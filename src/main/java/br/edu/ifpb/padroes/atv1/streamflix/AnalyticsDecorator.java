package br.edu.ifpb.padroes.atv1.streamflix;

public class AnalyticsDecorator extends VideoDecorator {

    public AnalyticsDecorator(VideoComponent video) {
        super(video);
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Coletando estatísticas de visualização.");
    }
}
