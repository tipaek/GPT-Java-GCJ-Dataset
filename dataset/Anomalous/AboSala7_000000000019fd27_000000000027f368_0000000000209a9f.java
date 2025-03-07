package CodeJam2020.Qualification;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int caseNumber = 1;

        while (numberOfTests > 0) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '0') {
                    output.append('0');
                } else {
                    output.append('(').append('1');
                    int j = i + 1;
                    while (j < input.length() && input.charAt(j) == '1') {
                        output.append('1');
                        i++;
                        j++;
                    }
                    output.append(')');
                }
            }
            System.out.println("Case #" + caseNumber + ": " + output);
            numberOfTests--;
            caseNumber++;
        }
    }
}