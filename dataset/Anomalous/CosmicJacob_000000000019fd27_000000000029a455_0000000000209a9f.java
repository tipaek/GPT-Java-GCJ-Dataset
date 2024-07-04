import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GoogleNestingDepth {

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        
        for (int i = 1; i <= numCases; i++) {
            String inputString = scanner.next();
            String nestedString = createNestedString(0, inputString);
            System.out.println(nestedString);
        }
        
        scanner.close();
    }

    private static String createNestedString(int currentDepth, String input) {
        if (input.isEmpty()) {
            return "";
        }

        int firstDigit = input.charAt(0) - '0';
        StringBuilder result = new StringBuilder();

        if (firstDigit > currentDepth) {
            for (int i = 0; i < firstDigit - currentDepth; i++) {
                result.append('(');
            }
            result.append(firstDigit);
            result.append(createNestedString(firstDigit, input.substring(1)));
        } else if (firstDigit < currentDepth) {
            for (int i = 0; i < currentDepth - firstDigit; i++) {
                result.append(')');
            }
            result.append(firstDigit);
            result.append(createNestedString(firstDigit, input.substring(1)));
        } else {
            result.append(firstDigit);
            result.append(createNestedString(currentDepth, input.substring(1)));
        }

        return result.toString();
    }
}