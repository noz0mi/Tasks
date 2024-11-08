package task1.c;

import java.time.LocalTime;

public class Track {
    private LocalTime duration;
    private String name;

    public Track(LocalTime duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    public Track(String name) {
        this.name = name;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Track{" +
                "duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }
}
