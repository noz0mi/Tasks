package task1.a;

import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LocalTime duration = LocalTime.of(0,3,10);
        LocalTime totalDuration = LocalTime.of(0,0,0);
        ArrayList<MyImmutableLP.Track> tracks = new ArrayList<>();
        for(int i = 1; i < 6; i++) {
            MyImmutableLP.Track track = new MyImmutableLP.Track("track" + i, duration);
            tracks.add(track);
            totalDuration.plusMinutes(3).plusSeconds(10);
        }
        MyImmutableLP LP = new MyImmutableLP("NewAlbum", tracks, totalDuration);
    }
}
