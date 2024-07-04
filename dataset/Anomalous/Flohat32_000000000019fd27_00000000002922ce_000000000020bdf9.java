import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // read 1st line of input, 1st line corresponds to an int
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int event = Integer.parseInt(sc.nextLine());
            int J = 0;
            int C = 0;
            String res = "";
            int[][] events = new int[event][2];
            for (int e = 0; e < event; e++) {
                String[] parts = sc.nextLine().split(" ");
                events[e][0] = Integer.parseInt(parts[0]);
                events[e][1] = Integer.parseInt(parts[1]);
            }
            EventIndex[] evSort = new EventIndex[event];
            for (int i = 0; i < event; i++) {
                evSort[i] = new EventIndex(events[i], i);
            }
            Arrays.sort(evSort, Comparator.comparingInt(e -> e.event[0]));
            char[] resArray = new char[event];
            boolean impossible = false;
            for (EventIndex ei : evSort) {
                int[] nums = ei.event;
                int ix = ei.index;
                if (nums[0] >= C) {
                    C = nums[1];
                    resArray[ix] = 'C';
                } else if (nums[0] >= J) {
                    J = nums[1];
                    resArray[ix] = 'J';
                } else {
                    res = "IMPOSSIBLE";
                    impossible = true;
                    break;
                }
            }
            if (!impossible) {
                res = new String(resArray);
            }
            System.out.println("Case #" + caseNum + ": " + res);
        }
        sc.close();
    }

    static class EventIndex {
        int[] event;
        int index;

        EventIndex(int[] event, int index) {
            this.event = event;
            this.index = index;
        }
    }
}