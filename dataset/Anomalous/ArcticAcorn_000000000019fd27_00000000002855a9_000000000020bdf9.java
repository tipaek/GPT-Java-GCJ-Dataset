import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCount = 1;
        StringBuilder resultBuilder = new StringBuilder();
        int t = sc.nextInt();

        while (t-- > 0) {
            int cTop = 0, jTop = 0;
            StringBuilder res = new StringBuilder("J");

            int n = sc.nextInt();
            int[][] j = new int[n][2];
            int[][] c = new int[n][2];

            for (int i = 0; i < n; i++) {
                int l1 = sc.nextInt();
                int h1 = sc.nextInt();

                if (i == 0) {
                    j[jTop][0] = l1;
                    j[jTop][1] = h1;
                    jTop++;
                    continue;
                }

                boolean canAssignJ = true, canAssignC = true;

                for (int k = 0; k < jTop; k++) {
                    int l = j[k][0];
                    int h = j[k][1];
                    if ((l1 >= l && l1 < h) || (h1 > l && h1 <= h) || (l1 <= l && h1 >= h)) {
                        canAssignJ = false;
                        break;
                    }
                }

                for (int k = 0; k < cTop; k++) {
                    int l = c[k][0];
                    int h = c[k][1];
                    if ((l1 >= l && l1 < h) || (h1 > l && h1 <= h) || (l1 <= l && h1 >= h)) {
                        canAssignC = false;
                        break;
                    }
                }

                if (!canAssignJ && !canAssignC) {
                    res = new StringBuilder("IMPOSSIBLE");
                    break;
                } else if (canAssignC && !canAssignJ) {
                    c[cTop][0] = l1;
                    c[cTop][1] = h1;
                    cTop++;
                    res.append("C");
                } else if (canAssignJ && !canAssignC) {
                    j[jTop][0] = l1;
                    j[jTop][1] = h1;
                    jTop++;
                    res.append("J");
                } else {
                    if (res.charAt(res.length() - 1) == 'J') {
                        j[jTop][0] = l1;
                        j[jTop][1] = h1;
                        jTop++;
                        res.append("J");
                    } else {
                        c[cTop][0] = l1;
                        c[cTop][1] = h1;
                        cTop++;
                        res.append("C");
                    }
                }
            }

            resultBuilder.append("Case #").append(caseCount).append(": ").append(res).append("\n");
            caseCount++;
        }

        System.out.print(resultBuilder.toString());
    }
}