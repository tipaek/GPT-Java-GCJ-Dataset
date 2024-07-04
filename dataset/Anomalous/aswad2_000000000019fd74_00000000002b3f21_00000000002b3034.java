import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader file = new FastReader();
        int times = file.nextInt();
        for (int testCase = 0; testCase < times; testCase++) {
            int n = file.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                patterns.add(file.next());
            }
            List<Integer> starIndices = new ArrayList<>();
            List<PrefixSuffix> prefixes = new ArrayList<>();
            List<PrefixSuffix> suffixes = new ArrayList<>();
            for (String pattern : patterns) {
                int starIndex = pattern.indexOf("*");
                starIndices.add(starIndex);
                prefixes.add(new PrefixSuffix(pattern.substring(0, starIndex)));
                suffixes.add(new PrefixSuffix(pattern.substring(starIndex + 1)));
            }
            boolean isValid = true;
            Collections.sort(prefixes);
            Collections.sort(suffixes);
            for (int i = 0; i < prefixes.size() - 1; i++) {
                if (!prefixes.get(i + 1).value.startsWith(prefixes.get(i).value)) {
                    isValid = false;
                    break;
                }
                if (!suffixes.get(i + 1).value.endsWith(suffixes.get(i).value)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println("Case #" + (testCase + 1) + ": " + prefixes.get(prefixes.size() - 1).value + "A" + suffixes.get(suffixes.size() - 1).value);
            } else {
                System.out.println("Case #" + (testCase + 1) + ": *");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    static class PrefixSuffix implements Comparable<PrefixSuffix> {
        String value;

        public PrefixSuffix(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(PrefixSuffix other) {
            return Integer.compare(this.value.length(), other.value.length());
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