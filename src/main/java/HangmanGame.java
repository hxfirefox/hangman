/**
 * Created by hx on 16-1-22.
 */
public class HangmanGame {
    public static final int TOTAL_CHANCE = 12;
    public static final String INIT_USED = "AEIOU";
    private int chance;
    private String used;
    private String result;
    private char[] answers;
    private char[] displays;

    public void game(String answer) {
        answers = answer.toCharArray();
        prepare();
    }

    private void prepare() {
        reset();
        initDashes(answers.length);
        for (char c : used.toCharArray()) {
            tryWithLetter(c);
        }
    }

    private void reset() {
        chance = TOTAL_CHANCE;
        used = INIT_USED;
    }

    private void initDashes(int length) {
        displays = new char[length];
        for (int i = 0; i < length; i++) {
            displays[i] = '_';
        }
    }

    public boolean tryWith(char letter) {
        final boolean matched = tryWithLetter(letter);
        used += letter;
        if (!matched) {
            adjustChance();
        }
        checkGame();
        return matched;
    }

    private void checkGame() {
        if (chance == 0) {
            result = "Game Over";
        } else {
            if (String.valueOf(answers).equals(String.valueOf(displays))) {
                result = "Game Win";
            }
        }
    }

    private boolean tryWithLetter(char letter) {
        boolean matched = false;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == letter) {
                displays[i] = letter;
                matched = true;
            }
        }
        return matched;
    }

    private void adjustChance() {
        chance--;
    }

    public String display() {
        return String.valueOf(displays);
    }

    public int chance() {
        return chance;
    }

    public String used() {
        return used;
    }

    public String result() {
        return result;
    }

    public String answer() {
        return String.valueOf(answers);
    }
}
