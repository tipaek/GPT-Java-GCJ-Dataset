import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            List<List<Integer>> ts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                ArrayList<Integer> l = new ArrayList<>();
                l.add(s);
                l.add(e);
                l.add(i);
                ts.add(l);
            }
            ts.sort(Comparator.comparing(task -> task.get(0)));

            int cEnd = -1, jEnd = -1;
            boolean failed = false;
            for (List<Integer> task : ts) {
                if (cEnd <= task.get(0)) {
                    cEnd = task.get(1);
                    task.add(0);
                } else {
                    if (jEnd <= task.get(0)) {
                        jEnd = task.get(1);
                        task.add(1);
                    } else {
                        failed = true;
                        break;
                    }
                }
            }
            ts.sort(Comparator.comparing(task -> task.get(2)));

            String[] cs = {"C", "J"};
            System.out.println("Case #" + t + ": " + (failed ?
                    "IMPOSSIBLE"
                    : ts.stream().map(task -> cs[task.get(3)]).collect(Collectors.joining())));
        }
    }
}
