import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = reader.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = reader.next();
            }

            String baseWord = words[0];
            int matchingCount = 0;
            String maxLengthWord = "";
            String minLengthWord = "";

            for (int i = 1; i < n; i++) {
                String currentWord = words[i];
                if (currentWord.equals(baseWord)) {
                    matchingCount++;
                    continue;
                }

                int baseLength = baseWord.length();
                int currentLength = currentWord.length();
                int maxLength = Math.max(baseLength, currentLength);
                int minLength = Math.min(baseLength, currentLength);

                if (maxLength == baseLength) {
                    maxLengthWord = baseWord;
                    minLengthWord = currentWord;
                } else {
                    maxLengthWord = currentWord;
                    minLengthWord = baseWord;
                }

                int m = maxLength;
                int commonSuffixLength = 0;
                for (int j = minLength - 1; j >= 1; j--) {
                    if (maxLengthWord.charAt(m - 1) == minLengthWord.charAt(j)) {
                        commonSuffixLength++;
                    } else {
                        break;
                    }
                    m--;
                }

                if (commonSuffixLength != minLength - 1) {
                    break;
                }

                baseWord = maxLengthWord;
                matchingCount++;
            }

            if (matchingCount == n - 1) {
                System.out.println("Case #" + caseNumber + ": " + maxLengthWord.substring(1));
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
            caseNumber++;
        }
    }
}