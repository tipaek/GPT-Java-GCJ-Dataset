import java.util.*;
import java.io.*;

public class Solution {
    static BufferedWriter bw;
    static BufferedReader br;

    static int countBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    static boolean isValid(int row, int col) {
        return ((row & (row - 1)) == 0 && ((col - 1) & (col - 2)) == 0) ||
               ((col & (col - 1)) == 0 && ((row - 1) & (row - 2)) == 0);
    }

    static void solve() throws Exception {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = input[0];
        int col = input[1];

        if ((row <= 0 && col <= 0) || (row >= 0 && col >= 0)) {
            if (row == 0) {
                int count = countBits(Math.abs(col));
                char direction = col > 0 ? 'N' : 'S';
                for (int i = 0; i < count; i++) {
                    bw.write(direction);
                }
            } else if (col == 0) {
                int count = countBits(Math.abs(row));
                char direction = row > 0 ? 'E' : 'W';
                for (int i = 0; i < count; i++) {
                    bw.write(direction);
                }
            } else if (!isValid(Math.abs(row), Math.abs(col))) {
                bw.write("IMPOSSIBLE");
            } else {
                if (row > 0 && col > 0) {
                    if ((row & (row - 1)) == 0) {
                        bw.write("SEN");
                    } else {
                        bw.write("WNE");
                    }
                } else if (row < 0 && col < 0) {
                    row = Math.abs(row);
                    col = Math.abs(col);
                    if ((row & (row - 1)) == 0) {
                        bw.write("NWS");
                    } else {
                        bw.write("ESW");
                    }
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