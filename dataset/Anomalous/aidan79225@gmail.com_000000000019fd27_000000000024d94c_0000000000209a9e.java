import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            int b = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().getAnswer(caseNum, b, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int sameBit = -1;
    private int diffBit = -1;

    private void getAnswer(int caseNum, int length, Scanner scanner) {
        boolean[] state = new boolean[length];
        int curBit = 0;
        int target = length / 2;

        while (curBit < target) {
            int count = 10;
            boolean shouldComplement = false;
            boolean shouldReverse = false;

            if (hasSameBit()) {
                processBit(scanner, sameBit);
                shouldComplement = scanner.nextInt() > 0 != state[sameBit];
                count--;
            }

            if (hasDifferentBit()) {
                processBit(scanner, diffBit);
                int x = scanner.nextInt();
                shouldReverse = shouldComplement ? x > 0 == state[diffBit] : x > 0 != state[diffBit];
                count--;
            }

            if (shouldComplement) {
                complementArray(state);
            }

            if (shouldReverse) {
                reverseArray(state);
            }

            while (count > 1 && curBit < target) {
                processBit(scanner, curBit);
                state[curBit] = scanner.nextInt() > 0;

                processBit(scanner, length - curBit - 1);
                state[length - curBit - 1] = scanner.nextInt() > 0;

                if (!hasSameBit() && state[curBit] == state[length - curBit - 1]) {
                    sameBit = curBit;
                }

                if (!hasDifferentBit() && state[curBit] != state[length - curBit - 1]) {
                    diffBit = curBit;
                }

                curBit++;
                count -= 2;
            }

            if (count > 0 && curBit < target) {
                processBit(scanner, length - curBit - 1);
                scanner.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (boolean bit : state) {
            sb.append(bit ? '1' : '0');
        }
        System.out.println(sb.toString());
        System.out.flush();

        if (!scanner.next().equals("Y")) {
            throw new RuntimeException("failed");
        }
    }

    private void processBit(Scanner scanner, int bitPosition) {
        System.out.println(bitPosition + 1);
        System.out.flush();
    }

    private void complementArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = !array[i];
        }
    }

    private void reverseArray(boolean[] array) {
        int mid = array.length / 2;
        for (int i = 0; i < mid; i++) {
            boolean temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private boolean hasSameBit() {
        return sameBit >= 0;
    }

    private boolean hasDifferentBit() {
        return diffBit >= 0;
    }
}