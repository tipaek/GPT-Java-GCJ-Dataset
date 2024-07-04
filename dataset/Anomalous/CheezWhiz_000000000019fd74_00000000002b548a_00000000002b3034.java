import java.io.*;
import java.util.*;

public class Solution {
    static class Word implements Comparable<Word> {
        String text;
        int length;

        public Word(String text, int length) {
            this.text = text;
            this.length = length;
        }

        @Override
        public int compareTo(Word other) {
            return Integer.compare(this.length, other.length);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            Word[] words = new Word[n];
            for (int i = 0; i < n; i++) {
                String input = sc.next();
                words[i] = new Word(input, input.length());
            }
            Arrays.sort(words);
            boolean isValid = true;
            String longestWord = words[n - 1].text;
            if (longestWord.startsWith("*")) {
                longestWord = longestWord.substring(1);
            }
            for (int i = 0; i < n - 1; i++) {
                String currentWord = words[i].text;
                String nextWord = words[i + 1].text;
                if (currentWord.startsWith("*")) {
                    currentWord = currentWord.substring(1);
                }
                if (nextWord.startsWith("*")) {
                    nextWord = nextWord.substring(1);
                }
                if (!nextWord.endsWith(currentWord)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println("Case #" + t + ": " + longestWord);
            } else {
                System.out.println("Case #" + t + ": *");
            }
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
}