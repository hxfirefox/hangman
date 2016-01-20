/**
 * Created by hx on 16-1-20.
 */
public enum GuessResult {
    MISS() {
        @Override
        public void publish(GuessAlphabet guessAlphabet) {
        }
    },
    MATCH() {
        @Override
        public void publish(GuessAlphabet guessAlphabet) {
        }
    };

    public void publish(GuessAlphabet guessAlphabet) {
    }
}
