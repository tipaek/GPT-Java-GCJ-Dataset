import java.util.*;
import java.io.*;

class Solution {
    static class Reader {
        private final BufferedReader br;
        private final BufferedWriter bw;
        private StringTokenizer st;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        void print(String s) {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String s) {
            try {
                bw.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static int length(int x) {
        return Integer.toString(x).length();
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int queryCount = reader.nextInt();

        for (int itr = 1; itr <= queryCount; ++itr) {
            reader.print("Case #" + itr + ": ");
            int u = reader.nextInt();
            int[] minDigits = new int[26];
            char[] result = new char[10];
            Arrays.fill(minDigits, Integer.MAX_VALUE);

            for (int i = 0; i < 10000; ++i) {
                int m = reader.nextInt();
                char[] chars = reader.next().toCharArray();
                int numLength = chars.length;
                String[] digits = Integer.toString(m).split("");

                if (digits.length == numLength) {
                    int firstCharIndex = chars[0] - 'A';
                    int firstDigit = Integer.parseInt(digits[0]);
                    minDigits[firstCharIndex] = Math.min(minDigits[firstCharIndex], firstDigit);
                    int prev = firstDigit;

                    for (int j = 1; j < numLength; ++j) {
                        int charIndex = chars[j] - 'A';
                        int currentDigit = Integer.parseInt(digits[j]);
                        if ((j == 1 && prev == 1) || (prev == 0)) {
                            minDigits[charIndex] = Math.min(minDigits[charIndex], currentDigit);
                        } else {
                            minDigits[charIndex] = Math.min(minDigits[charIndex], 9);
                        }
                        prev = minDigits[charIndex];
                    }
                } else {
                    for (char ch : chars) {
                        int charIndex = ch - 'A';
                        minDigits[charIndex] = Math.min(minDigits[charIndex], 9);
                    }
                }
            }

            for (int i = 0; i < 26; ++i) {
                if (minDigits[i] != Integer.MAX_VALUE) {
                    result[minDigits[i]] = (char) (i + 'A');
                }
            }

            for (char c : result) {
                reader.print(c + "");
            }
            reader.println("");
        }
        reader.close();
    }
}