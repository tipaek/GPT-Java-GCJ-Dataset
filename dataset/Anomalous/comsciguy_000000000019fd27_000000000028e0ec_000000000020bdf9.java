import java.util.*;
import java.io.*;

public class ParentingPartneringReturns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine());
            List<Job> jobs = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                jobs.add(new Job(start, end, i));
            }
            
            Collections.sort(jobs);
            boolean[] cSchedule = new boolean[24 * 60];
            boolean[] jSchedule = new boolean[24 * 60];
            char[] result = new char[n];
            boolean impossible = false;
            
            for (Job job : jobs) {
                if (canSchedule(job, cSchedule)) {
                    fillSchedule(job, cSchedule);
                    result[job.index] = 'C';
                } else if (canSchedule(job, jSchedule)) {
                    fillSchedule(job, jSchedule);
                    result[job.index] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t + 1);
            } else {
                System.out.printf("Case #%d: %s\n", t + 1, new String(result));
            }
        }
        
        reader.close();
    }
    
    private static boolean canSchedule(Job job, boolean[] schedule) {
        for (int i = job.start; i < job.end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static void fillSchedule(Job job, boolean[] schedule) {
        Arrays.fill(schedule, job.start, job.end, true);
    }
}

class Job implements Comparable<Job> {
    int start;
    int end;
    int index;
    
    public Job(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
    
    @Override
    public int compareTo(Job other) {
        if (this.start == other.start) {
            return this.end - other.end;
        }
        return this.start - other.start;
    }
}