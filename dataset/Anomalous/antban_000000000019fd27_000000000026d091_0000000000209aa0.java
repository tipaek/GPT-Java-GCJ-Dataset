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

            if (diagonal > 0 && diagonal % size == 0) {
                System.out.println("Case #" + test + ": POSSIBLE");
                generateMatrix(size, diagonal);
            } else {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }

    private static void generateMatrix(int size, int diagonal) {
        int start = diagonal / size;
        
        for (int i = 0; i < size; i++) {
            String line = IntStream.range(start, start + size)
                                   .map(v -> v > size ? v - size : v)
                                   .mapToObj(String::valueOf)
                                   .collect(Collectors.joining(" "));
            System.out.println(line);
            start = (start % size) + 1;
        }
    }
}