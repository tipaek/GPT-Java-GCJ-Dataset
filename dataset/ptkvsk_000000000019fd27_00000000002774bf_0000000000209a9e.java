import java.util.Objects;
import java.util.Scanner;

public class Solution {
    private static int turn = 0;
    private static Integer equalPos, diffPos;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tb = in.nextLine();
        // System.err.println(tb);
        int t = Integer.parseInt(tb.split(" ")[0]); // Scanner has functions to read ints, longs, strings, chars, etc.
        int B = Integer.parseInt(tb.split(" ")[1]);
        for (int i = 1; i <= t; ++i) {
            turn = 0;
            equalPos = null;
            diffPos = null;
            // System.err.println("New round");
            Integer[] a = new Integer[B];

            // next 10 queries are special because they don't need verification
            int pos;
            for (pos = 0; pos < 5; pos++) {
                a[B - pos - 1] = getBit(B - pos - 1, in);
                a[pos] = getBit(pos, in);
                checkPairs(a, pos);
            }

            while (pos < B - pos - 1) {
                verify(a, in);

                for (int j = 0; (j < 4) && (pos < B - pos - 1); j++, pos++) {
                    a[pos] = getBit(pos, in);
                    a[B - pos - 1] = getBit(B - pos - 1, in);
                    checkPairs(a, pos);
                }
            }

            verify(a, in);

            StringBuilder sb = new StringBuilder();
            for (Integer integer : a) {
                sb.append(integer);
            }

            // System.err.println("Answer: " + sb.toString());
            System.out.println(sb.toString());
            String judgement = in.nextLine();
            // System.err.println("Judgement: " + judgement);
            if ("N".equals(judgement)) {
                return;
            }
        }
    }

    private static void verify(Integer[] a, Scanner in) {
        // System.err.println("Verify called");

        boolean equalFlipped = false, diffFlipped = false;
        if (equalPos != null) {
            equalFlipped = a[equalPos] != getBit(equalPos, in);
        } else {
            getBit(0, in);
        }

        if (diffPos != null) {
            diffFlipped = a[diffPos] != getBit(diffPos, in);
        } else {
            getBit(0, in);
        }

        boolean inversed = equalFlipped;
        boolean reversed = equalFlipped ^ diffFlipped;

        if (inversed) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != null) a[i] = 1 - a[i];
            }
        }

        if (reversed) {
            for (int i = 0; i < a.length - 1 - i; i++) {
                Integer c = a[i];
                a[i] = a[a.length - 1 - i];
                a[a.length - 1 - i] = c;
            }
        }
    }

    private static void checkPairs(Integer[] a, int pos) {
        if (Objects.equals(a[pos], a[a.length - pos - 1])) {
            equalPos = pos;
            // System.err.println("EqualPos: " + (equalPos + 1));
        } else {
            diffPos = pos;
            // System.err.println("DiffPos: " + (diffPos + 1));
        }
    }

    private static int getBit(int zeroBasedPos, Scanner in) {
        System.out.println(zeroBasedPos + 1);
        int answer = Integer.parseInt(in.nextLine());
        // System.err.printf("Turn %d: b(%d) == %d\n", ++turn, zeroBasedPos + 1, answer);
        return answer;
    }
}