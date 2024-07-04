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
        List<Pair> list;
        for (int i = 1; i <= tc; i++) {
            int n = in.nextInt();
            in.nextLine();
            list = new ArrayList<>(n);
            while (n-- > 0) {
                String line = in.nextLine();
                String[] ele = line.split(" ");
                list.add(new Pair(Integer.parseInt(ele[0]), Integer.parseInt(ele[1])));
            }
            if (i == tc) {
                output.append("Case #" + i + ": " + allocateSlot(list));
            } else {
                output.append("Case #" + i + ": " + allocateSlot(list) + "\n");
            }
        }
        System.out.println(output);
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return (o.start == this.start) ? 0 : o.start < this.start ? 1 : -1;
        }
    }

    static String allocateSlot(List<Pair> input) {
        Collections.sort(input);
        int c = -1, j = -1;
        StringBuilder output = new StringBuilder(input.size());
        for (Pair slot : input) {
            if (c == -1) {
                output.append("C");
                c = slot.end;
            } else if (j == -1) {
                output.append("J");
                j = slot.end;
            } else if (c <= slot.start) {
                output.append("C");
                c = slot.end;
            } else if (j <= slot.start) {
                output.append("J");
                j = slot.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return output.toString();
    }
}
