import java.util.ArrayList;

public class Collection {
    private ArrayList<Movie> movieList;
    private String name;

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public String getName() {
        return name;
    }

    public Collection(){
        this("un-named collection");
    }

    public Collection(String name){
        this(name, new ArrayList<Movie>());
    }

    public Collection(String name, ArrayList<Movie> movies){
        this.name = name;
        movieList = new ArrayList<Movie>();
        movieList.addAll(movies);
    }

    public void addMovie(Movie m){
        if (!movieList.contains(m))
            movieList.add(m);
    }

    public void remove(Movie m){
        if (movieList.contains(m))
            movieList.remove(m);
    }
}
