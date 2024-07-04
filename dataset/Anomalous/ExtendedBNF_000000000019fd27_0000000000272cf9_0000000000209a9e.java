import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            solve(scanner, bitLength);
        }
    }

    public static void solve(Scanner scanner, int bitLength) {
        int[] bitsArray = new int[bitLength + 1];
        int samePairIndex = -1;
        int diffPairIndex = -1;
        int diffPairValue = -1;
        int lastIndex = 5;

        // Initialize the bitsArray with -1
        Arrays.fill(bitsArray, -1);

        // First 10 digits
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            int firstValue = scanner.nextInt();
            System.out.println(bitLength - i + 1);
            int secondValue = scanner.nextInt();
            bitsArray[i] = firstValue;
            bitsArray[bitLength - i + 1] = secondValue;

            if (firstValue == secondValue) {
                samePairIndex = i;
            } else {
                diffPairIndex = i;
                diffPairValue = firstValue;
            }
        }

        while (!isFinished(bitsArray)) {
            updateArray(bitsArray, checkChange(bitsArray, samePairIndex, diffPairIndex, diffPairValue, scanner));
            
            for (int i = lastIndex + 1; i <= lastIndex + 4; i++) {
                System.out.println(i);
                int x = scanner.nextInt();
                System.out.println(bitLength - i + 1);
                int y = scanner.nextInt();
                bitsArray[i] = x;
                bitsArray[bitLength - i + 1] = y;
            }
            lastIndex += 4;
            diffPairValue = bitsArray[diffPairIndex];
        }

        for (int i = 1; i < bitsArray.length; i++) {
            System.out.print(bitsArray[i]);
        }
        System.out.println();
    }

    public static int checkChange(int[] bitsArray, int samePairIndex, int diffPairIndex, int diffPairValue, Scanner scanner) {
        if (samePairIndex != -1 && diffPairIndex != -1) {
            System.out.println(samePairIndex);
            int newSamePairValue = scanner.nextInt();
            System.out.println(diffPairIndex);
            int newDiffPairValue = scanner.nextInt();

            if (newSamePairValue == bitsArray[samePairIndex]) {
                return (newDiffPairValue == diffPairValue) ? 4 : 2;
            } else {
                return (newDiffPairValue == diffPairValue) ? 3 : 1;
            }
        } else {
            if (samePairIndex == -1) {
                System.out.println(diffPairIndex);
                int newDiffPairValue = scanner.nextInt();
                return (newDiffPairValue == bitsArray[diffPairIndex]) ? 4 : 2;
            } else {
                System.out.println(samePairIndex);
                int newSamePairValue = scanner.nextInt();
                return (newSamePairValue == bitsArray[samePairIndex]) ? 4 : 2;
            }
        }
    }

    public static void updateArray(int[] bitsArray, int action) {
        if (action == 4) return;

        if (action == 1) {
            for (int i = 0; i < bitsArray.length / 2; i++) {
                int temp = bitsArray[i + 1];
                bitsArray[i + 1] = bitsArray[bitsArray.length - 1 - i];
                bitsArray[bitsArray.length - 1 - i] = temp;
            }
        } else if (action == 2) {
            for (int i = 1; i < bitsArray.length; i++) {
                bitsArray[i] = (bitsArray[i] == 1) ? 0 : 1;
            }
        } else if (action == 3) {
            updateArray(bitsArray, 1);
            updateArray(bitsArray, 2);
        }
    }

    public static boolean isFinished(int[] bitsArray) {
        for (int i = 1; i < bitsArray.length; i++) {
            if (bitsArray[i] == -1) return false;
        }
        return true;
    }
}