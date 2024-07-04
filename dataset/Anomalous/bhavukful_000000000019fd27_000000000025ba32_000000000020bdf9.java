import java.util.*;

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SortByStart implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.start, p2.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            List<Pair> intervals = new ArrayList<>();
            Map<Pair, Integer> indexMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                Pair interval = new Pair(start, end);
                intervals.add(interval);
                indexMap.put(interval, j);
            }

            Collections.sort(intervals, new SortByStart());

            Stack<Pair> stackC = new Stack<>();
            Stack<Pair> stackJ = new Stack<>();
            char[] result = new char[N];
            Arrays.fill(result, '0');

            boolean possible = true;

            for (Pair interval : intervals) {
                if (stackC.isEmpty() || stackC.peek().end <= interval.start) {
                    if (!stackC.isEmpty()) {
                        stackC.pop();
                    }
                    stackC.push(interval);
                    result[indexMap.get(interval)] = 'C';
                } else if (stackJ.isEmpty() || stackJ.peek().end <= interval.start) {
                    if (!stackJ.isEmpty()) {
                        stackJ.pop();
                    }
                    stackJ.push(interval);
                    result[indexMap.get(interval)] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + (possible ? new String(result) : "IMPOSSIBLE"));
        }

        scanner.close();
    }
}