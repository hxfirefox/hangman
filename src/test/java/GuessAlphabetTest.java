import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hx on 16-1-20.
 */
public class GuessAlphabetTest {
    private GuessAlphabet guess;
    @Before
    public void setUp() throws Exception {
        guess = new GuessAlphabet("HANGMAN");
    }

    @Test
    public void should_return_missmatch_when_input_missmatch() throws Exception {
        // given

        // when
        final GuessResult result = guess.guessLetter("e");
        // then
        assertThat(result, is(GuessResult.MISS));
    }
}
