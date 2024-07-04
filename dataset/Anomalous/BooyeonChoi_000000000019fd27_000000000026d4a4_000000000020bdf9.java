import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(reader.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numTests = Integer.parseInt(reader.readLine());
            int[][] tasks = new int[numTests][3];
            String[] result = new String[numTests];

            for (int i = 0; i < numTests; i++) {
                String[] times = reader.readLine().split(" ");
                tasks[i][0] = Integer.parseInt(times[0]);
                tasks[i][1] = Integer.parseInt(times[1]);
                tasks[i][2] = i;
            }

            Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

            TreeSet<Integer> jSet = new TreeSet<>();
            TreeSet<Integer> cSet = new TreeSet<>();
            boolean isPossible = true;

            for (int[] task : tasks) {
                int start = task[0];
                int end = task[1];
                int index = task[2];

                if (canAssign(jSet, start, end)) {
                    assignTask(jSet, start, end);
                    result[index] = "J";
                } else if (canAssign(cSet, start, end)) {
                    assignTask(cSet, start, end);
                    result[index] = "C";
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.printf("Case #%d: %s\n", caseNum, String.join("", result));
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNum);
            }
        }

        reader.close();
    }

    private static boolean canAssign(TreeSet<Integer> set, int start, int end) {
        Integer floor = set.floor(start);
        Integer ceiling = set.ceiling(start);
        return (floor == null || floor < start) && (ceiling == null || ceiling >= end);
    }

    private static void assignTask(TreeSet<Integer> set, int start, int end) {
        for (int i = start; i < end; i++) {
            set.add(i);
        }
    }
}