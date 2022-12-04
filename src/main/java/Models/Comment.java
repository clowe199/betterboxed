package Models;
import java.util.List;

public class Comment extends Rating {
    private String ratingId;
    private String content;
    private int numLikes;
    private int numDislikes;


    /*
    public Comment(CommentBuilder builder){
        this.content = builder.content;
        this.numLikes = builder.numLikes;
        this.numDislikes = builder.numDislikes;
        super();
    }
*/

    public Comment(String ratingId, int rating, int movieId, String userName, String content, int numLikes, int numDislikes){
        super(ratingId, rating, movieId, userName);
        this.content = content;
        this.numLikes = numLikes;
        this.numDislikes = numDislikes;
    }

    /* Getter Methods */
    public String getRatingId() {
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
    public void setRatingId(String ratingId) {
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


    /* Builder Class */
    /*
    static public class CommentBuilder extends Rating.RatingBuilder{
        private int ratingId;
        private String content;
        private int numLikes;
        private int numDislikes;
        private int rating;
        private int movieId;
        private String userName;

        public RatingBuilder ratingId(int id)
        {
            this.ratingId = id;
            return this;
        }
        
        public RatingBuilder content(String comment)
        {
            this.content = comment;
            return this;
        }

        public RatingBuilder numLikes(int likes)
        {
            this.numLikes = likes;
            return this;
        }

        public RatingBuilder numDislikes(int dislikes)
        {
            this.numDislikes = dislikes;
            return this;
        }

        public Comment build()
        {
            return new Comment(this);
        }
    }*/


}
