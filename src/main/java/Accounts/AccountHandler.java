package Accounts;
import java.util.List;

import Models.Movie;

// ignore this class for now

public abstract class AccountHandler {
    public void createAccount(char[] pass, char[] user) {}
    public void login(char[] pass, char[] user){}
    public void logout(){}
    public boolean likeComment(int commentId){return false;}    //true if liked, false if unliked
    public boolean dislikeComment(int commentId) {return false;}    //true if disliked, false if undisliked
    
    public boolean userHasLiked(int commentId){return false;}
    public int numLikes(int commentId){return 0;}
    public boolean userHasDisliked(int commentId){return false;}
    public int numDislikes(int commentId){return 0;}

    public void rateMovie(int movieId, int rating){}
    public void reviewMovie(int movieId, int rating, String review){}
    public void addComment(String newCom, int previousCommentId){}

    public void addMovieToCollection(Movie m, int collindex){}
    public void removeMovieFromCollection(int movieId, int collindex){}

    public void recommendMovie(int movieId, String email){}
    public List<String> displayUserInfo(){return null;}
    public List<String> displaySavedCollection(int collectionId){return null;}
    public List<String> displayHighlyRatedMovies(){return null;}
    public List<Integer> findMoviesByActor(int actorId){return null;} //return list of movie ids
    public int createNewCollection(){return 0;} //return collectionId
    public List<Integer> findFilm(String title){return null;} //return list of movie ids
}
