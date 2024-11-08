package task1.c;

import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MyMutableLP newLP = new MyMutableLP("GoDeaf");
        ArrayList<Track> tracks = new ArrayList<>();
        LocalTime time1 = LocalTime.of(0,3,27);
        LocalTime time2 = LocalTime.of(0,3,0);
        Track track1 = new Track(time1, "track1");
        tracks.add(track1);
        Track track2 = new Track(time2, "track2");
        tracks.add(track2);
        Track track3 = new Track(time1,"track3");
        tracks.add(track3);
        LocalTime totalTime = LocalTime.of(0,9,54);
        newLP.setDuration(totalTime);
        newLP.setTracks(tracks);
        Track track4 = new Track(time1,"track4");

        MyMutableLP clone = newLP.clone();
        clone.setAlbumName("another");
        clone.addTrack(track4);
        System.out.println(newLP.getAlbumName() + " and " + clone.getAlbumName());
        System.out.println(clone.toString() + " it is clone.");
        System.out.println(newLP.toString() + " it is not");


    }
}
