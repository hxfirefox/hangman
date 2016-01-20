import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by hx on 16-1-20.
 */
public class GuessAlphabet {
    private final String word;
    private List<Integer> positions;

    public GuessAlphabet(String word) {
        this.word = word.toUpperCase();
    }

    public GuessResult guessLetter(String letter) {
        positions = getLetterPosition(letter.toUpperCase());
        final GuessResult guessResult = positions.size() != 0 ? GuessResult.MATCH : GuessResult.MISS;
        guessResult.publish(this);
        return guessResult;
    }

    private List<Integer> getLetterPosition(String letter) {
        List<Integer> positions = Lists.newArrayList();
        for (int i = 0; i < word.length(); i++) {
            i = word.indexOf(letter, i);
            if (i == -1)
                break;
            positions.add(i);
        }
        return positions;
    }

    public String getWord() {
        return word;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
