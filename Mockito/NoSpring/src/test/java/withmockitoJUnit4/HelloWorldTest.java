package withmockitoJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/*
* Steps in harnessing the full power of mockito:
* 1) Create stubs to stand in for the dependencies of the System/Class Under Test (SUT) - @Mock
* 2) Inject stubs into SUT - @InjectMock
* 3) Set expectations on the stubs - when/then clause
* 4) Test the SUT's methods one scenario at a time, which in turn call methods on the stub with the expected set in
*    step 3.
* 5) Check SUT's methods works as expected - assert
* 6) Verify that the stubs methods got invoked properly (the right number of times, in the right order, etc) - verify
*
* AAA:
* ARRANGE - step 1, 2
* ACT     - step 3, 4
* ASSERT  - step 5, 6
*  */

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldTest {
    // ARRANGE
    @Mock
    private PersonRepository personRepository;

    @Mock
    private TranslationService translationService;

    @InjectMocks
    private HelloWorld helloWorld;

    @Test
    public void testGreet() {
        // ACT
        when(personRepository.findById(anyInt()))
                .thenReturn(Optional.of(new Person(1, "Norman", "Price", LocalDate.of(2017, Month.JANUARY, 21))));

        when(translationService.translate("Hello Norman from Mockito", "en", "id"))
                .thenReturn("Selamat datang Norman!");

        // ASSERT
        String greeting = helloWorld.greetInForeignLanguage(1, "en", "id");
        assertEquals("Selamat datang Norman!", greeting);
    }
}
