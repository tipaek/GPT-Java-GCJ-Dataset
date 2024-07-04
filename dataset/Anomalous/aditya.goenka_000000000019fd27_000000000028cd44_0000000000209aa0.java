import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int sum = scanner.nextInt();

            boolean isPossible = false;
            int value = 0;

            for (int i = 1; i <= size; i++) {
                if (sum == i * size) {
                    isPossible = true;
                    value = i;
                    break;
                }
            }

            boolean alternateCheck = false;
            if (size % 2 == 0 && !isPossible) {
                int expectedSum = size * (size + 1) / 2;
                if (sum == expectedSum) {
                    alternateCheck = true;
                }
            }

            if (alternateCheck) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                int halfSize = size / 2;
                for (int i = 0; i < size; i++) {
                    int position = i;
                    for (int j = 1; j <= size; j++) {
                        if (j % 2 == 0) {
                            position++;
                        } else {
                            position += halfSize;
                        }
                        if (position > size) {
                            position -= size;
                        }
                        System.out.print(position + " ");
                    }
                    System.out.println();
                }
            } else if (isPossible) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                for (int i = 0; i < size; i++) {
                    int position = value + i;
                    if (position > size) {
                        position -= size;
                    }
                    for (int j = 0; j < size; j++) {
                        if (position <= 0) {
                            position += size;
                        }
                        System.out.print(position-- + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}