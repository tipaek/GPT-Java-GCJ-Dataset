import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.println(String.format("Case #%d: %s", i, solve(in)));
        }
    }

    private static String solve(Scanner sc) {
        int N = sc.nextInt();

        List<Slot> slots = new ArrayList<>();
        for(int i = 0; i< N; ++i) {
            slots.add(new Slot(sc.nextInt(), sc.nextInt(), i));
        }

        slots.sort(Comparator.comparingInt(Slot::getStart).thenComparingInt(Slot::getEnd));

        int cFree = 0;
        int jFree = 0;
        char[] solution = new char[N];

        for(Slot slot: slots) {
            if(slot.getStart() >= cFree) {
                cFree = slot.getEnd();
                solution[slot.getIndex()] = 'C';
            } else {
                if(slot.getStart() >= jFree) {
                    jFree = slot.getEnd();
                    solution[slot.getIndex()] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        return new String(solution);
    }

    static class Slot {
        private final int start;
        private final int end;
        private final int index;

        public Slot(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }
    }
}
  