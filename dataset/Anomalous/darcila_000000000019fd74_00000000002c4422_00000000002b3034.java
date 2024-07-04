import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int stringCount = Integer.parseInt(reader.readLine());
            String reversedString = reverseString(reader.readLine().substring(1));
            boolean isPossible = true;

            for (int i = 1; i < stringCount; i++) {
                String currentReversed = reverseString(reader.readLine().substring(1));
                if (reversedString.length() < currentReversed.length()) {
                    String temp = currentReversed;
                    currentReversed = reversedString;
                    reversedString = temp;
                }
                if (!reversedString.startsWith(currentReversed)) {
                    isPossible = false;
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (isPossible) {
                System.out.println(reverseString(reversedString));
            } else {
                System.out.println("*");
            }
        }
    }

    private static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}