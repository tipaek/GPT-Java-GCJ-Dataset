import java.io.*;
import java.util.*;

public class Solution {
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
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            List<String> strings = new ArrayList<>();
            int maxLengthIndex = 0;
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                strings.add(str);
                if (str.length() > maxLength) {
                    maxLength = str.length();
                    maxLengthIndex = i;
                }
            }

            String longestSuffix = strings.get(maxLengthIndex).substring(1);
            boolean isValid = true;

            for (int i = 0; i < n; i++) {
                if (i != maxLengthIndex) {
                    String currentString = strings.get(i);
                    int suffixIndex = longestSuffix.length() - 1;
                    boolean matches = true;

                    for (int k = currentString.length() - 1; k > 0; k--) {
                        if (currentString.charAt(k) != longestSuffix.charAt(suffixIndex--)) {
                            matches = false;
                            break;
                        }
                    }

                    if (!matches) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNumber + ": " + longestSuffix);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }

            caseNumber++;
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}