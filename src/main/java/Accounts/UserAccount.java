package Accounts;

import java.util.ArrayList;
import java.util.List;

import Api.TMDBController;
import Models.Collection;
import Models.Comment;
import SQLDBConnector.SQLDBConnector;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;

//Class 
public class UserAccount {

    private String userName;
    private TMDBController tmdb;
    private UserData userData;

    public UserAccount(String user){
        this.userName = user;
        tmdb = new TMDBController();
        //initialize userData - need sql methods
    }

    public int checkUser(String username) {
        return SQLDBConnector.checkUser(username);
    }

    public int createAccount(String user, String pass) {
        int accountStatus = SQLDBConnector.insertUser(user, pass);
        return accountStatus;
    }

    public boolean likeComment(Comment comment) {    //true if liked, false if unliked
        SQLDBConnector.insertLikedComment(comment);
        return false;
    }

    public boolean dislikeComment(Comment comment) {     //true if disliked, false if undisliked
        if (SQLDBConnector.insertDislikedComment(comment) == 1)
            return true;
        else
            return false;
    }
    
    // public boolean userHasLiked(int commentId) {
    //     // return sql method
    // }

    // public boolean userHasDisliked(int commentId) {
    //     // return sql method
    // }

    public int numLikes(String commentId){
        return SQLDBConnector.getComment(commentId).getNumLikes();
    }

    // public boolean userHasDisliked(int commentId)

    public int numDislikes(String commentId) {
        return SQLDBConnector.getComment(commentId).getNumDislikes();
    }

    // Create new movie Rating and Comment
    public void reviewMovie(int movieId, int rating, String content) {
        Comment review = new Comment.CommentBuilder()   // Create comment object
                        .content(content)
                        .rating(rating)
                        .movieId(movieId)
                        .userName(this.userName)
                        .build();

        SQLDBConnector.insertComment(review);   // Save comment to database
    }

    public void addComment(String content, String parentId) {
        Comment prev = SQLDBConnector.getComment(parentId);
        Comment newComment = new Comment.CommentBuilder()
            .content(content)
            .parentId(parentId)
            .userName(userName)
            .movieId(prev.getMovieId())
            .build();
        SQLDBConnector.insertComment(newComment);
    }


    public String recommendMovie(int movieId, String email) {
        return "mailto:" + email + "?subject=Check%20Out%20This%20Movie%20I%20Found!&body=More%20information%20can%20be%20found%20here:%0d%0ahttps://www.themoviedb.org/movie/" + movieId;
    }

    // public List<String> displayUserInfo()
    // public List<String> displaySavedCollection(int collectionId)

    public List<Person> searchPerson(String name){
        return tmdb.searchPerson(name);
    }
    public List<Integer> findMoviesByActor(Integer actorId) {//return list of movie ids
        // need method in TMDBController
        
        return null;
    }


    /*
     * Creates new collection in SQL database with given name, returns true
     * If a collection with given name already exists, false is returned
     */
    public boolean createNewCollection(String collectionName)
    {
        // If collection exists
        if (userData.containsCollection(collectionName))
        {
            return false;
        }

        userData.addCollection(collectionName);
        //SQLDBConnector._(this.userName, collectionName);     // Create collection in SQL database
        return true;
    }

    /*
     * Adds given movieId to the given collectionName in the SQL database
     * Returns boolean value indicating success/failure
     */
    public boolean addMovieToCollection(int movieId, String collectionName)
    {
        // If collection exists
        if (userData.containsCollection(collectionName))
        {
            SQLDBConnector.insertSaved(this.userName, movieId, collectionName);
            return (userData.addToCollection(movieId, collectionName));
        }

        userData.addCollection(collectionName);
        return (addMovieToCollection(movieId, collectionName)); // Recursive call
    }


    public void removeMovieFromCollection(int movieId, String collectionName)
    {
        // If collection exists
        if (userData.containsCollection(collectionName))
        {
            userData.removeFromCollection(movieId, collectionName);
            //SQLDBConnector._(this.userName, movieId, collectionName);     // Delete movieId from collection in database
        }
    }


    public boolean deleteCollection(String collectionName)
    {
        // If collection exists
        if (userData.containsCollection(collectionName))
        {
            //SQLDBConnector._(this.userName, collectionName);   // Delete collection from database
            userData.removeCollection(collectionName);
            return true;
        }

        return false;
    }


    public void addToWatched(int movieId)
    {
        userData.addToWatched(movieId);
        SQLDBConnector.insertWatched(this.userName, movieId);
    }


    public void addToWatchLater(int movieId)
    {
        userData.addToWatchLater(movieId);
        SQLDBConnector.insertWatchedLater(this.userName, movieId);
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
