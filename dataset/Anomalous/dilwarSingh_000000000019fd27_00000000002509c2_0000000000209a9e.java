import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        String response = "Y";
        for (int i = 0; i < testCases && response.equals("Y"); i++) {
            if (bitLength == 10) {
                System.out.println(processBitLength10());
                System.out.flush();
                scanner.nextLine();
                response = scanner.nextLine().trim();
            } else if (bitLength == 20) {
                System.out.println(processBitLength20());
                System.out.flush();
                scanner.nextLine();
                response = scanner.nextLine().trim();
            }
        }
    }

    private static String processBitLength10() {
        int[] bitArray = new int[10];
        for (int i = 0; i < 10; i++) {
            bitArray[i] = readBitAt(i);
        }

        StringBuilder result = new StringBuilder();
        for (int bit : bitArray) {
            result.append(bit);
        }
        return result.toString();
    }

    private static final int[] midBits = new int[10];
    private static final int[] nextBits = new int[5];

    private static String processBitLength20() {
        int[] bitArray = new int[20];

        for (int i = 0; i < 10; i++) {
            bitArray[i + 5] = readBitAt(i + 5);
            midBits[i] = bitArray[i + 5];
        }

        int transformationState = detectTransformation(10);

        switch (transformationState) {
            case 1:
                bitArray = complementArray(bitArray);
                break;
            case 2:
                bitArray = reverseArray(bitArray);
                break;
            case 3:
                bitArray = complementAndReverse(bitArray);
                break;
            default:
                break;
        }

        for (int i = 0; i < 5; i++) {
            bitArray[i] = readBitAt(i);
        }

        transformationState = detectTransformation(10);

        switch (transformationState) {
            case 1:
                bitArray = complementArray(bitArray);
                for (int i = 15; i < 20; i++) {
                    bitArray[i] = readBitAt(i);
                }
                break;
            case 2:
                bitArray = reverseArray(bitArray);
                for (int i = 0; i < 5; i++) {
                    bitArray[i] = readBitAt(i);
                }
                break;
            case 3:
                bitArray = complementAndReverse(bitArray);
                for (int i = 0; i < 5; i++) {
                    bitArray[i] = readBitAt(i);
                }
                break;
            default:
                for (int i = 15; i < 20; i++) {
                    bitArray[i] = readBitAt(i);
                }
                break;
        }

        StringBuilder result = new StringBuilder();
        for (int bit : bitArray) {
            result.append(bit);
        }
        return result.toString();
    }

    private static int detectTransformation(int mid) {
        for (int i = 0; i < 5; i++) {
            nextBits[i] = readBitAt(i + mid - 5);
        }

        int[] complementedBits = complementArray(Arrays.copyOf(nextBits, nextBits.length));
        int[] reversedBits = reverseArray(Arrays.copyOf(nextBits, nextBits.length));
        int[] complementedReversedBits = complementAndReverse(Arrays.copyOf(nextBits, nextBits.length));

        if (Arrays.equals(complementedBits, Arrays.copyOfRange(midBits, 0, 5))) {
            return 1;
        } else if (Arrays.equals(reversedBits, Arrays.copyOfRange(midBits, 5, 10))) {
            return 2;
        } else if (Arrays.equals(complementedReversedBits, Arrays.copyOfRange(midBits, 5, 10))) {
            return 3;
        }
        return 4;
    }

    private static int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    private static int[] complementArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        return array;
    }

    private static int[] complementAndReverse(int[] array) {
        return complementArray(reverseArray(array));
    }

    private static int readBitAt(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return scanner.nextInt();
    }
}