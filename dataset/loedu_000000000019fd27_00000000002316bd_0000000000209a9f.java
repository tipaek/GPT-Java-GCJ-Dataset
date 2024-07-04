import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(getReader());

        int cases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < cases; i++) {
            String s = in.nextLine();
            System.out.println("Case #" + (i + 1) + ": " + processCase(s));
        }

    }

    private String processCase(String s) {
        StringBuilder result = new StringBuilder();

        int currentLevel = 0;
        for (int i=0; i < s.length(); i++) {
            int currentDigit = Integer.parseInt(s.substring(i, i + 1));

            if (currentLevel < currentDigit) {
                String moreBrackets = getOpeningBrackets(currentLevel, currentDigit);
                currentLevel += moreBrackets.length();
                result.append(moreBrackets);
            } else if (currentLevel > currentDigit) {
                String morebrackets = getClosingBrackets(currentLevel, currentDigit);
                currentLevel -= morebrackets.length();
                result.append(morebrackets);
            }

            result.append(currentDigit);
        }

        for (int i=currentLevel; i > 0; i--) {
            result.append(")");
        }

        return result.toString();
    }

    private String getOpeningBrackets(int currentLevel, int currentDigit) {
        StringBuilder result = new StringBuilder();
        for (int i = currentLevel; i < currentDigit; i++) {
            result.append("(");
        }

        return result.toString();
    }

    private String getClosingBrackets(int currentLevel, int currentDigit) {
        StringBuilder result = new StringBuilder();
        for (int i = currentDigit; i < currentLevel; i++) {
            result.append(")");
        }

        return result.toString();
    }

    private InputStreamReader getReader() throws IOException {
        return new InputStreamReader(System.in);
        // return new InputStreamReader(getClass().getClassLoader().getResourceAsStream("nesting.txt"));
    }

}