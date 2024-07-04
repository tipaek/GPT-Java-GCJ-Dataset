import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();
            char[] characters = input.toCharArray();
            StringBuilder result = new StringBuilder();

            for (char c : characters) {
                int value = Character.getNumericValue(c);
                result.append("(".repeat(value));
                result.append(c);
                result.append(")".repeat(value));
            }

            // Simplify the parentheses
            String output = result.toString().replaceAll("\\)\\(", "");

            System.out.println(output);
        }
    }
}