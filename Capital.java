import java.io.*;
import java.util.*;


class Capital {

    private String name;
    private String country;
    private String[] hiddenWord;
    private ArrayList<String> notInWord = new ArrayList<String>();
    private ArrayList<String> alreadyGuessed = new ArrayList<String>();

    public Capital(String name, String country) {
        this.name = name.toUpperCase();
        this.country = country;
        this.hiddenWord = name.replaceAll("[A-Za-z]", "_").split("");
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public String[] getHiddenWord() {
        return this.hiddenWord;
    }

    public ArrayList<String> getNotInWord() {
        return this.notInWord;
    }

    public ArrayList<String> getAlreadyGuessed() {
        return this.alreadyGuessed;
    }

    public String getNotInWordAsString() {
        return "Not in word: " + String.join(" ", this.notInWord);
    }

    public String getHiddenWordAsString() {
        return String.join("", this.hiddenWord);
    }

    public String getHint() {
        return String.join(" ", this.hiddenWord);
    }

    public boolean isWordEqualCapitalName(String word) {
        return word.equalsIgnoreCase(this.name);
    }

    public void makeHiddenWordEqualWord() {
        this.hiddenWord = this.name.split("");
    }

    public void addLetterToNotInWord(String letter) {
        this.notInWord.add(letter);
    }

    public void addLetterToAlreadyGuessed(String letter) {
        this.alreadyGuessed.add(letter);
    }

    public void unhideLetter(char letter) {
        char[] word = this.name.toCharArray();

        int index = 0;
        for (char i : word) {
            if (Character.toUpperCase(letter) == i) {
                this.hiddenWord[index] = Character.toString(letter).toUpperCase();
            }
            index++;
        }
    }
}
