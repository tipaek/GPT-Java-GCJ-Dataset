import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        in.nextLine();
        StringBuilder output = new StringBuilder();
        ArrayList<Pair> list;
        for (int i = 1; i <= tc; i++) {
            int n = in.nextInt();
            in.nextLine();
            list = new ArrayList<>(n);
            while (n-- > 0) {
                String line = in.nextLine();
                String[] ele = line.split(" ");
                list.add(new Pair(Integer.parseInt(ele[0]), Integer.parseInt(ele[1])));
            }
            String result = allocateSlot((ArrayList<Pair>)list.clone());
            StringBuilder currentOutput = new StringBuilder(list.size());
            if (result.equals("0")) {
                for (Pair slot : list) {
                    currentOutput.append(slot.slot);
                }
            } else {
                currentOutput = new StringBuilder(result);
            }
            if (i == tc) {
                output.append("Case #" + i + ": " + currentOutput.toString());
            } else {
                output.append("Case #" + i + ": " + currentOutput.toString() + "\n");
            }
        }
        System.out.println(output);
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;
        char slot;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        void setSlot(char slot) {
            this.slot = slot;
        }

        char getSlot() {
            return this.slot;
        }

        @Override
        public int compareTo(Pair o) {
            return (o.start == this.start) ? 0 : o.start < this.start ? 1 : -1;
        }
    }

    static String allocateSlot(ArrayList<Pair> input) {
        //List<Pair> inputStill = input;
        Collections.sort(input);
        int c = -1, j = -1;
        //StringBuilder output = new StringBuilder(input.size());
        for (Pair slot : input) {
            if (c == -1) {
                slot.slot = 'C';
                c = slot.end;
            } else if (j == -1) {
                slot.slot = 'J';
                j = slot.end;
            } else if (c <= slot.start) {
                slot.slot = 'C';
                c = slot.end;
            } else if (j <= slot.start) {
                slot.slot = 'J';
                j = slot.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return "0";
    }
}
