package homework3;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//reads in the file into the Library Array List (private) and we have member functions that search the library
//have another ArrayList known as the playlist
public class LibraryAndPlaylistMaker {
    private ArrayList<MusicSelection> library;
    private ArrayList<MusicSelection> playlist;
    public boolean flag;    //to use in our loop

    public LibraryAndPlaylistMaker() {
        createLibrary();
        //playlist = new ArrayList<>();
        flag = true;
           //for keeping track of how many things we actively add/remove from the playlist
    }

    public void menu() {
        System.out.println();
        System.out.println("Choose an option: ");
        System.out.println("1.) Create Playlist..."); //just invokes "playlist = new ArrayList<>()"
        System.out.println("2.) Delete Playlist..."); //use isEmpty to make sure user doesn't delete a nonexistent playlist
        System.out.println("3.) Add Selection to Playlist..."); //use isEmpty
        System.out.println("4.) Remove Selection from Playlist...");
        System.out.println("5.) Quit...\n");
        System.out.println("Your choice?: ");
    }

    public void createPlaylist()        //dont forget to use .trimtosize after the user is done making the playlist
    {
        if (playlist != null) {
            System.out.println("Playlist is already made!");
        }
        else {
            playlist = new ArrayList<>();
      /*      for (int i = 0; i <  50; i++)
            {
                playlist.add(new MusicSelection()); //allocate memory
            } */
            System.out.println("Playlist Made");
        }
    }

    public void deletePlaylist() {
        if (playlist == null) {
            System.out.println("there is no Playlist made!");
        } else {
            playlist.clear();
            playlist = null;
            System.out.println("Playlist deleted");
        }
    }

    public void addSelection()
    {
        if (playlist == null) {
            System.out.println("You must create a Playlist first before adding selections!");
        } else {

        //include artist menu. generate titles based on the artist
            Scanner cin = new Scanner (System.in);
            int option; //used for title...if select 2, iterate through twice
            MusicSelection obj = new MusicSelection();  //create an object to help search the ArrayList
            artistMenu();
            option = cin.nextInt();

            switch(option)
            {
                case 1: obj.setArtist("Pink Floyd");
                    break;
                case 2: obj.setArtist("The Who");
                    break;
                case 3: obj.setArtist("Led Zeppelin");
                    break;
                case 4: obj.setArtist("Stephane Grappelli");
                    break;
                case 5: obj.setArtist("Spyro Gyra");
                    break;
                case 6: obj.setArtist("Yo-Yo Ma & Friends");
                    break;
                case 7: obj.setArtist("Yo-Yo Ma & Roma Sinfonietta");
                    break;
            }


            int sOption; int tempCounter = 1; //for loop later on to iterate through and select song choice

            for(MusicSelection song : library)
            {
                if ((song.getArtist().trim()).equals(obj.getArtist()))   //if song artist is same as desired artist, print out the song title
                {
                    System.out.println(tempCounter + ".) " + song.getTitle());
                    tempCounter++;
                }
            }
            System.out.println("Select a song: ");
            sOption = cin.nextInt();
            int temp = 1;
            for (MusicSelection song : library)
            {
                if (song.getArtist().equals(obj.getArtist()) && (temp == sOption) )
                {
                        obj.setTitle(song.getTitle());
                        obj.setDate(song.getDate());
                        obj.setAlbum(song.getAlbum());
                        obj.setGenre(song.getGenre());

                        temp++;
                }
                else if (song.getArtist().equals(obj.getArtist()) && temp != sOption)
                {
                    temp++;
                }
            }

            playlist.add(obj);
            System.out.println("Song: " + obj.getTitle() + " by " + obj.getArtist() + " Has been added.\n");

            printPlaylist();
        }

    }

    public void removeSelection()
    {
        if (playlist == null)
        {
            System.out.println("There is no playlist to remove a selection from. Please make a playlist.");
        }
        else
        {
          Scanner cin = new Scanner(System.in);
          printPlaylist();
          System.out.println("\nPlease select a song to remove from the playlist");
          int option = cin.nextInt();
          while (!(option <= playlist.size() && option > 0))
          {
              System.out.println("That is not a valid choice. Please select from 1 to " + playlist.size());
              option = cin.nextInt();
          }

          playlist.remove((option - 1));

          System.out.println("Updated Playlist...");
          printPlaylist();
        }
    }

    public void createLibrary() {
        library = new ArrayList<>();
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new FileInputStream("music.txt"));
        }  //checked exception
        catch (FileNotFoundException e) {
            System.out.println("Fatal Error: File Not Found.");
            System.exit(0);
        }

        while (inputStream.hasNextLine())   //as long as there is stuff to read, iterate the loop
        {
            MusicSelection obj = new MusicSelection();  //define a new music selection object
            obj.setGenre(inputStream.nextLine());
            obj.setArtist(inputStream.nextLine());
            obj.setTitle(inputStream.nextLine());
            obj.setAlbum(inputStream.nextLine());
            obj.setDate(inputStream.nextLine());
            //once the MusicSelection object is "fleshed out" add it to the ArrayList

            library.add(obj);
        }
    inputStream.close();
        library.trimToSize();
    }

    //switch statement: if select 1, print out all song labels by that artist in a menu
    public void artistMenu()
    {
        System.out.println("Choose an artist\n");
        System.out.println("1.) Pink Floyd");
        System.out.println("2.) The Who");
        System.out.println("3.) Led Zepplin");
        System.out.println("4.) Stephane Grappelli");
        System.out.println("5.) Spyro Gyra");
        System.out.println("6.) Yo-Yo Ma & Friends");
        System.out.println("7.) Yo-Yo Ma & Roma Sinfonietta");
        System.out.println("\nYour choice: \n");
    }


    private void printPlaylist()
    {
        int counter = 1;
        for (MusicSelection song : playlist)
        {
            System.out.println("Song #" + counter);
            System.out.print(song);
            counter++;
        }
    }
}

