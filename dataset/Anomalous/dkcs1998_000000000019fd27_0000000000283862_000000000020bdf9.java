import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Solution {
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Job {
        int time;
        int type; // 0 for start, 1 for end

        Job(int time, int type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public String toString() {
            return type == 0 ? "Starting job at " + time : "Ending job at " + time;
        }
    }

    static class JobComparator implements Comparator<Job> {
        public int compare(Job j1, Job j2) {
            if (j1.time != j2.time) {
                return Integer.compare(j1.time, j2.time);
            }
            return Integer.compare(j2.type, j1.type); // End jobs come before start jobs if times are the same
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = 1;

        while (caseNumber <= t) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> jobEndTimes = new HashMap<>();
            HashMap<Integer, Integer> jobIndices = new HashMap<>();
            PriorityQueue<Job> jobQueue = new PriorityQueue<>(new JobComparator());

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                jobQueue.add(new Job(start, 0));
                jobQueue.add(new Job(end, 1));
                jobEndTimes.put(start, end);
                jobIndices.put(start, i);
            }

            HashMap<Integer, Integer> activeJobs = new HashMap<>();
            int[] workers = new int[2];
            char[] result = new char[n];
            char[] workersChar = {'C', 'J'};
            boolean isPossible = true;

            while (!jobQueue.isEmpty()) {
                Job job = jobQueue.poll();
                if (job.type == 1) {
                    int worker = activeJobs.get(job.time);
                    workers[worker] = 0;
                    activeJobs.remove(job.time);
                } else {
                    if (workers[0] == 0) {
                        result[jobIndices.get(job.time)] = workersChar[0];
                        activeJobs.put(jobEndTimes.get(job.time), 0);
                        workers[0] = 1;
                    } else if (workers[1] == 0) {
                        result[jobIndices.get(job.time)] = workersChar[1];
                        activeJobs.put(jobEndTimes.get(job.time), 1);
                        workers[1] = 1;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
    }
}