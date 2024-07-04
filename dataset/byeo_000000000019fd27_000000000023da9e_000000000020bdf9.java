import java.util.*;

class Schedule implements Comparable<Schedule>{
    public Integer start, end;
    public int idx;

    public Schedule(int start, int end, int idx) {
        this.start = new Integer(start);
        this.end = new Integer(end);
        this.idx = idx;
    }

    @Override
    public int compareTo(Schedule other) {
        return (this.start).compareTo(other.start);
    }

    public boolean hasCollided(Schedule other) {
        return (this.start <= other.start && this.end > other.start) || (this.end > other.start && this.end <= other.end);
    }
}

public class Solution {
    private final static char JAMIE = 'J';
    private final static char CAMERON = 'C';
    private final static String IMPOSSIBLE = "IMPOSSIBLE";

    private static String parenting(int[][] schedules) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Schedule> pq = new PriorityQueue<>();

        for (int i = 0; i < schedules.length; i++) {
            Schedule s = new Schedule(schedules[i][0],schedules[i][1], i);
            pq.offer(s);
        }

        Map<Integer, Character> lookup = new HashMap<>(schedules.length);
        Deque<Schedule> jMap = new LinkedList<>();
        Deque<Schedule> cMap = new LinkedList<>();

        while (!pq.isEmpty()) {
            if (jMap.isEmpty()) {
                Schedule polled = pq.poll();
                jMap.add(polled);
                lookup.put(polled.idx, JAMIE);
            } else {
                Schedule jSchedule = jMap.peekLast();
                if (jSchedule.hasCollided(pq.peek())) {
                    // Try cMap
                    if (cMap.isEmpty()) {
                        Schedule polled = pq.poll();
                        cMap.add(polled);
                        lookup.put(polled.idx, CAMERON);
                    } else {
                        Schedule cSchedule = cMap.peekLast();
                        if (cSchedule.hasCollided(pq.peek())) {
                            return IMPOSSIBLE;
                        } else {
                            Schedule polled = pq.poll();
                            cMap.addLast(polled);
                            lookup.put(polled.idx, CAMERON);
                        }
                    }
                } else {
                    Schedule polled = pq.poll();
                    jMap.addLast(polled);
                    lookup.put(polled.idx, JAMIE);
                }
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
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(t+1).append(": ").append(schedule);
            System.out.println(sb.toString());
        }
    }

    private static int[][][] readInput() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); sc.nextLine();
        int[][][] cases = new int[T][][];

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(); sc.nextLine();
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
