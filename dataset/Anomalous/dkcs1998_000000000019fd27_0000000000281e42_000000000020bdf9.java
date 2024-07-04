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
        int type;

        Job(int time, int type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public String toString() {
            return (type == 0 ? "Starting job at " : "Ending job at ") + time;
        }
    }

    static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            if (o1.time != o2.time) {
                return Integer.compare(o1.time, o2.time);
            } else {
                return Integer.compare(o2.type, o1.type);
            }
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = 1;

        while (caseNumber <= t) {
            HashMap<Integer, Integer> jobMap = new HashMap<>();
            PriorityQueue<Job> jobQueue = new PriorityQueue<>(new JobComparator());
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                jobQueue.add(new Job(start, 0));
                jobQueue.add(new Job(end, 1));
                jobMap.put(start, end);
            }

            HashMap<Integer, Integer> activeJobs = new HashMap<>();
            int[] workers = new int[2];
            StringBuilder result = new StringBuilder();
            char[] workerNames = {'C', 'J'};
            boolean isPossible = true;

            while (!jobQueue.isEmpty() && isPossible) {
                Job currentJob = jobQueue.poll();

                if (currentJob.type == 1) {
                    if (activeJobs.containsKey(currentJob.time)) {
                        int workerIndex = activeJobs.get(currentJob.time);
                        workers[workerIndex] = 0;
                        activeJobs.remove(currentJob.time);
                    }
                } else {
                    if (workers[0] == 0) {
                        result.append(workerNames[0]);
                        activeJobs.put(jobMap.get(currentJob.time), 0);
                        workers[0] = 1;
                    } else if (workers[1] == 0) {
                        result.append(workerNames[1]);
                        activeJobs.put(jobMap.get(currentJob.time), 1);
                        workers[1] = 1;
                    } else {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
    }
}