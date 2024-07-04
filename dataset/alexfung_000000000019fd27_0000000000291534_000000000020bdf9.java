import java.lang.reflect.Array;
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
                    intervals.get(start).add(i);
                    intervals.get(start).add(end);
                } else {
                    ends = new ArrayList<>();
                    ends.add(i);
                    ends.add(end);
                    intervals.put(start, ends);
                }
            }
            int cFree = 0, jFree = 0;
            char[] duties = new char[N];
            boolean possible = true;
            for (int start : intervals.keySet()) {
                if (!possible) {
                    break;
                }
                ends = intervals.get(start);
                for (int i = 0; i < ends.size() / 2; i++) {
                    if (cFree <= start) {
                        duties[ends.get(2 * i)] = 'C';
                        cFree = ends.get(2 * i + 1);
                    } else if (jFree <= start) {
                        duties[ends.get(2 * i)] = 'J';
                        jFree = ends.get(2 * i + 1);
                    } else {
                        possible = false;
                    }
                }
            }
            System.out.println(String.format(
                    "Case #%d: %s", test, possible ? new String(duties)
                            : "IMPOSSIBLE"));
            test++;
        }
    }

}
