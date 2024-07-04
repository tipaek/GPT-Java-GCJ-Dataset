import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                String input = in.nextLine();
                System.out.println("Case #" + i + ": " + solve(input));
            }
        }
    }

    private static String solve(String input) {
        Stack<Character> result = new Stack<>();
        int totalOpenedBrace = 0;
        for(char ch : input.toCharArray()) {
            int x = Integer.parseInt(String.valueOf(ch));
            while(totalOpenedBrace < x) {
                result.push('(');
                totalOpenedBrace++;
            }
            while(totalOpenedBrace > x) {
                result.push(')');
                totalOpenedBrace--;
            }
            result.push(ch);
        }

        while(totalOpenedBrace > 0) {
            result.push(')');
            totalOpenedBrace--;
        }

        return new ArrayList<>(result).stream().map(String::valueOf).collect(Collectors.joining());
    }
}
