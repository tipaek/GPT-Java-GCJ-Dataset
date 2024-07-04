import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {

    private static final Logger LOGGER = Logger.getLogger(Solution.class.getName());
    private static final int ASCII_NUM_INIT_CODE = 48;
    private static final char INIT_PARENTHESIS = '(';
    private static final char FINAL_PARENTHESIS = ')';

    /**
     * Reads input stream and returns an array of strings.
     */
    public static String[] readInput(InputStream inStream) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }

    /**
     * Converts an ASCII character to its corresponding number.
     */
    private int convertASCIICharToNum(char c) {
        return c - ASCII_NUM_INIT_CODE;
    }

    /**
     * Encodes a number character with the corresponding number of parentheses.
     */
    private String encodeInputCharacter(char c) {
        int num = convertASCIICharToNum(c);
        if (num < 0 || num > 9) {
            return "";
        }
        StringBuilder initParenthesis = new StringBuilder();
        StringBuilder finalParenthesis = new StringBuilder();
        for (int i = 0; i < num; i++) {
            initParenthesis.append(INIT_PARENTHESIS);
            finalParenthesis.append(FINAL_PARENTHESIS);
        }
        return initParenthesis.toString() + num + finalParenthesis.toString();
    }

    /**
     * Attaches a new encoded character to the existing encoded string, handling nested parentheses.
     */
    private String attachNewCodedCharacter(String firstString, String secondString) {
        if (firstString.isEmpty() || secondString.isEmpty()) {
            LOGGER.log(Level.WARNING, "Wrong encoded characters: {0}, {1}", new Object[]{firstString, secondString});
            return firstString + secondString;
        }
        while (firstString.charAt(firstString.length() - 1) == FINAL_PARENTHESIS 
                && secondString.charAt(0) == INIT_PARENTHESIS) {
            firstString = firstString.substring(0, firstString.length() - 1);
            secondString = secondString.substring(1);
        }
        return firstString + secondString;
    }

    /**
     * Encodes each character in the input string with the corresponding number of parentheses.
     */
    public String encodeInputString(String inputString) {
        if (inputString == null) {
            return "";
        }
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            String encodedCharacter = encodeInputCharacter(inputString.charAt(i));
            if (!encodedCharacter.isEmpty()) {
                encodedString = new StringBuilder(attachNewCodedCharacter(encodedString.toString(), encodedCharacter));
            } else {
                LOGGER.log(Level.WARNING, "Input character cannot be encoded: {0}", inputString.charAt(i));
            }
        }
        return encodedString.toString();
    }

    public static void main(String[] args) {
        // Read the input file
        String[] lines = readInput(System.in);

        Solution solution = new Solution();
        // Get T = Test cases
        int T = Integer.parseInt(lines[0]);

        // Encode each of the test cases and print solution
        for (int i = 1; i <= T; i++) {
            System.out.println(String.format("Case #%d: %s", i, solution.encodeInputString(lines[i])));
        }
    }
}