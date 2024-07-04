
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Slot {
    int start;
    int end;

    public Slot(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    boolean isIn(int start, int end) {
        if (this.start < start && start < this.end)
            return true;
        return this.start < end && end < this.end;
    }
}

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();


        for (int i=1; i<= t; i++) {
            int n = in.nextInt();
            boolean impossible = false;
            ArrayList<Slot> c = new ArrayList<>();
            ArrayList<Slot> j = new ArrayList<>();
            String out = "";
            for (int k=0; k< n; k++) {
                if (impossible) {
                    in.nextLine();
                    continue;
                }
                int start = in.nextInt();
                int end = in.nextInt();
                boolean cCanDo = true;
                for (Slot cSlot : c) {
                    if (cSlot.isIn(start, end)) {
                        cCanDo = false;
                        break;
                    }
                }
                if (cCanDo) {
                    c.add(new Slot(start, end));
                    out += "C";
                    continue;
                }

                // check if jamie can do this
                for (Slot jSlot : j) {
                    if (jSlot.isIn(start, end)) {
                        impossible = true;
                        break;
                    }
                }
                if (!impossible) {
                    j.add(new Slot(start, end));
                    out += "J";
                }
            }
            if (impossible)
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            else
                System.out.println("Case #" + i + ": " + out);
        }
    }
}
