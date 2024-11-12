import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Spotify {
    private String U_name;
    private boolean isPremium;
    private String topSong;
    private String topArtist;
    private int totalListeningHours;
    private Map<String, Integer> songStreamCount = new HashMap<>();

    
    public Spotify(String U_name, boolean isPremium, int totalListeningHours) {
        this.U_name = U_name;
        this.isPremium = isPremium;
        this.totalListeningHours = totalListeningHours;
    }

    public String getU_name() {
        return U_name;
    }

    public void setU_name(String u_name) {
        U_name = u_name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public String getTopSong() {
        return topSong;
    }

    public void setTopSong(String topSong) {
        this.topSong = topSong;
    }

    public String getTopArtist() {
        return topArtist;
    }

    public void setTopArtist(String topArtist) {
        this.topArtist = topArtist;
    }

    public int getTotalListeningHours() {
        return totalListeningHours;
    }

    public void setTotalListeningHours(int totalListeningHours) {
        this.totalListeningHours = totalListeningHours;
    }

    public void addSong(String songName, int streams) {
        songStreamCount.put(songName, streams);
    }

    public void calculateTopSong() {
    int maxStreams = -1;
    String topSongName = "No songs streamed";

    for (Map.Entry<String, Integer> entry : songStreamCount.entrySet()) {
        if (entry.getValue() > maxStreams) {
            maxStreams = entry.getValue();
            topSongName = entry.getKey();
        }
    }

    this.topSong = topSongName;
}

    public void displayWrappedUp() {
        calculateTopSong();
        System.out.println("Spotify Wrapped for: " + U_name);
        System.out.println("Premium User: " + (isPremium ? "Yes" : "No"));
        System.out.println("Total Listening Hours: " + totalListeningHours);
        System.out.println("Top Song: " + topSong);
        System.out.println("Top Artist: " + topArtist);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Are you a premium user? (true/false): ");
        boolean isPremium = scanner.nextBoolean();

        System.out.print("Enter total listening hours: ");
        int listeningHours = scanner.nextInt();

        Spotify user = new Spotify(name, isPremium, listeningHours);

        scanner.nextLine();
        System.out.print("Enter your top artist: ");
        String topArtist = scanner.nextLine();
        user.setTopArtist(topArtist);

        System.out.print("How many songs do you want to add? ");
        int songCount = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < songCount; i++) {
            System.out.print("Enter song name: ");
            String songName = scanner.nextLine();

            System.out.print("Enter stream count for " + songName + ": ");
            int streamCount = scanner.nextInt();
            scanner.nextLine(); 

            user.addSong(songName, streamCount);
        }

        user.displayWrappedUp();

        scanner.close();
    }
}
