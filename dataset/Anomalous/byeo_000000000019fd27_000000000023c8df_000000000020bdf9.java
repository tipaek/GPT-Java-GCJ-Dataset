import java.util.*;

class Schedule implements Comparable<Schedule> {
    public int start, end;
    public char owner;

    public Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Schedule other) {
        return Integer.compare(this.start, other.start);
    }

    public boolean hasCollided(Schedule other) {
        return (this.start < other.end && this.end > other.start);
    }
}

public class Solution {
    private static final char JAMIE = 'J';
    private static final char CAMERON = 'C';
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static String parenting(int[][] schedules) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<Schedule> pq = new PriorityQueue<>();

        for (int[] schedule : schedules) {
            pq.offer(new Schedule(schedule[0], schedule[1]));
        }

        Map<Integer, Character> lookup = new HashMap<>();
        Deque<Schedule> jMap = new LinkedList<>();
        Deque<Schedule> cMap = new LinkedList<>();

        while (!pq.isEmpty()) {
            Schedule current = pq.poll();
            if (jMap.isEmpty() || !jMap.peekLast().hasCollided(current)) {
                jMap.add(current);
                lookup.put(current.start, JAMIE);
            } else if (cMap.isEmpty() || !cMap.peekLast().hasCollided(current)) {
                cMap.add(current);
                lookup.put(current.start, CAMERON);
            } else {
                return IMPOSSIBLE;
            }
        }

        for (int[] schedule : schedules) {
            result.append(lookup.get(schedule[0]));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][][] cases = readInput();
        for (int t = 0; t < cases.length; t++) {
            String schedule = parenting(cases[t]);
            System.out.printf("Case #%d: %s%n", t + 1, schedule);
        }
    }

    private static int[][][] readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][][] cases = new int[T][][];

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            cases[t] = new int[N][2];
            for (int n = 0; n < N; n++) {
                cases[t][n][0] = sc.nextInt();
                cases[t][n][1] = sc.nextInt();
            }
        }
        return cases;
    }
}