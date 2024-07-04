import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            int[] starts = new int[n];
            int[] ends  = new int[n];

            for(int j = 0; j < n; j++) {
                starts[j] = in.nextInt();
                ends[j] = in.nextInt();
            }

            solve(starts, ends, i);
        }
    }

    public static class Event {
        int start;
        int end;
        int id;
    }

    public static void solve(int[] starts, int[] ends, int testNum) {
        ArrayList<Event> evs = new ArrayList<>();
        for(int i = 0; i < starts.length; i++) {
            Event e = new Event();
            e.start = starts[i];
            e.end = ends[i];
            e.id = i;
            evs.add(e);
        }

        Collections.sort(evs, new Comparator<Event>() {
            public int compare(Event a, Event b) {
                return a.start - b.start;
            }
        });
        
        int cBusy = -1;
        int jBusy = -1;
        String sol = "";
        int[] assignments = new int[starts.length];

        for(int i = 0; i < evs.size(); i++) {
            Event e = evs.get(i);

            if(e.start >= jBusy) {
                assignments[e.id] = 1;
                jBusy = e.end;
            } else if(e.start >= cBusy) {
                assignments[e.id] = 2;
                cBusy = e.end;
            } else {
                sol = "IMPOSSIBLE";
                break;
            }
        }

        if(sol.equals("IMPOSSIBLE")) {

        } else {
            for(int i = 0; i < assignments.length; i++) {
                if(assignments[i] == 1) {
                    sol += "J";
                } else {
                    sol += "C";
                }
            }
        }

        System.out.println("Case #" + testNum + ": " + sol);
    }
}