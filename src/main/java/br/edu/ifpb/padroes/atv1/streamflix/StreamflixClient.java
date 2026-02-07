package br.edu.ifpb.padroes.atv1.streamflix;

import br.edu.ifpb.padroes.atv1.streamflix.auth.AuthenticationService;
import br.edu.ifpb.padroes.atv1.streamflix.converter.VideoConverter;
import br.edu.ifpb.padroes.atv1.streamflix.services.GoogleCloudStorage;
import br.edu.ifpb.padroes.atv1.streamflix.services.StorageService;
import br.edu.ifpb.padroes.atv1.streamflix.stream.StreamingService;
import br.edu.ifpb.padroes.atv1.streamflix.subtitle.SubtitleService;

public class StreamflixClient {

    public void watchVideo(String userId, String token, String videoId) {
        // Cliente precisa conhecer TODOS os subsistemas!
        AuthenticationService auth = new AuthenticationService();
        VideoConverter converter = new VideoConverter();
        SubtitleService subtitles = new SubtitleService();
        StreamingService streaming = new StreamingService();

        // Processo complexo e acoplado
        if (auth.authenticate(userId, token)) {
            byte[] rawVideo = StorageService.downloadFromS3("videos", videoId);
            byte[] convertedVideo = converter.convert(rawVideo, "MP4");
            String subs = subtitles.getSubtitles(videoId, "pt-BR");

            Video video = new Video(videoId, "Movie Title", convertedVideo);
            video.play();
            streaming.startStream(convertedVideo);
        }
    }

    // Se quiser usar Google Cloud, precisa duplicar código!
    public void watchVideoFromGCS(String userId, String token, String videoId) {
        AuthenticationService auth = new AuthenticationService();
        GoogleCloudStorage gcs = new GoogleCloudStorage();
        VideoConverter converter = new VideoConverter();
        SubtitleService subtitles = new SubtitleService();
        StreamingService streaming = new StreamingService();

        if (auth.authenticate(userId, token)) {
            byte[] rawVideo = gcs.retrieveFile("my-project", videoId);
            byte[] convertedVideo = converter.convert(rawVideo, "MP4");
            String subs = subtitles.getSubtitles(videoId, "pt-BR");

            Video video = new Video(videoId, "Movie Title", convertedVideo);
            video.play();
            streaming.startStream(convertedVideo);
        }
    }

}
