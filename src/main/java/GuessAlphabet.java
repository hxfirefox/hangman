/**
 * Created by hx on 16-1-20.
 */
public class GuessAlphabet {
    private final String word;
    public GuessAlphabet(String word) {
        this.word = word.toUpperCase();
    }

    public GuessResult guessLetter(String letter) {
        return GuessResult.MISS;
    }
}
