import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int k = 1; k <= testCase; k++) {
            System.out.printf("Case #%d: ", k);
            int N = sc.nextInt();
            int sortedAct[][] = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    sortedAct[i][j] = sc.nextInt();
                }
                sortedAct[i][2] = i;
            }

            Arrays.sort(sortedAct, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
            char ans[] = new char[N];
            int c_activity[] = new int[2];
            int j_activity[] = new int[2];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (sortedAct[i][0] >= c_activity[1]) {
                    ans[i] = 'C';
                    c_activity[0] = sortedAct[i][0];
                    c_activity[1] = sortedAct[i][1];
                } else if (sortedAct[i][0] >= j_activity[1]) {
                    ans[i] = 'J';
                    j_activity[0] = sortedAct[i][0];
                    j_activity[1] = sortedAct[i][1];
                } else {
                    sb.append("IMPOSSIBLE");
                    break;
                }
            }

            if (sb.length() > 0) {
                System.out.println(sb.toString());
                continue;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (sortedAct[j][2] == i) {
                        sb.append(ans[j]);
                    }
                }
            }
            System.out.println(sb.toString());

        }
    }
}