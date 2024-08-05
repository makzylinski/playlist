import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) != null) {
            System.out.println("Song already exists");
            return false;
        }
        songs.add(new Song(title, duration));
        return true;
    }

    private Song findSong(String title) {
       for (int i = 0; i <= songs.size() - 1; i++) {
           Song song = songs.get(i);
           if(song.getTitle().equals(title)) {
               return song;
           }
       }
       return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songs.size())) {
            playlist.add(songs.get(index));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
       Song checkedSong = findSong(title);

       if(checkedSong != null) {
           playlist.add(checkedSong);
           return true;
       }
       return false;
    }
}
