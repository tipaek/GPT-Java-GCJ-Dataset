import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + i + ": " + getNumberParen(in.next()));
        }
    }

    private static String getNumberParen(String s) {
        String result = "";
        if (s == null || s.length() == 0) return result;
        int rightNeeded = s.charAt(0) - '0';
        for (int i = 0; i < rightNeeded; i++) result += "(";
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            result += curr;
            if (i == s.length() - 1) continue;
            int next = s.charAt(i + 1) - '0';
            if (next == curr) {
            } else if (next > curr) {
                for (int j = 0; j < next - rightNeeded; j++) result += "(";
                rightNeeded = next;
            } else {
                for (int j = 0; j < rightNeeded - next; j++) result += ")";
                rightNeeded -= rightNeeded - next;
            }
        }
        for (int i = 0; i < rightNeeded; i++) result += ")";
        return result;
    }
}