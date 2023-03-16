package withmockitoJUnit4;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
public class Person {
    @NonNull
    private int id;

    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private String firstName;

    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private String lastName;

    @Setter(AccessLevel.PRIVATE)
    @NonNull
    private LocalDate dateOfBirth;
}
