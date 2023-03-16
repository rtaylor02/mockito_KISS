package withmockitoJUnit5;

import lombok.Data;
import java.time.LocalDate;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
public class Person {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
}
