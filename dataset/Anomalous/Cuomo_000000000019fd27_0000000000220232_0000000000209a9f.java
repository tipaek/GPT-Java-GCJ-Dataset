import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] inputNumbers = scanner.nextLine().split("");
            int[] digits = Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).toArray();
            
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int digit : digits) {
                while (openParentheses < digit) {
                    result.append("(");
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    result.append(")");
                    openParentheses--;
                }
                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}