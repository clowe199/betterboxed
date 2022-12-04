package Accounts;

import java.util.ArrayList;
import java.util.List;

import Api.TMDBController;
import Models.Collection;
import Models.Comment;
import SQLDBConnector.SQLDBConnector;
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
        SQLDBConnector.insertUser(user, pass);
    }
    // public void login(char[] pass, char[] user)
    // public void logout(){

    // }
    public boolean likeComment(Comment comment) {    //true if liked, false if unliked
        // if (userHasLiked(comment.getRatingId()))
        // //  set to unliked
        //     return true;
        // else
            SQLDBConnector.insertLikedComment(comment);
            return false;
    }
    public boolean dislikeComment(Comment comment) {     //true if disliked, false if undisliked
        // if (userHasLiked(comment.getRatingId()))
        // //  set to unliked
        //     return true;
        // else
        // SQLDBConnector.insertDislikedComment(comment);
        return false;
    }
    
    // public boolean userHasLiked(int commentId) {
    //     // return sql method
    // }
    public int numLikes(String commentId){
        // return SQLDBConnector.getComment(commentId).getNumLikes();
        return 0; //this line will get deleted
    }
    // public boolean userHasDisliked(int commentId)
    public int numDislikes(String commentId) {
        // return SQLDBConnector.getComment(commentId).getNumDislikes();
        return 0; //this line will get deleted
    }

    // Create new movie Rating and Comment
    public void reviewMovie(int movieId, int rating, String content) {
        // Create comment object
        Comment review = new Comment.CommentBuilder()
                        .content(content)
                        .rating(rating)
                        .movieId(movieId)
                        .userName(this.userName)
                        .build();

        // Save comment to database
        SQLDBConnector.insertComment(review);
    }

    public void addComment(String content, int parentId) {
        // comment prev = fetch comment from database
        // Comment newComment = new Comment(content, userName, prev.getMovieId(), previousCommentId);
        // save newComment in database
    }

    // public void addMovieToCollection(Movie m, int collindex)
    // public void removeMovieFromCollection(int movieId int collindex)




    public String recommendMovie(int movieId, String email) {
        return "mailto:" + email + "?subject=Check%20Out%20This%20Movie%20I%20Found!&body=More%20information%20can%20be%20found%20here:%0d%0ahttps://www.themoviedb.org/movie/" + movieId;
    }

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
