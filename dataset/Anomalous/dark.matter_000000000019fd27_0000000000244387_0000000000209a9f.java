import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();
            int prevNum = 0;

            for (char ch : input.toCharArray()) {
                int num = ch - '0';
                while (prevNum < num) {
                    output.append('(');
                    prevNum++;
                }
                while (prevNum > num) {
                    output.append(')');
                    prevNum--;
                }
                output.append(ch);
            }
            while (prevNum > 0) {
                output.append(')');
                prevNum--;
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}