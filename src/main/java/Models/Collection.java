package Models;
import java.util.ArrayList;
import java.util.List;

public class Collection {
    private List<Integer> movieList;
    private String name;

    public List<Integer> getMovieList() {
        return movieList;
    }

    public String getName() {
        return name;
    }

    public Collection(){
        this("un-named collection");
    }

    public Collection(String name){
        this(name, new ArrayList<Integer>());
    }

    public Collection(String name, ArrayList<Integer> movies){
        this.name = name;
        movieList = new ArrayList<Integer>();
        movieList.addAll(movies);
    }

    public void add(Integer movieId){
        if (!movieList.contains(movieId))
            movieList.add(movieId);
    }

    public void remove(Integer movieId){
        if (movieList.contains(movieId))
            movieList.remove(movieId);
    }

    public boolean contains(Integer movieId){
        return movieList.contains(movieId);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name + ": ");
        sb.append(", ");
        for (Integer movieId : movieList){
            sb.append(movieId);
            sb.append(" ");
        }
        return sb.toString();
    }
}
