/**
 * Created by hx on 16-1-22.
 */
public class HangmanGame {
    private char[] answers;
    private int chance = 12;
    private String used = "AEIOU";
    private String display = "_A___A_";

    public void game(String answer) {
        answers = answer.toCharArray();
    }

    public boolean tryWith(char letter) {
        final char[] displays = display.toCharArray();
        boolean matched = false;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == letter) {
                displays[i] = letter;
                matched = true;
            }
        }

        if (!matched) {
            chance = chance - 1;
            used += letter;
        }

        display = String.valueOf(displays);

        return matched;
    }

    public String display() {
        return display;
    }

    public int chance() {
        return chance;
    }

    public String used() {
        return used;
    }
}
