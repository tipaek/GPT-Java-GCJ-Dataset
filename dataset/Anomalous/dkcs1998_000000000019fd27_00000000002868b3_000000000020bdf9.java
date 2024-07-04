import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        boolean isEnd;
        Id jobId;

        Job(Id id, int time, boolean isEnd) {
            this.jobId = id;
            this.time = time;
            this.isEnd = isEnd;
        }

        @Override
        public String toString() {
            return (isEnd ? "Ending" : "Starting") + " job at " + time;
        }
    }

    static class Id {

        int startTime;
        int id;

        Id(int startTime, int id) {
            this.startTime = startTime;
            this.id = id;
        }
    }

    static class JobComparator implements Comparator<Job> {

        @Override
        public int compare(Job j1, Job j2) {
            if (j1.jobId.startTime != j2.jobId.startTime) {
                return Integer.compare(j1.jobId.startTime, j2.jobId.startTime);
            }
            return Boolean.compare(j1.isEnd, j2.isEnd);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = sc.nextInt();
            PriorityQueue<Job> jobQueue = new PriorityQueue<>(new JobComparator());
            Map<Id, Id> jobMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                Id startId = new Id(start, i);
                Id endId = new Id(end, i);
                jobQueue.add(new Job(startId, start, false));
                jobQueue.add(new Job(endId, end, true));
                jobMap.put(startId, endId);
            }

            Map<Integer, Integer> activeJobs = new HashMap<>();
            int[] workers = new int[2];
            char[] result = new char[n];
            boolean isPossible = true;

            while (!jobQueue.isEmpty() && isPossible) {
                Job currentJob = jobQueue.poll();

                if (currentJob.isEnd) {
                    int workerIndex = activeJobs.get(currentJob.jobId.startTime);
                    workers[workerIndex] = 0;
                    activeJobs.remove(currentJob.jobId.startTime);
                } else {
                    if (workers[0] == 0) {
                        result[currentJob.jobId.id] = 'C';
                        activeJobs.put(jobMap.get(currentJob.jobId).startTime, 0);
                        workers[0] = 1;
                    } else if (workers[1] == 0) {
                        result[currentJob.jobId.id] = 'J';
                        activeJobs.put(jobMap.get(currentJob.jobId).startTime, 1);
                        workers[1] = 1;
                    } else {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNum + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}