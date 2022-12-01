import java.util.ArrayList;

public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<Movie> featuredMovies;

    public Person(PersonBuilder p){
        firstName = p.firstName;
        lastName = p.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Movie> getFeaturedMovies() {
        return featuredMovies;
    }

    public class PersonBuilder {
        private String firstName;
        private String lastName;

        public PersonBuilder firstName(String fn){
            firstName = fn;
            return this;
        }

        public PersonBuilder lastName(String ln){
            lastName = ln;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
