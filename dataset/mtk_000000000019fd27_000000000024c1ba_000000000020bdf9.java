import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Parenting Parterning
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader ir = new InputReader();
        int testCases = ir.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = ir.nextInt(); // number of activities

            List<Activity> activityMoment = new ArrayList<>();
            int s, e;
            for (int i = 0; i < n; i++) {
                s = ir.nextInt(); e = ir.nextInt();
                activityMoment.add(new Activity(s, 'S', i ,s, e));
                activityMoment.add(new Activity(e, 'E', i, s, e));
            }
            activityMoment.sort((a,b) -> {
               int c = a.time - b.time;
               if (c == 0) {
                   return a.type - b.type; // end should come first so as to not calculate continous times as overlapping
               }
               return c;
            });
//            System.out.println(intervals);
//            activityMoment.forEach(System.out::println);

            int prevEnd = activityMoment.get(0).end;
            char currentAssigned = 'C'; // can be C or J
            activityMoment.get(0).assignedIndividual = currentAssigned;
            String ans = "IMPOSSIBLE";
            int intervalDepth = 1; // first activity started
            Activity assignedToC = activityMoment.get(0);
            Activity assignedToJ = null;
            for (int i = 1; i < activityMoment.size(); i++) {
                Activity moment = activityMoment.get(i);
//                System.err.println("Current moment " + moment);
                char currentIntervalType = moment.type;
                if (currentIntervalType == 'S') {
                    moment.assignedIndividual = currentAssigned;

                    int start = moment.start;
//                    System.err.println("current start " + start + " prevEnd " + prevEnd);

                    if (start < prevEnd) {
                        intervalDepth++;
//                        System.err.println("Overlap . Interval depth " + intervalDepth);
                        if (intervalDepth > 2) {
                            break;
                        }
                        char nextAssigned = getNextAssignedIndividual(moment, assignedToC, assignedToJ);
                        moment.assignedIndividual = nextAssigned;
                        if (nextAssigned == 'C')
                            assignedToC = moment;
                        else
                            assignedToJ = moment;
                    }
                } else { // type is 'End'
                    intervalDepth--;
                }
                prevEnd = Math.max(prevEnd, moment.end);
//                assert intervalDepth >= 0;

            }
//            System.err.println("\nAfter algo");
//            activityMoment.forEach(System.err::println);
            if (intervalDepth < 3) {
                activityMoment.sort(Comparator.comparingInt(a -> a.index));
//                Character[] ans = intervals.stream().map(c -> c.assignedIndividual).toArray(Character[]::new);
//                String ans2 = Arrays.stream(ans).map(Objects::toString).collect(Collectors.joining(""));
                ans = activityMoment.stream()
                        .filter(a -> a.type == 'S')
                        .map(c -> ""+c.assignedIndividual)
                        .collect(Collectors.joining(""));

            }
            System.out.println("Case #" + testCase + ": " + ans);
        }

    }

    private static Character getNextAssignedIndividual(Activity moment, Activity assignedToC, Activity assignedToJ) {
        if (assignedToJ == null) return 'J';
        if (moment.start >= assignedToC.end) return 'C';
        if (moment.start >= assignedToJ.end) return 'J';
        return 'J';
    }

    static class Activity {
        int time;
        char type; // S : start, E : end
        int index;
        int start;
        int end;
        Character assignedIndividual;

        // for start times
        public Activity(int time, char type, int index, int start, int end) {
            this.time = time;
            this.type = type;
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            String s = "[" + start + " - " + end + "] - moment " + time + " " + type + " atIndex " + index;
            if (assignedIndividual != null)
                s += " [assigned " + assignedIndividual;
            return s;
        }

        public int getTime() {
            return time;
        }

        public int getIndex() {
            return index;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer st;

        public InputReader() throws FileNotFoundException {
            reader = new BufferedReader(new InputStreamReader(System.in));
            // reader = new BufferedReader(new InputStreamReader(new FileInputStream("ParentingPartnering.in")));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
