import java.util.*;
import java.io.*;

public class Solution {
    static MyScanner scanner;
    static PrintWriter writer;
    static final long MOD = 1_000_000_007;
    static final long INF = 1_000_000_000_000_000_000L;
    static final long inf = 2_000_000_000;

    public static void main(String[] args) {
        new Thread(null, null, "BaZ", 1 << 27) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static void solve() throws IOException {
        initIo(false, "");
        int t = nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            print("Case #" + caseNum + ":");
            long[] arr = new long[2];
            arr[0] = nextLong();
            arr[1] = nextLong();
            long diff = Math.abs(arr[0] - arr[1]);
            long low = 0, high = 2_000_000_000, mid, ans = low;
            while (low <= high) {
                mid = (low + high) / 2;
                long midSum = mid * (mid + 1) / 2;
                if (midSum <= diff) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            int which = arr[0] >= arr[1] ? 0 : 1;
            arr[which] -= ans * (ans + 1) / 2;
            int next = arr[0] >= arr[1] ? 0 : 1;
            ans = binarySearch(arr, ans + 1, next);
            println(ans + " " + arr[0] + " " + arr[1]);
        }
        writer.flush();
        writer.close();
    }

    static long binarySearch(long[] arr, long start, int which) {
        if (arr[0] < start && arr[1] < start) {
            return start - 1;
        }
        long low = start, high = 2_000_000_000, ans = start, mid;
        long whichTook = -1, otherTook = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            long total = (mid - start + 1) * (start + mid) / 2;
            long whichTakesTill = mid % 2 == start % 2 ? mid : mid - 1;
            long whichTakes = (mid - start + 2) / 2 * (start + whichTakesTill) / 2;
            long otherTakes = total - whichTakes;

            if (arr[which] >= whichTakes && arr[1 - which] >= otherTakes) {
                ans = mid;
                whichTook = whichTakes;
                otherTook = otherTakes;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        arr[which] -= whichTook;
        arr[1 - which] -= otherTook;
        return ans;
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scanner = new MyScanner(isFileIO, suffix);
        if (isFileIO) {
            writer = new PrintWriter("/Users/amandeep/Desktop/output" + suffix + ".txt");
        } else {
            writer = new PrintWriter(System.out, true);
        }
    }

    static int nextInt() throws IOException {
        return scanner.nextInt();
    }

    static long nextLong() throws IOException {
        return scanner.nextLong();
    }

    static void print(Object o) {
        writer.print(o + " ");
    }

    static void println(Object o) {
        writer.println(o);
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(boolean readingFromFile, String suffix) throws IOException {
            if (readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input" + suffix + ".txt"));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}