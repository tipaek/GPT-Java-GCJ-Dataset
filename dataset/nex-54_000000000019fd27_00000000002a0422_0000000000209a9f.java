import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i, in);
        }
    }

    private static void solve(int caseNum, Scanner in) {
        String str = in.next();

        int open = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= str.length(); i++) {
            boolean hasVal = i < str.length();
            int val = !hasVal ? 0 : str.charAt(i) - '0';
            while (open < val) {
                result.append('(');
                open++;
            }
            while (open > val) {
                result.append(')');
                open--;
            }
            if (hasVal)
                result.append(val);
        }

        print(caseNum, result);
    }

    private static void print(int caseNum, int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int r: result) {
            sb.append(" ");
            sb.append(r);
        }
        print(caseNum, sb);
    }

    private static void print(int caseNum, StringBuilder result) {
        print(caseNum, result.toString());
    }

    private static void print(int caseNum, String result) {
        System.out.println("Case #" + caseNum + ": " + result);
    }
}
