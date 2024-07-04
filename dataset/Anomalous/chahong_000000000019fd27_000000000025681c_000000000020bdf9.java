import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int[][] schedule = new int[t][2];
            Map<Integer, Integer> dict = new HashMap<>();

            for (int j = 0; j < t; j++) {
                schedule[j][0] = sc.nextInt();
                schedule[j][1] = sc.nextInt();
                dict.put(schedule[j][0], j);
            }

            Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

            char[] work = new char[t];
            int cEndTime = 0, jEndTime = 0;
            boolean possible = true;

            for (int j = 0; j < t; j++) {
                int start = schedule[j][0];
                int end = schedule[j][1];
                int originalIndex = dict.get(start);

                if (start >= cEndTime) {
                    work[originalIndex] = 'C';
                    cEndTime = end;
                } else if (start >= jEndTime) {
                    work[originalIndex] = 'J';
                    jEndTime = end;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(work) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        sc.close();
    }
}