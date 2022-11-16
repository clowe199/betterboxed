import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.TmdbApi;


public class TMDBController {
    private TmdbApi apiKey;
    private TmdbAccount userAccount;
    private String key = "7f8fa1bf325f4325f96ae5abae237bd1";
    private String query;

    public void TMDBController(String key){
        apiKey = new TmdbApi(key);
    }

    public void getMovieData(String movieId){
        query = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key="
        + key + "&language=en-US";
        System.out.println(query);
    }

    public void searchMovieName(String movieName){
        query = "https://api.themoviedb.org/3/search/movie?api_key=" + key + "&query=" + movieName;
        System.out.println(query);
    }
    

    public static void main(String args[]){
        TMDBController myController = new TMDBController();
        myController.getMovieData("464052");

        myController.searchMovieName("Interstellar");
    }
}
