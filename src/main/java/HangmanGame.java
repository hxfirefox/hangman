/**
 * Created by hx on 16-1-22.
 */
public class HangmanGame {
    private char[] answers;
    private int chance = 12;
    private String used = "AEIOU";
    private String display = "";

    public void game(String answer) {
        answers = answer.toCharArray();
        prepare();
    }

    private void prepare() {
        initDashes(answers.length);
        for(char c:used.toCharArray()) {
            tryWithLetter(c);
        }
    }

    private void initDashes(int length) {
        char[] dashes = new char[length];
        for (int i = 0; i < length; i++) {
            dashes[i] = '_';
        }
        display = String.valueOf(dashes);
    }

    public boolean tryWith(char letter) {
        final boolean matched = tryWithLetter(letter);
        changeUsedAndChance(letter, matched);
        return matched;
    }

    private boolean tryWithLetter(char letter) {
        final char[] displays = display.toCharArray();
        boolean matched = false;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == letter) {
                displays[i] = letter;
                matched = true;
            }
        }

        display = String.valueOf(displays);

        return matched;
    }

    private void changeUsedAndChance(char letter, boolean matched) {
        if (!matched) {
            chance = chance - 1;
            used += letter;
        }
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
