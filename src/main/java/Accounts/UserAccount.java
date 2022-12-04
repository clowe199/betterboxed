package Accounts;
import java.util.ArrayList;
import java.util.List;

import Api.TMDBController;
import Models.Collection;
import Models.Comment;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;

public class UserAccount {

    private String userName;
    private TMDBController tmdb;

    public UserAccount(String user){
        this.userName = user;
        tmdb = new TMDBController();
    }

    // private UserAccount = new UserAccount;
    public void createAccount(String pass, String user) {
        // SQLDBConnector.insertUser(user, pass);
    }
    // public void login(char[] pass, char[] user)
    // public void logout(){

    // }
    // public boolean likeComment(int commentId) {    //true if liked, false if unliked
        // if userHasLiked(commentId)
        //  set to unliked
        //  return true;
        // else
        //  like comment in database
        //  return false;
    // }
    // public boolean dislikeComment(int commentId) {     //true if disliked, false if undisliked
        // if userHasLiked(commentId)
        //  set to unliked
        //  return true;
        // else
        //  like comment in database
        //  return false;
    // }
    
    // public boolean userHasLiked(int commentId)
    public int numLikes(int commentId){
        // fetch comment/review from database
        // return number of likes
        return 0; // nonfinal return value
    }
    // public boolean userHasDisliked(int commentId)
    public int numDislikes(int commentId) {
        // fetch comment/review from database
        // return number of dislikes
        return 0; // nonfinal return value
    }

    // public void rateMovie(int movieId, int rating)
    public void reviewMovie(int movieId, int rating, String content) {
        // check if user has reviewed the movie
        Comment review = new Comment(rating, content, userName, movieId, -1);
        // save review to database
    }

    public void addComment(String content, int previousCommentId) {
        // comment prev = fetch comment from database
        // Comment newComment = new Comment(content, userName, prev.getMovieId(), previousCommentId);
        // save newComment in database
    }

    // public void addMovieToCollection(Movie m, int collindex)
    // public void removeMovieFromCollection(int movieId int collindex)




    // public void recommendMovie(int movieId, String email)




    // public List<String> displayUserInfo()
    // public List<String> displaySavedCollection(int collectionId)

    public List<Person> searchPerson(String name){
        return tmdb.searchPerson(name);
    }
    // public List<Integer> findMoviesByActor(Integer actorId) {//return list of movie ids
    //     need method in TMDBController
    
    // return null;
    // }

    public boolean createNewCollection(String collectionName) { //return collectionName, return empty string if name is taken
        // if collectionName is taken
            // return false
        Collection c = new Collection(collectionName);
        //save collection in SQL database

        return true;
    
    }


    public boolean deleteCollection(String collectionName) { //return collectionName, return empty string if name is taken
        // if collectionName is taken
            // return false
        Collection c = new Collection(collectionName);
        //delete collection from SQL database
        return true;
    }
    public void addToWatched(int movieId){
        // SQLDBConnector.insertWatched(userName, movieId);
    }
    public void addToWatchLater(int movieId){
        // SQLDBConnector.insertWatchedLater(userName, movieId);
    }
    
    public boolean addMovieToCollection(int movieId, String collectionName){
        //if collectionName does not exist
            //return false
        //else
            //insert movie in collection
            return true;
    }

    public List<Integer> displayHighlyRatedMovies(){
        List<MovieDb> movieList = tmdb.getHighlyRatedMovies();
        List<Integer> idList = new ArrayList<Integer>();
        for (MovieDb m: movieList){
            idList.add(m.getId());
        }
        return idList;
    }
    public List<Integer> findFilm(String title) { //return list of movie ids
        List<MovieDb> movieList = tmdb.searchMovieName(title);
        List<Integer> idList = new ArrayList<Integer>();
        for (MovieDb m: movieList){
            idList.add(m.getId());
        }
        return idList;
    }
}
