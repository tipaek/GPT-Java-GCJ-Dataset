import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        //rev
        //String s = get(new StringBuilder().append("00000000001011101101"), new StringBuilder().append("1011101101"));
        //comp
        //s =get(new StringBuilder().append("00000000001011101101"), new StringBuilder().append("1111111111"));
        //comp + rev
        //s =get(new StringBuilder().append("00000000001011101101"), new StringBuilder().append("0100010010"));

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int B = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            if(!solve(B, in)) {
                break;
            }
        }
        in.close();
    }

    private static boolean solve(int B, Scanner in) {
        if (B == 10)
            return solveSmall(in, B);
        else
            return solveMedium(in, B);
    }

    private static boolean solveSmall(Scanner in, int B) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B; i++) {
            System.out.println(i + 1);
            String t = in.next();
            sb.append(t);
        }
        System.out.println(sb.toString());
        String a = in.next();
        return !a.equals("N");
    }

    private static boolean solveMedium(Scanner in, int B) {
        StringBuilder sb = new StringBuilder(B);
        for (int i = 0; i < B; i++) {
            System.out.println(i + 1);
            int t = in.nextInt();
            sb.append(t);
        }

        //read next 10
        StringBuilder next_10 = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            String t = in.next();
            next_10.append(t);
        }

        System.out.println(get(sb, next_10));
        String a = in.next();
        return !a.equals("N");
    }

    public static String get(StringBuilder sb, StringBuilder next_10) {
        String n10 = next_10.toString();
        String f10 = sb.substring(0, 10);
        String l10 = sb.substring(sb.length() - 10);

        String res;
        if (f10.equals(n10)) {
            res = sb.toString();
        } else if (comp(f10).equals(n10)) {
            //complement
            res = comp(sb.toString());
        } else if (l10.equals(n10)) {
            //reverse
            res = sb.reverse().toString();
        } else {
            //rev + comp
            sb = sb.reverse();
            res = comp(sb.toString());
        }
        return res;
    }

    private static String comp(String s) {
        StringBuilder res = new StringBuilder();
        for (char x : s.toCharArray()) {
            if (x == '1')
                res.append('0');
            else
                res.append('1');
        }
        return res.toString();
    }
}
