package Models;
import java.util.List;

public class Comment extends Rating {
    private int ratingId;
    private String content;
    private int numLikes;
    private int numDislikes;


    public Comment(int ratingId, int rating, int movieId, String userName, String content, int numLikes, int numDislikes){
        super(ratingId, rating, movieId, userName);
        this.content = content;
        this.numLikes = numLikes;
        this.numDislikes = numDislikes;
    }

    /* Getter Methods */
    public int getRatingId() {
        return ratingId;
    }

    public String getContent() {
        return content;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public int getNumDislikes() {
        return numDislikes;
    }


    /* Setter Methods */
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public void setNumDislikes(int numDislikes) {
        this.numDislikes = numDislikes;
    }


    /* DB Methods */
    /* 
    public void insertComment(CommentBuilder builder)
    {
        SQLDBConnector.insertComment()
    }*/
    

    public void replyToComment(String content, String userName) {
        Comment c = new Comment(this.getRatingId(), this.getRating(), this.getMovieId(), userName, content, this.getNumLikes(), this.getNumDislikes());
        //save comment to SQLdb - SQLDBConnector.insertComment(c);
    }

    /*
    public List<Comment> getReplies() {
        //query SQL for all comments that have this comments id as their parent id
        //create comment objects for each one and add them to return list.
        return null;
    }*/

}
