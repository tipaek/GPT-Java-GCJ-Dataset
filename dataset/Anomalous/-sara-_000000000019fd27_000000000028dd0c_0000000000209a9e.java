import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static int queryCount = 0;
    private static int bitLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        bitLength = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            queryCount = 0;
            Integer[] bitArray = new Integer[bitLength];

            for (int j = 1; j <= 5; j++) {
                performQuery(j, bitArray, scanner);
                performQuery(bitLength + 1 - j, bitArray, scanner);
            }

            boolean isCompleted = false;
            while (!isCompleted) {
                int transformation = detectTransformation(bitArray, scanner);
                bitArray = applyTransformation(bitArray, transformation);

                int index = 0;
                while (queryCount % 10 != 0 && !isCompleted) {
                    while (index < bitLength && bitArray[index] != null) {
                        index++;
                    }

                    if (index == bitLength) {
                        isCompleted = true;
                        System.out.println(Arrays.toString(bitArray).replace("[", "").replace(", ", "").replace("]", ""));
                        String verdict = scanner.next();
                        if (verdict.equals("N")) {
                            return;
                        }
                    } else {
                        performQuery(index + 1, bitArray, scanner);
                        if (queryCount % 10 != 0 && bitArray[bitLength - 1 - index] == null) {
                            performQuery(bitLength - index, bitArray, scanner);
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    private static void performQuery(int position, Integer[] bitArray, Scanner scanner) {
        System.out.println(position);
        bitArray[position - 1] = scanner.nextInt();
        queryCount++;
    }

    private static int detectTransformation(Integer[] bitArray, Scanner scanner) {
        System.out.println(1);
        int newBit1 = scanner.nextInt();
        queryCount++;

        int newBit2 = -1;
        int index2 = -1;

        if (bitArray[0] == bitArray[bitLength - 1]) {
            for (int j = 1; j < bitLength / 2; j++) {
                if (bitArray[j] != null && bitArray[j] != bitArray[bitLength - 1 - j]) {
                    System.out.println(j + 1);
                    newBit2 = scanner.nextInt();
                    queryCount++;
                    index2 = j;
                    break;
                }
            }

            if (newBit1 == bitArray[0]) {
                if (index2 == -1 || newBit2 == bitArray[index2]) {
                    return 4; // unchanged
                } else {
                    return 2; // reversed
                }
            } else {
                if (index2 != -1 && newBit2 == bitArray[index2]) {
                    return 3; // reversed and complemented
                } else {
                    return 1; // complemented
                }
            }
        } else {
            for (int j = 1; j < bitLength / 2; j++) {
                if (bitArray[j] != null && bitArray[j] == bitArray[bitLength - 1 - j]) {
                    System.out.println(j + 1);
                    newBit2 = scanner.nextInt();
                    queryCount++;
                    index2 = j;
                    break;
                }
            }

            if (newBit1 == bitArray[0]) {
                if (index2 != -1 && newBit2 == bitArray[index2]) {
                    return 4; // unchanged
                } else {
                    return 3; // reversed and complemented
                }
            } else {
                if (index2 == -1 || newBit2 == bitArray[index2]) {
                    return 2; // reversed
                } else {
                    return 1; // complemented
                }
            }
        }
    }

    private static Integer[] applyTransformation(Integer[] bitArray, int transformation) {
        switch (transformation) {
            case 1:
                for (int i = 0; i < bitLength; i++) {
                    if (bitArray[i] != null) {
                        bitArray[i] = 1 - bitArray[i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < bitLength / 2; i++) {
                    Integer temp = bitArray[bitLength - 1 - i];
                    bitArray[bitLength - 1 - i] = bitArray[i];
                    bitArray[i] = temp;
                }
                break;
            case 3:
                for (int i = 0; i < bitLength / 2; i++) {
                    Integer temp = bitArray[bitLength - 1 - i];
                    bitArray[bitLength - 1 - i] = bitArray[i];
                    bitArray[i] = temp;
                }
                for (int i = 0; i < bitLength; i++) {
                    if (bitArray[i] != null) {
                        bitArray[i] = 1 - bitArray[i];
                    }
                }
                break;
            case 4:
                break;
        }
        return bitArray;
    }
}