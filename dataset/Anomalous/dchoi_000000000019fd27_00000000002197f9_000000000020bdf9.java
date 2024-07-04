import java.io.*;
import java.util.*;

public class Solution {

    public static class Job {
        char worker;
        int startTime;
        int endTime;

        Job(char worker, int startTime, int endTime) {
            this.worker = worker;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            Stack<Character> workers = new Stack<>();
            workers.push('J');
            workers.push('C');
            List<Job> inProgress = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder workerOrder = new StringBuilder();

            for (int index = 0; index < N; index++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();
                
                // Here is where you would process the job scheduling logic.
                // This is a placeholder to keep the structure intact.
                Job job = new Job('C', startTime, endTime);
                // Add your logic to handle job assignments and conflicts here.
            }

            String result = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();
            String output = "Case #" + test_case + ": " + result;
            System.out.println(output);
        }
    }
}