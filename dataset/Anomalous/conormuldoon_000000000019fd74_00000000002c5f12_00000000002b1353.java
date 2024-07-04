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
        ArrayList<int[]> positions = new ArrayList<>();
        positions.add(new int[]{1, 1});
        int v = 1;
        boolean b = false;

        while (num < n) {
            if (v == 1) {
                positions.add(new int[]{2, 1});
                num++;
                v++;
            } else if (num + v <= n) {
                positions.add(new int[]{v + 1, 2});
                num += v;
                v++;
                b = true;
            } else {
                int[] cr = {v, 1};
                if (!b) {
                    cr[0]++;
                    v++;
                }
                b = false;
                positions.add(cr);
                num++;
            }
        }

        StringBuilder result = new StringBuilder("\n");
        for (int[] position : positions) {
            result.append(position[0]).append(" ").append(position[1]).append("\n");
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
            return null;
        }
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }

    private String[] stringArray() {
        StringTokenizer st = new StringTokenizer(readLine());
        int n = st.countTokens();
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = st.nextToken();
        }
        return result;
    }

    private int[] readIntArray() {
        String[] str = stringArray();
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    private long readLong() {
        return Long.parseLong(readLine());
    }

    private double readDouble() {
        return Double.parseDouble(readLine());
    }

    private long[] readLongArray() {
        String[] str = stringArray();
        long[] arr = new long[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        return arr;
    }

    private double[] readDoubleArray() {
        String[] str = stringArray();
        double[] arr = new double[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(str[i]);
        }
        return arr;
    }
}