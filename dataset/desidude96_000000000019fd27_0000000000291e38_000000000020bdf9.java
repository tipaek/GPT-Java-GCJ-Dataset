import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int size = in.nextInt();
            List<TimeObject> rows = new ArrayList<>();
            for (int j = 0; j < size; j++) rows.add(new TimeObject(in.nextInt(), in.nextInt(), j));
            Collections.sort(rows, (a,b) -> Integer.compare(a.start, b.start));
            String result = "";
            if (buildOrdering(rows).equals("IMPOSSIBLE")) result = "IMPOSSIBLE";
            else { 
                Collections.sort(rows, (a,b) -> Integer.compare(a.position, b.position));
                for (TimeObject time: rows) result += time.person;
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String buildOrdering(List<TimeObject> times) {
        int cameronEnd = 0;
        int jamieEnd = 0;
        for (TimeObject time: times) {
            int start = time.start;
            int end = time.end;
            if (start >= cameronEnd) {
                time.person = "C";
                cameronEnd = end;
            } else if (start >= jamieEnd) {
                time.person = "J";
                jamieEnd = end;
            } else return "IMPOSSIBLE";
        }
        return "";
    }
    
    private static class TimeObject {
        int start;
        int end;
        int position;
        String person;
        
        public TimeObject(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }
}