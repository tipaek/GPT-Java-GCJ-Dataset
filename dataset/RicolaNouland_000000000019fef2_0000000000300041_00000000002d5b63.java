import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Solution {


    private static boolean err = false;
    private final Scanner sc;
    private final static String CENTER = "CENTER";
    private final static String HIT = "HIT";
    private final static String MISS = "MISS";
//    private final static long limit = 1_000_000_000;
    private final static long limit = 4;


    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        String s = read(in);
        int[] line = lineToInt(s, " ");
        int t = line[0];// Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Solution solution = new Solution(in);
            solution.solve();
        }

    }


    private void solve() {


        long start = binarySearch(-limit, limit, x -> isInside(x, 0L));
        long end = binarySearch(start, limit, x -> !isInside(x, 0L));

        long centerX = (start + end)/2;

        long topCenter = binarySearch(-limit, 0, y -> isInside(centerX, y));
        long bottomCenter = binarySearch(-limit, 0, y -> !isInside(centerX, y));

        long centerY = (topCenter+bottomCenter)/2;

        for (int i = -3; i <= 3; i++) {
            for (int j = -3; j < 3; j++) {
                print(String.format("%d %d", centerX, centerY));
                if(read(sc).equals(CENTER)) return;
            }
        }

      throw new RuntimeException();
    }

    private long binarySearch(long left, long right, Function<Long, Boolean> check) {
        if(check.apply(left)){
            return left;
        }
        while (left < right) {
            long m = left+ (right -left) / 2;

            if(!check.apply(m)){
                left = m+1;
            }
            else right = m;

        }

        return left;
    }

    private boolean isInside(long x, long y) {
        print(String.format("%d %d", x, y));
        String read = read(sc);
        return read.equals(CENTER)  ||  read.equals(HIT);
    }

    public Solution(Scanner sc) {
        this.sc = sc;
    }


    private void print(String s) {
        System.out.println(s);
        if (err) {
            System.err.println("out: " + s);
        }
        System.out.flush();
    }

    private static String read(Scanner sc) {
        String s = sc.nextLine();
        if (err) {
            System.err.println("in: " + s);
        }
        return s;
    }

    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }
}
