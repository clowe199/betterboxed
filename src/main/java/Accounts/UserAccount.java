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
    public int createAccount(String user, String pass) {
        int accountStatus = SQLDBConnector.insertUser(user, pass);
        return accountStatus;
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
                // if (userHasDisliked(comment.getRatingId()))
                //     SQLDBConnector.removeLike(comment) // - this is pseudocode basically

            return false;
    }
    public boolean dislikeComment(Comment comment) {     //true if disliked, false if undisliked
        // if (userHasDisliked(comment.getRatingId()))
        // //  set to unDisliked
        //     return true;
        // else
        //     SQLDBConnector.insertDislikedComment(comment);
                // if (userHasLiked(comment.getRatingId()))
                //     SQLDBConnector.removeLike(comment) // - this is pseudocode basically
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
        Comment review = new Comment.CommentBuilder()   // Create comment object
                        .content(content)
                        .rating(rating)
                        .movieId(movieId)
                        .userName(this.userName)
                        .build();

        SQLDBConnector.insertComment(review);   // Save comment to database
    }

    public void addComment(String content, int parentId) {
        // comment prev = fetch comment from database
        // Comment newComment = new Comment(content, userName, prev.getMovieId(), previousCommentId);
        // save newComment in database
    }


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


    /*
     * Creates new collection in SQL database with given name and one movieId, returns true
     * If a collection with given name already exists, false is returned
     */
    public boolean createNewCollection(String collectionName, int movieId) 
    {
        List<String[]> collectionTest = SQLDBConnector.getSavedMovies(this.userName, collectionName);
        
        // If collection does not exist
        if (collectionTest == null) {
            Collection newCollection = new Collection(collectionName);
            newCollection.add(movieId);
            SQLDBConnector.insertSaved(this.userName, movieId, collectionName);     // Save collection in SQL database
            return true;
        }

        return false;
    }

    /*
     * Adds given movieId to the given collectionName in the SQL database
     * Returns boolean value indicating success/failure
     */
    public boolean addMovieToCollection(int movieId, String collectionId){

        List<String[]> collection = SQLDBConnector.getSavedMovies(this.userName, collectionId);

        if (collection == null)     // If empty collection, create new collection and add movieId
            return createNewCollection(collectionId, movieId);
        else    // Else, add the movieId to the DB collection
            SQLDBConnector.insertSaved(this.userName, movieId, collectionId);

        return true;
    }

    // public void removeMovieFromCollection(int movieId int collindex)

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
