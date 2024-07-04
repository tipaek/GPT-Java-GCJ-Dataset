import java.util.Scanner;

public class Program {
    public static void rotate(int[][] matrix, int startNumber, int size) {
        for (int i = 0; i < size; i++) {
            int limit = 0;
            for (int j = 0; j < size; j++) {
                if (startNumber <= size) {
                    matrix[i][j] = startNumber;
                    startNumber++;
                } else {
                    limit = j;
                    break;
                }
            }
            startNumber = 1;
            for (int j = limit; j < size; j++) {
                matrix[i][j] = startNumber;
                startNumber++;
            }
            startNumber--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int startNumber = 0;
            int size = scanner.nextInt();
            int requiredTrace = scanner.nextInt();
            boolean possible = false;

            for (int i = 1; i <= size; i++) {
                if (requiredTrace == size * i) {
                    possible = true;
                    startNumber = i;
                    break;
                }
            }

            if (possible) {
                int[][] matrix = new int[size][size];
                rotate(matrix, startNumber, size);
                System.out.println("Case #" + (caseNumber++) + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (caseNumber++) + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}