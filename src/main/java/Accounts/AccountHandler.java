package Accounts;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Api.TMDBController;
import Models.Comment;
import Models.Movie;
import SQLDBConnector.SQLDBConnector;
import info.movito.themoviedbapi.model.people.Person;

// ignore this class for now

public class AccountHandler {
    private UserAccount userAccount;
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        AccountHandler handler = new AccountHandler();
        handler.mainMenu();
    }

    private void mainMenu() {
        System.out.println("What would you like to do?\n 1: login\n 2: register new account\n 3: close BetterBoxd");
        String choice = scan.nextLine();

        int choiceInt;
        try {
             choiceInt = Integer.parseInt(choice);
             switch (choiceInt){
                case 1:
                    login();
                    break;
                case 2:
                    registerAccount();
                    break;
                case 3:
                    System.out.println("Goodbye");;
                    break;
                default:
                    System.out.println("Invalid choice");
                    mainMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            mainMenu();
        }
    }

    //----------------------menus------------------------
    private void homeScreen() {
        System.out.println("what would you like to do?"
            +"\n1: view account info"
            +"\n2: search for a movie"
            +"\n3: log out");

        int choiceInt;
        String choice = scan.nextLine();
        try {
             choiceInt = Integer.parseInt(choice);
             switch (choiceInt){
                case 1:
                    viewAccountInfo();
                    break;
                case 2:
                    goToMovieSearch();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice");
                    mainMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            mainMenu();
        }
    }

    //homeScreen
    private void goToMovieSearch(){
        System.out.println("what would you like to do?"
            +"\n1: search for a movie by title"
            +"\n2: search for a movie by actor"
            +"\n3: go back to home");

        int choiceInt;
        String choice = scan.nextLine();
        try {
             choiceInt = Integer.parseInt(choice);
             switch (choiceInt){
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    searchByActor();
                    break;
                case 3:
                    homeScreen();
                    break;
                default:
                    System.out.println("Invalid choice");
                    goToMovieSearch();
            }
        } catch (NumberFormatException e) {
            goToMovieSearch();
        }
    }

    //goToMovieSearch
    private void searchByActor() {
        System.out.println("Enter search query (actor name): ");
        String query = scan.nextLine();
        List<Person> idList = userAccount.findPerson(query);
        if (idList.size() == 1) {
            personFoundMenu(idList.get(0).getId());
        } else {
            for (int i = 0; i < idList.size(); i++){
                System.out.println(i+": "+userAccount.getPersonData(idList.get(i).getId()));
            }
            System.out.println("Choose person (enter number on left): ");
            String choice = scan.nextLine();
            try {
                int choiceInt = Integer.parseInt(choice);
                personFoundMenu(idList.get(choiceInt).getId());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                searchByActor();
            }
        }
    }

    //searchByActor
    private void personFoundMenu(int id) {
        List<Integer> idList = userAccount.findMoviesByActor(id);
        if (idList.size() == 1) {
            movieFoundMenu(idList.get(0));
        }
        else {
            for (int i = 0; i < idList.size(); i++){
                System.out.println(i+": "+userAccount.getMovieData(idList.get(i)));
            }
            System.out.println("Choose movie (enter number on left, -1 to exit): ");
            String choice = scan.nextLine();
            try {
                int choiceInt = Integer.parseInt(choice);
                if (choiceInt == -1)
                    searchByActor();
                else if (choiceInt < 0 || choiceInt > idList.size()-1)
                    movieFoundMenu(idList.get(choiceInt));
                else {
                    System.out.println("Invalid choice");
                    personFoundMenu(id);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                personFoundMenu(id);
            }
        }
    }

    //goToMovieSearch
    private void searchByTitle(){
        System.out.println("Enter search query (title): ");
        String query = scan.nextLine();
        List<Integer> idList = userAccount.findFilm(query);
        if (idList.size() == 1) {
            movieFoundMenu(idList.get(0));
        }
        else {
            for (int i = 0; i < idList.size(); i++){
                System.out.println(i+": "+userAccount.getMovieData(idList.get(i)));
            }
            System.out.println("Choose movie (enter number on left): ");
            String choice = scan.nextLine();
            try {
                int choiceInt = Integer.parseInt(choice);
                movieFoundMenu(idList.get(choiceInt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                searchByTitle();
            }
        }
    }

    //searchByTitle
    private void movieFoundMenu(int id){
        System.out.println("Movie found: "+ userAccount.getMovieData(id).getOverview());
        System.out.println("What would you like to do?"
            +"\n1: read reviews"
            +"\n2: leave review"
            +"\n3: save movie"
            +"\n4: exit");
        
        int choiceInt;
        String choice = scan.nextLine();
        try {
             choiceInt = Integer.parseInt(choice);
             switch (choiceInt){
                case 1:
                    readReviews(id);
                    break;
                case 2:
                    leaveReview(id);
                    break;
                case 3:
                    saveMovie(id);
                    break;
                case 4:
                    searchByTitle();
                    break;
                default:
                    System.out.println("Invalid choice");
                    movieFoundMenu(id);
             }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            movieFoundMenu(id);
        }
    }

    //movieFoundMenu
    private void leaveReview(int movieId){
        System.out.println("Enter number rating: ");
        String rating = scan.nextLine();
        int ratingInt;
        try {
            ratingInt = Integer.parseInt(rating);
            System.out.println("Enter review content: ");
            String content = scan.nextLine();
            userAccount.addReview(content, ratingInt, movieId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid rating");
            leaveReview(movieId);
            return;
        }
        movieFoundMenu(movieId);
    }

    // Save movie to collection
    private void saveMovie(int id){
        boolean returnVal = false;
        System.out.println("Save movie: "+ userAccount.getMovieData(id));
        System.out.println("Where would you like to save the movie?"
            +"\n1: Watched movies list"
            +"\n2: Watch later list"
            +"\n3: Custom movie list");
        
        int choiceInt;
        String choice = scan.nextLine();
        try {
             choiceInt = Integer.parseInt(choice);
             switch (choiceInt){
                case 1:
                    returnVal = userAccount.addToWatched(id);
                    break;
                case 2:
                    returnVal = userAccount.addToWatchLater(id);
                    break;
                case 3:
                    String option = chooseCollection();
                    returnVal = userAccount.addMovieToCollection(id, option);
                    break;
                default:
                    System.out.println("Invalid choice");
                    movieFoundMenu(id);
             }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            movieFoundMenu(id);
        }

        if (returnVal) {
            System.out.println("Movie saved");
            goToMovieSearch();
        }
        else {
            System.out.println("Error - movie not saved");
            movieFoundMenu(id);
        }
    }


    //movieFoundMenu
    private void readReviews(int id){
        List<String> commentIds = userAccount.getComments(id);
        List<String> reviews = new ArrayList<String>();
        for (String cID: commentIds) {
            // Checking if database returns anything
            if (!userAccount.getComment(cID).toString().equals(null)){
                reviews.add(cID);
            }
        }
        if (reviews.size() == 0){
            System.out.println("No reviews");
            movieFoundMenu(id);
        }
        else {
            int currReview = 0;
            while (currReview < reviews.size()){
                // System.out.println(userAccount.getComment(reviews.get(currReview)));
                printReplies(reviews.get(currReview), userAccount.getComment(reviews.get(currReview)).getUserName());
                currReview++;
            }
            movieFoundMenu(id);
        }

    }

    private void printReplies(String commentText, String user ) {
        System.out.println(user +" Says: " + commentText);
	}

    //homescreen
    private void viewAccountInfo() {
        ArrayList<String> info = userAccount.displayUserInfo();
        System.out.println("Username: "+info.get(0));
        System.out.println(userAccount.getUserData().toString());
        System.out.println("\n\n\nWhat would you like to do?"
            + "\n1: edit watched movies"
            + "\n2: edit movies to watch later"
            + "\n3: edit collections"
            + "\n4: exit profile");

        int choiceInt;
        String choice = scan.nextLine();
        try {
             choiceInt = Integer.parseInt(choice);
             switch (choiceInt){
                case 1:
                    // editWatched();
                    break;
                case 2:
                    // editWatchLater();
                    break;
                case 3:
                    editCollection();
                    break;
                case 4:
                    homeScreen();
                    break;
                default:
                    System.out.println("Invalid choice");
                    viewAccountInfo();
             }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            viewAccountInfo();
        }
    }

    //viewAccountInfo
    private void editCollection(){
        System.out.println("What would you like to do?"
            +"\n1: Create a new collection"
            +"\n2: delete collection"
            +"\n3: remove movie from collection"
            +"\n4: change name of collection"
            +"\n5: exit profile");
        int choiceInt;
        String choice = scan.nextLine();
        try {
             choiceInt = Integer.parseInt(choice);
             switch (choiceInt){
                case 1:
                    createNewCollection();
                    break;
                case 2:
                    deleteCollection();
                    break;
                case 3:
                    removeMovieFromCollection();
                    break;
                case 4:
                    changeCollectionName();
                    break;
                case 5:
                    homeScreen();
                    break;
                default:
                    System.out.println("Invalid choice");
                    editCollection();
             }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice");
            editCollection();
        }
    }

    //editCollection
    private void changeCollectionName() {
        String choice = chooseCollection();
        System.out.println("Enter new collection name: ");
        String newName = scan.nextLine();
        userAccount.changeCollectionName(choice, newName);
        editCollection();
    }

    //helper function - editCollection
    private String chooseCollection() { // return collection id 
        System.out.println("Which collection? (enter -1 to cancel)");
        ArrayList<String> info = userAccount.displayUserInfo();
        for (int i = 3; i < info.size(); i++){
            System.out.println((i-2) + ": " + info.get(i));
        }
        int choiceInt;
        String choice = scan.nextLine();
        try {
             choiceInt = Integer.parseInt(choice)+2;
             if (choiceInt == -1)
                return null;
             return(info.get(choiceInt));
        } catch (NumberFormatException e){
            System.out.println("Invalid choice");
            return chooseCollection();
        } catch (Exception ex){
            System.out.println("Invalid choice");
            return chooseCollection();
        }
    }
    //editCollection
    private void deleteCollection(){
        String choice = chooseCollection();
        if (choice.equals(null))
            editCollection();
        else {
            userAccount.deleteCollection(null);
            viewAccountInfo();
        }
    }
    //editCollection
    private void removeMovieFromCollection() {
        // String choice = chooseCollection();
        // if (choice.equals(null))
        //     editCollection();
        // else {
        //     String movieChoice = chooseMovie();
        //     if (movieChoice.equals(null))
        //         editCollection();
        // }
        // viewAccountInfo();
        System.out.println("Please Select a collection to remove a movie from: ");
        String chosenCollectionId = chooseCollection();
        String decision; 

        List<String> moviesInCollection = userAccount.displaySavedCollection(chosenCollectionId);
        TMDBController apiAccess = new TMDBController();
        for (int i = 0; i < moviesInCollection.size(); i++){
            System.out.println("Would you like to remove: " + apiAccess.getMovieData(i).getTitle());
            System.out.println("Yes or No?");
            if((decision = scan.nextLine()).equals("Y")){
                removeMovieFromCollection(i, chosenCollectionId);
                homeScreen();
            }
            else if((decision = scan.nextLine()).equals("N")){
                continue;
            }
            else{
                System.out.println("Invalid choice");
                continue;
            }
        }
        
        // System.out.println("method not finished");
    }
   
   
   
    /* ---------- User Account Methods ---------- */

    public void registerAccount(){
        System.out.println("To create account, insert username and password");
        System.out.println("Enter new username: ");
        String username = scan.nextLine();
        System.out.println("Enter new password: ");
        String password = scan.nextLine();
        System.out.println("Creating account...");
        createAccount(username, password);
    }
    /*
     * Instantiates the UserAccount constructor
     */
    public void createAccount(String pass, String user)
    {
        userAccount = new UserAccount(user);
        if (userAccount.createAccount(user, pass) == 1) {
            System.out.println("Welcome to BetterBoxd " + user + "!");
            homeScreen();
        }
        else
            System.out.println("Error creating account");
            mainMenu();

    }

    public void login() {
        System.out.println("\n\n\n\n\nTo log in, insert username and password");
        System.out.println("Enter username: ");
        String username = scan.nextLine();
        System.out.println("Enter password: ");
        String password = scan.nextLine();
        login(password, username);
    }
    public void login(String pass, String user)
    {
        
        UserAccount u = new UserAccount(user);
        if(u.checkUser(user) != -1)
        {
            userAccount = new UserAccount(user);
            System.out.println("Welcome to BetterBoxd " + user + "!");
            homeScreen();
        }
        else
        {
            userAccount = new UserAccount(user);
            System.out.println("Welcome to BetterBoxd " + user + "!");
            homeScreen();
        }
    }


    public void logout()
    {
        userAccount = null;
        mainMenu();
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
    
    public void createNewCollection( )
    {   
        System.out.println("Please enter a new collection name: ");
        String collectionName = scan.nextLine();
        if (userAccount.createNewCollection(collectionName)){
            System.out.println("Collection " + collectionName + " created");
        }
        else{
            System.out.println("Collection " + collectionName + " already exists");
        }
        homeScreen();
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
