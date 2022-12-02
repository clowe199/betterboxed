import java.util.List;

import info.movito.themoviedbapi.model.people.Person;

public class LocalPerson {
    private String name;
    private int personId;
    private List<Movie> featuredMovies;

    // public LocalPerson(PersonBuilder p){
    //     firstName = p.firstName;
    //     lastName = p.lastName;
    // }

    public LocalPerson(Person p){
        name = p.getName();
        personId = p.getId();
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return personId;
    }

    public List<Movie> getFeaturedMovies() {
        return featuredMovies;
    }

    // public class PersonBuilder {
    //     private String firstName;
    //     private String lastName;

    //     public PersonBuilder firstName(String fn){
    //         firstName = fn;
    //         return this;
    //     }

    //     public PersonBuilder lastName(String ln){
    //         lastName = ln;
    //         return this;
    //     }

    //     public LocalPerson build(){
    //         return new LocalPerson(this);
    //     }
    // }
}
