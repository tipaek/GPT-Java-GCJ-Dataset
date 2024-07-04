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

            Stack<Character> workers = new Stack<>(); // the two parents: Cameron, Jamie
            workers.push('J');
            workers.push('C');
            List<Job> inProgress = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder workerOrder = new StringBuilder();

            for (int index = 0; index < N; index++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                // check and remove completed jobs
                for (int i = 0; i < inProgress.size(); i++) {
                    Job j = inProgress.get(i);
                    if (j.endTime <= startTime || endTime <= j.startTime) {
                        inProgress.remove(j);
                        workers.push(j.worker);
                    }
                }
            }

            String s = isImpossible ? "IMPOSSIBLE" : workerOrder.toString();

            String line = "Case #" + test_case + ": " + s + "\n";
            System.out.print(line);
        }
    }
}
