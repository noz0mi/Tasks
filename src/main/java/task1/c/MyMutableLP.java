package task1.c;



import java.time.LocalTime;
import java.util.ArrayList;

public class MyMutableLP implements Cloneable {

    private String albumName;
    private ArrayList<Track> Tracks;
    private LocalTime duration;

    public MyMutableLP(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public ArrayList<Track> getTracks() {
        return Tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        Tracks = tracks;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void addTrack (Track track) {
        Tracks.add(track);
    }

    @Override
    public MyMutableLP clone() {
        try {
            MyMutableLP clone = (MyMutableLP) super.clone();
            clone.Tracks = new ArrayList<>(Tracks);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "MyMutableLP{" +
                "albumName='" + albumName + '\'' +
                ", Tracks=" + Tracks +
                ", duration=" + duration +
                '}';
    }
}
