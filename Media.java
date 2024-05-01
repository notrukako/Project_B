// Interface representing a website user
interface WebsiteUser {
    String getName();
    String getType();
}

// Interface representing a media item
interface MediaItem {
    String getTitle();
    double getDuration();
}

// Enum representing different types of media
enum MediaType {
    MOVIE,
    ANIME,
    PODCAST
}

// Define a class to represent a media item
public class Media implements MediaItem {
    protected String title;
    private boolean isWatchable;
    protected MediaType type;
    private double duration;

    public Media(String title, boolean isWatchable, MediaType type, double duration) {
        this.title = title;
        this.isWatchable = true;
        this.type = type;
        this.duration = duration;
    }

    @Override
    public String toString(){
        return title  + " (" + (type) + ")";
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public double getDuration(){
        return duration;
    }

    public MediaType getType() {
        return type;
    }

    public boolean getIsWatchable() {
        return isWatchable;
    }

    public void checkVideo() {
        if (isWatchable == true) {
            System.out.println(title + " is available in your country!");
        } else {
            System.out.println(title + " isn't available in your country! Maybe check out some other videos :)");
        }
    }

    public void displayMetaData() {
        if (isWatchable == true) {
            System.out.println("Video name: " + title + ", is watchable: Yes");
        } else {
            System.out.println("Video name: " + title + ", is watchable: No");
        }
    }
}

