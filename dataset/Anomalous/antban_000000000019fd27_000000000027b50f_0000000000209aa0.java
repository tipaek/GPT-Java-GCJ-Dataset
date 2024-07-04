import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        
        for (int test = 1; test <= testCount; test++) {
            int size = scanner.nextInt();
            int diagonal = scanner.nextInt();

            if (isPossible(size, diagonal)) {
                System.out.println("Case #" + test + ": POSSIBLE");
                printMatrix(size, diagonal);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int size, int diagonal) {
        return diagonal > 0 && (diagonal % size) == 0;
    }

    private static void printMatrix(int size, int diagonal) {
        int start = diagonal / size;
        for (int i = 0; i < size; i++) {
            String line = generateLine(size, start);
            System.out.println(line);
            start = adjustStart(size, start);
        }
    }

    private static String generateLine(int size, int start) {
        return IntStream.range(start, start + size)
                .map(v -> v > size ? v - size : v)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static int adjustStart(int size, int start) {
        start -= 1;
        if (start <= 0) {
            start = size;
        }
        return start;
    }
}