package homework3;

import java.util.Scanner;
public class MusicPlaylistMakerMain
{
    public static void main(String[] args)
    {
        LibraryAndPlaylistMaker Music = new LibraryAndPlaylistMaker();
        System.out.println("creating Slightly Legal Online Music Library...");
        Music.createLibrary();
        Scanner cin = new Scanner(System.in);
        boolean flag = true;

        do {

            Music.menu();
            int option = cin.nextInt();
            while (!(option <= 5 && option > 0))
            {
                System.out.println("That's not a valid choice. Please pick from 1 to 5: ");
                option = cin.nextInt();
            }
            switch (option)
            {
                case 1: Music.createPlaylist();
                    break;
                case 2: Music.deletePlaylist();
                    break;
                case 3: Music.addSelection();
                    break;
                case 4: Music.removeSelection();
                    break;
                case 5: flag = false;
            }
        }while(flag);

        System.out.println("Thanks for illegally downloading music :) ");
    }
}
