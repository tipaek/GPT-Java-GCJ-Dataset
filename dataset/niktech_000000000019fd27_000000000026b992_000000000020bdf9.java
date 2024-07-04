
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
            ArrayList<Slot> c = new ArrayList<>();
            ArrayList<Slot> j = new ArrayList<>();
            StringBuilder out = new StringBuilder(n);
            out.setLength(n);

            c.add(slots.get(0));
            out.setCharAt(slots.get(0).index, 'C');

            for (int k=1; k< n; k++) {
                if (impossible) {
                    break;
                }
                Slot slot = slots.get(k);
                boolean cCanDo = canDo(c, slot);
                boolean jCanDo = canDo(j, slot);

                if (jCanDo && !cCanDo) {
                    j.add(slot);
                    out.setCharAt(slot.index, 'J');
                    continue;
                }

                if (cCanDo && !jCanDo) {
                    c.add(slot);
                    out.setCharAt(slot.index, 'C');
                    continue;
                }

                if (!cCanDo && !jCanDo) {
                    impossible = true;
                    continue;
                }

                if (j.isEmpty()) {
                    j.add(slot);
                    out.setCharAt(slot.index, 'J');
                    continue;
                }

                if (c.isEmpty()) {
                    c.add(slot);
                    out.setCharAt(slot.index, 'C');
                    continue;
                }

                if (j.get(j.size()-1).end > c.get(c.size()-1).end) {
                    c.add(slot);
                    out.setCharAt(slot.index, 'C');
                } else {
                    j.add(slot);
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
