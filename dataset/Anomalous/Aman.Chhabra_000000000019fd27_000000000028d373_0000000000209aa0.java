import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SolutionInteractive {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        List<Integer[][]> resultList = new ArrayList<>();
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            Integer[][] matrix = solve(n, s);
            resultList.add(matrix);
        }
        
        int count = 0;
        for (Integer[][] result : resultList) {
            if (result == null) {
                System.out.println("Case #" + (++count) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (++count) + ": POSSIBLE");
                printArray(result);
            }
        }
    }

    private static void printArray(Integer[][] result) {
        for (Integer[] row : result) {
            System.out.println(IntStream.range(0, row.length)
                .mapToObj(i -> row[i].toString())
                .reduce((a, b) -> a + " " + b)
                .orElse(""));
        }
    }

    private static Integer[][] solve(int n, int s) {
        Integer[][] array = new Integer[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (i + j + 1) % n == 0 ? n : (i + j + 1) % n;
            }
        }

        for (int i = 0; i < n; i++) {
            array = shiftTop(array);
            for (int j = 0; j < n; j++) {
                array = shiftLeft(array);
                if (diagonalSum(array) == s) {
                    return array;
                }
            }
        }
        return null;
    }

    private static int diagonalSum(Integer[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    private static Integer[][] shiftLeft(Integer[][] array) {
        int n = array.length;
        Integer[][] newArray = new Integer[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArray[i][(j + 1) % n] = array[i][j];
            }
        }
        return newArray;
    }

    private static Integer[][] shiftTop(Integer[][] array) {
        int n = array.length;
        Integer[][] newArray = new Integer[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newArray[(i + 1) % n][j] = array[i][j];
            }
        }
        return newArray;
    }
}