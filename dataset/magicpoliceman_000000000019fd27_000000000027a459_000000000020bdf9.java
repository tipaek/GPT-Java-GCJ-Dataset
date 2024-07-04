import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    static public void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));

        for (int i = 0; i < testCases; i++) {
            List<Timeslot> line = readInput(bufferedReader);
            String solution = solve(line);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    /**
     * 3
     * @return
     */

    static private List<Timeslot> readInput(BufferedReader bufferedReader) throws IOException {
        int size = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));
        List<Timeslot> timeslots = new LinkedList<>();
        for (int row = 0; row < size; row++) {
            String[] slot = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            Timeslot timeslot = new Timeslot();
            timeslot.start = Integer.parseInt(slot[0]);
            timeslot.end = Integer.parseInt(slot[1]);
            timeslots.add(timeslot);
        }
        return timeslots;
    }

    static private String solve(List<Timeslot> timeslots) {
        Collections.sort(timeslots);
        StringBuilder result = new StringBuilder();
        int endC = 0;
        int endJ = 0;
        for (Timeslot timeslot : timeslots) {
            if (timeslot.start >= endC) {
                endC = timeslot.end;
                result.append("C");
            } else if (timeslot.start >= endJ) {
                endJ = timeslot.end;
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private static class Timeslot implements Comparable<Timeslot> {
        int start;
        int end;

        @Override
        public int compareTo(Timeslot o) {
            if (o.start == start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }
}