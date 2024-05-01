enum genre {
    SHOJO,
    THRILLER,
    SLICE_OF_LIFE,
    ACTION,
    COMEDY,
    ISEKAI,
    SHOUNEN, DAILY_LIFE, COMMENTARY
}

public class Anime extends Media {
    private genre genre;
    private int seasons;
    private int episodes;
    private String studio;

    public Anime(String title, genre genre, int seasons, int episodes, String studio, boolean isWatchable, MediaType type, double duration) {
        super(title, isWatchable, type, duration);
        this.genre = genre;
        this.seasons = seasons;
        this.episodes = episodes;
        this.studio = studio;
    }

    public genre getGenre() {
        return genre;
    }

    public int getSeasons() {
        return seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public String getStudio() {
        return studio;
    }
    @Override
    public String toString(){
        return title  + " (" + (type) + ")";
    }
    
    @Override
    public void displayMetaData() {
        super.displayMetaData();
        System.out.println("Genre: " + getGenre());
        System.out.println("Seasons: " + getSeasons() + ", Episodes: " + getEpisodes());
        System.out.println("By studio " + getStudio());
        System.out.println("Is avbailable? " + getIsWatchable());
    }
}
