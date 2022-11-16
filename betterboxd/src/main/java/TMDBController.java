import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.TmdbMovies;

public class TMDBController {
    
    public static void main(String args[]){
        System.out.println("Hello World");
        String apiKey = "7f8fa1bf325f4325f96ae5abae237bd1";
        String apiRAToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ZjhmYTFiZjMyNWY0MzI1Zjk2YWU1YWJhZTIzN2JkMSIsInN1YiI6IjYzNDYyMGRjNjk5ZmI3MDA3OTA3Mjk2YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.yhkymI1CqH9Mp4UMS3Fd_-Kx2Jw9p-zIEx4N5WelR8A";

        TmdbAccount movies = new TmdbApi(apiKey).getAccount();
        System.out.println(movies);
    }
}
