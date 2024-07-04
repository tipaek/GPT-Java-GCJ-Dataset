import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int caseNumber = 0; caseNumber < cases; caseNumber++) {
            int size = scanner.nextInt();
            int sum = scanner.nextInt();
            if (sum % size == 0) {
                System.out.println("Case #" + (caseNumber + 1) + ": POSSIBLE");
                printMatrix(size, sum / size);
            } else {
                System.out.println("Case #" + (caseNumber + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static void printMatrix(int size, int start) {
        for (int i = 0; i < size; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0, size1 = size - 1; j < size1; j++) {
                stringBuilder.append(start);
                stringBuilder.append(' ');
                start++;
                if (start == size + 1) {
                    start = 1;
                }
            }
            stringBuilder.append(start);
            System.out.println(stringBuilder);
        }
    }


}
