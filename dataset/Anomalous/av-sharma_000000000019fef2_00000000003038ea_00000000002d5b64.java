import java.io.*;
import java.util.*;

public class Solution {
    private static final double PI = Math.PI;
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            // Handle exception
        }

        FastReader fr = new FastReader();
        int T = fr.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int R = fr.nextInt();
            int S = fr.nextInt();

            int[] arr = new int[R * S];
            for (int i = 0; i < R; i++) {
                arr[i] = i + 1;
            }
            for (int i = R; i < R * S; i++) {
                arr[i] = arr[i % R];
            }

            int moves = 0;
            int l = R, r = (R * S) - R - 1;
            int lDec = R <= S ? 0 : 1;
            int rDec = 1;
            int count = 0;
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
                } else if (R > S && (count + 1) % S == 0) {
                    count = 0;
                }
            }

            output.append("Case #").append(t).append(": ").append(moves).append("\n").append(sb);
        }

        System.out.print(output.toString().trim());
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