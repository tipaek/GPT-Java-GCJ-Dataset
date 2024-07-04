import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            String numberString = scanner.next();
            int[] digits = numberString.chars().map(Character::getNumericValue).toArray();
            StringBuilder answer = new StringBuilder();

            int currentDepth = 0;
            for (int digit : digits) {
                while (currentDepth < digit) {
                    answer.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    answer.append(')');
                    currentDepth--;
                }
                answer.append(digit);
            }
            while (currentDepth > 0) {
                answer.append(')');
                currentDepth--;
            }

            System.out.println(answer);
        }
    }
}