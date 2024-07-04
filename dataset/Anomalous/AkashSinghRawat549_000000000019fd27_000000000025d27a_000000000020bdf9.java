import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();
        ArrayList<String> results = new ArrayList<>();
        Solution solution = new Solution();

        for (int i = 0; i < cases; i++) {
            int taskCount = scanner.nextInt();
            int[][] tasks = new int[taskCount][2];

            for (int j = 0; j < taskCount; j++) {
                tasks[j][0] = scanner.nextInt();
                tasks[j][1] = scanner.nextInt();
                scanner.nextLine();
            }

            HashMap<Integer, String> assignments = new HashMap<>();
            for (int k = 0; k < taskCount; k++) {
                assignments.put(k, "C");
            }

            boolean impossible = false;

            for (int j = 1; j < taskCount && !impossible; j++) {
                int[] currentTask = tasks[j];

                for (int k = 0; k < j; k++) {
                    int[] previousTask = tasks[k];

                    if (solution.isOverlap(currentTask, previousTask) && assignments.get(k).equals(assignments.get(j))) {
                        assignments.put(j, solution.switchAssignment(assignments.get(j)));

                        for (int l = 0; l < j; l++) {
                            int[] checkTask = tasks[l];

                            if (solution.isOverlap(checkTask, currentTask) && assignments.get(j).equals(assignments.get(l))) {
                                impossible = true;
                                assignments.put(0, "IMPOSSIBLE");
                                for (int m = 1; m < taskCount; m++) {
                                    assignments.put(m, "");
                                }
                                break;
                            }
                        }
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (int k = 0; k < taskCount; k++) {
                output.append(assignments.get(k));
            }
            results.add(output.toString());
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    public String switchAssignment(String assignment) {
        return assignment.equals("C") ? "J" : "C";
    }

    public boolean isOverlap(int[] task1, int[] task2) {
        return !(task1[1] <= task2[0] || task2[1] <= task1[0]);
    }
}