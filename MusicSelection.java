package homework3;

public class MusicSelection
{
    private String genre;
    private String artist;
    private String title;
    private String album;
    private String date;

    public MusicSelection()
    {
        this.genre = "";
        this.artist = "";
        this.title = "";
        this.album = "";
        this.date = "";
    };
    public MusicSelection(String genre, String artist, String title, String album, String date) //send "" when creating objects
                                                                                            //so new MusicSelection("", "", ""...)
    {
        this.genre = genre;
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.date = date;
    }
    //Mutator methods
    public void setGenre(String genre) {this.genre = genre;}
    public void setArtist(String artist) {this.artist = artist;}
    public void setTitle(String title) {this.title = title;}
    public void setAlbum(String album) {this.album = album;}
    public void setDate(String date) {this.date = date;}

    //Accessor methods
    public String getGenre() {return genre;}
    public String getArtist() {return artist;}
    public String getTitle() {return title;}
    public String getAlbum() {return album;}
    public String getDate() {return date;}

    public String toString()
    {
        //use String format
        return (
                "\n" +
                "Genre:  " + genre + "\n" +
                "Artist: " + artist + "\n" +
                "Title:  " + title + "\n" +
                "Album:  " + album + "\n" +
                "Date:   " + date + "\n"
                );
    }




}
