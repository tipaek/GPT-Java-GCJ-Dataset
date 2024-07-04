import java.io.*;
import java.util.*;

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

    static FastReader reader = new FastReader();
    static PrintWriter writer = new PrintWriter(System.out);

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
        int testCases = readInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            result.append("Case #").append(caseNumber++).append(": ");
            long n = readLong();
            long d = readLong();
            HashMap<Double, Integer> valueCountMap = new HashMap<>();

            for (long i = 0; i < n; i++) {
                double value = reader.nextDouble();
                valueCountMap.put(value, valueCountMap.getOrDefault(value, 0) + 1);
            }

            if (d == 2) {
                boolean found = valueCountMap.values().stream().anyMatch(count -> count >= 2);
                result.append(found ? "0\n" : "1\n");
            } else if (d == 3) {
                boolean foundThree = false;
                boolean foundHalf = false;

                for (double key : valueCountMap.keySet()) {
                    if (valueCountMap.get(key) >= 3) {
                        foundThree = true;
                        break;
                    } else if (valueCountMap.containsKey(key / 2)) {
                        foundHalf = true;
                    }
                }

                if (foundThree) {
                    result.append("0\n");
                } else if (foundHalf) {
                    result.append("1\n");
                } else {
                    result.append("2\n");
                }
            } else {
                result.append("1\n");
            }
        }

        writer.print(result.toString());
        writer.flush();
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}