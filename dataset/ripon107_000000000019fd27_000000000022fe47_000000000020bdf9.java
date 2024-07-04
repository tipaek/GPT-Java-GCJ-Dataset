import java.util.*;

class Solution {

    public static void main(String[] args) {
        class Time implements Comparable{
            int startTime;
            int endTime;
            int pos;
            public Time(int startTime, int endTime, int pos) {
                this.startTime = startTime;
                this.endTime = endTime;
                this.pos = pos;
            }

            @Override
            public int compareTo(Object o) {
                return endTime - ((Time)o).endTime;
            }
        }
        int testcase;

        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();


        for(int caseno = 1; caseno<=testcase;caseno++) {
            int event = sc.nextInt();
            char[] res = new char[event];
            List<Time> events = new ArrayList<>();
            List<Time> alternate = new ArrayList<>();

            for (int i=0;i<event;i++) {
                events.add(new Time(sc.nextInt(), sc.nextInt(), i));
            }

            Collections.sort(events);
            alternate.addAll(events);

            int lastEndTime = 0;
            for (int i=0;i<events.size();i++) {
                if (events.get(i).startTime >= lastEndTime) {
                    res[events.get(i).pos] = 'C';
                    lastEndTime = events.get(i).endTime;
                    alternate.remove(events.get(i));
                }
            }

            int ok = 1;
            lastEndTime = 0;
            for (int i=0;i<alternate.size();i++) {
                if (alternate.get(i).startTime >= lastEndTime) {
                    res[alternate.get(i).pos] = 'J';
                    lastEndTime = alternate.get(i).endTime;
                } else {
                    ok = 0;
                }
            }

            if (ok == 0) {
                System.out.println("Case #" + caseno + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseno + ": " + new String(res));
            }

        }
    }
}
