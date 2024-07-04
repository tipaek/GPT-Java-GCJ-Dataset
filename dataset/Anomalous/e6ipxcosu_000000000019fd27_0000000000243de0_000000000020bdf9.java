import java.util.Scanner;

public class Solution {
    public static class Task {
        int start;
        int end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= testCases; i++) {
            int numTasks = Integer.parseInt(scanner.nextLine());
            Task[] tasks = new Task[numTasks];

            for (int j = 0; j < numTasks; j++) {
                String[] taskDetails = scanner.nextLine().split(" ");
                Task task = new Task();
                task.start = Integer.parseInt(taskDetails[0]);
                task.end = Integer.parseInt(taskDetails[1]);
                tasks[j] = task;
            }

            boolean[] filledC = new boolean[24 * 60 + 1];
            boolean[] filledJ = new boolean[24 * 60 + 1];
            boolean possible = false;

            for (int j = 0; j < (1 << numTasks); j++) {
                possible = true;
                for (int k = 0; k <= 24 * 60; k++) {
                    filledC[k] = false;
                    filledJ[k] = false;
                }

                int assignment = j;
                for (int l = 0; l < numTasks; l++) {
                    Task task = tasks[l];
                    if ((assignment & (1 << l)) == 0) {
                        for (int t = task.start; t < task.end; t++) {
                            if (filledC[t]) {
                                possible = false;
                                break;
                            }
                            filledC[t] = true;
                        }
                    } else {
                        for (int t = task.start; t < task.end; t++) {
                            if (filledJ[t]) {
                                possible = false;
                                break;
                            }
                            filledJ[t] = true;
                        }
                    }
                    if (!possible) break;
                }

                if (possible) {
                    StringBuilder schedule = new StringBuilder();
                    assignment = j;
                    for (int l = 0; l < numTasks; l++) {
                        if ((assignment & (1 << l)) == 0) {
                            schedule.append("J");
                        } else {
                            schedule.append("C");
                        }
                    }
                    System.out.println("Case #" + i + ": " + schedule);
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}