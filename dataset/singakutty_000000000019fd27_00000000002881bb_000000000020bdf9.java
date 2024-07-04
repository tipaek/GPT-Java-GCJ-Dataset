import java.util.*;

public class Solution {

    public static class Interval {
        int start;
        int end;
        int intervalActualIdx;

        public Interval(int start, int end, int intervalActualIdx) {
            this.start = start;
            this.end = end;
            this.intervalActualIdx = intervalActualIdx;
        }

        @Override
        public boolean equals(Object o) {
            Interval i = (Interval) o;
            return i.start == this.start && i.end == this.end && i.intervalActualIdx == this.intervalActualIdx;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.start, this.end, this.intervalActualIdx);
        }
    }

    private static boolean doesItOverlap(Interval a, Interval b) {
        return a.start < b.end && b.start < a.end;
    }

    private static String getPossibility(List<Interval> givenActivities) {
        Collections.sort(givenActivities, (a, b) ->  {
           if(a.start == b.start) {
               return b.end - a.end;
           }
           return a.start - b.start;
        });
        TreeSet<Interval> jamieSet = new TreeSet<>((a, b) -> {
            if(a.start == b.start) {
                return b.end - a.end;
            }
            return a.start - b.start;
        });

        TreeSet<Interval> cameronSet = new TreeSet<>((a, b) -> {
            if(a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        Map<Integer, String> intervalToPerson = new HashMap<>();
        for(int curIntervalIdx = 0; curIntervalIdx < givenActivities.size(); curIntervalIdx++) {
            boolean doesOverlapWithJamie = (jamieSet.isEmpty() ? false: doesItOverlap(jamieSet.last(), givenActivities.get(curIntervalIdx)));
            boolean doesOverlapWithCameron = (cameronSet.isEmpty() ? false: doesItOverlap(cameronSet.last(), givenActivities.get(curIntervalIdx)));
            if(doesOverlapWithJamie && doesOverlapWithCameron) {
                return "IMPOSSIBLE";
            }
            if(doesOverlapWithCameron) {
                jamieSet.add(givenActivities.get(curIntervalIdx));
                intervalToPerson.put(givenActivities.get(curIntervalIdx).intervalActualIdx, "J");
            }

            if(doesOverlapWithJamie) {
                cameronSet.add(givenActivities.get(curIntervalIdx));
                intervalToPerson.put(givenActivities.get(curIntervalIdx).intervalActualIdx, "C");
            }
            if(!doesOverlapWithCameron && !doesOverlapWithJamie) {
                jamieSet.add(givenActivities.get(curIntervalIdx));
                intervalToPerson.put(givenActivities.get(curIntervalIdx).intervalActualIdx, "J");
            }
        }
        String possibility = "";
        for(int curIntervalIdx = 0; curIntervalIdx < givenActivities.size(); curIntervalIdx++) {
            possibility = possibility + intervalToPerson.get(curIntervalIdx);
        }

        return possibility;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestcases = scanner.nextInt();
        for(int testcase = 1; testcase <= numTestcases; testcase++) {
            int numActivities = scanner.nextInt();
            List<Interval> givenActivities = new ArrayList<>();
            for(int activity = 0; activity < numActivities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                givenActivities.add(new Interval(start, end, activity));
            }
            System.out.println("Case #"+ testcase + ": " + getPossibility(givenActivities));
        }
    }
}