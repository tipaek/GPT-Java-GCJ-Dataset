import java.util.Scanner;

public class Program {
    public static void rotate(int[][] matrix, int startNum, int size) {
        for (int i = 0; i < size; i++) {
            int resetIndex = 0;
            for (int j = 0; j < size; j++) {
                if (startNum <= size) {
                    matrix[i][j] = startNum;
                    startNum++;
                } else {
                    resetIndex = j;
                    break;
                }
            }
            startNum = 1;
            for (int j = resetIndex; j < size; j++) {
                matrix[i][j] = startNum;
                startNum++;
            }
            startNum--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int requiredTrace = scanner.nextInt();
            boolean isPossible = false;
            int startNum = 0;

            for (int i = 1; i <= size; i++) {
                if (requiredTrace == size * i) {
                    isPossible = true;
                    startNum = i;
                    break;
                }
            }

            if (isPossible) {
                int[][] matrix = new int[size][size];
                rotate(matrix, startNum, size);

                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }

        scanner.close();
    }
}