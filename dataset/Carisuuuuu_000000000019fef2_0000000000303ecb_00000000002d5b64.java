import java.awt.*;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner IN = new Scanner(System.in);
    private static final PrintStream OUT = System.out;
    private static final PrintStream LOG = System.err;

    public static void main(String[] args) {
        int t = IN.nextInt();
        for (int g = 1; g <= t; ++g) {
            int r = IN.nextInt();
            int s = IN.nextInt();
            List<Point> results = IntStream.range(0, (s-1)*(r-1))
                    .mapToObj(a -> new Point((s-1)*r-a, (r-1)-a/(s-1)))
                    .collect(Collectors.toList());
            OUT.println("Case #" + g + ": " + results.size());
            results.forEach(p -> OUT.println(p.x + " " + p.y));
        }
    }
}
// R = 3, S = 3
// 1 2 3 1 2 3 1 2 3: 7, 2
// 1 2 1 2 3 1 2 3 3: 6, 2
// 1 2 1 2 1 2 3 3 3: 5, 1
// 1 1 2 1 2 2 3 3 3: 4, 1
// 1 1 1 2 2 2 3 3 3
// R = 4, S = 2
// 1 2 3 4 1 2 3 4: 5, 3
// 1 2 3 1 2 3 4 4: 4, 2
// 1 2 1 2 3 3 4 4: 3, 1
// 1 1 2 2 3 3 4 4