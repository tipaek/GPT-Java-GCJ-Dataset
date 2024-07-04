import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = null;
        if (System.getProperty("user.name").equals("Alexey")) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }

        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {
            int intervals = Integer.parseInt(sc.nextLine());
            Range[] input = new Range[intervals];
            for (int j = 0; j < intervals; j++) {
                String[] vals = sc.nextLine().split(" ");
                input[j] = new Range(vals[0], vals[1]);
            }
            String result = resolveSingleCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }

    private static String resolveSingleCase(Range[] input) {
        StringBuilder result = new StringBuilder();
        Range[] sortedInput = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedInput);
        System.err.println(Arrays.toString(input));

        int balance = 0;
        int cIsFreeAt = 0;
        int jIsFreeAt = 0;
        for (Range range : sortedInput) {
            if (balance == 2) {
                if (jIsFreeAt <= range.start && cIsFreeAt <= range.start) {
                    balance = 0;
                } else if (jIsFreeAt <= range.start || cIsFreeAt <= range.start) {
                    balance = 1;
                } else {
                    return "IMPOSSIBLE";
                }
            }
            if (balance == 1) {
                if (jIsFreeAt <= range.start && cIsFreeAt <= range.start) {
                    balance = 0;
                } else if (cIsFreeAt <= range.start) {
                    balance++;
                    range.who = 'C';
                    cIsFreeAt = range.end;
                } else if (jIsFreeAt <= range.start) {
                    balance++;
                    range.who = 'J';
                    jIsFreeAt = range.end;
                }
            }
            if (balance == 0) {
                balance++;
                range.who = 'C';
                cIsFreeAt = range.end;
            }
        }

        for (Range range : input) {
            result.append(range.who);
        }
        return result.toString();
    }
}

class Range implements Comparable<Range> {
    public int start;
    public int end;
    Character who = null;

    Range(int s, int e) {
        start = s;
        end = e;
    }

    Range(String s, String e) {
        start = Integer.parseInt(s);
        end = Integer.parseInt(e);
    }

    @Override
    public int compareTo(Range other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}