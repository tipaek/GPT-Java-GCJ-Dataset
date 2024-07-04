import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            handleInput(reader);
        }
    }

    private static class InputData {
        int numTasks;
        int[] startTimes, endTimes;

        public InputData(BufferedReader reader) throws IOException {
            numTasks = Integer.parseInt(reader.readLine());
            startTimes = new int[numTasks];
            endTimes = new int[numTasks];
            for (int i = 0; i < numTasks; i++) {
                String[] times = reader.readLine().split(" ");
                startTimes[i] = Integer.parseInt(times[0]);
                endTimes[i] = Integer.parseInt(times[1]);
            }
        }
    }

    private static class Result {
        String result;

        public Result(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return result;
        }
    }

    public static void handleInput(BufferedReader reader) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(new InputData(reader)));
        }
    }

    static Result solve(InputData inputData) {
        PriorityQueue<int[]> eventsQueue = new PriorityQueue<>(Comparator.<int[]>comparingInt(event -> event[0])
                .thenComparing(event -> event[1]));
        char[] taskAssignments = new char[inputData.numTasks];
        String workers = "CJ";
        boolean[] workerBusy = new boolean[workers.length()];

        for (int i = 0; i < inputData.numTasks; i++) {
            eventsQueue.add(new int[]{inputData.endTimes[i], 0, i});
            eventsQueue.add(new int[]{inputData.startTimes[i], 1, i});
        }

        int concurrentTasks = 0;
        while (!eventsQueue.isEmpty()) {
            int[] event = eventsQueue.poll();
            if (event[1] == 0) {
                concurrentTasks--;
                workerBusy[workers.indexOf(taskAssignments[event[2]])] = false;
            } else {
                concurrentTasks++;
                if (concurrentTasks == 3) {
                    return new Result("IMPOSSIBLE");
                }
                for (int i = 0; i < workerBusy.length; i++) {
                    if (!workerBusy[i]) {
                        taskAssignments[event[2]] = workers.charAt(i);
                        workerBusy[i] = true;
                        break;
                    }
                }
            }
        }
        return new Result(new String(taskAssignments));
    }
}