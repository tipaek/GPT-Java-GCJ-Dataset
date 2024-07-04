package gcj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void solve(int testNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] m = new int[n][n];
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i=0;i<n;i++) {
            Set<Integer> seen = new HashSet();
            boolean broken = false;
            for (int j=0;j<n;j++) {
                m[i][j] = scanner.nextInt();
                if (seen.contains(m[i][j])) {
                    broken = true;
                } else {
                    seen.add(m[i][j]);
                }
            }
            if (broken) { r++; };
        }
        for (int j=0;j<n;j++) {
            Set<Integer> seen = new HashSet();
            boolean broken = false;
            for (int i=0;i<n;i++) {
                if (seen.contains(m[i][j])) {
                    broken = true;
                } else {
                    seen.add(m[i][j]);
                }
            }
            if (broken) { c++; };
            k += m[j][j];
        }
        System.out.println(String.format("Case #%d: %d %d %d", testNum, k, r, c));
    }
    public static void main(String[] args) {
        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new File("/Users/vpytak/code/bcom/combooboo/codejam/qual/in1"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 1; i<=t; i++) {
            solve(i, scanner);
        }
    }
}
