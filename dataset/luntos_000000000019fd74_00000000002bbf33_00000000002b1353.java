import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            List<Integer> sweepRows = new ArrayList<>();
            int N = sc.nextInt();
            N -= 1;
            while (N > 1 && (sweepRows.size() == 0 || sweepRows.get(sweepRows.size() - 1) != 2)) {
                int d = 1;
                int c = 1;
                if (sweepRows.size() == 0) {
                    while (d * 2 <= N - c + 1) {
                        d *= 2;
                        c++;
                    }
                } else {
                    int pathUp = sweepRows.get(sweepRows.size() - 1);
                    while (d * 2 <= N - (pathUp - 2) && c + 1 < pathUp) {
                        d *= 2;
                        c++;
                    }
                    N -= (pathUp - c) - 1;
                }
                if (c == 1) {
                    break;
                }
                sweepRows.add(c);
                N -= d;
            }
            System.out.println("Case #" + t + ": ");
            System.out.println("1 1");
            int cr = 1, cc = 1;
            for (int i = sweepRows.size() - 1; i >= 0; i--) {
                int r = sweepRows.get(i);
                while (cr < r) {
                    if (cc > 1) {
                        cc ++;
                    }
                    cr ++;
                    System.out.println(cr + " " + cc);
                }
                if (cc > 1) {
                    while (cc > 1) {
                        cc --;
                        System.out.println(cr + " " + cc);
                    }
                } else {
                    while (cc < cr) {
                        cc ++;
                        System.out.println(cr + " " + cc);
                    }
                }
            }
            while (N > 0) {
                if (cc > 1) {
                    cc ++;
                }
                cr ++;
                System.out.println(cr + " " + cc);
                N--;
            }
        }


    }
}
