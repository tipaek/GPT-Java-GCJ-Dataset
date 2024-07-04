import java.util.*;
import java.io.*;

public class Solution {

    static final boolean stdin = true;
    static final String filename = "";
    static FastScanner scanner;
    static PrintWriter writer;

    public static void main(String[] args) throws IOException {
        if (stdin) {
            scanner = new FastScanner();
            writer = new PrintWriter(new OutputStreamWriter(System.out));
        } else {
            scanner = new FastScanner(filename + ".in");
            writer = new PrintWriter(new FileWriter(filename + ".out"));
        }

        Solver solver = new Solver();
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            writer.print("Case #" + i + ": ");
            solver.solve(scanner, writer);
        }
        writer.close();
    }

    static class Solver {
        static final long MOD = 1_000_000_007;

        public void solve(FastScanner scanner, PrintWriter writer) throws IOException {
            int n = scanner.nextInt();
            List<String> right = new ArrayList<>();
            List<String> left = new ArrayList<>();
            List<String> mid = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String s = scanner.nextToken();
                boolean startsWithAsterisk = s.charAt(0) == '*';
                boolean endsWithAsterisk = s.charAt(s.length() - 1) == '*';

                if (startsWithAsterisk) {
                    right.add(s.substring(1));
                } else if (endsWithAsterisk) {
                    left.add(s.substring(0, s.length() - 1));
                } else {
                    mid.add(s);
                }
            }

            Collections.sort(right, new MyComparator());
            Collections.sort(left, new MyComparator());

            String outR = getRightPattern(right);
            String outL = getLeftPattern(left);

            if (outR.equals("*") || outL.equals("*")) {
                writer.println("*");
            } else {
                if (mid.isEmpty()) {
                    writer.println(outL + outR);
                } else if (mid.size() == 1) {
                    handleSingleMidPattern(mid.get(0), outL, outR, writer);
                } else {
                    writer.println("*");
                }
            }
        }

        private String getRightPattern(List<String> right) {
            if (right.isEmpty()) return "";

            String firstRight = right.get(0);
            for (String s : right) {
                if (!firstRight.endsWith(s)) {
                    return "*";
                }
            }
            return firstRight;
        }

        private String getLeftPattern(List<String> left) {
            if (left.isEmpty()) return "";

            String firstLeft = left.get(0);
            for (String s : left) {
                if (!firstLeft.startsWith(s)) {
                    return "*";
                }
            }
            return firstLeft;
        }

        private void handleSingleMidPattern(String midPattern, String outL, String outR, PrintWriter writer) {
            for (int i = 0; i < midPattern.length(); i++) {
                if (midPattern.charAt(i) == '*') {
                    String leftPart = midPattern.substring(0, i);
                    String rightPart = midPattern.substring(i + 1);

                    if (!isValidLeftPart(leftPart, outL) || !isValidRightPart(rightPart, outR)) {
                        writer.println("*");
                        return;
                    }

                    String resultLeft = leftPart.length() > outL.length() ? leftPart.substring(outL.length()) : "";
                    String resultRight = rightPart.length() > outR.length() ? rightPart.substring(0, rightPart.length() - outR.length()) : "";

                    writer.println(outL + resultLeft + resultRight + outR);
                    return;
                }
            }
        }

        private boolean isValidLeftPart(String leftPart, String outL) {
            int minLength = Math.min(leftPart.length(), outL.length());
            return leftPart.substring(0, minLength).equals(outL.substring(0, minLength));
        }

        private boolean isValidRightPart(String rightPart, String outR) {
            int minLength = Math.min(rightPart.length(), outR.length());
            return rightPart.substring(rightPart.length() - minLength).equals(outR.substring(outR.length() - minLength));
        }

        public class MyComparator implements Comparator<String> {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        }

        static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        static long lcm(long a, long b) {
            return a * (b / gcd(a, b));
        }

        static long pow(long a, long b) {
            if (b == 0) return 1;
            long half = pow(a, b / 2);
            long result = half * half % MOD;
            return b % 2 == 0 ? result : result * a % MOD;
        }
    }

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            return x == other.x ? Integer.compare(y, other.y) : Integer.compare(x, other.x);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastScanner(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}