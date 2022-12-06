package Models;
import Api.TMDBController;
import SQLDBConnector.SQLDBConnector;

public class Comment extends Rating {
    private String parentId;
    private String content;
    private int numLikes;
    private int numDislikes;

    public String toString() {
        TMDBController t = new TMDBController();
        StringBuilder sb = new StringBuilder();
        sb.append("Movie: " + t.getMovieData(getMovieId()));
        if (getRating() >= 0 && getRating() <=10)
            sb.append("\nRating: " + getRating());
        sb.append("\nPoster: " + getUserName());
        sb.append("\nContent: " + getContent());
        sb.append("\nLikes: " + getNumLikes());
        sb.append("\nDislikes: " + getRatingId());
        sb.append(getRatingId());
        return sb.toString();
    }
    
    public Comment(CommentBuilder builder){
        super(builder.ratingBuilder);
        this.content = builder.content;
        this.numLikes = builder.numLikes;
        this.numDislikes = builder.numDislikes;
        this.parentId = builder.parentId;
    }

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
        private String parentId = "-1";
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
