import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(scanner, i + 1);
        }
    }

    public static void solve(Scanner scanner, int caseNumber) {
        boolean isPossible = true;
        int numberOfSlots = scanner.nextInt();
        List<Slot> slots = new ArrayList<>();
        
        for (int i = 0; i < numberOfSlots; i++) {
            slots.add(new Slot(i + 1, scanner.nextInt(), scanner.nextInt()));
        }
        
        for (int i = 0; i < slots.size() - 1; i++) {
            for (int j = i + 1; j < slots.size(); j++) {
                if (slots.get(i).conflicts(slots.get(j))) {
                    slots.get(i).addOverlap(slots.get(j));
                    slots.get(j).addOverlap(slots.get(i));
                }
            }
        }
        
        Queue<Slot> queue = new LinkedList<>();
        for (Slot slot : slots) {
            if (slot.owner == -1) {
                slot.owner = 0;
                slot.visited = true;
                queue.add(slot);
                
                while (!queue.isEmpty()) {
                    Slot currentSlot = queue.poll();
                    for (Slot overlapSlot : currentSlot.overlaps) {
                        if (!overlapSlot.visited) {
                            overlapSlot.visited = true;
                            overlapSlot.owner = (currentSlot.owner == 0) ? 1 : 0;
                            queue.add(overlapSlot);
                        } else if (currentSlot.owner == overlapSlot.owner) {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
        }
        
        System.out.print("Case #" + caseNumber + ": ");
        if (!isPossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (Slot slot : slots) {
                System.out.print(slot.owner == 0 ? "C" : "J");
            }
            System.out.println();
        }
    }
}

class Slot {
    public int number;
    public int start;
    public int end;
    public int owner;
    public boolean visited;
    public List<Slot> overlaps;

    Slot(int number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
        this.owner = -1;
        this.visited = false;
        this.overlaps = new ArrayList<>();
    }

    public void addOverlap(Slot slot) {
        overlaps.add(slot);
    }

    public boolean conflicts(Slot slot) {
        return (this.start < slot.end && this.end > slot.start);
    }
}