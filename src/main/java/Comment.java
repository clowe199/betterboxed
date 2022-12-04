import java.util.List;

public class Comment extends Rating {
    private String content;
    private int parentId; // -1 if
    private int numLikes;

    public Comment(double rating, String content, String userName, int movieId, int parentId) {
        super(rating, userName, movieId);
        this.content = content;
        this.parentId = parentId;
        // query for num likes: return 0 if review id not found (this would be a new comment then)
    }

    // if a comment, rating is -1; if a full review add a rating and parentId is -1
    public Comment(String content, String userName, int movieId, int parentId) {
        this(-1, content, userName, movieId, parentId);
    }

    public void replyToComment(String content, String userName) {
        Comment c = new Comment(content, userName, this.getMovieId(), this.getReviewId());
        //save comment to SQLdb
    }

    public List<Comment> getReplies() {
        //query SQL for all comments that have this comments id as their parent id
        //create comment objects for each one and add them to return list.
        return null;
    }

    public String getContent() {
        return content;
    }

    public int getParentId() {
        return parentId;
    }

    public int getNumLikes() {
        return numLikes;
    } 

}
