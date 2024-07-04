import java.util.*;

class Schedule {
    int start;
    int end;
    Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t<= test; t++) {
            int q = in.nextInt();
            List<Schedule> list = new ArrayList<>();
            Map<Integer, Character> map = new TreeMap<>();
            Map<Schedule, Integer> scheduleIndexMap = new HashMap<>();
            for (int i = 0; i<q; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Schedule schedule = new Schedule(start, end);
                list.add(schedule);
                scheduleIndexMap.put(schedule, i);
            }
            Collections.sort(list, new Comparator<Schedule>() {
                @Override
                public int compare(Schedule s1, Schedule s2) {
                    return s1.end - s2.end;
                }
            });
//            System.out.println(list);
            String result = "";
            int  camEndTime = 0;
            int jamEndTime = 0;
            boolean isPossible = true;
            for (Schedule s: list) {
                int pos = scheduleIndexMap.get(s);
                if (s.start >= camEndTime) {
                    camEndTime = s.end;
                    map.put(pos, 'C');
                } else if(s.start >= jamEndTime) {
                    jamEndTime = s.end;
                    map.put(pos, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible) {
                System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
            } else {
                for (Map.Entry<Integer, Character> m: map.entrySet()) {
                    result += m.getValue();
                }
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }
}
