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

            String currentWord = words[0];
            String maxWord = "";
            String minWord = "";
            int matchedWords = 0;

            for (int i = 1; i < n; i++) {
                String nextWord = words[i];

                if (nextWord.equals(currentWord)) {
                    maxWord = currentWord;
                    matchedWords++;
                    continue;
                }

                int currentLength = currentWord.length();
                int nextLength = nextWord.length();
                int maxLength = Math.max(currentLength, nextLength);
                int minLength = Math.min(currentLength, nextLength);

                if (maxLength == currentLength) {
                    maxWord = currentWord;
                    minWord = nextWord;
                } else {
                    maxWord = nextWord;
                    minWord = currentWord;
                }

                int maxIndex = maxLength;
                int matchCount = 0;

                for (int j = minLength - 1; j >= 1; j--) {
                    if (maxWord.charAt(maxIndex - 1) == minWord.charAt(j)) {
                        matchCount++;
                    } else {
                        break;
                    }
                    maxIndex--;
                }

                if (matchCount != minLength - 1) {
                    break;
                }

                currentWord = maxWord;
                matchedWords++;
            }

            if (matchedWords == n - 1) {
                System.out.println("Case #" + caseNumber + ": " + maxWord.substring(1));
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }

            caseNumber++;
        }
    }
}