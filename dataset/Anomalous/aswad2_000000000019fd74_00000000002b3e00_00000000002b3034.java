import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader file = new FastReader();
        int testCases = file.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = file.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                patterns.add(file.next());
            }
            List<Integer> starsIndex = new ArrayList<>();
            List<Thing> prefixes = new ArrayList<>();
            List<Thing> suffixes = new ArrayList<>();
            for (String pattern : patterns) {
                int starPos = pattern.indexOf("*");
                starsIndex.add(starPos);
                prefixes.add(new Thing(pattern.substring(0, starPos)));
                suffixes.add(new Thing(pattern.substring(starPos + 1)));
            }
            boolean isValid = true;
            Collections.sort(prefixes);
            Collections.sort(suffixes);
            for (int i = 0; i < prefixes.size() - 1; i++) {
                if (!prefixes.get(i + 1).t.startsWith(prefixes.get(i).t)) {
                    isValid = false;
                    break;
                }
                if (!suffixes.get(i + 1).t.endsWith(suffixes.get(i).t)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println(prefixes.get(prefixes.size() - 1).t + "A" + suffixes.get(suffixes.size() - 1).t);
            } else {
                System.out.println("*");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    static class Thing implements Comparable<Thing> {
        String t;

        public Thing(String t) {
            this.t = t;
        }

        @Override
        public int compareTo(Thing other) {
            return Integer.compare(this.t.length(), other.t.length());
        }
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.x == other.x) {
                return Integer.compare(this.y, other.y);
            }
            return Integer.compare(this.x, other.x);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

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
}