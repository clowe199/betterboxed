package Accounts;

import java.util.ArrayList;
import java.util.List;

import Api.TMDBController;
import Models.Collection;
import Models.Comment;
import SQLDBConnector.SQLDBConnector;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.people.PersonCredit;

public class UserAccount {

    private String userName;
    private TMDBController tmdb;
    private UserData userData;
    public static void main(String[] args) {
        UserAccount test = new UserAccount("testkyle");
        // System.err.println(test.getUserData());
        System.out.println(test.findPerson("Chris"));
        System.out.println(test.getMovieData((test.findMoviesByActor(74568)).get(0)));
        System.out.println(test.getMovieData((test.findMoviesByActor(74568)).get(1)));
        System.out.println(test.getMovieData((test.findMoviesByActor(74568)).get(2)));
        System.out.println(test.getMovieData((test.findMoviesByActor(74568)).get(3)));

    }
    
    public UserAccount(String user) {
        this.userName = user;
        tmdb = new TMDBController();

        userData = new UserData.UserDataBuilder()
            .username(userName)
            // .watchLaterList(new Collection(UserData.WATCH_LATER_TITLE, convertToInt(SQLDBConnector.getWatchLater(user))))
            // .watchedList(new Collection(UserData.WATCHED_TITLE, convertToInt(SQLDBConnector.getWatched(user))))
            .collections(getCollections())
            .build();
    }

    public int checkUser(String username) {
        return SQLDBConnector.checkUser(username);
    }

    public int createAccount(String user, String pass) {
        int accountStatus = SQLDBConnector.insertUser(user, pass);
        return accountStatus;
    }

    //----------------------Likes and dislikes-------------------------
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
    public boolean userHasLiked(String commentId) {
        return SQLDBConnector.checkIfLikedComment(userName, commentId);
    }
    public boolean userHasDisliked(String commentId) {
        return SQLDBConnector.checkIfDislikedComment(userName, commentId);
    }
    public int numLikes(String commentId) {
        return SQLDBConnector.getComment(commentId).getNumLikes();
    }
    public int numDislikes(String commentId) {
        return SQLDBConnector.getComment(commentId).getNumDislikes();
    }

    // Create new Rating and Comment
    public void reviewMovie(int movieId, int rating, String content) {
        Comment review = new Comment.CommentBuilder()   // Create comment object
                        .content(content)
                        .rating(rating)
                        .movieId(movieId)
                        .userName(this.userName)
                        .build();

        SQLDBConnector.insertComment(review);   // Save comment to database
    }
    /**
     * 
     * @param content
     * @param parentId -1 if no parent/movie is parent
     */
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

    /**
     * 
     * order of list: username, Watched Id, Watch Later Id, finally any other Collection Ids
     * 
     * @return ArrayList<String
     * 
     */
    public ArrayList<String> displayUserInfo() {
        ArrayList<String> list = new ArrayList<String>();
        list.add(userName);
        list.add(UserData.WATCHED_TITLE);
        list.add(UserData.WATCH_LATER_TITLE);
        list.addAll(userData.getCollectionTitles());
        return list;
    }

    /**
     * 
     * @param collectionId
     * @return list of movie ids
     */
    public ArrayList<String> displaySavedCollection(String collectionId) {
        ArrayList<String[]> collection = SQLDBConnector.getSavedMovies(userName, collectionId);
        ArrayList<String> result = new ArrayList<String>();
        for (String[] movie :collection){
            result.add(movie[0]);
        }
        return result;

    }

    //----------------------Collection methods --------------------

    /*
     * Creates new collection in SQL database with given name, returns true
     * If a collection with given name already exists, false is returned
     */
    public boolean createNewCollection(String collectionName) {
        if (userData.containsCollection(collectionName))
            return false;
        userData.addCollection(collectionName);
        return true;
    }
    /*
     * Adds given movieId to the given collectionName in the SQL database
     * Returns boolean value indicating success/failure
     */
    public boolean addMovieToCollection(int movieId, String collectionName) {
        if (userData.containsCollection(collectionName)) {   // If collection exists
            if (SQLDBConnector.insertSaved(this.userName, movieId, collectionName)==1) {// if sql is successfull
                userData.addToCollection(movieId, collectionName);
                return true;
            }
        }
        return false;
    }
    public void removeMovieFromCollection(int movieId, String collectionName) {
        // If collection exists
        if (userData.containsCollection(collectionName))
        {
            userData.removeFromCollection(movieId, collectionName);
            SQLDBConnector.deleteSavedMovie(this.userName, String.valueOf(movieId), collectionName);     // Delete movieId from collection in database
        }
    }
    public boolean deleteCollection(String collectionName) {
        // If collection exists
        if (userData.containsCollection(collectionName))
        {
            ArrayList<Integer> collection = userData.getCollection(collectionName).getMovieList();
            for (Integer s : collection)
                SQLDBConnector.deleteSavedMovie(userName, Integer.toString(s), collectionName);   // Delete collection from database movie by movie
            userData.removeCollection(collectionName);
            return true;
        }

        return false;
    }

    public boolean addToWatched(int movieId)
    {
        if (userData.watchedContains(movieId)) {   // If collection exists
            if (SQLDBConnector.insertWatched(this.userName, movieId)==1) {// if sql is successfull
                userData.addToWatched(movieId);
                return true;
            }
        }
        return false;
    }

    public boolean addToWatchLater(int movieId)
    {
        if (userData.watchLaterContains(movieId)) {   // If collection exists
            if (SQLDBConnector.insertWatchLater(this.userName, movieId)==1) {// if sql is successfull
                userData.addToWatched(movieId);
                return true;
            }
        }
        return false;    
    }
    

    //----------------------TMDB related methods-----------------
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
    public List<Person> findPerson(String name){
        return tmdb.searchPerson(name);
    }
    public List<Integer> findMoviesByActor(Integer actorId) {//return list of movie ids
        List<Integer> idList = new ArrayList<Integer>();
        List<PersonCredit> movies = tmdb.getPersonData(74568).getCast();
        for (PersonCredit p: movies) {
            idList.add(p.getId());
        }
        return idList;
    }
    public MovieDb getMovieData(int movieId) {
        return tmdb.getMovieData(movieId);
    }
    //----------------------recommend movie by email ------------
    public String recommendMovie(int movieId, String email) {
        return "mailto:" + email + "?subject=Check%20Out%20This%20Movie%20I%20Found!&body=More%20information%20can%20be%20found%20here:%0d%0ahttps://www.themoviedb.org/movie/" + movieId;
    }

    //----------------------miscellaneous------------------------
    public UserData getUserData() {
        return userData;
    }

    private ArrayList<Integer> convertToInt(ArrayList<String[]> movies) {
        ArrayList<Integer> movieIds = new ArrayList<Integer>();
        for (String[] movie :movies){
            movieIds.add(Integer.parseInt(movie[0]));
        }
        return movieIds;
    }

    private ArrayList<Collection> getCollections() {
        ArrayList<Collection> collections = new ArrayList<Collection>();
        ArrayList<String[]> collectionIds = SQLDBConnector.getUserCollections(userName);
        for (String[] collection : collectionIds){
            collections.add(new Collection(collection[0], convertToInt(SQLDBConnector.getSavedMovies(userName, collection[0]))));
        }
        return collections;
    }

}
