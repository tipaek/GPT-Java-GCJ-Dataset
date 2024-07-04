import java.io.*;
import java.util.*;

class Pair {
    int start;
    int finish;

    Pair(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class Solution {
    public static String assignJobs(List<Pair> jobs) {
        List<Pair> originalJobs = new ArrayList<>(jobs);
        jobs.sort(Comparator.comparingInt(job -> job.start));

        StringBuilder schedule = new StringBuilder();
        boolean cAvailable = true, jAvailable = true;
        int cEndTime = -1, jEndTime = -1;
        Map<Pair, Character> jobAssignment = new HashMap<>();

        for (Pair job : jobs) {
            if (cAvailable || cEndTime <= job.start) {
                cEndTime = job.finish;
                cAvailable = true;
                jobAssignment.put(job, 'C');
            } else if (jAvailable || jEndTime <= job.start) {
                jEndTime = job.finish;
                jAvailable = true;
                jobAssignment.put(job, 'J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (Pair job : originalJobs) {
            schedule.append(jobAssignment.get(job));
        }

        return schedule.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int jobCount = Integer.parseInt(reader.readLine());
            List<Pair> jobs = new ArrayList<>();

            for (int i = 0; i < jobCount; i++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int finish = Integer.parseInt(times[1]);
                jobs.add(new Pair(start, finish));
            }

            String result = assignJobs(jobs);
            writer.write("Case #" + t + ": " + result + "\n");
        }

        writer.flush();
    }
}