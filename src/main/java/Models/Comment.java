package Models;
import SQLDBConnector.SQLDBConnector;

public class Comment extends Rating {
    private String parentId;
    private String content;
    private int numLikes;
    private int numDislikes;


    
    public Comment(CommentBuilder builder){
        super(builder.ratingBuilder);
        this.content = builder.content;
        this.numLikes = builder.numLikes;
        this.numDislikes = builder.numDislikes;
        this.parentId = builder.parentId;
    }


    // public Comment(String ratingId, int rating, int movieId, String userName, String content, int numLikes, int numDislikes){
    //     super(ratingId, rating, movieId, userName);
    //     this.content = content;
    //     this.numLikes = numLikes;
    //     this.numDislikes = numDislikes;
    // }

    /* Getter Methods */
    public String getParentId() {
        return parentId;
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
    // public void setRatingId(String ratingId) {
    //     this.ratingId = ratingId;
    // }

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
    

    public void replyToComment(String content, String userName, Comment comment) {
        Comment reply = new CommentBuilder()
            .content(content) 
            .rating(getRating()) 
            .movieId(getMovieId()) 
            .userName(userName)  
            .parentId(comment.getRatingId())
            .build();
        SQLDBConnector.insertComment(reply);
    }

    /*
    public List<Comment> getReplies() {
        //query SQL for all comments that have this comments id as their parent id
        //create comment objects for each one and add them to return list.
        return null;
    }*/


    /* Builder Class */
    
    static public class CommentBuilder {
        private String content;
        private int numLikes = 0;
        private int numDislikes = 0;
        private String parentId;
        private RatingBuilder ratingBuilder = new RatingBuilder();
        
        public CommentBuilder content(String comment)
        {
            this.content = comment;
            return this;
        }

        public CommentBuilder numLikes(int likes)
        {
            this.numLikes = likes;
            return this;
        }

        public CommentBuilder numDislikes(int dislikes)
        {
            this.numDislikes = dislikes;
            return this;
        }

        public CommentBuilder parentId(String parentId)
        {
            this.parentId = parentId;
            return this;
        }

        public CommentBuilder commentId(String id)
        {
            this.ratingBuilder.ratingId(id);
            return this;
        }

        public CommentBuilder rating(int num)
        {
            ratingBuilder = ratingBuilder.rating(num);
            return this;
        }

        public CommentBuilder movieId(int movie)
        {
            ratingBuilder = ratingBuilder.movieId(movie);
            return this;
        }

        public CommentBuilder userName(String name)
        {
            ratingBuilder = ratingBuilder.userName(name);
            return this;
        }

        public Comment build()
        {
            return new Comment(this);
        }
    }


}
