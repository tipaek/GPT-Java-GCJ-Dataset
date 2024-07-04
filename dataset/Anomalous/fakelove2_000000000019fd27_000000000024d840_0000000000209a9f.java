import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = Integer.parseInt(scanner.nextLine());

            for (int i = 1; i <= t; i++) {
                System.out.print("Case #" + i + ": ");
                processCase(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processCase(Scanner scanner) {
        char[] inputArray = ("0" + scanner.nextLine() + "0").toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < inputArray.length; i++) {
            char currentChar = inputArray[i];
            char previousChar = inputArray[i - 1];
            int difference = currentChar - previousChar;

            if (difference > 0) {
                for (int j = 0; j < difference; j++) {
                    result.append('(');
                }
                result.append(currentChar);
            } else {
                for (int j = 0; j < -difference; j++) {
                    result.append(')');
                }
                result.append(currentChar);
            }
        }
        result.deleteCharAt(result.length() - 1); // Remove the trailing '0'
        System.out.println(result);
    }
}