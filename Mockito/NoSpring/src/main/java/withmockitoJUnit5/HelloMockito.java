package withmockitoJUnit5;

import java.util.Optional;

public class HelloMockito {
    private String greeting = "Hello %s, from Mockito!";

    // Dependencies
    private final PersonRepository personRepository;
    private final TranslationService translationService;

    // Constructor to inject the dependencies
    public HelloMockito(PersonRepository personRepository, TranslationService translationService) {
        this.personRepository = personRepository;
        this.translationService = translationService;
    }

    // Method we want to test
    public String greet(int id, String sourceLanguage, String targetLanguage) {
        Optional<Person> person  = personRepository.findById(id);
        String name  = person.map(Person::getFirstName).orElse("World");
        return translationService.translate(String.format(greeting, name),sourceLanguage, targetLanguage);
    }
}
