import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int l = 0; l < testCount; l++) {
            String input = sc.nextLine();
            int[] numbers = new int[input.length()];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(input.substring(i, i + 1));
            }

            StringBuilder sb = new StringBuilder("Case #");
            sb.append((l+1));
            sb.append(": ");

            int currParenthesisDepth = 0;
            for (int number : numbers) {
                if (number == currParenthesisDepth) {
                    sb.append(number);
                } else if (number < currParenthesisDepth) {
                    for (int k = 0; k < currParenthesisDepth - number; k++) {
                        sb.append(")");
                    }
                    sb.append(number);
                    currParenthesisDepth = number;
                } else {
                    for (int k = 0; k < number - currParenthesisDepth; k++) {
                        sb.append("(");
                    }
                    sb.append(number);
                    currParenthesisDepth = number;
                }
            }

            while (currParenthesisDepth > 0) {
                sb.append(")");
                currParenthesisDepth--;
            }

            System.out.println(sb);
        }
        sc.close();
    }
}
