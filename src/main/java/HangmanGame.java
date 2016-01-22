/**
 * Created by hx on 16-1-22.
 */
public class HangmanGame {
    private char[] answers;
    private int chance = 12;
    private String used = "AEIOU";
    private char[] displays;

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
        displays = new char[length];
        for (int i = 0; i < length; i++) {
            displays[i] = '_';
        }
    }

    public boolean tryWith(char letter) {
        final boolean matched = tryWithLetter(letter);
        changeUsedAndChance(letter, matched);
        return matched;
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

    private void changeUsedAndChance(char letter, boolean matched) {
        if (!matched) {
            chance = chance - 1;
            used += letter;
        }
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
}
