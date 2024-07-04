import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        
        for (int test = 1; test <= testCount; test++) {
            int size = scanner.nextInt();
            int diagonal = scanner.nextInt();

            if (isPossible(diagonal, size)) {
                System.out.println("Case #" + test + ": POSSIBLE");
                printMatrix(size, diagonal);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int diagonal, int size) {
        return diagonal > 0 && (diagonal % size) == 0;
    }

    private static void printMatrix(int size, int diagonal) {
        int start = diagonal / size;
        for (int i = 0; i < size; i++) {
            String line = IntStream.range(start, start + size)
                    .map(v -> v > size ? v - size : v)
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(line);
            start = (start == 1) ? size : start - 1;
        }
    }
}