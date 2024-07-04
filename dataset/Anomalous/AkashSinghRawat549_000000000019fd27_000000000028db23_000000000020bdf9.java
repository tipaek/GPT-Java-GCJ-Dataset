import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        ArrayList<String> results = new ArrayList<>();
        Solution sol = new Solution();

        for (int i = 0; i < cases; i++) {
            int taskCount = sc.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }

            HashMap<Integer, String> schedule = new HashMap<>();
            for (int j = 0; j < taskCount; j++) {
                schedule.put(j, "C");
            }

            int minStartTime = tasks[0][0];
            int minIndex = 0;
            for (int j = 1; j < taskCount; j++) {
                if (tasks[j][0] < minStartTime) {
                    minStartTime = tasks[j][0];
                    minIndex = j;
                }
            }

            boolean impossible = false;
            schedule.put(minIndex, "C");
            schedule.put(0, "C");

            for (int j = 1; j < taskCount; j++) {
                int[] currentTask = tasks[j];
                for (int k = 0; k < j; k++) {
                    int[] previousTask = tasks[k];
                    if (sol.isOverlap(currentTask, previousTask) && schedule.get(k).equals(schedule.get(j))) {
                        schedule.put(j, sol.switchPerson(schedule.get(j)));
                        for (int l = 0; l < j; l++) {
                            int[] checkTask = tasks[l];
                            if (sol.isOverlap(checkTask, currentTask) && schedule.get(j).equals(schedule.get(l))) {
                                impossible = true;
                                schedule.put(0, "IMPOSSIBLE");
                                for (int m = 1; m < taskCount; m++) {
                                    schedule.put(m, "");
                                }
                                break;
                            }
                        }
                    }
                }
            }

            if (!schedule.get(0).equals("IMPOSSIBLE") && schedule.get(minIndex).equals("J")) {
                for (int j = 0; j < taskCount; j++) {
                    schedule.put(j, sol.switchPerson(schedule.get(j)));
                }
            }

            StringBuilder output = new StringBuilder();
            for (int j = 0; j < taskCount; j++) {
                output.append(schedule.get(j));
            }

            results.add(output.toString());
        }

        sc.close();
        for (int i = 0; i < cases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    public String switchPerson(String person) {
        return person.equals("C") ? "J" : "C";
    }

    public boolean isOverlap(int[] task1, int[] task2) {
        return !(task1[1] <= task2[0] || task2[1] <= task1[0]);
    }
}