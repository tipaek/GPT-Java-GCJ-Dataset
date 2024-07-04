
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Stream;

public class Solution {
    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private final Solution.Tx transmitter;
    private final Solution.Rx receiver;

    private final InvertableArray invertableArray;
    private int requested = 0;

    public Solution(Solution.Tx transmitter, Solution.Rx receiver, int size) throws IOException {
        this.transmitter = transmitter;
        this.receiver = receiver;
        this.invertableArray = new InvertableArray(size);
    }

    public static void main(String[] args) throws IOException {
        final int numOfCases = Integer.parseInt(READER.readLine().split(" ")[0]);
        for (int i = 0; i < numOfCases; i++) {
            int arraySize = Integer.parseInt(READER.readLine());
            if (!new Solution(Solution.Tx.SOUT, Solution.Rx.SIN, arraySize).run()) {
                break;
            }
        }
    }

    public boolean run() throws IOException {
        String result = runSolution();

        transmitter.transmit(result);
        final String testResult = receiver.receive();
        return "Y".equals(testResult);
    }

    public String runSolution() throws IOException {
        int length = invertableArray.values.length;
        int i = 0;
        while (!invertableArray.isFull()) {
            boolean firstBit = request(i);
            invertableArray.set(i, firstBit);
            int mirrorIndex = length - i - 1;
            boolean mirrorBit = request(mirrorIndex);
            invertableArray.set(mirrorIndex, mirrorBit);
            i++;
            if (requested % 10 == 0) {
                // check if was inverted or/and mirrored
                Integer sameBitsIndex = invertableArray.findSameBitsIndex();
                if (sameBitsIndex != null) {
                    boolean result = request(sameBitsIndex);
                    if (result != invertableArray.get(sameBitsIndex)) {
                        invertableArray.invert();
                    }
                } else {
                    request(0); // just to ruining sequence
                }
                Integer mirrorBitsIndex = invertableArray.findMirrorBitsIndex();
                if (mirrorBitsIndex != null) {
                    boolean result = request(mirrorBitsIndex);
                    if (result != invertableArray.get(mirrorBitsIndex)) {
                        invertableArray.reverse();
                    }
                } else {
                    request(0);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < invertableArray.values.length; j++) {
            stringBuilder.append(invertableArray.get(j) ? "1" : "0");
        }
        return stringBuilder.toString();
    }

    private boolean request(int i) throws IOException {
        transmitter.transmit(Integer.toString(i + 1));
        requested++;
        return Integer.parseInt(receiver.receive()) == 1;
    }


    private static class InvertableArray {

        private final Boolean[] values;

        private boolean isReversed = false;
        private boolean isInverted = false;


        private InvertableArray(int size) {
            this.values = new Boolean[size];
        }

        private void set(int index, boolean value) {
            int realIndex = isReversed ? values.length - index - 1 : index;
            values[realIndex] = isInverted ^ value;
        }

        private boolean get(int index) {
            int realIndex = isReversed ? values.length - index - 1 : index;
            return isInverted ^ values[realIndex];
        }

        private boolean isFull() {
            return Stream.of(values).allMatch(Objects::nonNull);
        }

        public Integer findSameBitsIndex() {
            for (int i = 0; i < values.length; i++) {
                int mirrorIndex = values.length - i - 1;
                if (values[i] != null && values[mirrorIndex] != null && values[i] == values[mirrorIndex]) {
                    return i;
                }
            }
            return null;
        }

        public Integer findMirrorBitsIndex() {
            for (int i = 0; i < values.length; i++) {
                int mirrorIndex = values.length - i - 1;
                if (values[i] != null && values[mirrorIndex] != null && values[i] != values[mirrorIndex]) {
                    return i;
                }
            }
            return null;
        }

        public void invert() {
            isInverted = !isInverted;
        }

        public void reverse() {
            isReversed = !isReversed;
        }
    }

    interface Rx {

        Solution.Rx SIN = READER::readLine;

        String receive() throws IOException;
    }

    interface Tx {

        Solution.Tx SOUT = line -> {
            System.out.println(line);
            System.out.flush();
        };

        void transmit(String request) throws IOException;
    }

}
