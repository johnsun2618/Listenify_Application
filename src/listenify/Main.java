package listenify;

import java.util.*;

public class Main {

    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Album album = new Album("Native", "OneRepublic");

        album.addSongToAlbum("Counting Stars", 4.17);
        album.addSongToAlbum("Love Runs Out", 3.44);
        album.addSongToAlbum("If I Lose My Self", 4.01);
        album.addSongToAlbum("Feel Again", 3.05);
        album.addSongToAlbum("What You Wanted", 4.01);

        albums.add(album);

        album = new Album("All 4 Nothing", "Lauv");

        album.addSongToAlbum("26",2.39);
        album.addSongToAlbum("Stranger",2.44);
        album.addSongToAlbum("Kids Are Born Star",3.07);
        album.addSongToAlbum("Molly In Mexico",2.59);
        album.addSongToAlbum("All 4 Nothing(I'm So In Love)",3.05);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addSongToPlayList("Counting Stars",playList_1);
        albums.get(0).addSongToPlayList("What You Wanted",playList_1);
        albums.get(0).addSongToPlayList("If I Lose My Self",playList_1);
        albums.get(0).addSongToPlayList("26",playList_1);
        albums.get(0).addSongToPlayList("All 4 Nothing(I'm So In Love)",playList_1);
        albums.get(0).addSongToPlayList("Kids Are Born Star",playList_1);


//        print the playlist that has been added
        play(playList_1);
    }

    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> listIterator = playlist.listIterator();

//        validation
        if(playlist.size() == 0){
            return;
        }

        Scanner sc = new Scanner(System.in);

        printMenu();
        System.out.println("Now playing" + listIterator.next());
        boolean forward = true;
        boolean quit = false;

        while(quit == false){

            int choice = sc.nextInt();

            switch(choice){

                case 0:
                    quit = true;
                    break;
                case 1:
                    if(forward == false){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    } else {
                        System.out.println("You at the last song");
                    }
                    //to play the next song
                    break;
                case 2:
                    if(forward == true){ //already towards the right of the last printed value
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    } else{
                        System.out.println("You are already at the first song");
                    }
                    //to play the previous song
                    break;
                case 3:
                    if(forward == true){ //I am on RHS : print the previous song
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    } else{ //forward is false and iam on the LHS
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    //replay the current song
                    break;
                case 4:
                    printAllSongs(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    //Delete the song
                    if(playlist.size() > 0){
                        System.out.println(listIterator.previous().toString() + "has been removed from playlist");
                        listIterator.remove();
                        if(playlist.size() > 0 && listIterator.hasPrevious()){
                            System.out.println("Now playing" + listIterator.next().toString());
                        } else if (playlist.size() > 0 && listIterator.hasNext()) {
                            System.out.println("Now playing" + listIterator.previous().toString());
                        }
                    } else {
                        System.out.println("The playlist is already empty");
                    }
                    break;
            }


        }

    }

    private static void printAllSongs(LinkedList<Song> songs) {
        ListIterator<Song> listIterator = songs.listIterator();

        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("""
                0 - to quit
                1 - to play next song
                2 - to play previous song
                3 - to replay current song
                4 - list of all songs
                5 - print all available options
                6 - delete current song
                """);



    }


}