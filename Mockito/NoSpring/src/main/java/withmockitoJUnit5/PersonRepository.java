package withmockitoJUnit5;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);

    Optional<Person> findById(int id);

    List<Person> findAll();

    long count();

    void delete(Person person);
}
