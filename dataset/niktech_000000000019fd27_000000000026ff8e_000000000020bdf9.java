
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class Slot implements Comparable<Slot> {
    int start;
    int end;
    int index;

    public Slot(final int start, final int end, final int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    boolean isIn(Slot s) {
        if (this.start < s.start && s.start < this.end)
            return true;
        return this.start < s.end && s.end < this.end;
    }

    @Override
    public int compareTo(final Slot slot) {
        if (this.start != slot.start)
            return this.start - slot.start;
        return this.end - slot.end;
    }
}

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();


        for (int i=1; i<= t; i++) {
            int n = in.nextInt();

            ArrayList<Slot> slots = new ArrayList<>(n);
            for (int k=0; k< n; k++) {
                int start = in.nextInt();
                int end = in.nextInt();
                slots.add(new Slot(start, end, k));
            }
            Collections.sort(slots);

            boolean impossible = false;
            StringBuilder out = new StringBuilder(n);
            out.setLength(n);

            Slot j = null;
            Slot c = slots.get(0);
            out.setCharAt(slots.get(0).index, 'C');

            for (int k=1; k< n; k++) {
                Slot slot = slots.get(k);
                boolean cCanDo = c == null || !c.isIn(slot);
                boolean jCanDo = j == null || !j.isIn(slot);

                if (jCanDo && !cCanDo) {
                    j = slot;
                    out.setCharAt(slot.index, 'J');
                    continue;
                }

                if (!jCanDo && cCanDo) {
                    c = slot;
                    out.setCharAt(slot.index, 'C');
                    continue;
                }

                if (!cCanDo && !jCanDo) {
                    impossible = true;
                    break;
                }

                if (j == null) {
                    j = slot;
                    out.setCharAt(slot.index, 'J');
                    continue;
                }

                if (c== null) {
                    c = slot;
                    out.setCharAt(slot.index, 'C');
                    continue;
                }

                if (j.end > c.end) {
                    c = slot;
                    out.setCharAt(slot.index, 'C');
                } else {
                    j = slot;
                    out.setCharAt(slot.index, 'J');
                }
            }
            if (impossible)
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + i + ": " + out);
        }
    }

    private static boolean canDo(final ArrayList<Slot> slots, final Slot slot) {
        for (Slot cSlot : slots) {
            if (cSlot.isIn(slot)) {
                return false;
            }
        }
        return true;
    }
}
