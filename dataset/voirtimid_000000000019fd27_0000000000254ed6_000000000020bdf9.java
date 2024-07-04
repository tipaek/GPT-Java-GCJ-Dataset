import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int N = scanner.nextInt();

            PriorityQueue<Slots> intervals = new PriorityQueue<>(N);

            for (int i = 0; i < N; i++) {
                intervals.add(new Slots(i, scanner.nextInt(), scanner.nextInt()));
            }

            List<Slots> jSlots = new ArrayList<>();
            List<Slots> cSlots = new ArrayList<>();

            boolean flag = true;
            for (Slots slot : intervals) {
                Integer beginning = slot.startTime;
                Integer end = slot.endTime;
                if (canTakeSlot(beginning, end, jSlots)) {
                    jSlots.add(new Slots(slot.id, beginning, end));
                    slot.who = "J";
                } else if (canTakeSlot(beginning, end, cSlots)) {
                    cSlots.add(new Slots(slot.id, beginning, end));
                    slot.who = "C";
                } else {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", t + 1));
                    flag = false;
                    break;
                }
            }

            List<Slots> collect = new ArrayList<>(intervals);

            String result = collect.stream().sorted(Comparator.comparing(slot -> slot.id)).map(slot -> slot.who).collect(Collectors.joining(""));

            if (flag)
                System.out.println(String.format("Case #%d: %s", t + 1, result));
        }
    }

    private static boolean canTakeSlot(Integer start, Integer end, List<Slots> slots) {
        return slots.stream().anyMatch(s -> (s.startTime <= start && s.endTime > start) || (s.startTime < end && s.endTime >= end));
    }

    static class Slots implements Comparable<Slots> {

        public Integer id;

        public String who;

        public Integer startTime;

        public Integer endTime;

        public Slots(Integer id, Integer startTime, Integer endTime) {
            this.id = id;
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

