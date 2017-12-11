import java.io.*;
import java.util.*;

/**
 * Represents Capital word to guess
 */
class Capital {

    private String name;
    private String country;
    private String[] hiddenWord;
    private ArrayList<String> notInWord = new ArrayList<String>();
    private ArrayList<String> alreadyGuessed = new ArrayList<String>();

    /**
     * Constructor of the Capital
     * @param name name of the capital
     * @param country country of the capital
     */
    public Capital(String name, String country) {
        this.name = name.toUpperCase();
        this.country = country;
        this.hiddenWord = name.replaceAll("[^\\s]", "_").split("");
    }

    /**
     * Getter of name
     * @return name of the capital
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of the country
     * @return name of the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Getter of the hidden word
     * @return word respresented with dashes as a String array
     */
    public String[] getHiddenWord() {
        return this.hiddenWord;
    }

    /**
     * Getter of notInWord hint
     * @return hint with guessed letters which are not in guessing word
     */
    public ArrayList<String> getNotInWord() {
        return this.notInWord;
    }

    /**
     * Getter of alreadyGuessed letters
     * @return already guessed letters
     */
    public ArrayList<String> getAlreadyGuessed() {
        return this.alreadyGuessed;
    }

    /**
     * Get notInWord as a String
     * @return notIsWord as a String
     */
    public String getNotInWordAsString() {
        return String.join(" ", this.notInWord);
    }

    /**
     * Get hidden word as a String
     * @return hidden word as a String
     */
    public String getHiddenWordAsString() {
        return String.join("", this.hiddenWord);
    }

    /**
     * Get hint from hiddenWord
     * @return hiddenWord as a String
     */
    public String getHint() {
        return String.join(" ", this.hiddenWord);
    }

    /**
     * Chceck if word is equal capital name
     * @param word entered word by the user
     * @return true if is equal else false
     */
    public boolean isWordEqualCapitalName(String word) {
        return word.equalsIgnoreCase(this.name);
    }

    /**
     * Reveal hidden word to the user - change hiddenWord variable to capital name
     */
    public void makeHiddenWordEqualWord() {
        this.hiddenWord = this.name.split("");
    }

    /**
     * Adds letter to notInWord array
     * @param letter letter given by user
     */
    public void addLetterToNotInWord(String letter) {
        this.notInWord.add(letter);
    }

    /**
     * Adds letter to alreadyGuessed array
     * @param letter letter given by the user
     */
    public void addLetterToAlreadyGuessed(String letter) {
        this.alreadyGuessed.add(letter);
    }

    /**
     * Unhide given letter in hiddenWord
     * @param letter letter given by the user
     */
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
