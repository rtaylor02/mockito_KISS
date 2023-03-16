package withmockitoJUnit4;

import java.util.Optional;

public interface PersonRepository {
    Optional<Person> findById(int id);
}
