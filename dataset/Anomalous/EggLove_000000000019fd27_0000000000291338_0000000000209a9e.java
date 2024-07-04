import java.util.*;
import java.io.*;

public class Solution {
    public static final int LIMIT = 150;
    public static int sameIndex;
    public static int diffIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solve(bitLength, i, scanner);
        }
    }

    public static void solve(int bitLength, int testCase, Scanner scanner) {
        sameIndex = -1;
        diffIndex = -1;
        int[] bitArray = new int[bitLength];
        
        if (bitLength <= 10) {
            readBits(bitArray, bitLength, scanner);
            printBitArray(bitArray);
            return;
        }

        int index = 0;
        while (!criteriaAreMet(bitArray, index, bitLength)) {
            Arrays.fill(bitArray, -1);
            fillArray(index, bitArray, bitLength, scanner);
            index += 5;
        }

        boolean workToDo = true;
        while (workToDo) {
            if (sameIndex != -1) {
                System.out.println(sameIndex + 1);
                int response = scanner.nextInt();
                if (response == bitArray[sameIndex]) {
                    System.out.println(diffIndex + 1);
                    response = scanner.nextInt();
                    if (response != bitArray[diffIndex]) {
                        reverse(bitArray);
                    }
                } else {
                    System.out.println(diffIndex + 1);
                    response = scanner.nextInt();
                    if (response == bitArray[diffIndex]) {
                        reverse(bitArray);
                        complement(bitArray);
                    } else {
                        complement(bitArray);
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                int nextIndex = findNextIndex(bitArray);
                if (nextIndex == -1) {
                    workToDo = false;
                    break;
                }
                System.out.println(nextIndex + 1);
                bitArray[nextIndex] = scanner.nextInt();
            }
        }

        printBitArray(bitArray);
    }

    public static void reverse(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }

    public static void complement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
        }
    }

    public static boolean criteriaAreMet(int[] array, int index, int length) {
        boolean same = false;
        boolean different = false;
        for (int i = 0; i < index; i++) {
            if (array[i] == array[length - 1 - i]) {
                same = true;
                if (sameIndex == -1) sameIndex = i;
            } else {
                different = true;
                if (diffIndex == -1) diffIndex = i;
            }
        }
        return same && different;
    }

    public static void fillArray(int index, int[] array, int length, Scanner scanner) {
        for (int i = index; i < index + 5; i++) {
            System.out.println(i + 1);
            array[i] = scanner.nextInt();
            System.out.println(length - i);
            array[length - 1 - i] = scanner.nextInt();
        }
    }

    public static int findNextIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) return i;
        }
        return -1;
    }

    public static void readBits(int[] array, int length, Scanner scanner) {
        for (int i = 0; i < length; i++) {
            System.out.println(i + 1);
            array[i] = scanner.nextInt();
        }
    }

    public static void printBitArray(int[] array) {
        for (int bit : array) {
            System.out.print(bit);
        }
        System.out.println();
    }
}