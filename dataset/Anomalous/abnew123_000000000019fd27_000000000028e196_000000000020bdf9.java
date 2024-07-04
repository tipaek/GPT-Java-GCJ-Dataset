import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            StringBuilder answer = new StringBuilder();
            int n = in.nextInt();
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            boolean impossible = false;
            
            for (int j = 0; j < n; j++) {
                int[] event = {in.nextInt(), in.nextInt()};
                boolean cameronConflict = hasConflict(event, cameron);
                boolean jamieConflict = hasConflict(event, jamie);
                
                if (cameronConflict && jamieConflict) {
                    impossible = true;
                } else if (!cameronConflict) {
                    cameron.add(event);
                    answer.append("C");
                } else {
                    jamie.add(event);
                    answer.append("J");
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + answer.toString());
            }
        }
    }

    private static boolean hasConflict(int[] event, List<int[]> schedule) {
        for (int[] scheduledEvent : schedule) {
            if (isOverlapping(scheduledEvent, event)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverlapping(int[] e1, int[] e2) {
        return !(e1[1] <= e2[0] || e1[0] >= e2[1]);
    }
}