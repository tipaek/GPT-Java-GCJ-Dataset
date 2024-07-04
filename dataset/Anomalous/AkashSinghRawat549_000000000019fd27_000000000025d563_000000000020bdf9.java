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

        for (int i = 0; i < cases; i++) {
            int taskCount = sc.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = sc.nextInt();
                tasks[j][1] = sc.nextInt();
            }

            String result = assignTasks(tasks);
            results.add(result);
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }

        sc.close();
    }

    private static String assignTasks(int[][] tasks) {
        HashMap<Integer, String> assignments = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            assignments.put(i, "C");
        }

        for (int i = 1; i < tasks.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isOverlap(tasks[i], tasks[j]) && assignments.get(i).equals(assignments.get(j))) {
                    assignments.put(i, switchAssignment(assignments.get(i)));

                    for (int k = 0; k < i; k++) {
                        if (isOverlap(tasks[k], tasks[i]) && assignments.get(i).equals(assignments.get(k))) {
                            return "IMPOSSIBLE";
                        }
                    }
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < tasks.length; i++) {
            output.append(assignments.get(i));
        }

        return output.toString();
    }

    private static String switchAssignment(String current) {
        return current.equals("C") ? "J" : "C";
    }

    private static boolean isOverlap(int[] a, int[] b) {
        return (a[0] < b[1] && a[1] > b[0]);
    }
}