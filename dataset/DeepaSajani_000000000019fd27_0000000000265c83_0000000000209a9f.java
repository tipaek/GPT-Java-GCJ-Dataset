import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    final static int ZERO_ASCII = 48;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String inputString = in.next();
            System.out.println("Case #" + caseNumber + ": " + solution(inputString));
        }
    }

    public static StringBuilder solution(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int open = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int number = c - ZERO_ASCII;
            if (number > open) {
                while (open < number) {
                    stringBuilder.append("(");
                    open++;
                }
            } else if (number < open) {
                while (open > number) {
                    stringBuilder.append(")");
                    open--;
                }
            }
            stringBuilder.append(number);
        }
        while (open > 0) {
            stringBuilder.append(")");
            open--;
        }
        return stringBuilder;
    }
}
