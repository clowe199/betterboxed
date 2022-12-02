import java.util.ArrayList;
import java.util.List;

public class Collection {
    private List<Movie> movieList;
    private String name;

    public List<Movie> getMovieList() {
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

    public void add(Movie m){
        if (!movieList.contains(m))
            movieList.add(m);
    }

    public void remove(Movie m){
        if (movieList.contains(m))
            movieList.remove(m);
    }

    public boolean contains(Movie m){
        return movieList.contains(m);
    }
}
