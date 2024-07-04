import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = Integer.parseInt(sc.nextLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cases; i++) {
            result.append("Case #").append(i + 1).append(": ");
            String inputLine = sc.nextLine();
            StringBuilder processedLine = new StringBuilder();

            for (char ch : inputLine.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                processedLine.append("(".repeat(digit)).append(digit).append(")".repeat(digit));
            }

            String finalLine = processedLine.toString().replace(")(", "");
            result.append(finalLine).append("\n");
        }

        sc.close();
        System.out.print(result.toString());
    }
}