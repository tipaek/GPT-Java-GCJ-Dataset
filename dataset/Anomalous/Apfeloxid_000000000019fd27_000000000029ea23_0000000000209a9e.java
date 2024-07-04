import java.util.Scanner;

class Solution {

    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int UNKNOWN = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        int bitCount = scanner.nextInt();

        for (int test = 1; test <= testCount; test++) {
            int[] bits = new int[bitCount + 1];
            initializeBits(bits);

            int sameIndex = -1;
            int diffIndex = -1;
            int currentIdx = 1;
            boolean checkOperation = false;

            for (int query = 0; query < 150; query++) {
                if (query == 0) {
                    System.out.println("1");
                    scanner.nextInt();
                    continue;
                }

                if (!checkOperation) {
                    if (currentIdx > bitCount / 2) {
                        break;
                    } else if (bits[currentIdx] == UNKNOWN) {
                        System.out.println(currentIdx);
                        bits[currentIdx] = scanner.nextInt();
                    } else {
                        System.out.println(bitCount - currentIdx + 1);
                        bits[bitCount - currentIdx + 1] = scanner.nextInt();

                        if (bits[currentIdx] == bits[bitCount - currentIdx + 1]) {
                            sameIndex = currentIdx;
                        } else {
                            diffIndex = currentIdx;
                        }

                        currentIdx++;
                    }
                } else {
                    handleCheckOperation(scanner, bits, sameIndex, diffIndex);
                    checkOperation = false;
                }

                if (query % 10 == 0) {
                    checkOperation = true;
                }
            }

            printBits(bits);
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

    private static void handleCheckOperation(Scanner scanner, int[] bits, int sameIndex, int diffIndex) {
        if (diffIndex == UNKNOWN || sameIndex == UNKNOWN) {
            System.out.println("1");
            int result = scanner.nextInt();
            if (result != bits[1]) {
                complementBits(bits);
            }
        } else {
            System.out.println(sameIndex);
            int result1 = scanner.nextInt();
            System.out.println(diffIndex);
            int result2 = scanner.nextInt();

            if (result1 != bits[sameIndex]) {
                if (result2 == bits[diffIndex]) {
                    reverseBits(bits);
                }
                complementBits(bits);
            } else {
                if (result2 != bits[diffIndex]) {
                    reverseBits(bits);
                }
            }
        }
    }

    private static void printBits(int[] bits) {
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
            bits[i] = bits[i] == OFF ? ON : OFF;
        }
    }
}