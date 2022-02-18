package pl.edu.agh.hangman;

import org.w3c.dom.ls.LSOutput;

/**
 * Metody wyświetlające szubienicę i status wyszukiwanego słowa
 */

public class WordPrinter {
    private int trialNumber = 0;
    private final WordProcessor wordProcessor;

    public WordPrinter (WordProcessor wordProcessor) {
        this.wordProcessor = wordProcessor;
    }

    public String printUserFriendlyFormat(Boolean userInput){
        wordProcessor.getWordCurrentState();
        if(!userInput){
            trialNumber++;
        }
        if(trialNumber == HANGMANPICS.length - 1){
            return "Game Over";
        }
        else if(!wordProcessor.getWordCurrentState().contains("_")){
            return "You have won!";
        }
        else{
            return "";
        }
    }


    public void printHangman(){
        System.out.println(HANGMANPICS[getTrialNumber()]);
    }

    public int getTrialNumber() {
        return trialNumber;
    }

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };
}
