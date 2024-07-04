import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        Slice[] sortedSlices = new Slice[20000];
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + calculateCuts(sortedSlices));
        }
    }

    public static class Slice implements Comparable<Slice> {
        long size;
        int count;

        public Slice(long size) {
            this.size = size;
            this.count = 1;
        }

        @Override
        public int hashCode() {
            return (int) (this.size % 100000);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Slice)) return false;
            Slice other = (Slice) obj;
            return this.size == other.size;
        }

        @Override
        public int compareTo(Slice other) {
            long diff = this.size - other.size;
            return diff > 0 ? -1 : 1;
        }
    }

    private static int calculateCuts(Slice[] sortedSlices) {
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        Map<Slice, Slice> sliceMap = new HashMap<>();
        Slice tempSlice = new Slice(0L);
        TreeSet<Slice> sliceSet = new TreeSet<>();
        int cuts = 0;

        for (int i = 0; i < N; i++) {
            long size = scanner.nextLong();
            tempSlice.size = size;

            if (sliceMap.containsKey(tempSlice)) {
                Slice existingSlice = sliceMap.get(tempSlice);
                existingSlice.count++;
                if (existingSlice.count >= D) return 0;
            } else {
                Slice newSlice = new Slice(size);
                sliceMap.put(newSlice, newSlice);
                sliceSet.add(newSlice);
            }
        }

        int index = 0;
        for (Slice slice : sliceSet) {
            sortedSlices[index++] = slice;
        }

        int minCuts = D - 1;
        if (D == 2) return 1;

        for (int i = 0; i < sliceSet.size(); i++) {
            Slice targetSlice = sortedSlices[i];
            if (targetSlice.count == 2) {
                tempSlice.size = targetSlice.size * 2;
                if (sliceSet.contains(tempSlice)) return 1;
            }
        }

        return minCuts;
    }
}