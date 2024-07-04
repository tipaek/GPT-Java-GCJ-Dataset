import java.util.*;

class Schedule implements Comparable<Schedule> {
    public int start, end, idx;

    public Schedule(int start, int end, int idx) {
        this.start = start;
        this.end = end;
        this.idx = idx;
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

        for (int i = 0; i < schedules.length; i++) {
            pq.offer(new Schedule(schedules[i][0], schedules[i][1], i));
        }

        Map<Integer, Character> assignment = new HashMap<>(schedules.length);
        Deque<Schedule> jamieSchedules = new LinkedList<>();
        Deque<Schedule> cameronSchedules = new LinkedList<>();

        while (!pq.isEmpty()) {
            Schedule current = pq.poll();
            if (jamieSchedules.isEmpty() || !jamieSchedules.peekLast().hasCollided(current)) {
                jamieSchedules.add(current);
                assignment.put(current.idx, JAMIE);
            } else if (cameronSchedules.isEmpty() || !cameronSchedules.peekLast().hasCollided(current)) {
                cameronSchedules.add(current);
                assignment.put(current.idx, CAMERON);
            } else {
                return IMPOSSIBLE;
            }
        }

        for (int i = 0; i < schedules.length; i++) {
            result.append(assignment.get(i));
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
        sc.nextLine();
        int[][][] cases = new int[T][][];

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            sc.nextLine();
            cases[t] = new int[N][2];
            for (int n = 0; n < N; n++) {
                cases[t][n][0] = sc.nextInt();
                cases[t][n][1] = sc.nextInt();
                if (sc.hasNextLine()) sc.nextLine();
            }
        }
        return cases;
    }
}