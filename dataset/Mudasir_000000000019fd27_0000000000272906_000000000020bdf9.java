import java.util.*;
import java.io.*;

public class Solution {


    public static final String IMPOSSIBLE = "IMPOSSIBLE";
    static final String CASE_HEAD = "Case #";
    static final String SEP = ": ";

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        PriorityQueue<Integer[]> activityQueue = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
        char[] sequence = null;
        int[] freeUntil = null;
        char[] workers = {'C', 'J'};
        boolean isImpossible = false;
        StringBuilder result = null;
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            sequence = new char[n];
            freeUntil = new int[]{-1, -1};
            isImpossible = false;
            result = new StringBuilder(CASE_HEAD).append(i).append(SEP);
            for (Integer j = 0; j < n; j++) {
                activityQueue.offer(new Integer[]{in.nextInt(), in.nextInt(), j});
            }

            while (!activityQueue.isEmpty()) {
                Integer[] activity = activityQueue.poll();
                if (freeUntil[0] == -1 || freeUntil[0] <= activity[0]) {
                    freeUntil[0] = activity[1];
                    sequence[activity[2]] = workers[0];
                } else if (freeUntil[1] == -1 || freeUntil[1] <= activity[0]) {
                    freeUntil[1] = activity[1];
                    sequence[activity[2]] = workers[1];
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible)
                System.out.println(result.append(IMPOSSIBLE));
            else
                System.out.println(result.append(sequence));

        }


    }

}
