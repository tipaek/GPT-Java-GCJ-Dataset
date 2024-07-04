import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            while (st == null || !st.hasMoreTokens()) {
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
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = sc.next();
            }

            String longestString = findLongestString(strings);
            boolean isValid = checkSuffixes(strings, longestString);

            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + longestString);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
            caseNumber++;
        }
    }

    private static String findLongestString(String[] strings) {
        String longestString = "";
        for (String s : strings) {
            if (s.length() > longestString.length()) {
                longestString = s;
            }
        }
        return longestString.substring(1);
    }

    private static boolean checkSuffixes(String[] strings, String longestString) {
        for (String s : strings) {
            if (!isSuffix(s, longestString)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSuffix(String s, String longestString) {
        int k = 0;
        int lo = longestString.length() - 1;
        for (int j = s.length() - 1; j >= 1; j--) {
            if (longestString.charAt(lo) != s.charAt(j)) {
                return false;
            }
            lo--;
        }
        return true;
    }
}