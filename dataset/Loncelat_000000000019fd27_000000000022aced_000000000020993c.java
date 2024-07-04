import java.io.*;
import java.util.*;
class Solution {
    static Scanner sc;
    static void testcase(int no) {

        int n = sc.nextInt();
        int m[][] = new int[n][n];

        HashSet<Integer> nums = new HashSet<>();

        int trace = 0;
        int row_overlap = 0;
        int col_overlap = 0;
        boolean overlap_found = false;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int cur = sc.nextInt();
                m[i][j] = cur;
                if (i == j) { trace += cur; }
                if (!overlap_found && nums.contains(cur)) { row_overlap += 1; overlap_found = true;}
                else { nums.add(cur); }

            }
            overlap_found = false;
            nums.clear();

        }

        /* Column j  */
        for (int j = 0; j < n; j++) {

            for (int i = 0; i < n; i++) {
                int cur = m[i][j];
                if (nums.contains(cur)) { col_overlap += 1; break; }
                else { nums.add(cur); }
            }
            nums.clear();

        }

        System.out.printf("Case #%d: %d %d %d\n", no, trace, row_overlap, col_overlap);



    }
    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            testcase(i + 1);
        }
    }
}