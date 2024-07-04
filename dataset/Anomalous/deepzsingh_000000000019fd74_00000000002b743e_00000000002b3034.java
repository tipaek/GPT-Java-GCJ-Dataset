import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static Integer[] arr;
    static int[] b;

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = 0;

        while (t-- > 0) {
            int n = sc.nextInt();
            Set<Character> uniqueChars = new HashSet<>();
            String[] strings = new String[n];
            b = new int[n];

            for (int i = 0; i < n; i++) {
                strings[i] = sc.next();
            }

            Arrays.sort(strings);
            int count = 0;

            for (int i = 0; i < n - 1; i++) {
                if (strings[i].length() > strings[i + 1].length()) {
                    count++;
                }
            }

            caseNumber++;
            if (count > 0) {
                System.out.println("Case #" + caseNumber + ": " + strings[0]);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
    }
}