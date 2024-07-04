import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            Activity[] activities = new Activity[N];
            Activity[] originalOrder = new Activity[N];
            
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
                originalOrder[i] = new Activity(start, end);
            }
            
            Arrays.sort(activities);
            int[] assignment = new int[N];
            int[] endTimes = new int[2];
            boolean feasible = true;
            
            for (int i = 0; i < N; i++) {
                boolean assigned = false;
                for (int j = 0; j < 2; j++) {
                    if (endTimes[j] <= activities[i].start) {
                        assignment[i] = j;
                        endTimes[j] = activities[i].end;
                        assigned = true;
                        break;
                    }
                }
                if (!assigned) {
                    feasible = false;
                    break;
                }
            }
            
            if (feasible) {
                System.out.print("Case #" + caseNumber + ": ");
                boolean[] used = new boolean[N];
                
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!used[j] && originalOrder[i].equals(activities[j])) {
                            System.out.print(assignment[j] == 0 ? "C" : "J");
                            used[j] = true;
                            break;
                        }
                    }
                }
                System.out.println();
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber));
            }
        }
    }
}

class Activity implements Comparable<Activity> {
    int start;
    int end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Activity activity = (Activity) obj;
        return start == activity.start && end == activity.end;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}