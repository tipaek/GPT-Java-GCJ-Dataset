import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }

        private long nextLong() {
            return Long.parseLong(next());
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        private String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static FastReader reader = new FastReader();
    private static PrintWriter out = new PrintWriter(System.out);

    private static int[] readIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        return arr;
    }

    private static long[] readLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextLong();
        }
        return arr;
    }

    private static int readInt() {
        return reader.nextInt();
    }

    private static long readLong() {
        return reader.nextLong();
    }

    private static String readString() {
        return reader.next();
    }

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int t = readInt();
        int caseNumber = 1;

        while (t-- > 0) {
            result.append("Case #").append(caseNumber++).append(": ");
            long n = readLong();
            long d = readLong();
            Map<Double, Integer> map = new HashMap<>();

            for (long i = 0; i < n; i++) {
                double value = reader.nextDouble();
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            if (d == 2) {
                boolean found = map.values().stream().anyMatch(count -> count >= 2);
                result.append(found ? "0\n" : "1\n");
            } else if (d == 3) {
                boolean foundThree = false;
                boolean foundTwoAndAnother = false;
                boolean foundHalf = false;

                for (double key : map.keySet()) {
                    int count = map.get(key);
                    if (count >= 3) {
                        foundThree = true;
                        break;
                    } else if (count == 2) {
                        for (double otherKey : map.keySet()) {
                            if (otherKey > key) {
                                foundTwoAndAnother = true;
                                break;
                            }
                        }
                    } else {
                        double half = key / 2;
                        if (map.containsKey(half)) {
                            foundHalf = true;
                        }
                    }
                }

                if (foundThree) {
                    result.append("0\n");
                } else if (foundTwoAndAnother || foundHalf) {
                    result.append("1\n");
                } else {
                    result.append("2\n");
                }
            } else {
                result.append("1\n");
            }
        }

        out.print(result.toString());
        out.flush();
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}