import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hx on 16-1-22.
 */
public class HangmanGameTest {

    private HangmanGame hangmanGame;

    @Before
    public void setUp() throws Exception {
        hangmanGame = new HangmanGame();
    }

    @Test
    public void should_new_game() throws Exception {
        // given
        hangmanGame.game("HANGMAN");
        // when
        // then
        assertThat(hangmanGame.chance(), is(12));
        assertThat(hangmanGame.used(), is("AEIOU"));
        assertThat(hangmanGame.display(), is("_A___A_"));
    }

    @Test
    public void should_match_when_try_with_correct_letter() throws Exception {
        // given
        hangmanGame.game("HANGMAN");
        // when
        boolean matched = hangmanGame.tryWith('H');
        // then
        assertThat(matched, is(true));
        assertThat(hangmanGame.chance(), is(12));
        assertThat(hangmanGame.used(), is("AEIOU"));
        assertThat(hangmanGame.display(), is("HA___A_"));
    }

    @Test
    public void should_mismatch_when_try_with_incorrect_letter() throws Exception {
        // given
        hangmanGame.game("HANGMAN");
        // when
        boolean matched = hangmanGame.tryWith('S');
        // then
        assertThat(matched, is(false));
        assertThat(hangmanGame.chance(), is(11));
        assertThat(hangmanGame.used(), is("AEIOUS"));
        assertThat(hangmanGame.display(), is("_A___A_"));
    }
}
