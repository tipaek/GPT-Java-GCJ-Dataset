import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        Slice[] listSlicesSorted = new Slice[20000];
        for (int i = 1; i <= T; i++) {
            System.out.println("Case #" + i + ": " + secret(listSlicesSorted));
        }
    }

    public static class Slice implements Comparable<Slice> {
        long size;
        int times;

        public Slice(long size) {
            this.times = 1;
            this.size = size;
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
        public int compareTo(Slice o) {
//            if (this.times > o.times)
//                return -1;
//            if (this.times < o.times)
//                return 1;
            long diff = this.size - o.size;
            if (diff > 0)
                return -1;
            return 1;
        }
    }

    private static int secret(Slice[] listSlicesSorted) {
        int N = in.nextInt(); // Current number of slices
        int D = in.nextInt(); // Number of diners, of the cake!
        Map<Slice, Slice> numToCount = new HashMap<>(); // Change to size+times

        Slice fakeSlice = new Slice(0L);

        int numCuts = 0;

        TreeSet<Slice> allSlices = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            long Ai = in.nextLong();

            fakeSlice.size = Ai;

            if (numToCount.containsKey(fakeSlice)) {
                Slice oldSlice = numToCount.get(fakeSlice);
                oldSlice.times++;

                if (oldSlice.times == D)
                    return 0;
            } else {
                Slice newSlice = new Slice(Ai);

                numToCount.put(newSlice, newSlice);

                allSlices.add(newSlice);
            }
        }

        int k = 0;

        for (Slice slice : allSlices) {
            listSlicesSorted[k] = slice;
            k++;
        }

        int min = D - 1;

        if (D == 2)
            return 1;

        for (int i = 0; i < allSlices.size(); i++) {
            Slice targetSlice = listSlicesSorted[i];

            if (targetSlice.times == 2) {
                fakeSlice.size = targetSlice.size * 2;
                if (allSlices.contains(fakeSlice)) {
                    return 1;
                }
            }
        }

        return min;


//        for (int i = 0; i < allSlices.size(); i++) {
//            Slice targetSlice = listSlicesSorted[i];
//            long totalCanAdd = 0;
//            for (int ip = 0; ip < i; ip++) {
//                Slice friendSlice = listSlicesSorted[ip];
//
////                    for(int time = 0; time < friendSlice.times; time++) {
//                long singleCanAdd = friendSlice.size / targetSlice.size;
//
//                totalCanAdd += singleCanAdd * friendSlice.times;
//
//                // singleCanAdd -1, if 
//
//
////                    }
//
//            }
//
//            if (totalCanAdd + targetSlice.times >= D) {
//                int value = 500;
//
//                Math.min(min, value);
//            }
//        }

//        return min;
//
    }
}
