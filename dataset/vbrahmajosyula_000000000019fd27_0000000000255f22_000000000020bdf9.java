import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static class Slot {
        public int position;
        public int begin;
        public int end;

        public Slot(int position, int begin, int end) {
            this.position = position;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Slot{" +
                    "position=" + position +
                    ", begin=" + begin +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            compute(in, i);
        }
    }

    private static void compute(Scanner in, int test) {

        int noOfSlots = in.nextInt();
        List<Slot> slots = new ArrayList<>();
        char[] allotments = new char[noOfSlots];
        for (int i=0; i < noOfSlots; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            Slot slot = new Slot(i, begin, end);
            slots.add(slot);
        }

        slots.sort((Comparator.comparingInt(s -> s.end)));

        boolean cAvailable = true;
        int cBusyFrom = Integer.MAX_VALUE;
        boolean jAvailable = true;
        int jBusyFrom = Integer.MAX_VALUE;
        boolean isImpossible = false;

        for (int i = slots.size() - 1 ; i >= 0; i--) {
            Slot slot = slots.get(i);

            if (cBusyFrom >= slot.end) {
                cAvailable = true;
            }

            if (jBusyFrom >= slot.end) {
                jAvailable = true;
            }

            if (cAvailable) {
                allotments[slot.position] = 'C';
                cAvailable = false;
                cBusyFrom = slot.begin;
            } else if (jAvailable) {
                allotments[slot.position] = 'J';
                jAvailable = false;
                jBusyFrom = slot.begin;
            } else {
                isImpossible = true;
                break;
            }
        }


        printOutput(test, allotments, isImpossible);
    }

    private static void printOutput(int test, char[] allotments, boolean isImpossible) {
        if (isImpossible) {
            System.out.printf("Case #%d: IMPOSSIBLE\n", test + 1);
        } else {
            System.out.printf("Case #%d: %s\n", test + 1, new String(allotments));
        }
    }
}
