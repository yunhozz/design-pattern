package behavior.state;

interface VideoState {
    void play(VideoPlayer player);
    void stop(VideoPlayer player);
}

class PlayingState implements VideoState {
    @Override
    public void play(VideoPlayer player) {
        System.out.println("Video is already playing.");
    }

    @Override
    public void stop(VideoPlayer player) {
        System.out.println("Pausing the video.");
        player.setState(new PausedState());
    }
}

class StoppedState implements VideoState {
    @Override
    public void play(VideoPlayer player) {
        System.out.println("Starting the video.");
        player.setState(new PlayingState());
    }

    @Override
    public void stop(VideoPlayer player) {
        System.out.println("Video is already stopped.");
    }
}

class PausedState implements VideoState {
    @Override
    public void play(VideoPlayer player) {
        System.out.println("Resuming the video.");
        player.setState(new PlayingState());
    }

    @Override
    public void stop(VideoPlayer player) {
        System.out.println("Stopping the video.");
        player.setState(new StoppedState());
    }
}

public class VideoPlayer {
    private VideoState state;

    // Set initial state Stopped
    public VideoPlayer() {
        this.state = new StoppedState();
    }

    public void setState(VideoState state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public void stop() {
        state.stop(this);
    }
}

class VideoPlayerDemo {
    public static void main(String[] args) {
        VideoPlayer player = new VideoPlayer();
        player.play();   // Starting the video.
        player.play();   // Video is already playing.
        player.stop();   // Pausing the video.
        player.play();   // Resuming the video.
        player.stop();   // Pausing the video.
        player.stop();   // Stopping the video.
        player.stop();   // Video is already stopped.
    }
}