import java.util.Scanner;

public class Solution {

    private static final int UNKNOWN = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int[] bits = new int[bitLength + 1];
            initializeBits(bits);

            int sameIndex = UNKNOWN;
            int differentIndex = UNKNOWN;
            int currentIndex = 1;

            for (int query = 0; query < 150; query++) {
                if (query == 0) {
                    System.out.println("1");
                    scanner.nextInt();
                    continue;
                }

                if (query == 1 || query % 10 != 1) {
                    if (currentIndex > bitLength / 2) {
                        break;
                    } 
                    if (bits[currentIndex] == UNKNOWN) {
                        System.out.println(currentIndex);
                        bits[currentIndex] = scanner.nextInt();
                    } else {
                        System.out.println(bitLength - currentIndex + 1);
                        bits[bitLength - currentIndex + 1] = scanner.nextInt();

                        if (bits[currentIndex] == bits[bitLength - currentIndex + 1]) {
                            sameIndex = currentIndex;
                        } else {
                            differentIndex = currentIndex;
                        }
                        currentIndex++;
                    }
                } else {
                    handleQuantumFluctuation(scanner, bits, sameIndex, differentIndex);
                    query++;
                }
            }

            outputBits(bits);
            if (!scanner.next().equals("Y")) {
                return;
            }
        }
    }

    private static void initializeBits(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = UNKNOWN;
        }
    }

    private static void handleQuantumFluctuation(Scanner scanner, int[] bits, int sameIndex, int differentIndex) {
        if (differentIndex == UNKNOWN || sameIndex == UNKNOWN) {
            System.out.println("1");
            int queryResult = scanner.nextInt();
            if (queryResult != bits[1]) {
                complementBits(bits);
            }
        } else {
            System.out.println(sameIndex);
            int result1 = scanner.nextInt();
            System.out.println(differentIndex);
            int result2 = scanner.nextInt();

            if (result1 != bits[sameIndex]) {
                if (result2 == bits[differentIndex]) {
                    reverseBits(bits);
                }
                complementBits(bits);
            } else if (result2 != bits[differentIndex]) {
                reverseBits(bits);
            }
        }
    }

    private static void outputBits(int[] bits) {
        for (int i = 1; i < bits.length; i++) {
            System.out.print(bits[i]);
        }
        System.out.println();
    }

    private static void reverseBits(int[] bits) {
        for (int i = 1; i <= bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - i];
            bits[bits.length - i] = temp;
        }
    }

    private static void complementBits(int[] bits) {
        for (int i = 1; i < bits.length; i++) {
            bits[i] = (bits[i] == 0) ? 1 : 0;
        }
    }
}