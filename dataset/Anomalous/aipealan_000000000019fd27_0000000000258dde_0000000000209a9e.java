import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            char[] bitArray = new char[b];
            Arrays.fill(bitArray, 'N');

            boolean foundSamePair = false, foundDifferentPair = false;
            int leftIndex = 1, rightIndex = b;
            int queryCount = 0;
            int[] samePairIndices = new int[2];
            int[] differentPairIndices = new int[2];

            while ((!foundSamePair || !foundDifferentPair) && leftIndex <= rightIndex) {
                if (queryCount != 0 && queryCount % 10 == 0) {
                    leftIndex = 1;
                    rightIndex = b;
                }

                if (leftIndex == rightIndex) {
                    System.out.println(leftIndex);
                    char input = scanner.nextLine().charAt(0);
                    if (input == 'N') System.exit(0);
                    bitArray[leftIndex - 1] = input;
                    break;
                }

                System.out.println(leftIndex);
                char leftInput = scanner.nextLine().charAt(0);
                if (leftInput == 'N') System.exit(0);
                bitArray[leftIndex - 1] = leftInput;

                System.out.println(rightIndex);
                char rightInput = scanner.nextLine().charAt(0);
                if (rightInput == 'N') System.exit(0);
                bitArray[rightIndex - 1] = rightInput;

                queryCount += 2;

                if (!foundSamePair && leftInput == rightInput) {
                    foundSamePair = true;
                    samePairIndices[0] = leftIndex - 1;
                    samePairIndices[1] = rightIndex - 1;
                } else if (!foundDifferentPair && leftInput != rightInput) {
                    foundDifferentPair = true;
                    differentPairIndices[0] = leftIndex - 1;
                    differentPairIndices[1] = rightIndex - 1;
                }

                leftIndex++;
                rightIndex--;
            }

            while (queryCount <= 150 && leftIndex < rightIndex) {
                if (queryCount % 10 == 0) {
                    char[] response = new char[2];
                    System.out.println(samePairIndices[0] + 1);
                    response[0] = scanner.nextLine().charAt(0);
                    if (response[0] == 'N') System.exit(0);

                    System.out.println(differentPairIndices[0] + 1);
                    response[1] = scanner.nextLine().charAt(0);
                    if (response[1] == 'N') System.exit(0);

                    queryCount += 2;

                    if (bitArray[samePairIndices[0]] != response[0] && bitArray[differentPairIndices[0]] != response[1]) {
                        flipBits(bitArray, 0, leftIndex - 1);
                        flipBits(bitArray, rightIndex, b - 1);
                    } else if (bitArray[samePairIndices[0]] != response[0]) {
                        reverseArray(bitArray, 0, b - 1);
                        int temp = leftIndex;
                        leftIndex = b - rightIndex + 1;
                        rightIndex = b - temp + 1;
                    } else if (bitArray[differentPairIndices[0]] != response[1]) {
                        flipBits(bitArray, 0, leftIndex - 1);
                        flipBits(bitArray, rightIndex, b - 1);
                        reverseArray(bitArray, 0, b - 1);
                        int temp = leftIndex;
                        leftIndex = b - rightIndex + 1;
                        rightIndex = b - temp + 1;
                    }
                } else {
                    System.out.println(leftIndex);
                    char input = scanner.nextLine().charAt(0);
                    if (input == 'N') System.exit(0);
                    bitArray[leftIndex - 1] = input;
                    leftIndex++;
                }
            }

            if (leftIndex >= rightIndex) {
                StringBuilder output = new StringBuilder();
                for (char c : bitArray) {
                    output.append(c);
                }
                System.out.println(output.toString());
                if (scanner.nextLine().charAt(0) == 'N') System.exit(0);
            }
        }
    }

    private static void flipBits(char[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            array[i] = (array[i] == '0') ? '1' : '0';
        }
    }

    private static void reverseArray(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}