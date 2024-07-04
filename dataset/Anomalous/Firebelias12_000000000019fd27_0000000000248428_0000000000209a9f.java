import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCases; i++) {
            String inputString = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < inputString.length(); ) {
                if (inputString.charAt(j) == '1') {
                    result.append("(");
                    while (j < inputString.length() && inputString.charAt(j) == '1') {
                        result.append("1");
                        j++;
                    }
                    result.append(")");
                } else {
                    result.append("0");
                    j++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}