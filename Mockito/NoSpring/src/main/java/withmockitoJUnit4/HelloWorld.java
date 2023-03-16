package withmockitoJUnit4;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor // Creates a constructor with all fields
public class HelloWorld {
    @NonNull
    private PersonRepository personRepository;
    @NonNull
    private TranslationService translationService;

    private String greeting = "Hello %s from Mockito";

    public String greetInForeignLanguage(int id, String sourceLanguage, String targetLanguage) {
        Optional<Person> person = personRepository.findById(id);
        String name = person.map(Person::getFirstName).orElse("Stranger");

        return translationService.translate(String.format(greeting,name), sourceLanguage, targetLanguage);
    }
}
