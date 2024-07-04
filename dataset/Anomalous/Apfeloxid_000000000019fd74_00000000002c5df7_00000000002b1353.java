import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testAmount = scanner.nextInt();

        for (int testId = 1; testId <= testAmount; testId++) {
            int n = scanner.nextInt();
            String binaryRepresentation = Integer.toBinaryString(n);
            int binaryLength = binaryRepresentation.length();
            System.out.println(binaryRepresentation);

            int adjustedN = n - binaryLength + 1;
            String adjustedNBinary = Integer.toBinaryString(adjustedN);
            System.out.println(adjustedNBinary);
            int zeroCount = countZeros(adjustedNBinary);
            int remainingSteps = n - adjustedN - zeroCount;

            boolean moveLeft = true;
            int currentRow = 0;

            for (int i = adjustedNBinary.length() - 1; i >= 0; i--) {
                currentRow++;
                if (adjustedNBinary.charAt(i) == '0') {
                    int column = moveLeft ? 1 : currentRow;
                    System.out.println(currentRow + " " + column);
                } else {
                    if (moveLeft) {
                        for (int column = 1; column <= currentRow; column++) {
                            System.out.println(currentRow + " " + column);
                        }
                    } else {
                        for (int column = currentRow; column >= 1; column--) {
                            System.out.println(currentRow + " " + column);
                        }
                    }
                    moveLeft = !moveLeft;
                }
            }
            currentRow++;

            if (moveLeft) {
                for (int i = 0; i < remainingSteps; i++) {
                    System.out.println(currentRow + " 1");
                }
            } else {
                for (int i = 0; i < remainingSteps; i++) {
                    System.out.println(currentRow + " " + currentRow);
                }
            }

            System.out.println("Case #" + testId + ": ");
        }
    }

    private static int countZeros(String binaryString) {
        int zeroCount = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '0') {
                zeroCount++;
            }
        }
        return zeroCount;
    }
}