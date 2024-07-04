import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int testCaseCount = Integer.parseInt(scanner.nextLine());
            for (int testCase = 0; testCase < testCaseCount; testCase++) {
                int intervalCount = Integer.parseInt(scanner.nextLine());
                int[][] intervals = new int[intervalCount][3];
                for (int i = 0; i < intervalCount; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    scanner.nextLine();
                    intervals[i][0] = start;
                    intervals[i][1] = end;
                    intervals[i][2] = i;
                }
                Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

                char[] assignedTasks = new char[intervalCount];
                String result = "";
                PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
                char[] workers = {'C', 'J'};
                int currentWorker = 0;

                for (int i = 0; i < intervalCount; i++) {
                    if (result.equals("IMPOSSIBLE")) {
                        scanner.nextLine();
                        continue;
                    }
                    if (priorityQueue.isEmpty()) {
                        priorityQueue.add(new int[]{intervals[i][1], currentWorker, intervals[i][2]});
                    } else {
                        if (intervals[i][0] < priorityQueue.peek()[0]) {
                            if (priorityQueue.size() == 2) {
                                result = "IMPOSSIBLE";
                                continue;
                            }
                            currentWorker = (priorityQueue.peek()[1] + 1) % 2;
                            priorityQueue.add(new int[]{intervals[i][1], currentWorker, intervals[i][2]});
                        } else {
                            while (!priorityQueue.isEmpty() && intervals[i][0] >= priorityQueue.peek()[0]) {
                                int[] finishedTask = priorityQueue.poll();
                                currentWorker = finishedTask[1];
                                assignedTasks[finishedTask[2]] = workers[currentWorker];
                            }
                            priorityQueue.add(new int[]{intervals[i][1], currentWorker, intervals[i][2]});
                        }
                    }
                }

                if (!result.equals("IMPOSSIBLE")) {
                    while (!priorityQueue.isEmpty()) {
                        int[] finishedTask = priorityQueue.poll();
                        currentWorker = finishedTask[1];
                        assignedTasks[finishedTask[2]] = workers[currentWorker];
                    }
                    result = new String(assignedTasks);
                }

                System.out.println("Case #" + (testCase + 1) + ": " + result + "\n");
            }
        }
    }
}