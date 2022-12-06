package Accounts;
import java.util.List;

import Models.Comment;
import Models.Movie;
import SQLDBConnector.SQLDBConnector;

// ignore this class for now

public class AccountHandler {
    private UserAccount userAccount;

    public static void main(String[] args){
        AccountHandler accountHandler = new AccountHandler();
        accountHandler.createAccount("test", "test");
    }

    /* ---------- User Account Methods ---------- */

    /*
     * Instantiates the UserAccount constructor
     */
    public void createAccount(String pass, String user)
    {
        userAccount = new UserAccount(user);
        userAccount.createAccount(user, pass);
    }


    public void login(String pass, String user)
    {
        // Check if user is in the system
        if(userAccount.checkUser(user) == -1)
        {
            // Log user in
        }
    }


    public void logout()
    {

    }

    /* ---------- Comment Methods ---------- */

    /*
     * @param String commentId
     * @return int
     */
    public int numLikes(String commentId)
    {
        return (userAccount.numLikes(commentId));
    }

    /*
     * @param String commentId
     * @return int
     */
    public int numDislikes(String commentId)
    {
        return (userAccount.numDislikes(commentId));
    }


    /*
     * @param Comment
     * @return boolean
     */
    public boolean likeComment(Comment comment)
    {
        return (userAccount.likeComment(comment));
    }

    /*
     * @param Comment
     * @return boolean
     */
    public boolean dislikeComment(Comment comment)
    {
        return (userAccount.dislikeComment(comment));
    }
    
    /*
     * @param String commentId
     * @return boolean
     */
    public boolean userHasLiked(String commentId)
    {
        return (userAccount.userHasLiked(commentId));
    }

    /*
     * @param String commentId
     * @return boolean
     */
    public boolean userHasDisliked(String commentId)
    {
        return (userAccount.userHasDisliked(commentId));
    }


    /* ---------- Rating & Comment Methods ---------- */

    public void rateMovie(int movieId, int rating)
    {
        userAccount.reviewMovie(movieId, rating, null);
    }


    public void reviewMovie(int movieId, int rating, String review)
    {
        userAccount.reviewMovie(movieId, rating, review);
    }

    public void addComment(String newComment, String previousCommentId)
    {
        userAccount.addComment(newComment, previousCommentId);
    }


    /* ---------- Collection Methods ---------- */
    
    public void createNewCollection(String collectionName)
    {
        if (userAccount.createNewCollection(collectionName))
            System.out.println("Collection " + collectionName + " created");
        else
            System.out.println("Collection " + collectionName + " already exists");
    }

    public void addMovieToCollection(int movieId, String collectionName)
    {
        if (userAccount.addMovieToCollection(movieId, collectionName))
            System.out.println("Movie " + movieId + " added to collection " + collectionName);
        else
            System.out.println("Movie " + movieId + " already in collection " + collectionName);
    }

    public void removeMovieFromCollection(int movieId, String collectionName)
    {
        userAccount.removeMovieFromCollection(movieId, collectionName);
    }

    /* ---------- Display Methods ---------- */

    // Display will tailor to the app type
    public List<String> displaySavedCollection(int collectionId)
    {
        return null;
    }

    public List<String> displayUserInfo()
    {
        return null;
    }
    
    public List<String> displayHighlyRatedMovies()
    {
        return null;
    }

    public List<Integer> findMoviesByActor(int actorId)
    {
        return null;
    } //return list of movie ids
    
    public List<Integer> findFilm(String title)
    {
        return null;
    } //return list of movie ids

    public void recommendMovie(int movieId, String email)
    {

    }
}
