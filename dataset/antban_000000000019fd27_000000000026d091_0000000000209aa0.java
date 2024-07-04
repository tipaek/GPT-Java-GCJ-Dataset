import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        for (int test = 1; test <= testCount; test++) {
            final int size = scanner.nextInt();
            final int diagonal = scanner.nextInt();

            if (diagonal > 0 && (diagonal % size) == 0) {
                // possible
                System.out.println("Case #" + test + ": " + "POSSIBLE");
                int start = diagonal / size;
                for (int i = 0; i < size; ++i) {
                    final String line = IntStream.range(start, start + size)
                            .map(v -> v > size ? v - size : v)
                            .boxed()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "));
                    System.out.println(line);
                    start += 1;
                    if (start > size) {
                        start = 1;
                    }
                }
            } else {
                System.out.println("Case #" + test + ": " + "IMPOSSIBLE");
            }

        }
    }

}
