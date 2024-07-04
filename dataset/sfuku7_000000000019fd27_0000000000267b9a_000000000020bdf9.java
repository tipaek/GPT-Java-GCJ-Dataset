import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder ans = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] activity = new int[N][3];
            for (int i = 0; i < N; i++) {
                int S = sc.nextInt();
                int E = sc.nextInt();
                activity[i][0] = i;
                activity[i][1] = S;
                activity[i][2] = E;
            }

            Arrays.sort(activity, (a,b)-> a[2]!=b[2] ? a[2]-b[2] : a[1]-b[1]);

            int[] diff = new int[24*60+1];
            for (int i = 0; i < N; i++) {
                diff[activity[i][1]]++;
                diff[activity[i][2]]--;
            }

            boolean possible = true;
            int cnt = 0;
            for (int i = 0; i < diff.length; i++) {
                cnt += diff[i];
                if (cnt > 2) {
                    possible = false;
                    break;
                }
            }
            if (!possible) {
                ans.append("Case #"+t+": IMPOSSIBLE\n");
                continue;
            }

            char[] charge = new char[N];
            boolean cameron = true;
            int prevEnd = 0;
            for (int i = 0; i < N; i++) {
                int actIdx = activity[i][0];
                if (prevEnd <= activity[i][1]) {
                    charge[actIdx] = cameron ? 'C' : 'J';
                } else {
                    charge[actIdx] = cameron ? 'J' : 'C';
                    cameron = !cameron;
                }
                prevEnd = activity[i][2];
            }

            ans.append("Case #"+t+": ");
            for (int i = 0; i < N; i++) {
                ans.append(charge[i]);
            }
            ans.append('\n');
        }
        System.out.print(ans);
    }

}

