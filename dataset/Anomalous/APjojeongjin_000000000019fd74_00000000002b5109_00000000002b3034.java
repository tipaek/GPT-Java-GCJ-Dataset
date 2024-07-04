import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfStrings = scanner.nextInt();
            String result = "";

            for (int i = 0; i < numberOfStrings; i++) {
                String inputString = scanner.next();
                if (inputString.startsWith("*")) {
                    inputString = inputString.substring(1);
                }

                if (result.contains(inputString)) {
                    continue;
                } else if (inputString.contains(result)) {
                    result = inputString;
                } else {
                    result = "*";
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}