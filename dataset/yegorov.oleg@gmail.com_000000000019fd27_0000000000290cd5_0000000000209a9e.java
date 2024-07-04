import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        int b = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            BitCommunicator bc = new BitCommunicator(in);
            int knownOpposites = -1;
            int knownSame = -1;

            BitSet bitSet = new BitSet(b);

            for (int curBit = 0; curBit < b / 2; curBit++) {
                if (bc.isCriticalStep()) {
                    boolean wasReversed = false;
                    boolean wasComplemented = false;

                    Boolean sameEq = null;
                    Boolean diffEq = null;
                    if (knownSame > -1) {
                        boolean val = bc.askBit(knownSame);
                        boolean oldVal = bitSet.get(knownSame);
                        sameEq = val == oldVal;
                    } else {
                        bc.askBit(0);
                    }

                    if (knownOpposites > -1) {
                        boolean val = bc.askBit(knownOpposites);
                        boolean oldVal = bitSet.get(knownOpposites);
                        diffEq = val == oldVal;
                    } else {
                        bc.askBit(0);
                    }

                    if (sameEq == null) {
                        wasComplemented = !diffEq;
                    }
                    else if (diffEq == null) {
                        wasComplemented = !sameEq;
                    }
                    else {
                        if (!sameEq && !diffEq) {
                            wasComplemented = true;
                            wasReversed = false;
                        }
                        if (sameEq && !diffEq) {
                            wasComplemented = false;
                            wasReversed = true;
                        }
                        if (!sameEq && diffEq) {
                            wasComplemented = true;
                            wasReversed = true;
                        }
                    }

                    if (wasComplemented) {
                        for (int j = 0; j < curBit; j++) {
                            bitSet.set(j, !bitSet.get(j));
                            bitSet.set(b - j - 1, !bitSet.get(b - j - 1));
                        }
                    }
                    if (wasReversed) {
                        for (int j = 0; j < curBit; j++) {
                            boolean temp = bitSet.get(j);
                            bitSet.set(j, bitSet.get(b - j - 1));
                            bitSet.set(b - j - 1, temp);
                        }
                    }
                }

                boolean val = bc.askBit(curBit);
                bitSet.set(curBit, val);

                boolean symmetricVal = bc.askBit(b - curBit - 1);
                bitSet.set(b - curBit - 1, symmetricVal);

                if (val == symmetricVal)
                    knownSame = curBit;
                if (val != symmetricVal)
                    knownOpposites = curBit;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < b; j++)
            {
                sb.append(bitSet.get(j) ? '1' : '0');
            }

            System.out.println(sb.toString());
            System.out.flush();
            String response = in.nextLine();
            response = in.nextLine();

            if (!response.equals("Y")) {
                throw new AssertionError();
            } else {

            }
        }
    }

    private static void diag(String s) {
        System.err.println(s);
        System.err.flush();
    }

    static class BitCommunicator {
        private int step;
        private Scanner in;

        public BitCommunicator(Scanner in) {
            this.in = in;
        }

        public boolean askBit(int bit) {
            System.out.println(bit + 1);
            System.out.flush();
            step++;

            return in.nextInt() == 1;
        }

        public int getStep() {
            return step;
        }

        public boolean isCriticalStep() {
            return step > 0 && step % 10 == 0;
        }
    }
}

