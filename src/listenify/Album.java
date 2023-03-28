package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    public String albumName;
    public String artistName;
    public List<Song> songList;


    //Intialize the songList
    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

   public boolean findSongInAlbum(String title){

        //Iterate over the arraylist and match
        //each Songs title with title

        for(Song song:songList){

            if((song.title).compareTo(title) == 0){
                return true;
            }
        }
       return false;
    }

    public String addSongToAlbum(String title, double duration){

        //check if the song is already present we will not add
        //otherwise we will create a new Song and add it to the songList

        if(findSongInAlbum(title)==true){
            return "Song is Already present";
        } else{
            //i need to create a song object and add it to songList
            Song newSong = new Song(title,duration);
            songList.add(newSong);
            return "New Song has been added successfully";
        }
    }


    public String addSongToPlayList(int trackNo, LinkedList<Song> playList){
        //trackNo is a no in the songList
        //TrackNo : 1,2,3,4,....
        //indices : 0,1,2,3,....
        int index = trackNo - 1;

        //checking for validity of index
        if(index >= 0 && index < this.songList.size()){
            Song song = this.songList.get(index);
            playList.add(song);

            return "Song added to the playlist";
        }
        return "Invalid track No";

    }


//    using Polymorphism
    public String addSongToPlayList(String title, LinkedList<Song> playlist){
//        i need to find out the song with that title
//                and put it in the playlist

//        iterate
        for(Song song: songList){

            if(song.title == title){
                playlist.add(song);
                return "Song has been added successfully";
            }
        }
        return "Song does not exist";
    }


}
