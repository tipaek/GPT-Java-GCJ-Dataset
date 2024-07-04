import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            solve(in, testCase);
        }
    }

    static void solve(Scanner in, int testCase) {
        int N = in.nextInt();
        int D = in.nextInt();
        ArrayList<Long> al = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            al.add(in.nextLong() * 10000000L);
        }
        ArrayList<Slice> sl = new ArrayList<>(N * D);
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= D; j++) {
                sl.add(new Slice(j, (al.get(i)) / j));
            }
        }

        Map<Double, List<Slice>> grouped = sl.stream().collect(Collectors.groupingBy(Slice::getSize));
        int mn = 51;
        for (List<Slice> slices : grouped.values()) {

            slices.sort(Comparator.comparingInt(Slice::getParts));
            int parts = 0;
            for (int i = 0; i < slices.size(); i++) {
                parts += slices.get(i).parts;
                if (parts == D) {
                    mn = Math.min(mn, D - i - 1);
                    break;
                }
                if (parts > D) {
                    mn = Math.min(mn, D - i);
                    break;
                }
            }
        }
        ot(testCase, String.valueOf(mn));
    }


    static class Slice {
        private final int parts;
        private final long size;

        Slice(int parts, long size) {
            this.parts = parts;
            this.size = size;
        }

        public int getParts() {
            return parts;
        }

        public double getSize() {
            return size;
        }
    }

    static void ot(int testCase, String s) {
        System.out.println(String.format("Case #%d: %s", testCase, s));
    }

}