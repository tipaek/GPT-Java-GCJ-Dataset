
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
        return this.start - slot.start;
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
            for (int k=0; k< n; k++) {
                if (impossible) {
                    break;
                }
                Slot slot = slots.get(k);
                boolean cCanDo = true;
                for (Slot cSlot : c) {
                    if (cSlot.isIn(slot)) {
                        cCanDo = false;
                        break;
                    }
                }
                if (cCanDo) {
                    c.add(slot);
                    out.setCharAt(slot.index, 'C');
                    continue;
                }

                // check if jamie can do this
                for (Slot jSlot : j) {
                    if (jSlot.isIn(slot)) {
                        impossible = true;
                        break;
                    }
                }
                if (!impossible) {
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
}
