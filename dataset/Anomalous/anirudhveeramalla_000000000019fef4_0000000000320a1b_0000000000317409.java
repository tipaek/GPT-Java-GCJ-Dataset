import java.io.*;
import java.util.*;

class Solution {
    static BufferedReader br;
    static BufferedWriter bw;

    static void solve() throws Exception {
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        String str = input[2];

        if (x == 0 && y == 0) {
            bw.write("0");
            bw.newLine();
            return;
        }

        boolean isPossible = false;
        int minTime = Integer.MAX_VALUE;
        int length = 0;

        for (char ch : str.toCharArray()) {
            length++;
            switch (ch) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            int timeRequired = Math.abs(x) + Math.abs(y);
            if (timeRequired <= length) {
                minTime = Math.min(minTime, length);
                isPossible = true;
            }
        }

        if (isPossible) {
            bw.write(Integer.toString(minTime));
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