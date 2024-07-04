import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        Slice[] listSlicesSorted = new Slice[20000];
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + calculateMinimumCuts(listSlicesSorted));
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
            if (!(obj instanceof Slice))
                return false;
            Slice slice = (Slice) obj;
            return this.size == slice.size;
        }

        @Override
        public int compareTo(Slice other) {
            long diff = this.size - other.size;
            return diff > 0 ? -1 : 1;
        }
    }

    private static int calculateMinimumCuts(Slice[] listSlicesSorted) {
        int N = in.nextInt(); // Number of slices
        int D = in.nextInt(); // Number of diners
        Map<Slice, Slice> sliceMap = new HashMap<>();
        Slice tempSlice = new Slice(0L);
        int cuts = 0;
        TreeSet<Slice> sliceSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            long sliceSize = in.nextLong();
            tempSlice.size = sliceSize;

            if (sliceMap.containsKey(tempSlice)) {
                Slice existingSlice = sliceMap.get(tempSlice);
                existingSlice.count++;
                if (existingSlice.count == D) return 0;
            } else {
                Slice newSlice = new Slice(sliceSize);
                sliceMap.put(newSlice, newSlice);
                sliceSet.add(newSlice);
            }
        }

        int index = 0;
        for (Slice slice : sliceSet) {
            listSlicesSorted[index++] = slice;
        }

        int minCuts = D - 1;
        if (D == 2) return 1;

        for (int i = 0; i < sliceSet.size(); i++) {
            Slice currentSlice = listSlicesSorted[i];
            if (currentSlice.count == 2) {
                tempSlice.size = currentSlice.size * 2;
                if (sliceSet.contains(tempSlice)) {
                    return 1;
                }
            }
        }

        return minCuts;
    }
}