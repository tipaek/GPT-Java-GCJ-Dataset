import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = reader.nextInt(); // Number of test cases
        reader.nextLine();

        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            String s = reader.nextLine();
            StringBuilder transformedString = new StringBuilder();
            boolean oneFound = false;

            for (int j = 0; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (currentChar == '1' && !oneFound) {
                    transformedString.append('(');
                    oneFound = true;
                } else if (currentChar == '0' && oneFound) {
                    transformedString.append(')');
                    oneFound = false;
                }
                transformedString.append(currentChar);
                
                if (j == s.length() - 1 && currentChar == '1') {
                    transformedString.append(')');
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + transformedString.toString();
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}