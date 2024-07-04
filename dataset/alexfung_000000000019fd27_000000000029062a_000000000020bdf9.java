import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(), test = 1;
        int N;
        while (test <= T) {
            N = scan.nextInt();
            TreeMap<Integer, ArrayList<Integer>> intervals = new TreeMap<>();
            ArrayList<Integer> ends;
            for (int i = 0; i < N; i++) {
                int start = scan.nextInt(), end = scan.nextInt();
                if (intervals.containsKey(start)) {
                    intervals.get(start).add(end);
                } else {
                    ends = new ArrayList<>();
                    ends.add(end);
                    intervals.put(start, ends);
                }
            }
            int cFree = 0, jFree = 0;
            StringBuilder duties = new StringBuilder();
            boolean possible = true;
            for (int start : intervals.keySet()) {
                if (!possible) {
                    break;
                }
                for (int end : intervals.get(start)) {
                    if (cFree <= start) {
                        duties.append("C");
                        cFree = end;
                    } else if (jFree <= start) {
                        duties.append("J");
                        jFree = end;
                    } else {
                        possible = false;
                    }
                }
            }
            System.out.println(String.format(
                    "Case #%d: %s", test, possible ? duties.toString() : "IMPOSSIBLE"));
            test++;
        }
    }

}
