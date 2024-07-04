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

            int minStart = tasks[0][0];
            int minIndex = 0;
            for (int j = 1; j < taskCount; j++) {
                if (minStart > tasks[j][0]) {
                    minStart = tasks[j][0];
                    minIndex = j;
                }
            }

            boolean impossible = false;

            for (int j = 1; j < taskCount; j++) {
                for (int k = 0; k < j; k++) {
                    if (sol.isOverlap(tasks[j], tasks[k]) && schedule.get(j).equals(schedule.get(k))) {
                        schedule.put(j, sol.switchSchedule(schedule.get(j)));
                        for (int l = 0; l < j; l++) {
                            if (sol.isOverlap(tasks[l], tasks[j]) && schedule.get(j).equals(schedule.get(l))) {
                                impossible = true;
                                schedule.put(0, "IMPOSSIBLE");
                                break;
                            }
                        }
                        if (impossible) break;
                    }
                }
                if (impossible) break;
            }

            if (!schedule.get(minIndex).equals("IMPOSSIBLE")) {
                if (schedule.get(minIndex).equals("J")) {
                    for (int j = 0; j < taskCount; j++) {
                        schedule.put(j, sol.switchSchedule(schedule.get(j)));
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (int j = 0; j < taskCount; j++) {
                if (!schedule.get(0).equals("IMPOSSIBLE")) {
                    output.append(schedule.get(j));
                } else {
                    output.append(schedule.get(0));
                    break;
                }
            }
            results.add("Case #" + (i + 1) + ": " + output.toString());
        }

        results.forEach(System.out::println);
        sc.close();
    }

    public String switchSchedule(String current) {
        return current.equals("C") ? "J" : "C";
    }

    public boolean isOverlap(int[] a, int[] b) {
        return !(a[1] <= b[0] || b[1] <= a[0]);
    }
}