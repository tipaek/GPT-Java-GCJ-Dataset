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
            // sort on moments time
            activityMoment.sort((a,b) -> {
               int c = a.time - b.time;
               if (c == 0) {
                   // E comes before S due to natural alphabetically ordering
                   return a.type - b.type;
               }
               return c;
            });
//            activityMoment.forEach(System.err::println);

            // first will always be start
            Activity assignedToC = activityMoment.get(0);
            Activity assignedToJ = null;
            int prevEnd = assignedToC.end;
            assignedToC.assignedIndividual = 'C';
            int intervalDepth = 1; // first activity started
            boolean possible = true;
            String ans = "";
            StringBuilder sb = new StringBuilder(n);
            for (int i=0; i < n; i++) sb.append(' ');
            sb.setCharAt(assignedToC.index, 'C');
            for (int i = 1; i < activityMoment.size(); i++) {
                Activity moment = activityMoment.get(i);
                if (moment.type == 'S') {
//                    System.err.println("current start " + start + " prevEnd " + prevEnd);
                    if (moment.start < prevEnd) {
                        intervalDepth++;
//                        System.err.println("Overlap . Interval depth " + intervalDepth);
                        if (intervalDepth > 2) {
                            possible = false;
                            break;
                        }
                    }
                    char nextAssigned = getNextAssignedIndividual(moment, assignedToC, assignedToJ);
                    sb.setCharAt(moment.index, nextAssigned);
                    if (nextAssigned == 'C') assignedToC = moment;
                    else assignedToJ = moment;
                } else { // type is 'End'
                    intervalDepth--;
                    if (intervalDepth == 0) {
                        assignedToC = null;
                        assignedToJ = null;
                    }
                }
                //System.err.println("Current moment " + moment);
                prevEnd = Math.max(prevEnd, moment.end);
            }

            if (possible) {
                ans = sb.toString();
            } else {
                ans = "IMPOSSIBLE";
            }
            System.out.println("Case #" + testCase + ": " + ans);
        }

    }

    private static Character getNextAssignedIndividual(Activity moment, Activity assignedToC, Activity assignedToJ) {
        if (assignedToJ == null) return 'J';
        if (assignedToC == null) return 'C';
        if (moment.start >= assignedToJ.end) return 'J';
        if (moment.start >= assignedToC.end) return 'C';
        return 'J';
    }

    static class Activity {
        int time, index, start, end;
        char type; // S : start, E : end
        char assignedIndividual;

        // for start timesdd
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
            if (type == 'S')
                s += " [" + assignedIndividual + "]";
            return s;
        }

        public int getTime() { return time; }

        public int getIndex() { return index; }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer st;

        public InputReader() throws FileNotFoundException {
        reader = new BufferedReader(new InputStreamReader(System.in));
            // reader = new BufferedReader(new InputStreamReader(new FileInputStream("ParentingPartnering.in")));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) { st = new StringTokenizer(nextLine()); }
            return st.nextToken();
        }

        public String nextLine() {
            try { return reader.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
    }
}
