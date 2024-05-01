import java.util.*;

public class Subscribers implements WebsiteUser{
    private String name;
    private Map<String, Media> watchedItems;
    private Map<String, Media> favoriteItems;

    public Subscribers(String name){
        this.name = name;
        this.watchedItems = new HashMap<>();
        this.favoriteItems = new HashMap<>();
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getType(){
        return "Subscriber";
    }

    public void watchMedia(String mediaID, Movie movie){
        watchedItems.put(mediaID, movie);
    }
    
    public void watchMedia(String mediaID, Media media){
        watchedItems.put(mediaID, media);
    }

    public void addFavorite(String mediaID, Media media){
        //Checks if item is already in favorites
        if (!favoriteItems.containsKey(mediaID)){
            favoriteItems.put(mediaID, media);
        } else {
            System.out.println("This media is already in favorites.");
        }
    }

    public void removeFavorite(String mediaID){
        favoriteItems.remove(mediaID);
    }

    public void displayWatchedMedia() {
        System.out.println(getName() + "'s Watched Media:");
        watchedItems.forEach((id, media) -> {
            System.out.print("- " + media.getTitle());
            if (media instanceof Movie) {
                System.out.println(" (" + ((Movie) media).getGenre() + "), Duration: "+ media.getDuration() + " minutes");
            } else if (media instanceof Podcast) {
                System.out.println(" (" + ((Podcast) media).getGenre() + "), Duration: "+ media.getDuration() + " minutes");
            } else if (media instanceof Anime) {
                System.out.println(" (" + ((Anime) media).getGenre() + "), Duration: "+ media.getDuration() + " minutes");
            } else {
                System.out.println();
            }
        });
    }

    public void displayFavoriteItems() {
        System.out.println("\n" + getName() + "'s Favorite Media: ");
        favoriteItems.forEach((id, media) -> {
            System.out.print("- " + media.getTitle());
            if (media instanceof Movie) {
                System.out.println(" (" + ((Movie) media).getGenre() + "), Duration: " + media.getDuration() + " minutes");
            } else if (media instanceof Podcast) {
                System.out.println(" (" + ((Podcast) media).getGenre() + "), Duration: " + media.getDuration() + " minutes");
            } else if (media instanceof Anime) {
                System.out.println(" (" + ((Anime) media).getGenre() + "), Duration: " + media.getDuration() + " minutes");
            } else {
                System.out.println();
            }
        });
    }
    
}
