import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
            ArrayList<String> strings = new ArrayList<>();
            int indexWithLongestString = 0;
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                strings.add(sc.nextLine());
                int length = strings.get(i).length();
                if (length > maxLength) {
                    maxLength = length;
                    indexWithLongestString = i;
                }
            }

            String longestSubstring = strings.get(indexWithLongestString).substring(1);
            boolean isValid = true;

            for (int i = 0; i < n; i++) {
                if (i != indexWithLongestString) {
                    String currentString = strings.get(i);
                    int matchIndex = maxLength - 2;
                    boolean matches = true;

                    for (int k = currentString.length() - 1; k > 0; k--) {
                        if (currentString.charAt(k) == longestSubstring.charAt(matchIndex)) {
                            matchIndex--;
                        } else {
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
                System.out.println("Case #" + caseNumber + ": " + longestSubstring);
            } else {
                System.out.print("Case #" + caseNumber + ": *");
            }

            caseNumber++;
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }
}