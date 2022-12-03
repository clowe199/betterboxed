import info.movito.themoviedbapi.model.people.Person;

public class LocalPerson extends ApiKey {
    private String name;
    private int personId;

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

    //Do we even need a getFeaturedMovies method? I'm not deleting this yet, but I don't see a reason
    //for it in the use cases.
    
    // public List<Movie> getFeaturedMovies() {
    //     TmdbApi api = new TmdbApi(apiKey);
    //     TmdbPeople people = api.getPeople();
    //     return people.
    // }

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
