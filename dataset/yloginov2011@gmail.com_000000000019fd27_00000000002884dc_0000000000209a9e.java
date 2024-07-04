import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int B = in.nextInt();
            solve(B, in);
        }
    }

    private static void solve(int B, Scanner in) {
        if (B == 10)
            solveSmall(in, B);
        else
            solveMedium(in, B);
    }

    private static void solveSmall(Scanner in, int B) {
        BitSet bs = new BitSet(B);
        for (int i = 0; i < B; i++) {
            System.out.println(i + 1);
            int t = in.nextInt();
            if (t == 1) {
                bs.set(i);
            }
        }
        System.out.println(str(bs));
    }

    private static void solveMedium(Scanner in, int B) {
        BitSet bs = new BitSet(B);
        for (int i = 0; i < B; i++) {
            System.out.println(i + 1);
            int t = in.nextInt();
            if (t == 1) {
                bs.set(i);
            }
        }

        //read next 10
        BitSet next_10 = new BitSet(10);
        BitSet first_10 = new BitSet(10);
        for (int i = 0; i < 10; i++) {
            first_10.set(i, bs.get(i));
            System.out.println(i + 1);
            int t = in.nextInt();
            if (t == 1) {
                next_10.set(i);
            }
        }

        int n10 = convert(next_10);
        int f10 = convert(first_10);


        if (~n10 == f10) {
            //complement
            for (int i = 0; i < B; i++) {
                bs.flip(i);
            }
        } else if (Integer.reverse(n10) == f10) {
            //reverse
            bs = reverse(bs);
        } else if (Integer.reverse(~n10) == f10) {
            //rev + comp
            for (int i = 0; i < B; i++) {
                bs.flip(i);
            }
            //
            bs = reverse(bs);
        }

        System.out.println(str(bs));
    }

    private static BitSet reverse(BitSet bits) {
        BitSet b_next = new BitSet(bits.size());
        int j = 0;
        for (int i = bits.size() - 1; i >= 0; i--) {
            b_next.set(j, bits.get(i));
            j++;
        }
        return b_next;
    }

    private static String str(BitSet bits) {
        StringBuilder sb = new StringBuilder();
        for (int i = bits.length() - 1; i >= 0; i--) {
            if (bits.get(i)){
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    private static int convert(BitSet bits) {
        int value = 0;
        for (int i = 0; i < bits.length(); ++i) {
            value += bits.get(i) ? (1 << i) : 0;
        }
        return value;
    }
}
