import java.io.*;
import java.util.*;

public class Solution {

    public static class Job {
        char worker;
        int startTime;
        int endTime;

        public Job(char worker, int startTime, int endTime) {
            this.worker = worker;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int jobCount = scanner.nextInt();

            Stack<Character> availableWorkers = new Stack<>();
            availableWorkers.push('J');
            availableWorkers.push('C');
            List<Job> ongoingJobs = new ArrayList<>();
            boolean impossible = false;
            StringBuilder assignmentOrder = new StringBuilder();

            for (int i = 0; i < jobCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                new Job('C', start, end); // This line seems to be a placeholder and isn't used
            }

            String result = impossible ? "IMPOSSIBLE" : assignmentOrder.toString();

            System.out.print("Case #" + testCase + ": " + result + "\n");
        }
    }
}