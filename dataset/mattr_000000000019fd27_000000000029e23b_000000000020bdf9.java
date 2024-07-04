
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            doCase(in, i);
        }
    }

    public static void solve(Scanner sc) {
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            doCase(sc, i);
        }
    }

    private static void doCase(Scanner sc, int caseNumber) {
        int n = Integer.parseInt(sc.nextLine());
        LinkedList<int[]> activities = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i ++) {
            String [] times = sc.nextLine().split(" ");
            activities.add(new int[]{ Integer.parseInt(times[0]), Integer.parseInt(times[1])});
        }
        
        activities = activities.stream().sorted(Comparator.comparingInt(a -> a[0])).collect(Collectors.toCollection(LinkedList::new));
        
        int cameronEndTime = -1;
        int jamieEndTime = -1;
        
        for (int[] activity : activities) {
            int actStart = activity[0];
            int actEnd = activity[1];
            if (actStart >= cameronEndTime) {
                sb.append("C");
                cameronEndTime = actEnd;
            } else if (actStart >= jamieEndTime) {
                sb.append("J");
                cameronEndTime = actEnd;
            } else {
                System.out.println("Case #" + Integer.toString(caseNumber) + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + Integer.toString(caseNumber) + ": " + sb.toString());
    }
}
