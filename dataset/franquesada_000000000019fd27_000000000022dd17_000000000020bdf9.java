import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        int actual = 0;
        while (actual++< T) {
            int tasks = scan.nextInt();
            List<Interval> intervals = new LinkedList<>();
            Person C = new Person("C");
            Person J = new Person("J");
            C.addActivity(new Interval(scan.nextInt(), scan.nextInt()));
            J.addActivity(new Interval(scan.nextInt(), scan.nextInt()));
            StringBuilder out = new StringBuilder("CJ");
            for (int i = 2; i < tasks; i++) {
                intervals.add(new Interval(scan.nextInt(), scan.nextInt()));
            }
            boolean notC = false;
            boolean notJ = false;
            for (Interval interval :
                    intervals) {
                notC=false;
                notJ=false;
                for (Interval cAct :
                        C.activities) {
                    if (interval.overlaps(cAct)) {
                        notC = true;
                        break;
                    }
                }
                if(notC)
                {
                    for (Interval jAct :
                            J.activities) {
                        if (interval.overlaps(jAct)) {
                            notJ=true;
                            break;
                        }
                    }
                }

                if(!notC)
                {
                    C.activities.add(interval);
                    out.append("C");
                }else if(!notJ)
                {
                    J.activities.add(interval);
                    out.append("J");
                }else{
                    System.out.printf("Case #%d: IMPOSSIBLE\n",actual);
                    break;
                }
            }
            if(!notC || !notJ)
            {
                System.out.printf("Case #%d: " + out +"\n",actual);
            }

        }
    }

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Interval interval) {
            int interv_start = interval.start;
            int interv_end = interval.end;
            return between(interv_start) || between(interv_end) || interval.between(start) || interval.between(end);
        }

        public boolean between(int t1) {
            return t1 > start && t1 < end;
        }
    }

    public static class Person {
        List<Interval> activities;
        String name;

        public Person(String name) {
            this.name = name;
            activities=new LinkedList<>();
        }

        public void addActivity(Interval interval) {
            activities.add(interval);
        }

        @Override
        public String toString() {
            return "name" + name + '\'';
        }
    }
}