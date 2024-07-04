import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int caseNumber = 1;

        while (numberOfTests > 0) {
            String currentString = scanner.next();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < currentString.length(); i++) {
                if (currentString.charAt(i) == '0') {
                    output.append('0');
                } else {
                    output.append("(1");
                    int j = i + 1;
                    while (j < currentString.length() && currentString.charAt(j) == '1') {
                        output.append('1');
                        i++;
                        j++;
                    }
                    output.append(')');
                }
            }

            System.out.println("Case #" + caseNumber + ": " + output);
            caseNumber++;
            numberOfTests--;
        }
    }
}