import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Job> jobs = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                jobs.add(new Job(i, start, end));
            }
            
            jobs.sort(Comparator.comparingInt(job -> job.start));
            
            int cEnd = 0, jEnd = 0;
            boolean isValid = true;
            
            for (Job job : jobs) {
                if (cEnd <= jEnd) {
                    if (cEnd <= job.start) {
                        cEnd = job.end;
                        job.assigned = 'C';
                    } else if (jEnd <= job.start) {
                        jEnd = job.end;
                        job.assigned = 'J';
                    } else {
                        isValid = false;
                        break;
                    }
                } else {
                    if (jEnd <= job.start) {
                        jEnd = job.end;
                        job.assigned = 'J';
                    } else if (cEnd <= job.start) {
                        cEnd = job.end;
                        job.assigned = 'C';
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            
            String result = isValid ? getResultString(jobs) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s%n", t, result);
        }
    }
    
    private static String getResultString(List<Job> jobs) {
        jobs.sort(Comparator.comparingInt(job -> job.index));
        StringBuilder sb = new StringBuilder();
        for (Job job : jobs) {
            sb.append(job.assigned);
        }
        return sb.toString();
    }
}

class Job {
    int index;
    int start;
    int end;
    char assigned;
    
    Job(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }
}