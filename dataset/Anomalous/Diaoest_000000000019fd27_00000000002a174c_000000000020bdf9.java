import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int numCases = Integer.parseInt(scanner.nextLine());

            for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
                int n = Integer.parseInt(scanner.nextLine());
                int[][] intervals = new int[n][3];

                for (int i = 0; i < n; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    scanner.nextLine();
                    intervals[i][0] = start;
                    intervals[i][1] = end;
                    intervals[i][2] = i;
                }

                Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

                char[] assigned = new char[n];
                String result = "";
                PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
                char[] options = new char[] {'C', 'J'};
                int currentPerson = 0;

                for (int i = 0; i < n; i++) {
                    if (priorityQueue.isEmpty()) {
                        priorityQueue.add(new int[] {intervals[i][1], currentPerson, intervals[i][2]});
                    } else {
                        if (intervals[i][0] < priorityQueue.peek()[0]) {
                            if (priorityQueue.size() == 2) {
                                result = "IMPOSSIBLE";
                                break;
                            }
                            currentPerson = (priorityQueue.peek()[1] + 1) % 2;
                            priorityQueue.add(new int[] {intervals[i][1], currentPerson, intervals[i][2]});
                        } else {
                            while (!priorityQueue.isEmpty() && intervals[i][0] >= priorityQueue.peek()[0]) {
                                int[] finishedTask = priorityQueue.poll();
                                currentPerson = finishedTask[1];
                                assigned[finishedTask[2]] = options[currentPerson];
                            }
                            priorityQueue.add(new int[] {intervals[i][1], currentPerson, intervals[i][2]});
                        }
                    }
                }

                if (!result.equals("IMPOSSIBLE")) {
                    while (!priorityQueue.isEmpty()) {
                        int[] finishedTask = priorityQueue.poll();
                        currentPerson = finishedTask[1];
                        assigned[finishedTask[2]] = options[currentPerson];
                    }
                    result = String.valueOf(assigned);
                }

                System.out.println("Case #" + (caseIndex + 1) + ": " + result + "\n");
            }
        }

        scanner.close();
    }
}