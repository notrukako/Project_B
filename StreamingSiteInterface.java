import java.util.*;

public class StreamingSiteInterface {
    static Subscribers subscriber;
    static boolean nameEntered = false; // Flag to track whether the name has been entered

    // Define media items as static fields
    static Media movie1 = new Movie("The Matrix","Lana Wachowski","1999", 120.0, true,MediaType.MOVIE,MovieGenre.ACTION);
    static Media movie2 = new Movie("Inception", "Christopher Nolan","2010", 150.0,true, MediaType.MOVIE,MovieGenre.SCI_FI);
    static Media anime1 = new Anime("Naruto", genre.SHOUNEN, 5, 220, "Pierrot", true, MediaType.ANIME, 25.0);
    static Media anime2 = new Anime("Attack on Titan", genre.ACTION,4, 89, "WIT/MAPPA", true, MediaType.ANIME, 30.0);
    static Media podcast1 = new Podcast("Mata Najwa", "Najwa", 20.0, genre.DAILY_LIFE, true, MediaType.PODCAST);
    static Media podcast2 = new Podcast("Close The Door", "Deddy Corbuzier", 40.0, genre.COMMENTARY, true, MediaType.PODCAST);

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int choice = 0;

        do {
            try {
                System.out.println("Streaming Site");
                System.out.println("1. Make Account");
                System.out.println("2. Continue Without Account");
                System.out.print("Choose an option: ");
                
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch(choice) {
                    case 1:
                        System.out.print("Please enter your name: ");
                        String name = scanner.nextLine();
                        subscriber = new Subscribers(name);
                        System.out.println("\nWelcome, " + name);
                        nameEntered = true;
                        break;
                    case 2:
                        nameEntered = true; // Set the flag to true to indicate that name isn't required
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scanner.nextLine(); // Clear scanner buffer
            }
        } while (!nameEntered);

        choice = 0; // Reset choice

        // Main menu loop
        do {
            try {
                System.out.println("\nMain Menu");
                System.out.println("1. Display Media");
                System.out.println("2. View Favorites");
                System.out.println("3. View History");
                System.out.println("4. Watch Media");
                System.out.println("5. Add Favorite");
                System.out.println("6. Log out");

                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear scanner buffer

                switch(choice) {
                    case 1:
                        displayAllMedia(movie1, movie2, anime1, anime2, podcast1, podcast2);
                        break;
                    case 2:
                        if (subscriber != null) {
                            subscriber.displayFavoriteItems();
                        } else {
                            System.out.println("You have not made an account!");
                        }
                        break;
                    case 3:
                        if (subscriber != null) {
                            subscriber.displayWatchedMedia();
                        } else {
                            System.out.println("You have not made an account!");
                        }
                        break;
                    case 4:
                        if (subscriber != null) {
                            watchMedia(scanner);
                        } else {
                            System.out.println("You have not made an account!");
                        }
                        break;
                    case 5:
                        addFavorite(scanner);
                        break;
                    case 6:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scanner.nextLine(); // Clear scanner buffer
            }
        } while(choice != 6);
        
        scanner.close(); // Close the scanner
    }

    public static void displayAllMedia(Media... mediaItems) {
        System.out.println("All Available Media:");
        System.out.println("---------------------");

        // Iterate over each media item and display its information
        for (Media media : mediaItems) {
            System.out.println(media.toString());
        }
    }

    public static void watchMedia(Scanner scanner) {
        System.out.println("Select the media to watch:");

        // Display the available media
        displayAllMedia(movie1, movie2, anime1, anime2, podcast1, podcast2);

        System.out.print("Enter the title of the media to watch: ");
        String title = scanner.nextLine();

        // Search for the selected media
        Media selectedMedia = null;
        for (Media media : new Media[]{movie1, movie2, anime1, anime2, podcast1, podcast2}) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                selectedMedia = media;
                break;
            }
        }

        // Check if the media is found
        if (selectedMedia != null) {
            System.out.println("Now watching: " + selectedMedia.getTitle());
            // Add the watched media to the subscriber's history
            if (subscriber != null) {
                subscriber.watchMedia("",selectedMedia);
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void addFavorite(Scanner scanner) {
        displayAllMedia(movie1, movie2, anime1, anime2, podcast1, podcast2);
        System.out.println("Add Favorite Media");
        System.out.println("-------------------");
        System.out.println("Enter the title of the media to add to favorites:");

        String title = scanner.nextLine();

        // Search for the selected media
        Media selectedMedia = null;
        for (Media media : new Media[]{movie1, movie2, anime1, anime2, podcast1, podcast2}) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                selectedMedia = media;
                break;
            }
        }
        // Check if the media is found
        if (selectedMedia != null) {
            // Add the media to favorites
            if (subscriber != null) {
                subscriber.addFavorite("",selectedMedia);
                System.out.println("Added to favorites: " + selectedMedia.getTitle());
            } else {
                System.out.println("You have not made an account!");
            }
        } else {
            System.out.println("Media not found!");
        }
    }
}
