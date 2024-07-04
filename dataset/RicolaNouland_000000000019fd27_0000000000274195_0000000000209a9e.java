
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Solution {


    private static boolean err = false;
    private final Scanner sc;


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
        int[] bits = new int[10];
        print(""+ 1);
        read(sc);

        for (int i = 1; i <= 10; i++) {
            print("" + i);
            int b = Integer.parseInt(read(sc));
            bits[i-1] = b;
        }

        print(Arrays.toString(bits).replaceAll("[, \\[\\]]", ""));
        String result = read(sc);

        if(result.equals("N")){
            System.exit(0);
        }
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
