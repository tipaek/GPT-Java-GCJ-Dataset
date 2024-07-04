import java.util.*;

class Slot {
    int start;
    int end;
    int index;
    char assignee;

    public Slot(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            Slot[] slots = new Slot[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                slots[i] = new Slot(start, end, i);
            }

            Arrays.sort(slots, Comparator.comparingInt(slot -> slot.start));

            boolean isImpossible = false;
            StringBuilder result = new StringBuilder();
            int endC = slots[0].end;
            int endJ = slots[1].end;
            slots[0].assignee = 'C';
            slots[1].assignee = 'J';

            for (int i = 2; i < n; i++) {
                int startTime = slots[i].start;
                if (startTime < endC && startTime < endJ) {
                    isImpossible = true;
                    break;
                } else if (startTime >= endC) {
                    endC = slots[i].end;
                    slots[i].assignee = 'C';
                } else {
                    endJ = slots[i].end;
                    slots[i].assignee = 'J';
                }
            }

            Arrays.sort(slots, Comparator.comparingInt(slot -> slot.index));

            for (Slot slot : slots) {
                result.append(slot.assignee);
            }

            System.out.println("Case #" + caseNumber + ": " + (isImpossible ? "IMPOSSIBLE" : result.toString()));
            caseNumber++;
        }
    }
}