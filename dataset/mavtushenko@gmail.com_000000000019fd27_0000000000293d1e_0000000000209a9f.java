import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static String addPar(String s, char cur) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean c = true;
        int prev = 0;
        for (int i = 0; i < n; ++i) {
            if (c) {
                if (s.charAt(i) != cur) {
                    sb.append(s, prev, i);
                    prev = i;
                    c = false;
                }
            } else {
                if (s.charAt(i) == cur) {
                    c = true;
                    sb.append('(');
                    sb.append(addPar(s.substring(prev, i), (char)(cur + 1)));
                    sb.append(')');
                    prev = i;
                }
            }
        }
        if (!c) {
            sb.append('(');
            sb.append(addPar(s.substring(prev), (char)(cur + 1)));
            sb.append(')');
        } else {
            sb.append(s, prev, s.length());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        in.nextLine();
        for (int test = 1; test <= tests; ++test) {
            String s = in.nextLine();
            System.out.println("Case #" + test + ": " + addPar(s, '0'));
            System.out.println();
        }
    }
}