import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] mainEntry = reader.readLine().split(" ");
        int T = Integer.parseInt(mainEntry[0]);
        for (int i = 0; i < T; i++) {
            mainLoop(i + 1, reader, Integer.parseInt(mainEntry[1]));
        }
    }

    private static void mainLoop(int caseId, BufferedReader reader, int b) throws IOException {
        int[] bytes = new int[b];
        Result result = new Result(b);
        ByteRequester byteRequester = new ByteRequester(reader);

        int index = 1;
        while (result.bytesFound < b) {
            char bit = byteRequester.askForByte(index);
            result.setBit(bit, index - 1);
            char pairBit = byteRequester.askForByte(b - index + 1);
            result.setBit(pairBit, b - index);
            if (result.pairIndex < 0 && bit == pairBit) {
                result.pairIndex = index - 1;
                result.pairBit = bit;
            } else if (result.reversePairIndex < 0 && bit != pairBit) {
                result.reversePairIndex = index - 1;
                result.reversePairBit = bit;
            }
            index++;
            if (result.bytesFound < b && byteRequester.trials % 10 == 0) {
                // check for transformation
                boolean sameReverse = true;
                boolean samePair = true;
                if (result.reversePairIndex > -1) {
                    char reverseCheckByte = byteRequester.askForByte(result.reversePairIndex + 1);
                    sameReverse = reverseCheckByte == result.reversePairBit;
                }
                if (result.pairIndex > -1) {
                    char pairCheckByte = byteRequester.askForByte(result.pairIndex + 1);
                    samePair = pairCheckByte == result.pairBit;
                }
                if (sameReverse && samePair) {
                    // do nothing
                } else if (sameReverse) {
                    // complement + reverse
                    result.complement();
                    result.reverse();
                } else if (samePair) {
                    // complement
                    result.complement();
                } else {
                    result.reverse();
                }
            }
        }
        System.out.println(result.toString());
        String s = reader.readLine();
        if (!s.equals("Y")) {
            throw new RuntimeException(s);
        }
    }

    private static class ByteRequester {
        int trials = 0;
        BufferedReader reader;

        public ByteRequester(BufferedReader reader) {
            this.reader = reader;
        }

        private char askForByte(int i) throws IOException {
            System.out.println(i);
            trials++;
            return reader.readLine().charAt(0);
        }
    }

    private static class Result {

        private char[] result;
        // if same : (complement + reverse) or same
        // else : reverse or complement
        private int reversePairIndex = -1;
        private int reversePairBit = 'X';

        // if same : same or complement
        // else : reverse or (complement + reverse)
        private int pairIndex = -1;
        private char pairBit = 'X';

        private int bytesFound = 0;

        public Result(int b) {
            result = new char[b];
            for (int i = 0; i < b; i++) {
                result[i] = 'X';
            }
        }

        private void setBit(char bit, int index) {
            result[index] = bit;
            bytesFound++;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                stringBuilder.append(result[i]);
            }
            return stringBuilder.toString();
        }

        private void complement() {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] == '0' ? '1' : (result[i] == '1' ? '0' : 'X');
            }
            postTransform();
        }

        private void reverse() {
            int i = 0;
            for (int j = result.length - 1; j > i; ++i) {
                char tmp = result[j];
                result[j] = result[i];
                result[i] = tmp;
                j--;
            }
            postTransform();
        }

        private void postTransform() {
            pairBit = result[pairIndex];
            reversePairBit = result[reversePairIndex];
        }
    }
}
