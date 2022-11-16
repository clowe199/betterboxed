public class UserData {
    private char[] username;
    private char[] password;
    private String emailAddress;
    // private Movie[] watchedList;
    // private Movie[] watchLaterList;
    //add methods: addToWatched, addToWatchLater, watchedContains(Movie), watchLaterContains(Movie),
    //getWatched, getWatchLater
    //Need Movie class first
    
    public UserData(UserDataBuilder builder){
        username = builder.username;
        password = builder.password;
        emailAddress = builder.emailAddress;
    }
    public char[] getUsername(){
        return username;
    }
    public char[] getPassword(){
        return password;
    }
    public String getEmailAddress(){
        return emailAddress;
    }
    public void setUsername(char[] u){
        username = u;
    }
    public void setPassword(char[] p){
        password = p;
    }
    public void setEmailAddress(String a){
        emailAddress = a;
    }

    static public class UserDataBuilder {
        private char[] username;
        private char[] password;
        private String emailAddress;
        
        public UserDataBuilder username(char[] user)
        {
            this.username = user;
            return this;
        }
    
        public UserDataBuilder password(char[] pass)
        {
            this.password = pass;
            return this;
        }
    
        public UserDataBuilder emailAddress(String add)
        {
            this.emailAddress = add;
            return this;
        }
    
        public UserData build(){
            return new UserData(this);
        }
    }


}

//did it work?????