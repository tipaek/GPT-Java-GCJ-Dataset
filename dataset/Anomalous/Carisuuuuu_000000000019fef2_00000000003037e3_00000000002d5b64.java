import java.awt.Point;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream output = System.out;
    private static final PrintStream log = System.err;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            List<Point> points = IntStream.range(0, (columns - 1) * (rows - 1))
                    .mapToObj(index -> new Point((columns - 1) * rows - index, (rows - 1) - index / (columns - 1)))
                    .collect(Collectors.toList());
            output.println("Case #" + testCase + ": " + points.size());
            points.forEach(point -> output.println(point.x + " " + point.y));
        }
    }
}