import java.util.*;
import java.io.*;
public class Solution {
    static StringBuilder answer;
    public static boolean findScheduling(int[][] schedule, int index, int c, int j, HashMap<String, Boolean> dp, StringBuilder ans) {
        if(index == schedule.length) {
            answer = new StringBuilder(ans);
            return true;
        }

        String str = c + "$" + j + "$" + index;
        if(dp.containsKey(str))
            return dp.get(str);

        if(c <= schedule[index][0]) {
            ans.append('C');
            boolean possible = findScheduling(schedule, index + 1, schedule[index][1], j, dp, ans);
            ans.deleteCharAt(ans.length()-1);
            if(possible)
                return true;
        }
        if(j <= schedule[index][0]) {
            ans.append('J');
            boolean possible = findScheduling(schedule, index + 1, c, schedule[index][1], dp, ans);
            ans.deleteCharAt(ans.length()-1);
            if(possible)
                return true;
        }
        dp.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            Arrays.sort(arr, (int[] a1, int[] a2) -> {
                if(a1[0] == a2[0])
                    return a1[1] - a2[1];
                return a1[0] - a2[0];
            });

            boolean possible = findScheduling(arr, 0, 0, 0, new HashMap<String, Boolean>(), new StringBuilder());

            if(!possible)
                answer = new StringBuilder("IMPOSSIBLE");
            System.out.println("Case #" + k + ": " + answer);
        }
    }
}