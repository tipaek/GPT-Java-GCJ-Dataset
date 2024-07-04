import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveCases();
        solution.close();
    }

    private void solveCases() {
        int t = readInt();
        for (int i = 1; i <= t; i++) {
            pw.println("Case #" + i + ": " + solve());
        }
    }

    private String solve() {
        int[] arr = readIntArr();
        int n = arr[0];
        int d = arr[1];
        long[] a = readLongArr();

        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    ns[i]++;
                }
            }
        }

        int maxNs = 0;
        for (int count : ns) {
            maxNs = Math.max(maxNs, count);
        }

        if (maxNs >= d) {
            return "0";
        } else if (d == 2) {
            return "1";
        } else if (d == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i] == a[j] * 2) {
                        return "1";
                    }
                }
            }
            return "2";
        }
        return null;
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String readString() {
        return readLine();
    }

    private long readLong() {
        return Long.parseLong(readLine());
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private String[] stringArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            ret[i] = st.nextToken();
        }
        return ret;
    }

    private int[] readIntArr() {
        String[] str = stringArray();
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    private double[] readDoubleArr() {
        String[] str = stringArray();
        double[] arr = new double[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(str[i]);
        }
        return arr;
    }

    private long[] readLongArr() {
        String[] str = stringArray();
        long[] arr = new long[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        return arr;
    }

    private double readDouble() {
        return Double.parseDouble(readLine());
    }
}