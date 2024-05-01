enum genre {
    DAILY_LIFE,
    COMEDY,
    COMMENTARY
}

public class Podcast extends Media {
    private String creatorName;
    private genre genre;

    public Podcast(String title, String creatorName, double duration, genre genre, boolean isWatchable, MediaType type) {
        super(title, isWatchable, type, duration);
        this.creatorName = creatorName;
        this.genre = genre;
    }

    public String getCreatorName() {
        return creatorName;
    }


    public genre getGenre() {
        return genre;
    }

    @Override
    public String toString(){
        return title  + " (" + (type) + ")";
    }

    @Override
    public void displayMetaData() {
        super.displayMetaData();
        System.out.println("Genre: " + getGenre());
        System.out.println("duration: " + getDuration());
        System.out.println("By " + getCreatorName());
        System.out.println("Is avbailable? " + getIsWatchable());
    }
}
