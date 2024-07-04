import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int tc = 1; tc <= testCases; tc++) {
            int n = scanner.nextInt();
            Job[] jobs = new Job[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                jobs[i] = new Job(start, end, i);
            }
            
            Arrays.sort(jobs);
            char[] assignedWorkers = new char[n];
            int[] workerEndTimes = new int[2]; // [0] for Cameron, [1] for Jamie
            String result = "";
            
            for (int i = 0; i < n; i++) {
                boolean assigned = false;
                
                for (int j = 0; j < 2; j++) {
                    if (workerEndTimes[j] <= jobs[i].start) {
                        workerEndTimes[j] = jobs[i].end;
                        assignedWorkers[jobs[i].index] = (j == 0) ? 'C' : 'J';
                        assigned = true;
                        break;
                    }
                }
                
                if (!assigned) {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            if (result.isEmpty()) {
                result = new String(assignedWorkers);
            }
            
            System.out.printf("Case #%d: %s%n", tc, result);
        }
        
        scanner.close();
    }
}

class Job implements Comparable<Job> {
    int start, end, index;
    
    Job(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
    
    @Override
    public int compareTo(Job other) {
        if (this.start != other.start) {
            return this.start - other.start;
        }
        return this.end - other.end;
    }
}