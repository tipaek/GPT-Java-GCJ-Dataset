import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    private static int testcaseNumber = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer testcases = scan.nextInt();

        while (testcases > 0) {
            testcaseNumber += 1;
            StringBuilder resultString = new StringBuilder();
            Stack<Pair> cameronStack = new Stack<>();
            Stack<Pair> jamieStack = new Stack<>();
            boolean overlapsBoth = false;
            int intervalSize = scan.nextInt();
            int[][] intervals = new int[intervalSize][2];

            for (int i = 0; i < intervalSize; i++) {
                intervals[i][0] = scan.nextInt();
                intervals[i][1] = scan.nextInt();
            }

            for (int[] interval : intervals) {
                int startTime = interval[0];
                int endTime = interval[1];

                boolean overlapsCameron = overlapsSchedule(cameronStack, startTime, endTime);
                boolean overlapsJamie = overlapsSchedule(jamieStack, startTime, endTime);

                if (overlapsCameron && overlapsJamie) {
                    overlapsBoth = true;
                    break;
                }
                if (overlapsCameron) {
                    addToSchedule(jamieStack, startTime, endTime);
                    resultString.append("J");
                } else {
                    addToSchedule(cameronStack, startTime, endTime);
                    resultString.append("C");
                }

            }
            if (overlapsBoth) {
                System.out.println("Case #" + testcaseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testcaseNumber + ": " + resultString);
            }
            testcases--;
        }

    }

    private static void addToSchedule(Stack<Pair> intervalStack, int startTime, int endTime) {
        if (intervalStack.isEmpty()) {
            intervalStack.push(new Pair(startTime, endTime));
            return;
        }
        intervalStack.push(new Pair(startTime, endTime));
    }

    private static boolean overlapsSchedule(Stack<Pair> intervalStack, int startTime, int endTime) {
        if (intervalStack.isEmpty()) return false;

        for (Pair element : intervalStack) {
            int init = Math.max(element.start, startTime);
            int end = Math.min(element.end, endTime);
            if (init < end) {
                return true;
            }
        }
        return false;
    }
}

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
