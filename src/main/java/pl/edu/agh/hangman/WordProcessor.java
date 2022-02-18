package pl.edu.agh.hangman;
import org.apache.commons.lang3.StringUtils;

/**
 * Klasa powinna zawierać metody odpowiadające za:
 * - losowanie  słowa
 * - sprawdzanie czy dana litera jest w wylosowanym słowie
 */
public class WordProcessor {
    private String wordToFind;
    private String wordCurrentState;

    public String getWordToFind() {
        return wordToFind;
    }

    public void setWordToFind(String wordToFind) {
        this.wordToFind = wordToFind;
    }

    public String getWordCurrentState() {
        return wordCurrentState;
    }

    public void setWordCurrentState(String wordCurrentState) {
        this.wordCurrentState = wordCurrentState;
    }

    public WordProcessor() {
        pickAWord();
        wordCurrentState = StringUtils.repeat("_",wordToFind.length());
    }

    public void pickAWord() {
        this.wordToFind = WordFinder.getRandomWord();
    }

    public boolean updateWithUserInput(char userInput){
        if (wordToFind.contains(Character.toString(userInput)) || wordCurrentState.contains(Character.toString(userInput))){
            char[] result = this.wordCurrentState.toCharArray();
            for (int i = 0; i < wordCurrentState.length(); i++) {
                if (userInput == wordToFind.toCharArray()[i]) {
                    result[i] = wordToFind.toCharArray()[i];
                }
            }
            this.wordCurrentState = String.valueOf(result);
            return true;
        }
        return false;
    }
}
