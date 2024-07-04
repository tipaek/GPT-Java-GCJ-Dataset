import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String... args) {
        Scanner cin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int N = cin.nextInt();
            int[][] as = new int[N][3];
            for(int j = 0;j < N;j++) {
                as[j][0] = cin.nextInt();
                as[j][1] = cin.nextInt();
                as[j][2] = j;
            }
            System.out.println(String.format("Case #%d: %s", i + 1, solve(as)));
        }
    }

    public static String solve(int[][] activities) {
        Arrays.sort(activities, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        char[] arrange = new char[activities.length];
        int cEnd = 0, jEnd = 0;
        for(int i = 0;i < activities.length;i++) {
            if(activities[i][0] >= cEnd) {
                arrange[activities[i][2]] = 'C';
                cEnd = activities[i][1];
            } else if(activities[i][0] >= jEnd) {
                arrange[activities[i][2]] = 'J';
                jEnd = activities[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(arrange);
    }
}
