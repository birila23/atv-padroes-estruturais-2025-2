package br.edu.ifpb.padroes.atv1.streamflix;

public abstract class VideoDecorator implements VideoComponent {

    protected VideoComponent video;

    public VideoDecorator(VideoComponent video) {
        this.video = video;
    }

    @Override
    public void play() {
        video.play();
    }
}
