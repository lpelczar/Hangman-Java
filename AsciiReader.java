import java.io.*;

/**
 * Reads txt file and returns string containing lines from startline to endline.
 */
class AsciiReader {

    /**
     * Read file with Ascii arts and return Ascii art from startline to endline as a String.
     * @param startLine start line of ascii art in a file
     * @param endLine end line of ascii art in a file
     * @return Ascii art
     */
    public static String readAscii(int startLine, int endLine) {

        String line;
        BufferedReader br = null;
        int currentLineNo = 1;
        String txtFile = "ascii_hangman.txt";
        String ascii = "";

        try {

            br = new BufferedReader(new FileReader(txtFile));

            while (currentLineNo <= endLine) {

                line = br.readLine();
                if (currentLineNo >= startLine && currentLineNo<=endLine) {
                    ascii += line +"\n";
                }
                currentLineNo++;
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
    return ascii;
    }
}
