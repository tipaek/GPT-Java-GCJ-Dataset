import java.io.*;
import java.util.*;

/**
 * JoinTheRanks
 * Author: av-sharma
 */

public class Solution {
    private static final double PI = Math.PI;
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        setupIO("input.txt", "output.txt");

        FastReader fr = new FastReader();
        int T = fr.nextInt();

        for (int t = 1; t <= T; t++) {
            int R = fr.nextInt();
            int S = fr.nextInt();

            int moves = 0;
            int count = 0;
            int l = R;
            int r = R * S - R - 1;
            int lDec = (R <= S) ? 0 : 1;
            int rDec = 1;
            int[] arr = new int[R * S];

            for (int i = 0; i < R; i++) {
                arr[i] = i + 1;
            }

            int rep = Math.max(R, S);
            int k = R;

            while (rep-- > 0 && k < R * S) {
                for (int j = 0; j < R; j++) {
                    arr[k++] = arr[j];
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!isSorted(arr)) {
                sb.append(l).append(" ").append(r).append("\n");

                int[] lArr = Arrays.copyOfRange(arr, 0, l);
                int[] rArr = Arrays.copyOfRange(arr, l, l + r);

                System.arraycopy(rArr, 0, arr, 0, r);
                System.arraycopy(lArr, 0, arr, r, l);

                l -= lDec;
                r -= rDec;
                moves++;
                count++;

                if ((R <= S && (moves + 1) % S == 0) || (R > S && (count + 1) % S != 0)) {
                    l--;
                }
                if (R > S && (count + 1) % S == 0) {
                    count = 0;
                }
            }

            sb.setLength(sb.length() - 1); // Remove the last newline
            System.out.println("Case #" + t + ": " + moves + "\n" + sb.toString());
        }
    }

    private static void setupIO(String inputFilePath, String outputFilePath) {
        try {
            FileInputStream inputStream = new FileInputStream(inputFilePath);
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            System.setIn(inputStream);
            System.setOut(new PrintStream(outputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
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

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}