import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            char [] output = new char[N];
            int cameronOccupied = 0;
            int jamieOccupied = 0;
            boolean isPossible = true;
            Integer[][] activities = new Integer[N][3];
            for (int i = 0; i < N; i++) {
                activities[i][0] = in.nextInt();
                activities[i][1] = in.nextInt();
                activities[i][2] = i;
            }
            Arrays.sort(activities, Comparator.comparing(a -> a[0]));
            for (int i = 0; i < N && isPossible; i++) {
                int start = activities[i][0];
                int finish = activities[i][1];
                if (start >= cameronOccupied) {
                    cameronOccupied = finish;
                    output[activities[i][2]] = 'C';
                } else if (start >= jamieOccupied) {
                    jamieOccupied = finish;
                    output[activities[i][2]] = 'J';
                } else {
                    output = "IMPOSSIBLE".toCharArray();
                    isPossible = false;
                }
            }
            System.out.println(String.format("Case #%s: %s", caseIndex, String.valueOf(output)));
        }
    }
}