import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; ++i) {
            solve(i, in);
        }
    }

    private static void solve(int caseNr, Scanner in) {
        String input = in.nextLine();
        StringBuilder result = new StringBuilder();
        int nestingDepth = 0;
        for (int i= 0; i < input.length(); i++) {
            int nextWantedDepth = Integer.parseInt(String.valueOf(input.charAt(i)));
            while (nextWantedDepth > nestingDepth) {
                result.append("(");
                nestingDepth++;
            }
            while (nextWantedDepth < nestingDepth) {
                result.append(")");
                nestingDepth--;
            }
            result.append(input.charAt(i));
        }
        while (nestingDepth > 0) {
            result.append(")");
            nestingDepth--;
        }
        System.out.println(String.format("Case #%d: %s", caseNr, result.toString()));
    }
}
