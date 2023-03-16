package withmockitoJUnit5;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelloMockitoTest {
    @Mock
    private PersonRepository personRepository;

    @Mock
    private TranslationService translationService;

    @InjectMocks
    private HelloMockito helloMockito;

    @Test
    @DisplayName("Greet Admiral Hopper")
    void greetAPersonThatExists() {
        // Set the expectations on the mocks
        when(personRepository.findById(anyInt()))
                .thenReturn(Optional.of(new Person(1, "Grace", "Hopper", LocalDate.of(1906, Month.DECEMBER, 9))));

        when(translationService.translate("Hello Grace, from Mockito!", "en", "en"))
                .thenReturn("Hello Grace!");

        // Test the greet method
        String greeting = helloMockito.greet(1, "en", "en");
        assertEquals("Hello Grace!", greeting);

        // Verify the methods are called once, in the right order
        InOrder inorder = inOrder(personRepository, translationService);
        inorder.verify(personRepository).findById(anyInt());
        inorder.verify(translationService).translate(anyString(), eq("en"), eq("en"));
    }

    @Test
    @DisplayName("Greet a person not in the database")
    void greetAPersonThatDoesNotExist() {
        // Set the expectations on the mocks
        when(personRepository.findById(anyInt()))
                .thenReturn(Optional.empty());

        when(translationService.translate("Hello World, from Mockito!", "en", "en"))
                .thenReturn("Hello World!");

        // Test the greet method
        String greeting = helloMockito.greet(100, "en", "en");
        assertEquals("Hello World, from Mockito!", greeting);

        // Verify the methods are called once, in the right order
        InOrder inorder = inOrder(personRepository, translationService);
        inorder.verify(personRepository).findById(anyInt());
        inorder.verify(translationService).translate(anyString(), eq("en"), eq("en"));
    }
}
