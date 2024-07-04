import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static int sameIndex;
    private static int diffIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            System.out.flush();
            solve(bitLength, scanner);
        }
    }

    private static void solve(int bitLength, Scanner scanner) {
        sameIndex = -1;
        diffIndex = -1;
        int[] bits = new int[bitLength];

        if (bitLength <= 10) {
            for (int i = 0; i < bitLength; i++) {
                System.out.println(i + 1);
                bits[i] = scanner.nextInt();
            }
            for (int bit : bits) {
                System.out.print(bit);
            }
            System.out.println();
            return;
        }

        int index = 0;
        while (!criteriaAreMet(bits, index, bitLength)) {
            Arrays.fill(bits, -1);
            fillArray(index, bits, bitLength, scanner);
            index += 5;
        }

        boolean continueFilling = true;
        while (continueFilling) {
            System.out.println(sameIndex + 1);
            int response = scanner.nextInt();
            if (response == bits[sameIndex]) {
                System.out.println(diffIndex + 1);
                response = scanner.nextInt();
                if (response != bits[diffIndex]) {
                    reverse(bits);
                }
            } else {
                System.out.println(diffIndex + 1);
                response = scanner.nextInt();
                if (response == bits[diffIndex]) {
                    reverse(bits);
                    complement(bits);
                } else {
                    complement(bits);
                }
            }

            for (int i = 0; i < 8; i++) {
                int nextIndex = getNextIndex(bits);
                if (nextIndex == -1) {
                    continueFilling = false;
                    break;
                }
                System.out.println(nextIndex + 1);
                bits[nextIndex] = scanner.nextInt();
            }
        }

        for (int bit : bits) {
            System.out.print(bit);
        }
        System.out.println();
    }

    private static void reverse(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
    }

    private static void complement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    private static boolean criteriaAreMet(int[] array, int index, int bitLength) {
        boolean same = false;
        boolean diff = false;
        for (int i = 0; i < index; i++) {
            if (array[i] == array[bitLength - 1 - i]) {
                same = true;
                if (sameIndex == -1) sameIndex = i;
            } else {
                diff = true;
                if (diffIndex == -1) diffIndex = i;
            }
        }
        return same && diff;
    }

    private static void fillArray(int index, int[] array, int bitLength, Scanner scanner) {
        for (int i = index; i < index + 5; i++) {
            System.out.println(i + 1);
            array[i] = scanner.nextInt();
            System.out.println(bitLength - i);
            array[bitLength - 1 - i] = scanner.nextInt();
        }
    }

    private static int getNextIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) return i;
        }
        return -1;
    }
}