package br.edu.ifpb.padroes.atv1.streamflix;

import br.edu.ifpb.padroes.atv1.streamflix.auth.AuthenticationService;
import br.edu.ifpb.padroes.atv1.streamflix.converter.VideoConverter;
import br.edu.ifpb.padroes.atv1.streamflix.services.StorageService;
import br.edu.ifpb.padroes.atv1.streamflix.stream.StreamingService;
import br.edu.ifpb.padroes.atv1.streamflix.subtitle.SubtitleService;

public class StreamflixFacade {

    private final AuthenticationService authService;
    private final StorageService storageService;
    private final VideoConverter converter;
    private final SubtitleService subtitleService;
    private final StreamingService streamingService;

    public StreamflixFacade(StorageService storageService) {
        this.authService = new AuthenticationService();
        this.storageService = storageService;
        this.converter = new VideoConverter();
        this.subtitleService = new SubtitleService();
        this.streamingService = new StreamingService();
    }

    public void watchVideo(String userId, String token, String videoId) {

        if (!authService.authenticate(userId, token)) {
            System.out.println("Authentication failed");
            return;
        }

        byte[] rawVideo = storageService.download("videos", videoId);
        byte[] convertedVideo = converter.convert(rawVideo, "MP4");
        subtitleService.getSubtitles(videoId, "pt-BR");

        Video video = new Video(videoId, "Movie Title", convertedVideo);
        video.play();
        streamingService.startStream(convertedVideo);
    }
}
