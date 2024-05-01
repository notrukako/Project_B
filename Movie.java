enum MovieGenre{
    ACTION,
    THRILLER,
    HORROR,
    MYSTERY,
    SCI_FI
}

public class Movie extends Media {
    private String yearReleased;
    private String director;
    private MovieGenre genre;

    public Movie(String title, String director, String yearReleased, double duration, boolean isWatchable, MediaType type, MovieGenre genre) {
        super(title, isWatchable, type, duration);
        this.yearReleased = yearReleased;
        this.director = director;
        this.genre=genre;
    }

    public String getDirector() {
        return director;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public MovieGenre getGenre(){
        return genre;
    }

    @Override
    public String toString(){
        return title  + " (" + (type) + ")";
    }

    @Override
    public void displayMetaData() {
        System.out.println("The " + getTitle() + " is Directed by " + getDirector() + ", was released in "
                + getYearReleased() + ", and is " + getDuration() + " minutes long!");
        System.out.println("is available? " + getIsWatchable());
    }
}
