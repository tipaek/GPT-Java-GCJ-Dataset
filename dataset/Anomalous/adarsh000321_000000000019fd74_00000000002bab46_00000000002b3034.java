import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            boolean singleCharOnly = true;
            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = reader.next();
                if (strings[i].length() != 1) singleCharOnly = false;
            }

            int[] suffixPositions = new int[n];
            int maxSuffixLength = -1;
            int maxSuffixIndex = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < strings[i].length(); j++) {
                    if (strings[i].charAt(j) == '*') {
                        suffixPositions[i] = j;
                        int currentSuffixLength = strings[i].length() - suffixPositions[i];
                        if (currentSuffixLength > maxSuffixLength) {
                            maxSuffixLength = currentSuffixLength;
                            maxSuffixIndex = i;
                        }
                        break;
                    }
                }
            }

            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                int suffixStart = strings[maxSuffixIndex].length() - 1;
                for (int j = strings[i].length() - 1; j >= 0; j--) {
                    if (j == suffixPositions[i]) break;
                    if (strings[i].charAt(j) != strings[maxSuffixIndex].charAt(suffixStart--)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                output.append("Case #").append(t).append(": *");
                if (t != testCases) output.append("\n");
                continue;
            }

            maxSuffixLength = -1;
            int maxPrefixIndex = -1;
            for (int i = 0; i < n; i++) {
                if (suffixPositions[i] > maxSuffixLength) {
                    maxSuffixLength = suffixPositions[i];
                    maxPrefixIndex = i;
                }
            }

            isValid = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < strings[i].length(); j++) {
                    if (j == suffixPositions[i]) break;
                    if (strings[i].charAt(j) != strings[maxPrefixIndex].charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                output.append("Case #").append(t).append(": *");
                if (t != testCases) output.append("\n");
                continue;
            }

            StringBuilder result = new StringBuilder();
            result.append(strings[maxPrefixIndex], 0, suffixPositions[maxPrefixIndex])
                  .append(strings[maxSuffixIndex].substring(suffixPositions[maxSuffixIndex] + 1));

            if (singleCharOnly) result.append('A');
            output.append("Case #").append(t).append(": ").append(result);
            if (t != testCases) output.append("\n");
        }

        System.out.print(output);
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