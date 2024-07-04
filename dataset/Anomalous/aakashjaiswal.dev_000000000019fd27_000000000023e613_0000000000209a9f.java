import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader in = new FastReader();
        int T = in.nextInt();
        int caseNumber = 0;

        while (T-- > 0) {
            String str = in.next();
            int[] digits = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                digits[i] = str.charAt(i) - '0';
            }
            boolean[] processed = new boolean[digits.length];
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < digits.length; i++) {
                pairs.add(new Pair(digits[i], i));
            }
            pairs.sort(Collections.reverseOrder());

            int[] openBrackets = new int[digits.length];
            int[] closeBrackets = new int[digits.length];

            for (Pair pair : pairs) {
                if (processed[pair.index]) continue;
                processed[pair.index] = true;

                // Process right side
                processSide(digits, processed, openBrackets, closeBrackets, pair.index, true);
                // Process left side
                processSide(digits, processed, openBrackets, closeBrackets, pair.index, false);
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                result.append("(".repeat(openBrackets[i]));
                result.append(digits[i]);
                result.append(")".repeat(closeBrackets[i]));
            }

            System.out.println("Case #" + (++caseNumber) + ": " + result);
        }
    }

    private static void processSide(int[] digits, boolean[] processed, int[] openBrackets, int[] closeBrackets, int startIndex, boolean right) {
        int max = digits[startIndex];
        int remainder = digits[startIndex];
        int lastIndex = startIndex;
        int step = right ? 1 : -1;
        int limit = right ? digits.length : -1;

        for (int i = startIndex + step; i != limit; i += step) {
            if (digits[i] > max) {
                if (right) closeBrackets[i - 1] += remainder;
                else openBrackets[i + 1] += remainder;
                remainder = 0;
                break;
            } else {
                if (digits[i] == max) {
                    lastIndex = i;
                    processed[i] = true;
                } else {
                    if (right) closeBrackets[i - 1] += remainder - digits[i];
                    else openBrackets[i + 1] += remainder - digits[i];
                    max = digits[i];
                    remainder = digits[i];
                    processed[i] = true;
                }
            }
            lastIndex = i;
        }
        if (remainder > 0) {
            if (right) closeBrackets[lastIndex] += remainder;
            else openBrackets[lastIndex] += remainder;
        }
    }

    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}