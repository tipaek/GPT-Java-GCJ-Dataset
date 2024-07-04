import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader file = new FastReader();
        int testCases = file.nextInt();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = file.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                patterns.add(file.next());
            }
            List<Integer> asteriskIndices = new ArrayList<>();
            List<PatternPart> prefixes = new ArrayList<>();
            List<PatternPart> suffixes = new ArrayList<>();
            for (String pattern : patterns) {
                int asteriskIndex = pattern.indexOf('*');
                asteriskIndices.add(asteriskIndex);
                prefixes.add(new PatternPart(pattern.substring(0, asteriskIndex)));
                suffixes.add(new PatternPart(pattern.substring(asteriskIndex + 1)));
            }

            boolean isValid = true;
            Collections.sort(prefixes);
            Collections.sort(suffixes);

            for (int i = 0; i < prefixes.size() - 1; i++) {
                if (!prefixes.get(i + 1).part.startsWith(prefixes.get(i).part)) {
                    isValid = false;
                    break;
                }
                if (!suffixes.get(i + 1).part.endsWith(suffixes.get(i).part)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + (testCase + 1) + ": " + prefixes.get(prefixes.size() - 1).part + "A" + suffixes.get(suffixes.size() - 1).part);
            } else {
                System.out.println("*");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    static class PatternPart implements Comparable<PatternPart> {
        String part;

        public PatternPart(String part) {
            this.part = part;
        }

        @Override
        public int compareTo(PatternPart other) {
            return Integer.compare(this.part.length(), other.part.length());
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