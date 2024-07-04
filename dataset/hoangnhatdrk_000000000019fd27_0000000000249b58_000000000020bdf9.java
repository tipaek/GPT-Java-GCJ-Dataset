import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] tasks = new int[n][3];
            for (int j = 1; j<=n; j++) {
                tasks[j-1][0] = j;
                tasks[j-1][1] = in.nextInt();
                tasks[j-1][2] = in.nextInt();
            }
            System.out.println("Case #"+i+": "+parenting(tasks));
        }
    }

    private static String parenting(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int[] end = {0,0};
        char[] assign = new char[tasks.length];
        for (int i = 1; i<=tasks.length; i++) {
            int[] curTask = tasks[i-1];
            if (curTask[1]>=end[0]) {
                assign[curTask[0]-1] = 'C';
                end[0] = curTask[2];
            } else if (curTask[1]>=end[1]){
                assign[curTask[0]-1] = 'J';
                end[1] = curTask[2];
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=tasks.length; i++) {
            sb.append(assign[i-1]);
        }
        return sb.toString();
    }
}