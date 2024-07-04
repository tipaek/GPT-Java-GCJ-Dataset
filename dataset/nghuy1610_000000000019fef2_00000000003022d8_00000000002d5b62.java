import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Scanner scan = new Scanner(new BufferedReader(new FileReader("test_case.txt")));
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nr = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < nr; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            String s = solve(x, y);
           System.out.printf("Case #%d: %s\n", i+1, s);
        }
    }

    private static String solve(int x, int y) {
        int ax = Math.abs(x);
        int ay = Math.abs(y);
        int tm = ax + ay;
        if (tm % 2 == 0) {
            return "IMPOSSIBLE";
        }
        int nbit = 0;
        while (tm != 0) {
            tm = tm >> 1;
            nbit++;
        }
        tm = ax + ay;
        int nMax = (1 << nbit) -1;
        int nBig = (nMax + tm) / 2;
        int nMin = nMax - nBig;
        boolean[] step = new boolean[nbit];
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        char[] dir = new char[nbit];
        for (int i = 0; i < nbit; i++) {
            if (((1 << i) & nBig) > 0) {
                step[i] = true;
                positive.add(i);
            } else {
                negative.add(i);
                step[i] = false;
            }
        }
        List<Integer> xDir = new ArrayList<>();
        List<Integer> yDir = new ArrayList<>();
        int tx = ax;
        for (int i : negative) {
            if ((tx & (1 << i)) > 0) {
                tx += 1 << i;
                xDir.add(i);
            } else {
                yDir.add(i);
            }
        }
        for (int i : positive) {
            if ((tx & (1 << i)) > 0) {
                xDir.add(i);
            } else {
                yDir.add(i);
            }
        }
        for (int i : xDir) {
            if (step[i]) {
                dir[i] = 'E';
            } else {
                dir[i] = 'W';
            }
        }
        for (int i : yDir) {
            if (step[i]) {
                dir[i] = 'N';
            } else {
                dir[i] = 'S';
            }
        }
        if (x < 0) {
            for (int i = 0; i < nbit; i++) {
                if (dir[i] == 'E') {
                    dir[i] = 'W';
                } else if (dir[i] == 'W'){
                    dir[i] = 'E';
                }
            }
        }
        if (y < 0) {
            for (int i = 0; i < nbit; i++) {
                if (dir[i] == 'N') {
                    dir[i] = 'S';
                } else if (dir[i] == 'S'){
                    dir[i] = 'N';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : dir) {
            sb.append(c);
        }
        return sb.toString();
    }

    static boolean isExp(int a) {
        while (a > 0) {
            if (a % 2 != 0) {
                return false;
            }
            a = a/ 2;
        }
        return true;
    }


}
