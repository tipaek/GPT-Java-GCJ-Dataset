
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
    private final static long limit = 1_000_000_000;
//    private final static long limit = 4;


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

        long[] inside = findInside();

        long start = binarySearch(-limit, inside[0], x -> isInside(x, 2));

        long end = binarySearch(start, limit, x -> !isInside(x, 0));

        long centerX = (start + end)/2;

        long bottomCenter = binarySearch(-limit, limit, y -> isInside(centerX, y));
        long topCenter = binarySearch(bottomCenter, limit, y -> !isInside(centerX, y));

        long centerY = (topCenter+bottomCenter)/2;

        int[] d = new int[]{0, 1, -1, 2, -2, 3, -3, 4, -4, 5, -5, 6, -6, 7, -7, 8, -8, 9, -9, 10, -10};
        for (int dx : d) {
            for (int dy : d) {
                print(String.format("%d %d", centerX+dx, centerY+dy));
                if(read(sc).equals(CENTER)) return;
            }
        }

        throw new RuntimeException();
    }

    private long[] findInside(){
        long[] l = {-limit/2, -limit/2};
        if(isInside(l[0], l[1])){
            return l;
        }

        l = new long[]{-limit/2, limit/2};
        if(isInside(l[0], l[1])){
            return l;
        }

        l = new long[]{limit/2, -limit/2};
        if(isInside(l[0], l[1])){
            return l;
        }

        l = new long[]{limit/2, limit/2};
        if(isInside(l[0], l[1])){
            return l;
        }

        l = new long[]{0, 0};
        if(isInside(l[0], l[1])){
            return l;
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
        if(s.equals("WRONG")){
          System.exit(0);
        }
        return s;
    }

    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }
}
