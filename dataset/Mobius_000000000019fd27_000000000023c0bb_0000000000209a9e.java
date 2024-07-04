import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static int numQueries;
    static int[] out;
    static int sameA = -1;
    static int diffA = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        int b = in.nextInt();

        for (int test = 0; test < t; test++) {
            solve(b, in);
        }
        System.exit(0);
    }

    static void solve(int b, Scanner in) {
        numQueries = 0;
        out = new int[b];

        sameA = -1;
        diffA = -1;

        for (int i = 0; i < b / 2; i++) {

            if (numQueries % 10 == 0 && i != 0) {
                testChange(in);
            }

            numQueries++;
            System.out.println(i + 1);
            out[i] = in.nextInt();

            numQueries++;
            System.out.println(b - i);
            out[b - i - 1] = in.nextInt();

            if (out[i] == out[b - i - 1] && sameA == -1) {
                // pair of same bits
                sameA = i + 1;
            } else if (out[i] != out[b - i - 1] && diffA == -1) {
                // pair of different bits
                diffA = i + 1;
            }
        }

        StringBuilder sb = new StringBuilder(out.length);
        for (int i : out) {
            sb.append(i);
        }
        System.out.println(sb.toString());

        String response = in.next();
        if (!response.equals("Y")) {
            System.exit(0);
        }
    }

    static void testChange(Scanner in) {
        //next query should test
        if (sameA != -1 && diffA != -1) {
            numQueries++;
            System.out.println(sameA);
            int result1 = in.nextInt();

            numQueries++;
            System.out.println(diffA);
            int result2 = in.nextInt();

            if (out[sameA - 1] == result1) {
                // reverse or nothing
                if (out[diffA - 1] != result2) {
                    // reverse
                    reverse();
                }
                // nothing

            } else {
                // both or complement
                if (out[diffA - 1] == result2) {
                    // both
                    reverse();
                }
                complement();
            }
        } else {
            numQueries++;
            System.out.println(1);
            int result1 = in.nextInt();
            if (out[0] != result1) {
                complement();
            }

            numQueries++;
            System.out.println(1);
            in.nextInt();
        }
    }

    static void complement() {
        for (int i = 0; i < out.length; i++) {
            if (out[i] == 0) {
                out[i] = 1;
            } else {
                out[i] = 0;
            }
        }
    }

    static void reverse() {
        int[] tmp = new int[out.length];

        for (int i = 0; i < out.length; i++) {
            tmp[out.length - i - 1] = out[i];
        }

        out = tmp;
    }
}
