import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            byte[] bits = new byte[bitLength];
            initializeArray(bits, (byte) -1);

            for (int i = 0; i < 5; i++) {
                bits[i] = readBit(scanner, i + 1);
                bits[bitLength - i - 1] = readBit(scanner, bitLength - i);
            }

            int frontIndex = 5;
            AtomicInteger queryCount = new AtomicInteger(11);

            while (queryCount.get() <= 150) {
                if (frontIndex >= bitLength / 2) {
                    System.out.println(convertArrayToString(bits));
                    break;
                }

                if (queryCount.get() % 10 == 1) {
                    int operationType = determineOperationType(bits, frontIndex, scanner, queryCount);
                    applyOperation(bits, frontIndex, operationType);
                }

                byte frontBit = -2, backBit = -2;
                for (int i = 0; i < 2; i++) {
                    if (queryCount.get() % 10 != 1 && i == 0) {
                        frontBit = readBit(scanner, frontIndex + 1);
                        queryCount.incrementAndGet();
                    }
                    if (queryCount.get() % 10 != 1 && i == 1) {
                        backBit = readBit(scanner, bitLength - frontIndex);
                        queryCount.incrementAndGet();
                    }
                }

                if (frontBit != -2 && backBit != -2) {
                    bits[frontIndex] = frontBit;
                    bits[bitLength - frontIndex - 1] = backBit;
                    frontIndex++;
                }
            }

            if (scanner.next().charAt(0) == 'N') {
                break;
            }
        }
    }

    private static void initializeArray(byte[] array, byte value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    private static byte readBit(Scanner scanner, int position) {
        System.out.println(position);
        return charToByte(scanner.next().charAt(0));
    }

    private static byte charToByte(char ch) {
        return (byte) (ch == '1' ? 1 : 0);
    }

    private static String convertArrayToString(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append(b);
        }
        return sb.toString();
    }

    private static int determineOperationType(byte[] bits, int index, Scanner scanner, AtomicInteger queryCount) {
        Set<Integer> possibleOperations = new HashSet<>();
        Set<Integer> possibleOperationsBySecondary = new HashSet<>();

        int primaryIndex = findPrimaryIndex(bits, index);
        if (primaryIndex >= 0) {
            byte primaryBit = readBit(scanner, primaryIndex + 1);
            queryCount.incrementAndGet();
            updatePossibleOperations(bits, primaryIndex, primaryBit, possibleOperations);
        }

        int secondaryIndex = findSecondaryIndex(bits, index);
        if (secondaryIndex >= 0) {
            byte secondaryBit = readBit(scanner, secondaryIndex + 1);
            queryCount.incrementAndGet();
            updatePossibleOperations(bits, secondaryIndex, secondaryBit, possibleOperationsBySecondary);
        }

        return determineCommonOperation(possibleOperations, possibleOperationsBySecondary);
    }

    private static int findPrimaryIndex(byte[] bits, int index) {
        for (int i = 0; i < index; i++) {
            if (bits[i] == bits[bits.length - i - 1]) {
                return i;
            }
        }
        return -1;
    }

    private static int findSecondaryIndex(byte[] bits, int index) {
        for (int i = 0; i < index; i++) {
            if ((bits[i] > bits[bits.length - i - 1] && bits[i] - 1 == bits[bits.length - i - 1]) ||
                (bits[i] < bits[bits.length - i - 1] && bits[i] + 1 == bits[bits.length - i - 1])) {
                return i;
            }
        }
        return -1;
    }

    private static void updatePossibleOperations(byte[] bits, int index, byte bit, Set<Integer> possibleOperations) {
        if (bits[index] == 1 && bit == 0 || bits[index] == 0 && bit == 1) {
            possibleOperations.add(1);
            possibleOperations.add(3);
        } else {
            possibleOperations.add(2);
            possibleOperations.add(4);
        }
    }

    private static int determineCommonOperation(Set<Integer> primaryOps, Set<Integer> secondaryOps) {
        for (int op : primaryOps) {
            if (secondaryOps.contains(op)) {
                return op;
            }
        }
        return primaryOps.isEmpty() ? secondaryOps.iterator().next() : primaryOps.iterator().next();
    }

    private static void applyOperation(byte[] bits, int index, int operationType) {
        switch (operationType) {
            case 1:
                invertBits(bits, index);
                break;
            case 2:
                reverseBits(bits, index);
                break;
            case 3:
                reverseAndInvertBits(bits, index);
                break;
            default:
                break;
        }
    }

    private static void invertBits(byte[] bits, int index) {
        for (int i = 0; i < index; i++) {
            bits[i] = (byte) (bits[i] == 1 ? 0 : 1);
            bits[bits.length - i - 1] = (byte) (bits[bits.length - i - 1] == 1 ? 0 : 1);
        }
    }

    private static void reverseBits(byte[] bits, int index) {
        for (int i = 0; i < index; i++) {
            byte temp = bits[i];
            bits[i] = bits[bits.length - i - 1];
            bits[bits.length - i - 1] = temp;
        }
    }

    private static void reverseAndInvertBits(byte[] bits, int index) {
        for (int i = 0; i < index; i++) {
            byte temp = bits[i];
            bits[i] = (byte) (bits[bits.length - i - 1] == 1 ? 0 : 1);
            bits[bits.length - i - 1] = (byte) (temp == 1 ? 0 : 1);
        }
    }
}