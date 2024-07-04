import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution implements Runnable {

    private final InputStream inStream;
    private final OutputStream outStream;

    public Solution(InputStream in, PrintStream out) {
        this.inStream = in;
        this.outStream = out;
    }

    class Data {
        final int size;
        final Boolean[] values;
        final Scanner scan;
        final PrintWriter out;

        Data(int n, Scanner scan, PrintWriter out) {
            size = n;
            values = new Boolean[n];
            this.scan = scan;
            this.out = out;
        }

        void complementKnownBits() {
            for (int i = 0; i < size; i++) {
                if (values[i] != null) {
                    values[i] = !values[i];
                }
            }
        }

        void reverseKnownBits() {
            for (int i = 0; i < size / 2; i++) {
                Boolean temp = values[i];
                values[i] = values[size - i - 1];
                values[size - i - 1] = temp;
            }
        }

        void complementAndReverseKnownBits() {
            complementKnownBits();
            reverseKnownBits();
        }

        boolean isReady() {
            for (Boolean value : values) {
                if (value == null) {
                    return false;
                }
            }
            return true;
        }

        int getNextUnknownPosition() {
            for (int i = 0; i < size / 2 + 1; i++) {
                if (values[i] == null) {
                    return i;
                }
                if (values[size - i - 1] == null) {
                    return size - i - 1;
                }
            }
            return -1;
        }

        int getFirstSameValuePairPosition() {
            for (int i = 0; i < size / 2; i++) {
                if (values[i] != null && values[size - i - 1] != null && values[i].equals(values[size - i - 1])) {
                    return i;
                }
            }
            return -1;
        }

        int getFirstAlternatingValuePairPosition() {
            for (int i = 0; i < size / 2; i++) {
                if (values[i] != null && values[size - i - 1] != null && !values[i].equals(values[size - i - 1])) {
                    return i;
                }
            }
            return -1;
        }
    }

    protected void processTestCase(int caseNum, int bits, Scanner scan, PrintWriter out) {
        Data data = new Data(bits, scan, out);
        int ask = 10;
        boolean firstRound = true;
        do {
            if (!firstRound) {
                ask -= determineTransformationAndUpdateBits(data);
            }
            askPositions(data, ask);
            firstRound = false;
            ask = 10;
        } while (!data.isReady());
        guess(data);
        String answer = scan.next();
        if ("N".equals(answer)) {
            throw new IllegalStateException("Wrong answer");
        }
    }

    private int determineTransformationAndUpdateBits(Data data) {
        int questionsAsked = 0;
        int sameValuePos = data.getFirstSameValuePairPosition();
        int diffValuePos = data.getFirstAlternatingValuePairPosition();

        if (sameValuePos != -1) {
            if (diffValuePos != -1) {
                boolean origSame = data.values[sameValuePos];
                boolean sameChanged = askValueOfPosition(sameValuePos, data) != origSame;
                boolean origDiff = data.values[diffValuePos];
                boolean diffChanged = askValueOfPosition(diffValuePos, data) != origDiff;

                if (sameChanged) {
                    if (diffChanged) {
                        data.complementKnownBits();
                    } else {
                        data.complementAndReverseKnownBits();
                    }
                } else {
                    if (diffChanged) {
                        data.reverseKnownBits();
                    }
                }
                questionsAsked = 2;
            } else {
                boolean origSame = data.values[sameValuePos];
                boolean sameChanged = askValueOfPosition(sameValuePos, data) != origSame;

                if (sameChanged) {
                    data.complementKnownBits();
                }
                questionsAsked = 1;
            }
        } else if (diffValuePos != -1) {
            boolean origDiff = data.values[diffValuePos];
            boolean diffChanged = askValueOfPosition(diffValuePos, data) != origDiff;

            if (diffChanged) {
                data.complementKnownBits();
            }
            questionsAsked = 1;
        } else {
            throw new IllegalStateException("There should be known values already!");
        }

        return questionsAsked;
    }

    private void askPositions(Data data, int ask) {
        int questionsAsked = 0;
        while (questionsAsked < ask) {
            int pos = data.getNextUnknownPosition();
            if (pos == -1) {
                break;
            }
            data.values[pos] = askValueOfPosition(pos, data);
            questionsAsked++;
        }
    }

    private Boolean askValueOfPosition(int pos, Data data) {
        data.out.println(pos + 1);
        data.out.flush();
        String answer = data.scan.next();
        if ("N".equals(answer)) {
            throw new IllegalStateException("Wrong position query: " + pos);
        }
        return "1".equals(answer);
    }

    private void guess(Data data) {
        for (boolean value : data.values) {
            data.out.append(value ? '1' : '0');
        }
        data.out.println();
        data.out.flush();
    }

    @Override
    public void run() {
        try (Scanner scan = new Scanner(inStream); PrintWriter out = new PrintWriter(outStream)) {
            int t = scan.nextInt();
            int b = scan.nextInt();
            for (int i = 0; i < t; i++) {
                processTestCase(i + 1, b, scan, out);
            }
        } catch (IllegalStateException e) {
            System.err.println("Process failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Solution(System.in, System.out).run();
    }
}