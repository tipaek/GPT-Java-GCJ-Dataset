import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testsNum = Integer.parseInt(scanner.nextLine());
        for (int testIndex = 0; testIndex < testsNum; testIndex++) {
            String[] strings = scanner.nextLine().split(" ");
            int matrixSize = Integer.parseInt(strings[0]);
            int desiredTrace = Integer.parseInt(strings[1]);
            System.out.print("Case #" + (testIndex + 1) + ": ");
            if (desiredTrace < matrixSize || desiredTrace > matrixSize * matrixSize || desiredTrace % matrixSize != 0) {
                System.out.print("IMPOSSIBLE\n");
                continue;
            }
            System.out.print("POSSIBLE\n");
            int diagonal = desiredTrace / matrixSize;
            for (int i = 0; i < matrixSize; i++) {
                for (int j = matrixSize - 1; j > 0; j--) {
                    System.out.print((diagonal + i + j) % matrixSize + 1 + " ");
                }
                System.out.print((diagonal + i + matrixSize) % matrixSize + 1);
                System.out.print('\n');
            }
        }
        System.out.flush();
    }
}