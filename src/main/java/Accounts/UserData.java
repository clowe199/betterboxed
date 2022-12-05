package Accounts;
import java.util.ArrayList;

import Models.Collection;

public class UserData {
    
    public static final String WATCHED_TITLE = "Watched Movies";
    public static final String WATCH_LATER_TITLE = "Movies to Watch";
    
    private String username;
    // private char[] password;
    // private String emailAddress;
    private Collection watchedList;
    private Collection watchLaterList;
    private ArrayList<Collection> collections;

    
    
    public UserData(UserDataBuilder builder){
        this.username = builder.username;
        // password = builder.password;
        // emailAddress = builder.emailAddress;
        this.watchedList = builder.watchedList;
        this.watchLaterList = builder.watchLaterList;
        this.collections = builder.collections;
    }


    public String getUsername(){
        return username;
    }
    // public char[] getPassword(){
    //     return password;
    // }
    // public String getEmailAddress(){
    //     return emailAddress;
    // }
    public Collection getWatchedList(){
        return watchedList;
    }
    public Collection getWatchLaterList(){
        return watchLaterList;
    }

    public void setUsername(String u){
        username = u;
    }
    // public void setPassword(char[] p){
    //     password = p;
    // }
    // public void setEmailAddress(String a){
    //     emailAddress = a;
    // }

    public void addToWatched(int m){
        watchedList.add(m);
    }
    public void removeFromWatched(int m){
        watchedList.remove(m);
    }
    public boolean watchedContains(int m){
        return watchedList.contains(m);
    }
    
    public void addToWatchLater(int m){
        watchLaterList.add(m);
    }
    public void removeFromWatchLater(int m){
        watchLaterList.remove(m);
    }
    public boolean watchLaterContains(int m){
        return watchLaterList.contains(m);
    }

    public void addCollection(String name){
        if (!this.containsCollection(name))
            collections.add(new Collection(name));
    }
    public void removeCollection(String name){
        Collection search = null;
        for (Collection c: collections){
            if (c.getName().equals(name))
                search = c;
        }
        if (search != null)
            collections.remove(search);
    }
    public boolean containsCollection(String name){
        for (Collection c: collections){
            if (c.getName().equals(name))
                return true;
        }
        return false;
    }

    
    //adds movie to collection, returns false if collection can't be found
    public boolean addToCollection(int m, String collectionName){
        for (Collection c: collections){
            if (c.getName().equals(collectionName)){
                c.add(m);
                return true;
            }
        }
        return false;
    }
    //removes movie from collection, returns false if collection can't be found
    public boolean removeFromCollection(int m, String collectionName){
        for (Collection c: collections){
            if (c.getName().equals(collectionName)){
                c.remove(m);
                return true;
            }
        }
        return false;
    }
    public boolean collectionContains(int m, String collectionName){
        for (Collection c: collections){
            if (c.getName().equals(collectionName)){
                return c.contains(m);
            }
        }
        return false;
    }

    static public class UserDataBuilder {
        private String username;
        // private char[] password;
        // private String emailAddress;
        private Collection watchedList;
        private Collection watchLaterList;
        private ArrayList<Collection> collections;
        
        public UserDataBuilder username(String user)
        {
            this.username = user;
            return this;
        }
    
        // public UserDataBuilder password(char[] pass)
        // {
        //     this.password = pass;
        //     return this;
        // }
    
        // public UserDataBuilder emailAddress(String add){
        //     this.emailAddress = add;
        //     return this;
        // }
    
        public UserData build(){
            return new UserData(this);
        }
        
        public UserDataBuilder watchedList(Collection c){
            this.watchedList = c;
            return this;
        }

        public UserDataBuilder watchLaterList(Collection c){
            this.watchLaterList = c;
            return this;
        }

        public UserDataBuilder collections(ArrayList<Collection> collections){
            this.collections = collections;
            return this;
        }


    }


}