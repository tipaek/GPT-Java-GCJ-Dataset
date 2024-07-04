import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution { // diagonal always be the same N, 1*4, 2*4, 3*4, 4*4
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (m % n != 0) {
                result.add("Case #" + i + ": IMPOSSIBLE");
            } else {
                result.add("Case #" + i + ": POSSIBLE");
                result.add(generateMatrix(n, m));
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String generateMatrix(int n, int m) {
        StringBuilder sb = new StringBuilder();

        List<Integer> range = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.rotate(range, m / n);

        range.stream().forEach(x -> sb.append(x + " "));
        // range.stream().forEach(x -> System.out.print(x + " "));
        for (int i = 1; i < n; ++i) {
            sb.append(System.getProperty("line.separator"));
            Collections.rotate(range, 1);
            // System.out.println();
            // range.stream().forEach(x -> System.out.print(x + " "));
            range.stream().forEach(x -> sb.append(x + " "));
            
        }

        return sb.toString();
    }
}