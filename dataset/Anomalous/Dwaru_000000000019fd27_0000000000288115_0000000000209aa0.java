import java.util.Scanner;

public class Program {

    public static void rotate(int[][] matrix, int num, int size) {
        for (int i = 0; i < size; i++) {
            int t = 0;
            for (int j = 0; j < size; j++) {
                if (num <= size) {
                    matrix[i][j] = num;
                    num++;
                } else {
                    t = j;
                    break;
                }
            }
            num = 1;
            for (int j = t; j < size; j++) {
                matrix[i][j] = num;
                num++;
            }
            num--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int num = 0;
            int size = scanner.nextInt();
            int rtrace = scanner.nextInt();
            boolean possible = false;

            for (int i = 1; i <= size; i++) {
                if (rtrace == size * i) {
                    possible = true;
                    num = i;
                    break;
                }
            }

            if (possible) {
                int[][] matrix = new int[size][size];
                rotate(matrix, num, size);

                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int val : row) {
                        System.out.print(val + " ");
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