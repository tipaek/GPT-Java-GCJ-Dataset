import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        scan.nextLine();
        for (int i = 1; i <= t; i++) {
            solve(scan, i);
        }
    }

    static void solve(Scanner scan, int test) {
        String s = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        int firstNum = s.charAt(0) - '0';
        sb.append(buildString('(', firstNum));
        sb.append(firstNum);
        for (int i = 1; i < s.length(); i++) {
            int current = s.charAt(i) - '0';
            int previous = s.charAt(i - 1) - '0';
            if (current > previous) {
                sb.append(buildString('(', current - previous));
                sb.append(current);
            }
            else if (previous == current) {
                sb.append(current);
            }
            else {
                sb.append(buildString(')', previous - current));
                sb.append(current);
            }
        }
        sb.append(buildString(')', s.charAt(s.length() - 1) - '0'));
        String ans = sb.toString();
        System.out.println("Case #" + test + ": " + ans);
    }

    static String buildString(char c, int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }
}