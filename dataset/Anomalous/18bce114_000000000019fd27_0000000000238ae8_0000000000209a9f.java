import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.nextLine();
            char[] inputChars = input.toCharArray();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < inputChars.length; j++) {
                if (inputChars[j] == '0') {
                    if (result.length() > 0 && result.charAt(result.length() - 1) == ')') {
                        result.append('0');
                    } else {
                        result.append('0');
                    }
                } else if (inputChars[j] == '1') {
                    result.append('(').append('1');
                    int k = j + 1;
                    while (k < inputChars.length && inputChars[k] == '1') {
                        result.append('1');
                        k++;
                        j++;
                    }
                    result.append(')');
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}