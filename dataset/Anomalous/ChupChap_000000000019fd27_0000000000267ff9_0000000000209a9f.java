import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static String processString(String input) {
        input += "0";
        StringBuilder result = new StringBuilder();
        result.append(input.charAt(0) == '0' ? "0" : "(1");

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            char previous = input.charAt(i - 1);
            
            if (current == '0' && previous == '1') {
                result.append(")0");
            } else if (current == '1' && previous == '0') {
                result.append("(1");
            } else {
                result.append(current);
            }
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String output = processString(input);
            System.out.println("Case #" + i + ": " + output);
        }
    }
}