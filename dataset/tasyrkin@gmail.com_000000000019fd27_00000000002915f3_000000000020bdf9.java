import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            PriorityQueue<SchedulePoint> schedulePoints = new PriorityQueue<>();

            final int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                schedulePoints.add(new SchedulePoint(i, false, start));

                int end = scanner.nextInt();
                schedulePoints.add(new SchedulePoint(i, true, end));
            }
            Map<Integer, Character> map = new HashMap<>();
            boolean isPossible = true;
            Integer cameronActivityId = null;
            Integer jamieActivityId = null;
            while (!schedulePoints.isEmpty()) {
                SchedulePoint currSchedulePoint = schedulePoints.poll();
                if (!currSchedulePoint.isEnd) {
                    if (cameronActivityId == null) {
                        cameronActivityId = currSchedulePoint.id;
                        map.put(cameronActivityId, 'C');
                    } else if (jamieActivityId == null) {
                        jamieActivityId = currSchedulePoint.id;
                        map.put(jamieActivityId, 'J');
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (cameronActivityId != null && currSchedulePoint.id == cameronActivityId) {
                        cameronActivityId = null;
                    } else if (jamieActivityId != null && currSchedulePoint.id == jamieActivityId) {
                        jamieActivityId = null;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            if (isPossible) {
                for (int i = 0; i < N; i++) {
                    sb.append(map.get(i));
                }
            }

            System.out.println(
                    String.format("Case #%d: %s", caseNumber, isPossible ? sb.toString() : "IMPOSSIBLE")
            );
        }
    }

    private static class SchedulePoint implements Comparable<SchedulePoint> {
        int id;
        boolean isEnd;
        int minute;

        public SchedulePoint(int id, boolean isEnd, int minute) {
            this.id = id;
            this.isEnd = isEnd;
            this.minute = minute;
        }

        @Override
        public int compareTo(SchedulePoint o) {
            int cmp = Integer.compare(minute, o.minute);
            if (cmp == 0) {
                return -1 * Boolean.compare(isEnd, o.isEnd);
            }
            return cmp;
        }
    }
}
