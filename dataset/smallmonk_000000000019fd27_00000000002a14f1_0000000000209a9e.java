
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner has functions to read ints, longs, strings, chars, etc.
        String line = in.nextLine();
        String[] inputParam = line.split("\\s+");
        int T = Integer.parseInt(inputParam[0]);
        int B = Integer.parseInt(inputParam[1]);
        for (int i = 1; i <= T; ++i) {
            boolean success = interact(in, B);

            if (!success) {
                break;
            }
        }
    }

    public static List<Integer> getCheckBitPosition(int B, int bitposForReverseCheck, int bitposForComplementCheck, boolean complementReverse) {
        List<Integer> checkPositions = new ArrayList<>();

        if (bitposForReverseCheck < 0 && bitposForComplementCheck < 0) {
            /// Reverse check
            /// 000 000
            checkPositions.add(1);
            return checkPositions;
        }

        if (bitposForComplementCheck < 0) {
            /// Reverse check only
            /// 000 111
            checkPositions.add(bitposForReverseCheck + 1);
            return checkPositions;
        }

        if (bitposForReverseCheck < 0) {
            /// Complement check only
            /// 010 010
            checkPositions.add(bitposForComplementCheck);
            return checkPositions;
        }

        if (bitposForReverseCheck == bitposForComplementCheck) {
            if (!complementReverse) {
                checkPositions.add(bitposForComplementCheck);
                checkPositions.add(bitposForComplementCheck + 1);
                checkPositions.add(B-bitposForComplementCheck);
            } else {
                checkPositions.add(B - bitposForComplementCheck + 1);
                checkPositions.add(B-bitposForComplementCheck);
                checkPositions.add(bitposForComplementCheck + 1);
            }
            return checkPositions;
        }

        if (bitposForReverseCheck < bitposForComplementCheck) {
            if (!complementReverse) {
                checkPositions.add(bitposForReverseCheck + 1);
                checkPositions.add(bitposForComplementCheck + 1);
                checkPositions.add(B - bitposForComplementCheck);
            } else {
                checkPositions.add(B - bitposForReverseCheck);
                checkPositions.add(B - bitposForComplementCheck);
                checkPositions.add(bitposForComplementCheck + 1);
            }

            return  checkPositions;
        }

        /// Impossible condition which return empty list as this is eliminated during determine reverse bit

        return checkPositions;
    }

    public static Boolean getVal(int B, int pos, List<Boolean> startList, List<Boolean> endList) {
        if (pos < B/2) {
            return startList.get(pos-1);
        } else {
            return endList.get(B-pos);
        }
    }

    public static int getBitProcessMode(int B, int bitposForReverseCheck, int bitposForComplementCheck, boolean complementSide, List<Boolean> startList, List<Boolean> endList, List<Integer> position, List<Boolean> values) {
        int mode = 0;

        if (bitposForComplementCheck < 0) {
            int pos = position.get(0) - 1;
            final Boolean val = startList.get(pos);

            Boolean check = values.get(0);
            if (!val.equals(check)) {
                /// Bit inverse is required
                mode = 1;
            }

            return mode;
        }

        if (bitposForReverseCheck < 0) {
            int pos = position.get(0) - 1;
            final Boolean val = startList.get(pos);

            Boolean check = values.get(0);
            if (!val.equals(check)) {
                /// Bit inverse is required
                mode = 1;
            }

            return mode;
        }

        final Boolean val1 = getVal(B, position.get(0), startList, endList);
        final Boolean val2 = getVal(B, position.get(1), startList, endList);
        final Boolean val3 = getVal(B, position.get(2), startList, endList);

        final Boolean check1 = values.get(0);
        final Boolean check2 = values.get(1);
        final Boolean check3 = values.get(2);

        if (!check1.equals(check2)) {
            /// Neighbour difference is found
            if (!val1.equals(check1)) {
                // Bit inverse is required
                return 1;
            }
            return 0;
        }

        // Reverse is required as neighbour different is not found
        mode = 2;

        if (!check3.equals(val2)) {
            /// Bit inverse is required
            mode = mode | 1;
        }

        return mode;
    }

    public static boolean interact(final Scanner in, int B) {
        List<Boolean> startList = new ArrayList<>(B/2);
        List<Boolean> endList = new ArrayList<>(B/2);

        int bitposForComplementCheck = -1;
        int bitposForReverseCheck = -1;
        boolean complementReverse = false;

        int remainingBit = B;
        int bitpos = 0;
        boolean reverse = false;
        boolean valBeforeReverse = false;
        boolean valLastPosNon = false;
        boolean valLastPosReverse = false;
        int cycle = 10;
        boolean checkMode = false;
        List<Integer> checkPositions = null;
        List<Boolean> checkValues = null;
        int bitProcessMode =  0;
        for (int i=0; i<150; i++) {
            if (i != 0 && i%cycle == 0) {
                /// Checking mode
                checkMode = true;
                checkPositions = getCheckBitPosition(B, bitposForReverseCheck, bitposForComplementCheck, complementReverse);
                checkValues = new ArrayList<>();
            }

            if (checkMode && null != checkPositions && checkPositions.size() > 0) {
                System.out.println(checkPositions.get(checkValues.size()));
                String line = in.nextLine();
                if ("N".equals(line)) {
                    return false;
                }

                boolean bitVal = "1".equals(line);
                checkValues.add(bitVal);
                if (checkValues.size() == checkPositions.size()) {
                    bitProcessMode = getBitProcessMode(B, bitposForReverseCheck, bitposForComplementCheck, complementReverse, startList, endList, checkPositions, checkValues);
                    checkMode = false;
                }
                continue;
            }

            if (!reverse) {
                System.out.println(bitpos + 1);
            } else {
                System.out.println(B - bitpos);
            }

            String line = in.nextLine();
            if ("N".equals(line)) {
                return false;
            }

            boolean bitVal = "1".equals(line);

            final boolean invertVal;
            final boolean reverseBitPos;
            switch(bitProcessMode) {
                case 1: invertVal = true; reverseBitPos = reverse; break;
                case 2: invertVal = false; reverseBitPos = !reverse; break;
                case 3: invertVal = true; reverseBitPos = !reverse; break;
                default:
                    invertVal = false;
                    reverseBitPos = reverse;
            }

            /// Transform of bitVal is required here according to mode
            if (invertVal) {
                bitVal = !bitVal;
            }

            if (!reverseBitPos) {
                startList.add(bitVal);

                if (bitpos>0 && bitposForComplementCheck == -1) {
                    if (valLastPosNon != bitVal) {
                        bitposForComplementCheck = bitpos;
                        complementReverse = reverseBitPos;
                        //System.out.println("Complement bit: " + bitposForComplementCheck);
                    }
                }
                valLastPosNon = bitVal;
            } else {
                endList.add(bitVal);

                if (bitpos>0 && bitposForComplementCheck == -1) {
                    if (valLastPosReverse != bitVal) {
                        bitposForComplementCheck = bitpos;
                        complementReverse = reverseBitPos;
                        //System.out.println("Complement bit: " + bitposForComplementCheck);
                    }
                }
                valLastPosReverse = bitVal;
            }

            //bitposForComplementCheck
            if (!reverse) {
                valBeforeReverse = bitVal;
            } else {
                if (bitposForReverseCheck == -1) {
                    if (valBeforeReverse != bitVal) {
                        //System.out.println("Complement bit: " + bitposForComplementCheck);

                        bitposForReverseCheck = bitpos;
                        if (bitposForComplementCheck != -1 && bitposForComplementCheck < bitposForReverseCheck) {
                            bitposForComplementCheck = bitpos;
                            if (startList.get(bitpos) != startList.get(bitpos-1)) {
                                complementReverse = false;
                            } else {
                                complementReverse = true;
                            }
                        }

                        //System.out.println("Reverse bit: " + bitposForReverseCheck);
                        //System.out.println("Complement bit: " + bitposForComplementCheck);
                    }
                }

                bitpos++;
            }

            remainingBit--;
            reverse = !reverse;

            if (remainingBit <= 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder(B);
        for (int i=0; i<startList.size(); i++) {
            if (startList.get(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        for (int i=endList.size(); i>0; i--) {
            if (endList.get(i-1)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        System.out.println(sb.toString());

        String response = in.nextLine();

        return "Y".equals(response);
    }
}