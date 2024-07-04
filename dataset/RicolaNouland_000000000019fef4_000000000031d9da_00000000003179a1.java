import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;


public class Solution {



    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String result = solve(in);

            System.out.println(String.format("Case #%d: %s", i, result));
        }

    }

    private static String solve(Scanner in) {
        in.nextLine();
        Set<Character> letters = new HashSet<>();
        Map<String, String> input = new HashMap<>();


        for (int i = 0; i < 10000; i++) {
            String[] line = in.nextLine().split(" ");
            String R = line[1];
            input.put(line[0], R);
            for (char c : R.toCharArray()) {
                letters.add(c);
            }
        }

        Set<Character> potZero = new HashSet<>();
        potZero.addAll(letters);

        for (String s : input.values()) {
            potZero.remove(s.charAt(0));
        }

        return "a";
    }

    public static int[] lineToInt(String line, String regex) {
        return Stream.of(line.split(regex)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] lineToInt(String line) {
        return lineToInt(line, " ");
    }
}