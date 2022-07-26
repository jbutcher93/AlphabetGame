public class View {

    private App app;

    public View(App app) {
        this.app = app;
    }

    public void requestWord(int counter) {
        System.out.println("Enter a word beginning with the letter " + app.getAlphabet()[counter]);
    }

    public void useCorrectLetter() {
        System.out.println("You must use a word beginning with the correct letter");
    }

    public void useRealWords() {
        System.out.println("You must use a word found in the English dictionary.");
    }

    public void enterWords() {
        System.out.println("Now go back through all the words you've given. " +
                "Press ENTER after every word. ");
    }

    public void gameOver(boolean winOrLose, int score) {
        if (!winOrLose) {
            System.out.println("Looks like that last answer wasn't quite right.");
        } else {
            System.out.println("Great job!");
        }
        System.out.println("Your score was: " + score);

    }
}
