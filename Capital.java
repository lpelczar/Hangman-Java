import java.io.*;
import java.util.*;


class Capital {

    String name;
    String country;
    String[] hiddenWord;

    public Capital(String name, String country) {
        this.name = name;
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

    public String getHiddenWordAsString() {
        return String.join(" ", this.hiddenWord);
    }

    public static Capital getRandomCapital() {

        ArrayList<Capital> capitals = getCapitalsFromFile();
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(capitals.size());
        return capitals.get(randomIndex);
    }

    private static ArrayList<Capital> getCapitalsFromFile() {

        String txtFile = "countries_and_capitals.txt";
        BufferedReader br = null;
        String line = "";
        int COUNTRY_COL = 0;
        int CAPITAL_COL = 1;
        ArrayList<Capital> capitals = new ArrayList<Capital>();

        try {

            br = new BufferedReader(new FileReader(txtFile));

            while ((line = br.readLine()) != null) {
                String[] capital = line.split(" \\| ");
                capitals.add(new Capital(capital[CAPITAL_COL], capital[COUNTRY_COL]));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return capitals;
    }
}
