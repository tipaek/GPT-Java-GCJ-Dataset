import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        for (int i = 1; i <= cases; i ++) {

            Integer activities = in.nextInt();

            Boolean jamieFree = true;
            Boolean cameronFree = true;

            Integer jamieFreeAt = -1;
            Integer cameronFreeAt = -1;

            List<Schedule> schedules = new ArrayList<>();

            for (int j = 0; j < activities; j++)
                schedules.add(new Schedule(in.nextInt(), in.nextInt(), j));

            Collections.sort(schedules);

            //System.out.println(schedules);

            String result = "";

            for (Schedule s : schedules) {

                if (!jamieFree && s.start >= jamieFreeAt)
                    jamieFree = true;

                if (!cameronFree && s.start >= cameronFreeAt)
                    cameronFree = true;

                if (cameronFree) {
                    result += "C";
                    cameronFreeAt = s.finish;
                    cameronFree = false;
                    continue;
                }

                if (jamieFree) {
                    result += "J";
                    jamieFreeAt = s.finish;
                    jamieFree = false;
                    continue;
                }

                result = "IMPOSSIBLE";
                break;
            }

            result = normalizeResult(schedules, result);

            System.out.format("Case #%d: %s\n", i, result);
        }
    }

    private static String normalizeResult(List<Schedule> schedules, String unbalancedResult) {

        String result = "";

        for(Schedule s : schedules) {
            result += unbalancedResult.toCharArray()[s.originOrder];
        }

        return result;
    }
}

class Schedule implements Comparable<Schedule> {

    Integer start;
    Integer finish;
    Integer originOrder;

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
