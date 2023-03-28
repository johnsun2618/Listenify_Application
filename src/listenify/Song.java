package listenify;

public class Song {

    public String title;
    public double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {  //presenting the object in a nice manner
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }



}
