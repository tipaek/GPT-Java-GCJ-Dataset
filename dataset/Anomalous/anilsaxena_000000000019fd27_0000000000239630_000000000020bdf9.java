import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;
    private static int N;
    private static Slot[] slots;

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCount = scanner.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = scanner.nextInt();
            slots = new Slot[N];
            for (int i = 0; i < N; i++) {
                slots[i] = new Slot(scanner.nextInt(), scanner.nextInt());
            }
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        Slot[] originalSlots = Arrays.copyOf(slots, slots.length);
        Arrays.sort(slots);

        for (int i = 0; i < slots.length; i++) {
            Slot slot = slots[i];
            for (int j = i + 1; j < slots.length; j++) {
                Slot other = slots[j];
                if (other.start < slot.end) {
                    slot.children.add(other);
                    other.children.add(slot);
                }
            }
        }

        for (Slot slot : slots) {
            if (slot.assignment == null) {
                slot.assignment = "C";
                if (!assignSlot(slot)) {
                    return "IMPOSSIBLE";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Slot slot : originalSlots) {
            result.append(slot.assignment);
        }
        return result.toString();
    }

    private static boolean assignSlot(Slot slot) {
        for (Slot child : slot.children) {
            if (child.assignment == null) {
                child.assignment = slot.assignment.equals("C") ? "J" : "C";
                if (!assignSlot(child)) {
                    return false;
                }
            } else {
                if (child.assignment.equals(slot.assignment)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String joinValues(List<? extends Object> list, String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private static String joinValues(int[] array, String delimiter) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(delimiter));
    }

    private static int[] readInts(Scanner scanner, int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printDebug(Object message) {
        if (debug) {
            System.out.println("DEBUG: " + message);
        }
    }

    private static class Slot implements Comparable<Slot> {
        String assignment;
        int start, end;
        Set<Slot> children = new TreeSet<>();

        public Slot(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Slot other) {
            if (start == other.start) {
                if (end == other.end) {
                    return Integer.compare(hashCode(), other.hashCode());
                } else {
                    return Integer.compare(end, other.end);
                }
            }
            return Integer.compare(start, other.start);
        }

        @Override
        public String toString() {
            return start + "-" + end;
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }
}