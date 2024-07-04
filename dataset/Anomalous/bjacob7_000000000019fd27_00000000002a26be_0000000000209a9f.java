import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Nesting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int t = 1; t <= testCases; t++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int openBraces = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                if (digit > openBraces) {
                    result.append(repeat('(', digit - openBraces));
                } else if (digit < openBraces) {
                    result.append(repeat(')', openBraces - digit));
                }

                result.append(ch);
                openBraces = digit;
            }

            if (openBraces > 0) {
                result.append(repeat(')', openBraces));
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }

    private static String repeat(char ch, int count) {
        return String.join("", Collections.nCopies(count, String.valueOf(ch)));
    }
}