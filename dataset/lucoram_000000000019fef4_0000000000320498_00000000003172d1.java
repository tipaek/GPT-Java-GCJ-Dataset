import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        outer:for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int d = in.nextInt();

            List<Slice> slicesByOccs = new ArrayList<>();
            List<Slice> slicesBySize = new ArrayList<>();
            Map<Long, Slice> slicesOccs = new HashMap<>();

            for (int j = 0; j < n; j++) {
                long sliceVal = in.nextLong();

                Slice current;

                if (slicesOccs.containsKey(sliceVal)) {
                    current = slicesOccs.get(sliceVal);
                } else {
                    current = new Slice(sliceVal);
                    slicesOccs.put(sliceVal, current);
                    slicesByOccs.add(current);
                    slicesBySize.add(current);
                }

                current.occs++;
            }

            Collections.sort(slicesByOccs);
            Collections.sort(slicesBySize, new SizeComp());

            int minCut = -1;

            for(Slice s : slicesByOccs) {
                if(s.occs >= d || d == 1) {
                    System.out.println("Case #" + i + ": 0");
                    continue outer;
                }

                int neededSlices = d - s.occs;
                int cutCount = 0;

                for(Slice r : slicesBySize) {
                    if(s.equals(r)) {
                        continue;
                    }

                    if(r.value > s.value) {
                        long rr = r.value;
                        long ss = s.value;
                        while(rr > ss && neededSlices > 0) {
                            rr -= ss;
                            cutCount++;
                            neededSlices--;
                        }

                        if(rr == ss && neededSlices > 0) {
                            neededSlices--;
                        }

                        if(neededSlices == 0) {
                            minCut = minCut == -1 ? cutCount : Math.min(cutCount, minCut);
                        }
                    }
                }
            }

            if(minCut > 0) {
                System.out.println("Case #" + i + ": " + minCut);
                continue outer;
            }

            // here we need wholenum division, number of cuts must be d - 1;

            System.out.println("Case #" + i + ": " + (d - 1));
        }
    }
}

class SizeComp implements Comparator<Slice> {

    @Override
    public int compare(Slice left, Slice right) {
        if (left.value > right.value) {
            return 1;
        }
        if (left.value < right.value) {
            return -1;
        }
        return 0;
    }

}

class Slice implements Comparable<Slice> {
    long value;
    int occs;

    public Slice(long value) {
        this.value = value;
    }

    @Override
    public int compareTo(Slice other) {
        return occs - other.occs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (value ^ (value >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Slice other = (Slice) obj;
        if (value != other.value)
            return false;
        return true;
    }
}