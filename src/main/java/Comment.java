import java.util.List;

public class Comment extends Review {
    private String content;
    private List<Comment> commentChain;

    public Comment(double rating, String content, String userName, int movieId){
        super(rating, userName, movieId);
        this.content = content;
    }

    public Comment(String content, String userName, int movieId){
        this(-1, content, userName, movieId);
    }

    public void replyToComment(String reply, String userName, int movieId){
        commentChain.add(new Comment(reply, userName, movieId));
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getCommentChain() {
        return commentChain;
    }  

}
