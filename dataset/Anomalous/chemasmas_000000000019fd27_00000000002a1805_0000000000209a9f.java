import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static Scanner keyboard = new Scanner(System.in);
    
    private static void solve() {
        int[] digits = Arrays.stream(keyboard.nextLine().split(""))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        StringBuilder result = new StringBuilder();
        
        for (int digit : digits) {
            result.append("(".repeat(digit))
                  .append(digit)
                  .append(")".repeat(digit));
        }

        String output = result.toString().replaceAll("\\)\\(", "");
        System.out.println(output);
    }

    public static void main(String[] args) {
        int testCases = keyboard.nextInt();
        keyboard.nextLine(); // Consume the newline character
        
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }
}