import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int N = scanner.nextInt();

            PriorityQueue<Slots> intervals = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                intervals.add(new Slots(scanner.nextInt(), scanner.nextInt()));
            }

            List<Slots> jSlots = new ArrayList<>();
            List<Slots> cSlots = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (Slots interval : intervals) {
                Integer beginning = interval.startTime;
                Integer end = interval.endTime;
                if (canTakeSlot(beginning, jSlots)) {
                    jSlots.add(new Slots(beginning, end));
                    sb.append("J");
                } else if (canTakeSlot(beginning, cSlots)) {
                    cSlots.add(new Slots(beginning, end));
                    sb.append("C");
                } else {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", t + 1));
                    flag = false;
                    break;
                }
            }

            if (flag)
                System.out.println(String.format("Case #%d: %s", t + 1, sb.toString()));
        }
    }

    private static boolean canTakeSlot(Integer start, List<Slots> slots) {
        return slots.stream().noneMatch(s -> s.endTime > start);
    }

    static class Slots implements Comparable<Slots> {
        public Integer startTime;

        public Integer endTime;

        public Slots(Integer startTime, Integer endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Slots slots) {
            if (this.startTime.equals(slots.startTime))
                return Integer.compare(this.endTime, slots.endTime);
            return Integer.compare(this.startTime, slots.startTime);
        }
    }
}

