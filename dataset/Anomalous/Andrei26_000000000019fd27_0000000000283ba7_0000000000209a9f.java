import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        System.out.println(numberOfCases);
        scanner.nextLine();

        for (int i = 0; i < numberOfCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            System.out.println(inputString);

            int index = 0;
            while (index < inputString.length()) {
                char currentChar = inputString.charAt(index);
                if (currentChar == '1') {
                    result.append("(");
                    while (index < inputString.length() && inputString.charAt(index) == '1') {
                        result.append("1");
                        index++;
                    }
                    result.append(")");
                } else if (currentChar == '0') {
                    result.append("0");
                    index++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }
}