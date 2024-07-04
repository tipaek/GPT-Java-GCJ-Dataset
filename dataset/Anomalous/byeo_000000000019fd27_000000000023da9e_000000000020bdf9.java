import java.util.*;

class Schedule implements Comparable<Schedule> {
    private final int start;
    private final int end;
    private final int idx;

    public Schedule(int start, int end, int idx) {
        this.start = start;
        this.end = end;
        this.idx = idx;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIdx() {
        return idx;
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
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Schedule> pq = new PriorityQueue<>();

        for (int i = 0; i < schedules.length; i++) {
            pq.offer(new Schedule(schedules[i][0], schedules[i][1], i));
        }

        Map<Integer, Character> lookup = new HashMap<>(schedules.length);
        Deque<Schedule> jDeque = new LinkedList<>();
        Deque<Schedule> cDeque = new LinkedList<>();

        while (!pq.isEmpty()) {
            Schedule current = pq.poll();
            if (jDeque.isEmpty() || !jDeque.peekLast().hasCollided(current)) {
                jDeque.addLast(current);
                lookup.put(current.getIdx(), JAMIE);
            } else if (cDeque.isEmpty() || !cDeque.peekLast().hasCollided(current)) {
                cDeque.addLast(current);
                lookup.put(current.getIdx(), CAMERON);
            } else {
                return IMPOSSIBLE;
            }
        }

        for (int i = 0; i < schedules.length; i++) {
            sb.append(lookup.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][][] cases = readInput();
        for (int t = 0; t < cases.length; t++) {
            String schedule = parenting(cases[t]);
            System.out.println("Case #" + (t + 1) + ": " + schedule);
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