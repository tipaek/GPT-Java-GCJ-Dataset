import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfTestCases = in.nextInt();
        in.nextLine();
        for (int t = 0; t < numberOfTestCases; t++) {
            String line = in.nextLine();
            int brackets = 0;
            StringBuilder result = new StringBuilder();
            for (char c : line.toCharArray()) {
                int number = Integer.parseInt(c + "");
                if (number > brackets) {
                    for (int i = brackets; i < number; i++) result.append("(");
                    brackets = number;
                } else if (number < brackets) {
                    for (int i = number; i < brackets; i++) result.append(")");
                    brackets = number;
                }
                result.append(c);
            }
            for (int i = 0; i < brackets; i++) result.append(")");

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}