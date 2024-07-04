import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }

    private static String solve() {
        String input = scanner.nextLine();
        String output = "";

        int currentDepth = 0;
        for (char c : input.toCharArray()) {
            int i = Character.getNumericValue(c);
            while (i != currentDepth) {
                if (i > currentDepth) {
                    output += "(";
                    currentDepth++;
                } else {
                    output += ")";
                    currentDepth--;
                }
            }
            output += i;
        }
        while (currentDepth > 0) {
            output += ")";
            currentDepth--;
        }
        return output;
    }

}
