import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        App app = new App();
        View view = new View(app);
        Scanner scanner = new Scanner(System.in);
        boolean isCorrectInput = true;
        String wordToAdd = "";
        int counter = 0;
        int score = 0;

        while (isCorrectInput && counter <= 25) {
            view.requestWord(counter);
            while (isCorrectInput) {
                wordToAdd = scanner.next();
                if (app.isCorrectLetter(wordToAdd, counter) && app.isEnglish(wordToAdd)) {
                    isCorrectInput = false;
                } else if (!app.isCorrectLetter(wordToAdd, counter)) {
                    view.useCorrectLetter();
                } else if (!app.isEnglish(wordToAdd)) {
                    view.useRealWords();
                }
            }
            app.addWord(wordToAdd);
            view.enterWords();
            for (int index = 0; index < app.getWordList().size(); index++) {
                isCorrectInput = app.isCorrectAnswer(scanner.next(), index);
                if (!isCorrectInput) {
                    break;
                } else {
                    score++;
                }
            }
            counter++;
        }
        view.gameOver(isCorrectInput, score);
    } //main

    private List<String> wordList = new ArrayList<>();
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public char[] getAlphabet() {
        return alphabet;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public String addWord(String word) {
        wordList.add(word);
        return word;
    }

    public boolean isCorrectLetter(String word, int index) {
        String letter = String.valueOf(alphabet[index]);
        if (word.toLowerCase().startsWith(letter)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCorrectAnswer(String word, int index) {
        if (word.equalsIgnoreCase(wordList.get(index))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEnglish(String word) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/dictionary.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                if (line.contains(word.toLowerCase())) {
                    return true;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Dictionary.csv file not found");
        }
        return false;
    }
}


