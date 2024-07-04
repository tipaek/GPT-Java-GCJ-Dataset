import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    static void findBitsInInterval(char[] bits, int start, int end, Scanner scanner) {
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            System.out.flush();
            bits[i] = scanner.next().charAt(0);
        }
    }

    static int findMirroredBit(char[] bits, int start1, int end1, int start2, int end2) {
        for (int i = start1; i <= end1; i++) {
            if (bits[i] == bits[end2 - (i - start1)]) return i;
        }
        return -1;
    }

    static int findUnMirroredBit(char[] bits, int start1, int end1, int start2, int end2) {
        for (int i = start1; i <= end1; i++) {
            if (bits[i] != bits[end2 - (i - start1)]) return i;
        }
        return -1;
    }

    static void reverseArray(char[] bits, int size, int knownNr) {
        for (int i = 1; i <= knownNr; i++) {
            char temp = bits[i];
            bits[i] = bits[size - i + 1];
            bits[size - i + 1] = temp;
        }
    }

    static char complementOf(char c) {
        return (c == '0') ? '1' : '0';
    }

    static void complementArray(char[] bits, int size, int knownNr) {
        for (int i = 1; i <= knownNr; i++) {
            bits[i] = complementOf(bits[i]);
            bits[size - i + 1] = complementOf(bits[size - i + 1]);
        }
    }

    static char findBit(int pos, Scanner scanner) {
        System.out.println(pos);
        System.out.flush();
        return scanner.next().charAt(0);
    }

    static void performNeededOperations(char[] bits, int size, int knownNr, int mirroredBit, int unMirroredBit, Scanner scanner) {
        if (mirroredBit > 0 && unMirroredBit > 0) {
            char newMirrored = findBit(mirroredBit, scanner);
            char newUnMirrored = findBit(unMirroredBit, scanner);
            if (newMirrored != bits[mirroredBit]) {
                if (newUnMirrored == bits[unMirroredBit]) {
                    reverseArray(bits, size, knownNr);
                    complementArray(bits, size, knownNr);
                } else {
                    complementArray(bits, size, knownNr);
                }
            } else {
                if (newUnMirrored != bits[unMirroredBit]) {
                    reverseArray(bits, size, knownNr);
                }
            }
        } else if (mirroredBit > 0) {
            char newMirrored = findBit(mirroredBit, scanner);
            findBit(mirroredBit, scanner);
            if (newMirrored != bits[mirroredBit]) {
                complementArray(bits, size, knownNr);
            }
        } else {
            char newUnMirrored = findBit(unMirroredBit, scanner);
            findBit(unMirroredBit, scanner);
            if (newUnMirrored != bits[unMirroredBit]) {
                reverseArray(bits, size, knownNr);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int noTests = input.nextInt();
        int noBits = input.nextInt();
        char feedback;
        boolean exit = false;

        if (noBits == 10) {
            char[] bits = new char[11];
            for (int t = 1; t <= noTests && !exit; t++) {
                for (int i = 1; i <= noBits; i++) {
                    System.out.println(i);
                    bits[i] = input.next().charAt(0);
                }
                System.out.println(String.valueOf(bits, 1, 10));
                feedback = input.next().charAt(0);
                if (feedback == 'N') {
                    exit = true;
                }
            }
        } else if (noBits == 20) {
            char[] bits = new char[21];
            int mirroredBit, unMirroredBit;
            for (int t = 1; t <= noTests && !exit; t++) {
                findBitsInInterval(bits, 1, 5, input);
                findBitsInInterval(bits, 16, 20, input);

                mirroredBit = findMirroredBit(bits, 1, 5, 16, 20);
                unMirroredBit = findUnMirroredBit(bits, 1, 5, 16, 20);

                performNeededOperations(bits, 20, 5, mirroredBit, unMirroredBit, input);

                findBitsInInterval(bits, 6, 9, input);
                findBitsInInterval(bits, 12, 15, input);

                mirroredBit = findMirroredBit(bits, 1, 9, 11, 20);
                unMirroredBit = findUnMirroredBit(bits, 1, 9, 12, 20);

                performNeededOperations(bits, 20, 9, mirroredBit, unMirroredBit, input);

                findBitsInInterval(bits, 10, 11, input);

                System.out.println(String.valueOf(bits, 1, 20));
                feedback = input.next().charAt(0);
                if (feedback == 'N') {
                    exit = true;
                }
            }
        } else if (noBits == 100) {
            char[] bits = new char[101];
            int mirroredBit, unMirroredBit;
            for (int t = 1; t <= noTests && !exit; t++) {
                findBitsInInterval(bits, 1, 5, input);
                findBitsInInterval(bits, 96, 100, input);

                mirroredBit = findMirroredBit(bits, 1, 5, 96, 100);
                unMirroredBit = findUnMirroredBit(bits, 1, 5, 96, 100);

                performNeededOperations(bits, 100, 5, mirroredBit, unMirroredBit, input);

                for (int i = 6; i <= 49; i += 4) {
                    findBitsInInterval(bits, i, i + 3, input);
                    findBitsInInterval(bits, 100 - i - 2, 100 - i + 1, input);

                    mirroredBit = findMirroredBit(bits, 1, i + 3, 100 - i - 2, 100);
                    unMirroredBit = findUnMirroredBit(bits, 1, i + 3, 100 - i - 2, 100);

                    performNeededOperations(bits, 100, i + 3, mirroredBit, unMirroredBit, input);
                }

                findBitsInInterval(bits, 50, 51, input);

                System.out.println(String.valueOf(bits, 1, 100));
                feedback = input.next().charAt(0);
                if (feedback == 'N') {
                    exit = true;
                }
            }
        }
    }
}