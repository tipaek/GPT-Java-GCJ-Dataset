import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int N = scanner.nextInt();

            Map<Integer, Integer> intervals = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                intervals.put(scanner.nextInt(), scanner.nextInt());
            }

            List<Slots> jSlots = new ArrayList<>();
            List<Slots> cSlots = new ArrayList<>();

            Set<Integer> keys = intervals.keySet();
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (Integer beginning : keys) {
                Integer end = intervals.get(beginning);
                if (canTakeSlot(beginning, end, jSlots)) {
                    jSlots.add(new Slots(beginning, end));
                    sb.append("J");
                } else if (canTakeSlot(beginning, end, cSlots)) {
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

    private static boolean canTakeSlot(Integer start, Integer end, List<Slots> slots) {
        if (slots.stream().anyMatch(s -> s.endTime > start)) {
            return false;
        }
        return true;
    }

    static class Slots {
        public Integer startTime;

        public Integer endTime;

        public Slots(Integer startTime, Integer endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

}
