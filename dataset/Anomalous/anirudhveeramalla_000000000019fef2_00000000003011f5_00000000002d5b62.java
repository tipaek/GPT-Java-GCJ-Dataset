import java.io.*;
import java.util.*;

public class Solution {
    private static BufferedWriter bw;
    private static BufferedReader br;

    private static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    private static boolean isValid(int row, int col) {
        return (isPowerOfTwo(row) && isPowerOfTwo(col - 1)) || (isPowerOfTwo(col) && isPowerOfTwo(row - 1));
    }

    private static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }

    private static void solve() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int col = input[1];

        if ((row <= 0 && col <= 0) || (row >= 0 && col >= 0)) {
            if (row == 0 && col == 0) {
                bw.write("");
            } else if (row == 0) {
                int count = countBits(Math.abs(col));
                char direction = (col > 0) ? 'N' : 'S';
                for (int i = 0; i<count; i++) {
                    bw.write(direction);
                }
            } else if (col == 0) {
                int count = countBits(Math.abs(row));
                char direction = (row > 0) ? 'E' : 'W';
                for (int i = 0; i<count; i++) {
                    bw.write(direction);
                }
            } else if (!isValid(Math.abs(row), Math.abs(col))) {
                bw.write("IMPOSSIBLE");
            } else {
                if (row > 0 && col > 0) {
                    bw.write((isPowerOfTwo(row)) ? "SEN" : "WNE");
                } else if (row < 0 && col < 0) {
                    row = Math.abs(row);
                    col = Math.abs(col);
                    bw.write((isPowerOfTwo(row)) ? "NWS" : "ESW");
                }
            }
        } else {
            bw.write("IMPOSSIBLE");
        }
        bw.newLine();
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write("Case #" + (i + 1) + ": ");
            solve();
        }
        br.close();
        bw.close();
    }
}