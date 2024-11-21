package task1.a;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public final class MyImmutableLP {
    private final String albumName;
    private final ArrayList<Track> Tracks;
    private final LocalTime length;

    public MyImmutableLP(String albumName, ArrayList<Track> tracks, LocalTime length) {
        this.albumName = albumName;
        Tracks = tracks;
        this.length = length;
    }

    public List<Track> getTracks() {
        return List.copyOf(Tracks);
    }

    public LocalTime getLength() {
        return length;
    }

    public String getAlbumName() {
        return albumName;
    }

    public static class Track {
        private final String trackName;
        private final LocalTime duration;

        public Track(String trackName, LocalTime duration) {
            this.trackName = trackName;
            this.duration = duration;
        }

        public String getTrackName() {
            return trackName;
        }

        public LocalTime getDuration() {
            return duration;
        }
    }
}
