import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static BigInteger stopped;

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = sc.nextInt();

        for (int ca = 1; ca <= T; ca++) {
            BigInteger L = new BigInteger(sc.next());
            BigInteger R = new BigInteger(sc.next());
            BigInteger people = ZERO;
            boolean swapped = false;

            BigInteger[] stacks = {L, R};

            if (L.compareTo(R) < 0) {
                swap(stacks);
                swapped = true;
            }

            BigInteger low = ZERO;
            BigInteger high = new BigInteger("1000000000000000000");
            BigInteger mid;

            while (high.subtract(low).compareTo(ZERO) > 0) {
                mid = high.add(low).divide(TWO);
                BigInteger sum = sum(mid);
                if (stacks[0].subtract(sum).compareTo(stacks[1]) <= 0) {
                    high = mid;
                } else {
                    low = mid.add(ONE);
                }
            }

            people = people.add(high);
            stacks[0] = stacks[0].subtract(sum(high));
            stopped = people;

            if (stacks[0].compareTo(stacks[1]) == 0 && swapped) {
                swap(stacks);
                swapped = false;
            }

            if (stacks[1].compareTo(stacks[0]) > 0) {
                swap(stacks);
                swapped = !swapped;
            }

            BigInteger leftN, rightN;

            if (low.mod(TWO).compareTo(ZERO) == 1) {
                leftN = binSearchEven(stacks[0], stopped.add(ONE));
                stacks[0] = stacks[0].subtract(sumEven(leftN, stopped.add(ONE)));

                rightN = binSearchOdd(stacks[1], stopped.add(TWO));
                stacks[1] = stacks[1].subtract(sumOdd(rightN, stopped.add(TWO)));
            } else {
                leftN = binSearchOdd(stacks[0], stopped.add(ONE));
                stacks[0] = stacks[0].subtract(sumOdd(leftN, stopped.add(ONE)));

                rightN = binSearchEven(stacks[1], stopped.add(TWO));
                stacks[1] = stacks[1].subtract(sumEven(rightN, stopped.add(TWO)));
            }

            people = people.add(leftN).add(rightN);

            if (swapped) {
                swap(stacks);
            }

            out.printf("Case #%d: %s %s %s\n", ca, people, stacks[0], stacks[1]);
        }
        out.close();
    }

    private static void swap(BigInteger[] stacks) {
        BigInteger temp = stacks[0];
        stacks[0] = stacks[1];
        stacks[1] = temp;
    }

    private static BigInteger sum(BigInteger n) {
        return n.multiply(n.add(ONE)).divide(TWO);
    }

    private static BigInteger sumOdd(BigInteger n, BigInteger a) {
        return n.multiply(TWO.multiply(a).add((n.subtract(ONE)).multiply(TWO))).divide(TWO);
    }

    private static BigInteger sumEven(BigInteger n, BigInteger a) {
        return sumOdd(n, a.add(ONE)).subtract(n);
    }

    private static BigInteger binSearchEven(BigInteger stack, BigInteger start) {
        return binSearch(stack, start, true);
    }

    private static BigInteger binSearchOdd(BigInteger stack, BigInteger start) {
        return binSearch(stack, start, false);
    }

    private static BigInteger binSearch(BigInteger stack, BigInteger start, boolean isEven) {
        BigInteger low = ZERO;
        BigInteger high = new BigInteger("1000000000000000000");
        BigInteger mid;

        while (high.subtract(low).compareTo(ZERO) > 0) {
            mid = high.add(low).add(ONE).divide(TWO);
            BigInteger sum = isEven ? sumEven(mid, start) : sumOdd(mid, start);
            if (stack.subtract(sum).compareTo(ZERO) < 0) {
                high = mid.subtract(ONE);
            } else {
                low = mid;
            }
        }
        return low;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}