import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Function;

public class Solution {
    private Scanner scanner;
    private PrintStream printStream;

    public static void main(String[] args) {
        new Solution().execute(System.in, System.out);
    }

    Solution() {
        // No-op.
    }

    void execute(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        printStream = out;

        String[] items = scanner.nextLine().split(" ");
        int cases = Integer.parseInt(items[0]);
        int arraySize = Integer.parseInt(items[1]);

        for (int i = 0; i < cases; i++) {
            restoreOriginalArray(arraySize);
        }

        System.exit(0);
    }

    void restoreOriginalArray(int size) {
        int maxIndex = size / 2 + size % 2;

        DataRestorer dataRestorer = new DataRestorer(size);

        int index = 0;
        while (index < maxIndex) {
            int readsLeft = 10;

            if (index > 0) {
                readsLeft -= dataRestorer.checkLastFluctuationAndApplyForAll(this::read);
            }

            int n = readsLeft / 2;
            for (int i = 0; i < n; i++) {
                dataRestorer.setPair(index, read(index), read(size - 1 - index));

                index++;

                if (index > maxIndex) {
                    break;
                }
            }
        }

        checkArray(dataRestorer.toString());
    }

    protected int read(int i) {
        printStream.println((i + 1));
        printStream.flush();
        return scanner.nextLine().equals("1") ? 1 : 0;
    }

    protected boolean checkArray(String array) {
        printStream.println(array);
        printStream.flush();
        return scanner.nextLine().equals("Y");
    }

    private static class DataRestorer {
        private final int[] bytes;
        private int sameBytesIndex = -1;
        private int differentBytesIndex = -1;
        private int lastIndex = -1;

        DataRestorer(int size) {
            bytes = new int[size];
        }

        void setPair(int index, int leftValue, int rightValue) {
            bytes[index] = leftValue;
            bytes[bytes.length - 1 - index] = rightValue;

            if (leftValue == rightValue && sameBytesIndex == -1) {
                sameBytesIndex = index;
            }

            if (leftValue != rightValue && differentBytesIndex == -1) {
                differentBytesIndex = index;
            }

            lastIndex = index;
        }

        int checkLastFluctuationAndApplyForAll(Function<Integer, Integer> reader) {
            if (sameBytesIndex != -1 && differentBytesIndex != -1) {
                int newValue1 = reader.apply(sameBytesIndex);
                int newValue2 = reader.apply(differentBytesIndex);

                if (bytes[sameBytesIndex] != newValue1 && bytes[differentBytesIndex] != newValue2) {
                    modifyExistingBytes(Fluctuation.BITFLIP);
                } else if (bytes[sameBytesIndex] != newValue1) {
                    modifyExistingBytes(Fluctuation.REVERSE_AND_BITFLIP);
                } else if (bytes[differentBytesIndex] != newValue2) {
                    modifyExistingBytes(Fluctuation.REVERSE);
                }

                return 2;
            } else if (sameBytesIndex != -1 || differentBytesIndex != -1) {
                // Bytes are symmetrical so far.
                int idx = sameBytesIndex != -1 ? sameBytesIndex : differentBytesIndex;
                int newLeftValue = reader.apply(idx);
                int newRightValue = reader.apply(getRightIndex(idx));

                if (bytes[idx] != newLeftValue) {
                    modifyExistingBytes(Fluctuation.BITFLIP);
                }

                return 2;
            }

            return 0;
        }

        private void modifyExistingBytes(Fluctuation fluctuation) {
            if (fluctuation == Fluctuation.BITFLIP || fluctuation == Fluctuation.REVERSE_AND_BITFLIP) {
                for (int i = 0; i <= lastIndex; i++) {
                    bytes[i] = 1 - bytes[i];
                    int rightIndex = getRightIndex(i);
                    bytes[rightIndex] = 1 - bytes[rightIndex];
                }
            }

            if (fluctuation == Fluctuation.REVERSE || fluctuation == Fluctuation.REVERSE_AND_BITFLIP) {
                for (int i = 0; i <= lastIndex; i++) {
                    int temp = bytes[i];
                    int rightIndex = getRightIndex(i);
                    bytes[i] = bytes[rightIndex];
                    bytes[rightIndex] = temp;
                }
            }
        }

        private int getRightIndex(int index) {
            return bytes.length - 1 - index;
        }

        public String toString() {
            char[] chars = new char[bytes.length];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = bytes[i] == 1 ? '1' : '0';
            }

            return String.valueOf(chars);
        }
    }

    private enum Fluctuation {
        REVERSE,
        BITFLIP,
        REVERSE_AND_BITFLIP,
        NONE
    }
}