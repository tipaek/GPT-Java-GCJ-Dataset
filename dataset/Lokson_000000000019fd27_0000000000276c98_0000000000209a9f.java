import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String line = in.nextLine();
            int[] input = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                input[i] = (line.charAt(i) - '0') ;
            }
            System.out.println(String.format("Case #%s: %s", caseNumber, buildResult(input)));

        }
    }

    private static String buildResult(int[] input) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for(int i = 0; i < input.length; i++) {
            result.append(depthChange(input[i] - depth));
            result.append(input[i]);
            depth = input[i];
        }
        result.append(depthChange(0 - depth));

        return result.toString();
    }

    private static String depthChange(int i) {
        char sign = i >=0 ? '(' : ')';
        i = Math.abs(i);
        char[] change = new char[i];
        for(int j = 0; j < i; j++) {
            change[j] = sign;
        }
        return String.valueOf(change);
    }

}