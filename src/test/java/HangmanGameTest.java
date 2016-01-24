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
        assertThat(hangmanGame.used(), is("AEIOUH"));
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

    @Test
    public void should_game_win_when_all_match_before_chance_expired() throws Exception {
        // given
        hangmanGame.game("HANGMAN");
        // when
        hangmanGame.tryWith('H');
        hangmanGame.tryWith('N');
        hangmanGame.tryWith('G');
        hangmanGame.tryWith('M');
        // then
        assertThat(hangmanGame.chance() > 0, is(true));
        assertThat(hangmanGame.display(), is("HANGMAN"));
        assertThat(hangmanGame.result(), is("Game Win"));
    }

    @Test
    public void should_game_over_after_chance_expired() throws Exception {
        // given
        hangmanGame.game("HANGMAN");
        // when
        for (int i = 0; i < 12; i++) {
            hangmanGame.tryWith('S');
        }
        // then
        assertThat(hangmanGame.chance() == 0, is(true));
        assertThat(hangmanGame.used(), is("AEIOUSSSSSSSSSSSS"));
        assertThat(hangmanGame.result(), is("Game Over"));
    }

    @Test
    public void should_give_answer() throws Exception {
        // given
        hangmanGame.game("HANGMAN");
        // when

        // then
        assertThat(hangmanGame.answer(), is("HANGMAN"));
    }
}
