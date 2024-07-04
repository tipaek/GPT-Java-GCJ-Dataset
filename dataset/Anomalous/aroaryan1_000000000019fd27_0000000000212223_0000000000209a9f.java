import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = sc.next().trim();
            input = "0" + input + "0";
            StringBuilder result = new StringBuilder();

            for (int i = 1; i < input.length() - 1; i++) {
                char currentChar = input.charAt(i);
                if (currentChar != '0') {
                    if (input.charAt(i - 1) == '0') {
                        result.append('(').append(currentChar);
                        if (input.charAt(i + 1) == '0') {
                            result.append(')');
                        }
                    } else if (input.charAt(i + 1) == '0') {
                        result.append(currentChar).append(')');
                    } else {
                        result.append(currentChar);
                    }
                } else {
                    result.append(currentChar);
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result.toString().replace("0", ""));
        }
    }
}