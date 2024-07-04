import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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
            pw.print("Case #" + i + ": " + solve());
        }
    }

    private String solve() {
        int n = readInt();
        int num = 1;
        ArrayList<int[]> path = new ArrayList<>();
        path.add(new int[]{1, 1});
        int v = 1;
        boolean flag = false;

        while (num < n) {
            if (v == 1) {
                path.add(new int[]{2, 1});
                num++;
                v++;
            } else if (num + v <= n) {
                path.add(new int[]{v + 1, 2});
                num += v;
                v++;
                flag = true;
            } else {
                int[] cr = {v, 1};
                if (!flag) {
                    cr[0]++;
                }
                flag = false;
                path.add(cr);
                num++;
                v++;
            }
        }

        StringBuilder result = new StringBuilder("\n");
        for (int[] point : path) {
            result.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        return result.toString();
    }

    private void close() {
        pw.close();
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
        String[] ret = new String[st.countTokens()];
        for (int i = 0; i < ret.length; i++) {
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