import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int currentCase = 1; currentCase <= testCases; currentCase++) {
            int taskCount = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            Person personC = new Person("C");
            Person personJ = new Person("J");
            
            personC.addActivity(new Interval(scanner.nextInt(), scanner.nextInt()));
            personJ.addActivity(new Interval(scanner.nextInt(), scanner.nextInt()));
            StringBuilder schedule = new StringBuilder("CJ");
            
            for (int i = 2; i < taskCount; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }
            
            boolean conflictC = false;
            boolean conflictJ = false;
            
            for (Interval interval : intervals) {
                conflictC = false;
                conflictJ = false;
                
                for (Interval activityC : personC.getActivities()) {
                    if (interval.overlaps(activityC)) {
                        conflictC = true;
                        break;
                    }
                }
                
                for (Interval activityJ : personJ.getActivities()) {
                    if (interval.overlaps(activityJ)) {
                        conflictJ = true;
                        break;
                    }
                }
                
                if (!conflictC) {
                    personC.addActivity(interval);
                    schedule.append("C");
                } else if (!conflictJ) {
                    personJ.addActivity(interval);
                    schedule.append("J");
                } else {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", currentCase);
                    break;
                }
            }
            
            if (!conflictC || !conflictJ) {
                System.out.printf("Case #%d: %s\n", currentCase, schedule.toString());
            }
        }
    }

    private static class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Interval other) {
            return isBetween(other.start) || isBetween(other.end) || other.isBetween(this.start) || other.isBetween(this.end);
        }

        private boolean isBetween(int time) {
            return time > start && time < end;
        }
    }

    private static class Person {
        private final List<Interval> activities;
        private final String name;

        public Person(String name) {
            this.name = name;
            this.activities = new ArrayList<>();
        }

        public void addActivity(Interval interval) {
            activities.add(interval);
        }

        public List<Interval> getActivities() {
            return activities;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "'}";
        }
    }
}