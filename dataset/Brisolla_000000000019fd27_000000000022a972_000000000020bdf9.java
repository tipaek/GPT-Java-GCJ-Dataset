import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        for (int i = 1; i <= cases; i ++) {

            Integer activities = in.nextInt();

            Integer jamieFreeAt = -1;
            Integer cameronFreeAt = -1;

            List<Schedule> schedules = new ArrayList<>();

            for (int j = 0; j < activities; j++)
                schedules.add(new Schedule(in.nextInt(), in.nextInt(), j));

            //System.out.println(schedules);

            Collections.sort(schedules);

            String result = "";

            for (Schedule s : schedules) {

                if (s.start >= cameronFreeAt) {
                    s.responsible = "C";
                    cameronFreeAt = s.finish;
                    continue;
                }

                if (s.start >= jamieFreeAt) {
                    s.responsible = "J";
                    jamieFreeAt = s.finish;
                    continue;
                }

                result = "IMPOSSIBLE";
                break;
            }

            if (!result.equals("IMPOSSIBLE"))
                result = normalizeResult(schedules, result);

            System.out.format("Case #%d: %s\n", i, result);
        }
    }

    private static String normalizeResult(List<Schedule> schedules, String unbalancedResult) {

        String result = "";

        Collections.sort(schedules, new ScheduleOrderComparator());

        for (Schedule s : schedules)
            result += s.responsible;

        return result;
    }
}

class ScheduleOrderComparator implements Comparator<Schedule> {

    @Override
    public int compare(Schedule schedule, Schedule t1) {
        if (schedule.originOrder > t1.originOrder)
            return 1;
        if (schedule.originOrder < t1.originOrder)
            return -1;
        return 0;
    }
}

class Schedule implements Comparable<Schedule> {

    Integer start;
    Integer finish;
    Integer originOrder;
    String responsible;

    Schedule(Integer start, Integer finish, Integer originOrder) {
        this.start = start;
        this.finish = finish;
        this.originOrder = originOrder;
    }

    @Override
    public int compareTo(Schedule schedule) {

        if (this.start > schedule.start)
            return 1;
        if (this.start < schedule.start)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "[" + start + " - " + finish + "]";
    }
}
