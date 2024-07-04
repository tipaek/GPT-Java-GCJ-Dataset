import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    private static void processTestCase(Scanner scanner, int caseNumber) {
        int n = scanner.nextInt();
        List<Slot> slots = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            slots.add(new Slot(i, scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < slots.size() - 1; i++) {
            for (int j = i + 1; j < slots.size(); j++) {
                if (slots.get(i).conflicts(slots.get(j))) {
                    slots.get(i).addOverlap(slots.get(j));
                    slots.get(j).addOverlap(slots.get(i));
                }
            }
        }

        boolean isPossible = assignOwners(slots);

        System.out.print("Case #" + caseNumber + ": ");
        if (isPossible) {
            slots.forEach(slot -> System.out.print(slot.owner == 0 ? "C" : "J"));
            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean assignOwners(List<Slot> slots) {
        Queue<Slot> queue = new LinkedList<>();
        for (Slot slot : slots) {
            if (slot.owner == -1) {
                slot.owner = 0;
                slot.visited = true;
                queue.add(slot);
                while (!queue.isEmpty()) {
                    Slot current = queue.poll();
                    for (Slot overlap : current.overlaps) {
                        if (!overlap.visited) {
                            overlap.visited = true;
                            overlap.owner = 1 - current.owner;
                            queue.add(overlap);
                        } else if (overlap.owner == current.owner) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static class Slot {
        int number;
        int start;
        int end;
        int owner;
        boolean visited;
        List<Slot> overlaps;

        Slot(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
            this.owner = -1;
            this.visited = false;
            this.overlaps = new ArrayList<>();
        }

        void addOverlap(Slot slot) {
            overlaps.add(slot);
        }

        boolean conflicts(Slot slot) {
            return (this.start < slot.end && this.end > slot.start);
        }
    }
}