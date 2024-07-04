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

            PriorityQueue<Pair> intervals = new PriorityQueue<>((o1, o2) -> {
                if (o1.start == o2.start) return 0;
                if (o1.start > o2.start) return 1;
                return -1;
            });

            for (int i = 0; i < intervalSize; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                intervals.add(new Pair(start, end));
            }
            while (!intervals.isEmpty()){
                Pair interval = intervals.poll();
                int startTime = interval.start;
                int endTime = interval.end;

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
        intervalStack.pop();
        intervalStack.push(new Pair(startTime, endTime));
    }

    private static boolean overlapsSchedule(Stack<Pair> intervalStack, int startTime, int endTime) {
        if (intervalStack.isEmpty()) return false;

        Pair topInterval = intervalStack.peek();
        if (topInterval.end <= startTime) return false;
        return true;
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
