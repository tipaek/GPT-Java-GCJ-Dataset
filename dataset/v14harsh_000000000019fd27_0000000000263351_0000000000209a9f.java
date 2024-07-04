import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String seq = in.next();
            String ret = balancedSeq(seq);
            System.out.println("Case #" + i + ": " + ret);
        }
    }

    private static String balancedSeq(String seq) {
        StringBuilder balancedSeq = new StringBuilder();
        Integer prevVal = null;
        int N = seq.length();
        for (int c = 0; c < N; c++) {
            Integer val = Integer.valueOf(String.valueOf(seq.charAt(c)));
            if (prevVal != null) {
                if (val > prevVal) {
                    for (int i = prevVal; i < val; i++)
                        balancedSeq.append("(");
                } else if (val < prevVal) {
                    for (int i = prevVal; i > val; i--)
                        balancedSeq.append(")");
                }
            } else {
                for (int i = 1; i <= val; i++)
                    balancedSeq.append("(");
            }
            balancedSeq.append(val);
            prevVal = val;
        }
        for (int i = 1; i <= prevVal; i++)
            balancedSeq.append(")");
        return balancedSeq.toString();
    }
}
