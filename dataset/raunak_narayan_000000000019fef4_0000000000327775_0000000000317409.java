import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;

    private void run() throws Exception {
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            solve(i);
        }

        in.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution2().run();
    }

    final int MOD = 1000000000;
    int row, col;
    long mul;
    List<Integer> values;

    private void solve(int t) {

        int x = in.nextInt();
        int y = in.nextInt();
        String str = in.next();
        int res = 0;
        int f = 0;
        int time = 0;
        for (int j = 0; j < str.length(); j++) {
            // System.out.println(x+" "+y);
            if (Math.abs(x) + Math.abs(y) <= time) {
                res = time;
                f = 1;
                break;
            }
            if (str.charAt(j) == 'S')
                y--;
            else if (str.charAt(j) == 'N')
                y++;
            else if (str.charAt(j) == 'E')
                x++;
            else
                x--;
            time++;
        }
        if (Math.abs(x) + Math.abs(y) <= time) {
            res = time;
            f = 1;
        }
        if (f == 1)
            out.print("Case #" + t + ": " + res);
        else
            out.print("Case #" + t + ": " + "IMPOSSIBLE");
        out.println();
    }

    

    
    void excute(char c) {
        switch (c) {
            case 'N':
                goNorth();
                break;
            case 'S':
                goSouth();
                break;
            case 'E':
                goEast();
                break;
            case 'W':
                goWest();
                break;
        }
    }

    void goNorth() {

        row -= mul;
        // System.out.println("\t\tgoNorth() row = "+row);
        if (row <= 0) {
            row = MOD + row;
        }
        // System.out.println("\t\tgoNorth() row = "+row);
    }

    void goSouth() {
        row += mul;
        if (row >= MOD) {
            row = row % MOD;
        }
        // System.out.println("\t\tgoSouth() row = "+row);
    }

    void goWest() {
        col -= mul;
        if (col <= 0)
            col = MOD + col;
        // System.out.println("\t\tgoWest() col = "+col);
    }

    void goEast() {
        col += mul;
        if (col >= MOD)
            col = col % MOD;
        // System.out.println("\t\tgoEast() col = "+col);
    }
}
