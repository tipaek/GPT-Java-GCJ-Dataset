import java.util.*;

public class Solution {
    private static int testcaseNumber = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer testcases = scan.nextInt();

        while (testcases > 0) {
            testcaseNumber += 1;
            Stack<Pair> cameronStack = new Stack<>();
            Stack<Pair> jamieStack = new Stack<>();
            boolean overlapsBoth = false;
            int intervalSize = scan.nextInt();

            TreeMap<Integer, String> map = new TreeMap<>();
            Map<String, String> result = new HashMap<>();

            PriorityQueue<Pair> intervals = getPQ();
            for (int i = 0; i < intervalSize; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                Pair pair = new Pair(start, end);
                map.put(i, pair.start + "." + pair.end);
                intervals.add(pair);
            }

            while (!intervals.isEmpty()) {
                Pair pair = intervals.poll();
                int startTime = pair.start;
                int endTime = pair.end;

                boolean overlapsCameron = overlapsSchedule(cameronStack, startTime, endTime);
                boolean overlapsJamie = overlapsSchedule(jamieStack, startTime, endTime);

                if (overlapsCameron && overlapsJamie) {
                    overlapsBoth = true;
                    break;
                }
                if (overlapsCameron) {
                    addToSchedule(jamieStack, startTime, endTime);
                    result.put(startTime + "." + endTime, "J");
                } else {
                    addToSchedule(cameronStack, startTime, endTime);
                    result.put(startTime + "." + endTime, "C");
                }

            }
            StringBuilder resultString = new StringBuilder();
            for (Integer key : map.keySet()) {
                String pair = map.get(key);
                String assignedTo = result.get(pair);
                resultString.append(assignedTo);
            }
            if (overlapsBoth) {
                System.out.println("Case #" + testcaseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testcaseNumber + ": " + resultString);
            }
            testcases--;
        }

    }

    
    private static PriorityQueue<Pair> getPQ() {
        return new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) return 0;
            if (o1.start > o2.start) return 1;
            return -1;
        });
    }

    private static void addToSchedule(Stack<Pair> intervalStack, int startTime, int endTime) {
        Pair pair = new Pair(startTime, endTime);
        if (intervalStack.isEmpty()) {
            intervalStack.push(pair);
            return;
        }
        intervalStack.pop();
        intervalStack.push(pair);
    }

    private static boolean overlapsSchedule(Stack<Pair> intervalStack, int startTime, int endTime) {
        if (intervalStack.isEmpty()) return false;

        Pair element = intervalStack.peek();
        int init = Math.max(element.start, startTime);
        int end = Math.min(element.end, endTime);
        if (init < end) {
            return true;
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
