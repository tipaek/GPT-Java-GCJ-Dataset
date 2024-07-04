import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String [] line = scanner.nextLine().split(" ");
        int numTestCase = Integer.parseInt(line[0]);
        int numBits = Integer.parseInt(line[1]);
        for (int testCase = 1; testCase <= numTestCase; ++testCase) {
            solve(numBits);
        }
    }

    private static class Bit {
        private int value;
        private Status status;

        public Bit(int value, Status status) {
            this.value = value;
            this.status = status;
        }
    }

    private enum Status {
        EQUAL,
        DIFF;
    }

    private static void solve(int numBits) {
        Bit[] bits = new Bit[numBits];
        int moveCount = 0;
        int bitIndex = 0;
        while (bitIndex < numBits / 2) {
            int first = Integer.parseInt(sendToServer(String.valueOf(++bitIndex)));
            int firstIndex = bitIndex - 1;

            int second = Integer.parseInt(sendToServer(String.valueOf(numBits - firstIndex)));
            bits[firstIndex] = new Bit(first, first == second ? Status.EQUAL : Status.DIFF);
            moveCount += 2;

            if (moveCount > 10 && moveCount % 10 == 2) {
                updateBits(bits, firstIndex);
                moveCount += 2;
            }
        }

        for (int index = 0; index < numBits / 2; ++index) {
            int counterpartIndex = numBits - index - 1;
            Status status = bits[index].status;
            int value = bits[index].value;
            bits[counterpartIndex] = new Bit(status == Status.EQUAL ? value : reverse(value), status);
        }

        StringBuilder output = new StringBuilder();
        for (int index = 0; index < numBits; ++index) {
            output.append(bits[index].value);
        }
        String response = sendToServer(output.toString());
        if (isSuccess(response)) {
            return;
        } else {
            throw new IllegalArgumentException("Shouldn't happen");
        }
    }

    private static void updateBits(Bit[] bits, int updateLimitIndex) {
        int indexOfFirstEqual = findFirst(bits, Status.EQUAL, updateLimitIndex);
        boolean shouldReverseEquals = false;
        if (indexOfFirstEqual != -1) {
            int result = Integer.parseInt(sendToServer(String.valueOf(indexOfFirstEqual + 1)));
            shouldReverseEquals = bits[indexOfFirstEqual].value != result;
        } else {
            sendToServer("1");
        }

        int indexOfFirstDiff = findFirst(bits, Status.DIFF, updateLimitIndex);
        boolean shouldReverseDiffs = false;
        if (indexOfFirstDiff != -1) {
            int result = Integer.parseInt(sendToServer(String.valueOf(indexOfFirstDiff + 1)));
            shouldReverseDiffs = bits[indexOfFirstDiff].value != result;
        } else {
            sendToServer("1");
        }

        for (int index = 0; index < updateLimitIndex; ++index) {
            if (bits[index].status == Status.EQUAL && shouldReverseEquals) {
                bits[index].value = reverse(bits[index].value);
            }

            if (bits[index].status == Status.DIFF && shouldReverseDiffs) {
                bits[index].value = reverse(bits[index].value);
            }
        }
    }

    private static int reverse(int value) {
        return value == 0 ? 1 : 0;
    }

    private static int findFirst(Bit[] bits, Status status, int updateLimitIndex) {
        for (int index = 0; index < updateLimitIndex; ++index) {
            if (bits[index].status == status) {
                return index;
            }
        }

        return -1;
    }

    private static String sendToServer(String message) {
        System.out.println(message);
        System.out.flush();
        String response = scanner.nextLine();
        if (isError(response)) {
            System.exit(0);
        }

        return response;
    }

    private static boolean isSuccess(String response) {
        return "Y".equals(response);
    }

    private static boolean isError(String response) {
        return "N".equals(response);
    }

    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}