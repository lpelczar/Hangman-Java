import java.io.*;
import java.util.*;

class CapitalReader {

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