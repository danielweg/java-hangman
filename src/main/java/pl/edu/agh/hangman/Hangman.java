package pl.edu.agh.hangman;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) throws InterruptedException
    {
        WordProcessor wordProcessor = new WordProcessor();
        WordPrinter wordPrinter = new WordPrinter(wordProcessor);
        System.out.println("Hangman");
        System.out.println("Let's start:");
        boolean gameOver = false;
        do {
            wordPrinter.printHangman();
            System.out.println();
            System.out.println();
            System.out.println("The searched word is:");
            System.out.println(wordProcessor.getWordCurrentState());
            boolean evaluate = wordProcessor.updateWithUserInput(getUserInput());
            String status = wordPrinter.printUserFriendlyFormat(evaluate);
            gameOver = continueGame(status, wordPrinter);
        } while (!gameOver);
    }

    private static boolean continueGame(String printerOutput, WordPrinter wordPrinter)
    {
        switch (printerOutput) {
            case "You have won!" -> {
                System.out.println("Congratulations! You have won!");
                return true;
            }
            case "Game Over" -> {
                wordPrinter.printHangman();
                System.out.println("Game over!");
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    private static char getUserInput() {
        while (true) {
            System.out.println("Please choose the character: ");
            Scanner scanner = new Scanner(System.in);
            String userChar = scanner.nextLine();
            if (userChar.length() > 1) {
                System.out.println("Error! Please choose just one character!");
            } else if (userChar.length() == 1) {
                return userChar.toCharArray()[0];
            }
        }
    }
}
