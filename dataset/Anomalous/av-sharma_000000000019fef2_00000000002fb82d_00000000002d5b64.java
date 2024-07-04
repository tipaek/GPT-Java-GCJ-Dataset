import java.io.*;
import java.util.*;

public class Solution {
    private static final double PI = Math.PI;
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        setupIO();

        FastReader fr = new FastReader();
        int T = fr.nextInt();

        for (int t = 1; t <= T; t++) {
            int R = fr.nextInt();
            int S = fr.nextInt();
            int moves = 0;

            int l = R, r = (R * S) - R - 1;
            int lDec, rDec;
            if (R <= S) {
                lDec = 0;
                rDec = 1;
            } else {
                lDec = rDec = 1;
            }

            int[] arr = initializeArray(R, S);
            StringBuilder sb = new StringBuilder();

            while (!isSorted(arr)) {
                sb.append(l).append(" ").append(r).append("\n");
                performMove(arr, l, r);

                l -= lDec;
                r -= rDec;
                moves++;
            }

            System.out.println("Case #" + t + ": " + moves + "\n" + sb.toString().trim());
        }
    }

    private static void setupIO() {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            // Handle exception
        }
    }

    private static int[] initializeArray(int R, int S) {
        int[] arr = new int[R * S];
        for (int i = 0; i < R; i++) arr[i] = i + 1;
        int k = R;
        for (int rep = Math.max(R, S); rep-- > 0 && k < R * S; ) {
            for (int j = 0; j < R; j++) arr[k++] = arr[j];
        }
        return arr;
    }

    private static void performMove(int[] arr, int l, int r) {
        int[] lArr = Arrays.copyOfRange(arr, 0, l);
        int[] rArr = Arrays.copyOfRange(arr, l, l + r);

        System.arraycopy(rArr, 0, arr, 0, r);
        System.arraycopy(lArr, 0, arr, r, l);
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

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

    String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
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
}