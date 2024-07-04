import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        StringBuilder output = new StringBuilder();
        int t = sc.nextInt();

        while (t > 0) {
            t--;
            String result = "J";
            int n = sc.nextInt();
            int[][] j = new int[n][2];
            int[][] c = new int[n][2];
            int jTop = 0, cTop = 0;

            for (int i = 0; i < n; i++) {
                int l1 = sc.nextInt();
                int h1 = sc.nextInt();

                if (i == 0) {
                    j[jTop][0] = l1;
                    j[jTop][1] = h1;
                    jTop++;
                    continue;
                }

                boolean canAssignToJ = true;
                boolean canAssignToC = true;

                for (int[] interval : j) {
                    int l = interval[0];
                    int h = interval[1];
                    if ((l1 >= l && l1 < h) || (h1 > l && h1 <= h) || (l1 < l && h1 > h)) {
                        canAssignToJ = false;
                        break;
                    }
                }

                for (int[] interval : c) {
                    int l = interval[0];
                    int h = interval[1];
                    if (l == 0 && h == 0) break;
                    if ((l1 >= l && l1 < h) || (h1 > l && h1 <= h) || (l1 <= l && h1 >= h)) {
                        canAssignToC = false;
                        break;
                    }
                }

                if (!canAssignToJ && !canAssignToC) {
                    result = "IMPOSSIBLE";
                    break;
                } else if (canAssignToC && !canAssignToJ) {
                    c[cTop][0] = l1;
                    c[cTop][1] = h1;
                    cTop++;
                    result += "C";
                } else if (canAssignToJ && !canAssignToC) {
                    j[jTop][0] = l1;
                    j[jTop][1] = h1;
                    jTop++;
                    result += "J";
                } else {
                    int minJGap = Integer.MAX_VALUE, minJIndex = -1;
                    int minCGap = Integer.MAX_VALUE, minCIndex = -1;

                    for (int p = 0; p < n; p++) {
                        if (j[p][1] != 0 && l1 >= j[p][1] && (l1 - j[p][1]) < minJGap) {
                            minJGap = l1 - j[p][1];
                            minJIndex = p;
                        }
                        if (c[p][1] != 0 && l1 >= c[p][1] && (l1 - c[p][1]) < minCGap) {
                            minCGap = l1 - c[p][1];
                            minCIndex = p;
                        }
                    }

                    if (minJGap < minCGap) {
                        j[jTop][0] = l1;
                        j[jTop][1] = h1;
                        jTop++;
                        result += "J";
                    } else {
                        c[cTop][0] = l1;
                        c[cTop][1] = h1;
                        cTop++;
                        result += "C";
                    }
                }
            }

            output.append("Case #").append(count).append(": ").append(result).append("\n");
            count++;
        }

        System.out.println(output.toString());
    }
}