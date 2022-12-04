package Accounts;
public interface UserAccountInterface {
    
    public void displayAccountInfo();

    public void createAccount(char[] user, char[] password);

    public void login(char[] user, char[] password);

    public void logout();

    public void likeComment(String Comment, int commentId);

    public void dislikeComment(String Comment, int commentId);


    

}
