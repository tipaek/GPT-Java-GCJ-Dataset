import java.lang.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Case[] cases = null;
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            cases = new Case[T];
            for (int t = 0; t < T; ++t) {
                int N = sc.nextInt();
                int[][] jobs = new int[N][2];
                for (int i = 0; i < N * 2; ++i) {
                    jobs[i][0] = sc.nextInt();
                    jobs[i][1] = sc.nextInt();
                }
                cases[t] = new Case(jobs);
            }
        }
        
        for (int i = 0; i < cases.length; ++i) {
            String result = cases[i].solve();
            System.out.println("Case #" + (i + 1) + ": " + result);    
        }
    }

    private static class Case {
        int[][] jobs;
        TreeMap<Integer, Event> events = new TreeMap<>();
        
        public Case(int[][] jobs) {
            this.jobs = jobs;
            for (int i = 0; i < jobs.length; ++i) {
                int[] job = jobs[i];
                int start = job[0];
                int end = job[1];
                Event e1 = events.getOrDefault(start, new Event());
                e1.jobStarts.add(i);
                events.put(start, e1);
                
                Event e2 = events.getOrDefault(end, new Event());
                e2.jobEnds.add(i);
                events.put(end, e2);
            }
        }
        
        public String solve() {
            int[] jobToWorker = new int[jobs.length];
            int[] workersLoad = new int[2]; // 0 - C, 1 - J
            
            for (Event e : events.values()) {
                for (int job : e.jobEnds) {
                    // Free worker from job
                    int w = jobToWorker[job];
                    workersLoad[w] = -1;
                }
                for (int job : e.jobStarts) {
                    // Find free worker w
                    // Assign worker w to job
                    // Or return IMPOSSIBLE
                    int w = -1;
                    for (int i = 0; i < workersLoad.length; ++i) {
                        if (workersLoad[i] == 0) {
                            w = i;
                            break;
                        }
                    }
                    if (w == -1) {
                        return "IMPOSSIBLE";
                    }
                    workersLoad[w] += 1;
                    jobToWorker[job] = w;
                }
            }
            StringBuffer res = new StringBuffer();
            for (int w : jobToWorker) {
                res.append(w == 0 ? 'C' : 'J');
            }
            return res.toString();
        }
        
        private static class Event {
            public final Set<Integer> jobStarts = new HashSet<>();
            public final Set<Integer> jobEnds = new HashSet<>();
        }
    }
    
    
}