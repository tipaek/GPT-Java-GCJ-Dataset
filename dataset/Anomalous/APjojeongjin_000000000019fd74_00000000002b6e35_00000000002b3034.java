import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfStrings = Integer.parseInt(scanner.nextLine());
            String result = "";

            for (int i = 0; i < numberOfStrings; i++) {
                String inputString = scanner.nextLine();
                if (inputString.startsWith("*")) {
                    inputString = inputString.substring(1);
                }

                if (result.contains(inputString)) {
                    // No change needed
                } else if (inputString.contains(result)) {
                    result = inputString;
                } else {
                    result = "*";
                    break;
                }
            }

            if (result.contains("*")) {
                System.out.println("Case #" + testCase + ": *");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}