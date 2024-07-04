import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestingDepth {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i <= testCases; i++) {
            String input = reader.readLine();
            String result = processInput(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processInput(String input) {
        StringBuilder output = new StringBuilder();
        int previous = 0;

        for (char ch : input.toCharArray()) {
            int current = Character.getNumericValue(ch);
            int difference = current - previous;

            if (difference > 0) {
                for (int j = 0; j < difference; j++) {
                    output.append('(');
                }
            } else if (difference < 0) {
                for (int j = 0; j < -difference; j++) {
                    output.append(')');
                }
            }

            output.append(current);
            previous = current;
        }

        for (int j = 0; j < previous; j++) {
            output.append(')');
        }

        return output.toString();
    }
}