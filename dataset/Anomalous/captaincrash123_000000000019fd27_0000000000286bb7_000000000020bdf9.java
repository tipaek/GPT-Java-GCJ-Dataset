import java.util.*;
import java.io.*;

public class ParentingTwo {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] startingTimes = new int[n];
            int[] endingTimes = new int[n];
            Task[] tasks = new Task[n];
            
            for (int j = 0; j < n; j++) {
                startingTimes[j] = in.nextInt();
                endingTimes[j] = in.nextInt();
                tasks[j] = new Task(startingTimes[j], endingTimes[j], j);
            }
            
            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));
            
            int[] time = new int[1441];
            char[] assignments = new char[n];
            boolean possible = true;
            int threeCounter = 0;
            
            for (Task task : tasks) {
                for (int k = task.start; k <= task.end && possible; k++) {
                    time[k]++;
                    if (time[k] == 3) {
                        if (threeCounter == 1) {
                            possible = false;
                        } else {
                            threeCounter = 1;
                        }
                    } else if (threeCounter == 1) {
                        threeCounter = 0;
                    }
                }
            }
            
            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i + 1);
            } else {
                char[] sortedAssignments = new char[n];
                sortedAssignments[0] = 'J';
                
                for (int j = 1; j < n; j++) {
                    boolean assigned = false;
                    for (int k = 0; k < j; k++) {
                        if (tasks[j].start >= tasks[k].end) {
                            sortedAssignments[j] = sortedAssignments[k];
                            assigned = true;
                            break;
                        }
                    }
                    if (!assigned) {
                        sortedAssignments[j] = (sortedAssignments[j - 1] == 'J') ? 'C' : 'J';
                    }
                }
                
                for (int j = 0; j < n; j++) {
                    assignments[tasks[j].index] = sortedAssignments[j];
                }
                
                System.out.printf("Case #%d: ", i + 1);
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        
        in.close();
    }
    
    static class Task {
        int start;
        int end;
        int index;
        
        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}