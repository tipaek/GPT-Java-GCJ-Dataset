import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Expogo {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final int EMPTY = '_';

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 0; i < t; ++i) {

            long[] a = split(in.nextLine(), 2);
            long x = a[0];
            long y = a[1];
            String result = solve(x, y);
            String answer = "Case #" + (i + 1) + ": " + result;
            out.write(answer);
            out.newLine();
        }
        in.close();
        out.close();
    }

    static String solve(long x, long y) {
        String result = solveSimple(Math.abs(x), Math.abs(y));
        if (IMPOSSIBLE.equals(result)) {
            return result;
        }
        if (x < 0) {
            result = swap(result, 'W', 'E');
        }
        if (y < 0) {
            result = swap(result, 'N', 'S');
        }
        return result;
    }

    static String swap(String s, char c1, char c2) {
        return s.replace(c1, '_').replace(c2, c1).replace('_', c2);
    }

    static String solveSimple(long x, long y) {
        long xp2 = pow2up(x);
        long yp2 = pow2up(y);
        long xc = xp2 - x;
        long yc = yp2 - y;
        if (x == 0 && pow2(y + 1)) {
            return toString(toArray(y, 'N'));
        } else if (y==0 && pow2(x+1)) {
            return toString(toArray(x, 'E'));
        }else if (pow2(x + y + 1)){
            return toString(merge(toArray(x, 'E'), toArray(y, 'N')));
        } else if (pow2(xc + xp2 + y + 1)) {
            return toString(merge(toArray(xp2, 'E'), toArray(y, 'N'), toArray(xc, 'E')));
        } else if (pow2(x + yp2 + yc + 1)) {
            return toString(merge(toArray(x, 'E'), toArray(yp2, 'N'), toArray(yc, 'S')));
        }else if (pow2(xp2 + xc + yp2 + yc + 1)) {
            return toString(merge(toArray(xp2, 'E'), toArray(yp2, 'N'), toArray(yc, 'S'), toArray(xc, 'W')));
        } else {
            return IMPOSSIBLE;
        }
    }



    static String toString(int []a) {
        return Arrays.stream(a).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
    static int[] toArray(long n, char c) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            list.add(((n & i) > 0) ? (int) c : (int) EMPTY);
            i *= 2;
        }
        return list.stream().mapToInt(v -> v).toArray();
    }
    static int [] merge(int [] ...aa) {
        int length = Arrays.stream(aa).mapToInt(a ->a.length).max().orElse(0);
        return IntStream.range(0, length).map(i-> direction(column(aa, i))).toArray();
    }
    static int direction(int [] column) {
        return Arrays.stream(column).filter(i -> i != (int)EMPTY).findFirst().orElse(EMPTY);
    }
    static int [] column(int [][]bb, int column) {
        return Arrays.stream(bb).mapToInt(a -> column < a.length ? a[column] : '_').toArray();
    }

    static int [] align(int [] a, int n) {
        return a.length>= n ? a : IntStream.range(0, n).map(i -> i < a.length ? a[i] : '_').toArray();
    }

    static boolean pow2(long n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    static long pow2up(long n) {
        if (pow2(n)) {
            return n;
        }
        long i = 1;
        while (i <= n) {
            i *= 2;
        }
        return i;
    }


    static long[] split(String s, int limit) {
        return Arrays.stream(s.split(" ", limit)).mapToLong(Long::parseLong).toArray();
    }

}