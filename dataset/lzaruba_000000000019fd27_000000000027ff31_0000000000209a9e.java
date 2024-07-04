import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {

    private static int requestId = 1;

    private enum Fluct {
        NOTHING, SWAP, COMP, SWAP_COMP;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        System.err.println(String.format("Test count=%d", testCount));
        int bitsCount = in.nextInt();
        System.err.println(String.format("Bits count=%d", bitsCount));
        for (int caseId = 1; caseId <= testCount; caseId++) {
            requestId = 1;
            System.err.println("Test case " + caseId);
            int[] data = new int[bitsCount];
            for (int i = 0; i < data.length; i++) {
                data[i] = 2;
            }
            interact(in, data);
            String output = transformOutput(data);
            System.out.println(output);
            System.out.flush();
            System.err.println("Submitted " + output);
            in.nextLine();
            String judge = in.nextLine();
            if ("N".equals(judge)) {
                System.exit(100);
            }
        }
    }

    private static String transformOutput(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
        }
        return sb.toString();
    }

    private static void interact(Scanner in, int[] data) {
        int knownFromIndex = 0;
        int knownToIndex = data.length - 1;
        int knownValues = 0;

        while (knownValues < data.length && requestId < 150) {
            if (requestId % 10 != 1 || requestId == 1) {
                if (knownValues % 2 == 1) { // odd
                    System.err.println(String.format("Request data left [%d]", knownFromIndex));
                    data[knownFromIndex] = requestValue(in, knownFromIndex);
                    knownFromIndex++;
                } else { // even
                    System.err.println(String.format("Request data right [%d]", knownToIndex));
                    data[knownToIndex] = requestValue(in, knownToIndex);
                    knownToIndex--;
                }
                knownValues++;
                System.err.println(String.format("State after knownValues#%d: %s, leftIndex: %d rightIndex %d", knownValues, transformOutput(data), knownFromIndex, knownToIndex));
            } else {
                System.err.println("Fluctuation - handling correction");

                int samePairLeftIndex = -1;
                int differentPairLeftIndex = -1;

                int indexShift = -1;
                while (indexShift <= knownFromIndex && data.length - 1 - indexShift >= knownToIndex) {
                    indexShift++;
                    if (data[indexShift] == data[data.length - 1 - indexShift]) {
                        if (samePairLeftIndex >= 0) continue;
                        samePairLeftIndex = indexShift;
                    } else if (data[indexShift] != data[data.length - 1 - indexShift]) {
                        if (differentPairLeftIndex >= 0) continue;
                        differentPairLeftIndex = indexShift;
                    }
                }

                System.err.println(String.format("Current state: %s, sameL=%d diffL=%d",
                        transformOutput(data), samePairLeftIndex, differentPairLeftIndex));

                int samePairLeft = requestValue(in, samePairLeftIndex);
                int differentPairLeft = requestValue(in, differentPairLeftIndex);

                System.err.println(String.format("After update values: sameL=%d diffL=%d",
                        samePairLeft, differentPairLeft));

                Set<Fluct> optionsSame = new HashSet<>();
                if (samePairLeftIndex < 0) {
                    // ignore
                } else if (samePairLeft == data[samePairLeftIndex]) {
                    if (differentPairLeftIndex >= 0) {
                        optionsSame.add(Fluct.SWAP);
                    }
                    optionsSame.add(Fluct.NOTHING);
                } else {
                    optionsSame.add(Fluct.COMP);
                    if (differentPairLeftIndex >= 0) {
                        optionsSame.add(Fluct.SWAP_COMP);
                    }
                }

                Set<Fluct> optionsDiff = new HashSet<>();
                if (differentPairLeftIndex < 0) {
                    // ignore
                } else if (differentPairLeft == data[differentPairLeftIndex]) {
                    optionsDiff.add(Fluct.NOTHING);
                    if (samePairLeftIndex >= 0) {
                        optionsDiff.add(Fluct.SWAP_COMP);
                    }
                } else {
                    if (samePairLeftIndex >= 0) {
                        optionsDiff.add(Fluct.SWAP);
                    }
                    optionsDiff.add(Fluct.COMP);
                }
                System.err.println(String.format("Same pair options: %s, Diff pair options %s", optionsSame, optionsDiff));
                if (optionsSame.size() > 1) {
                    optionsSame.retainAll(optionsDiff);
                }
                Fluct solution = optionsSame.iterator().next();
                System.err.println("Solution: " + solution);

                if (solution == Fluct.SWAP) {
                    swap(data, knownFromIndex, knownToIndex);
                    knownValues--;
                    if (knownValues % 2 == 0) {
                        knownToIndex++;
                    } else {
                        knownFromIndex--;
                    }
                } else if (solution == Fluct.COMP) {
                    comp(data, knownFromIndex, knownToIndex);
                } else if (solution == Fluct.SWAP_COMP) {
                    swap(data, knownFromIndex, knownToIndex);
                    comp(data, knownFromIndex, knownToIndex);
                    knownValues--;
                    if (knownValues % 2 == 0) {
                        knownToIndex++;
                    } else {
                        knownFromIndex--;
                    }
                }

                System.err.println(String.format("State after fix: %s, leftIndex: %d rightIndex %d", transformOutput(data), knownFromIndex, knownToIndex));
            }
        }
    }

    private static void swap(int[] data, int knownLeftIndex, int knownRightIndex) {
        for (int i = 0; i < data.length / 2; i++) {
            int left = data[i];
            int right = data[data.length - 1 - i];
            data[i] = right;
            data[data.length - 1 - i] = left;
        }
    }

    private static void comp(int[] data, int knownLeftIndex, int knownRightIndex) {
        for (int i = 0; i < knownLeftIndex; i++) {
            data[i] = data[i] == 0 ? 1 : 0;
        }
        for (int i = data.length - 1; i > knownRightIndex; i--) {
            data[i] = data[i] == 0 ? 1 : 0;
        }
    }

    private static int requestValue(Scanner in, int index) {
        if (index < 0) return -1;
        System.out.println("" + (index + 1));
        System.out.flush();
        int output = in.nextInt();
        System.err.println(String.format("Request#%d [%d]=%d", requestId, index + 1, output));
        requestId++;
        return output;
    }

}

//1100011101001010110001000110000010010101101011100001001000111011100110010000010111110001110001100011
//1100011101001010110000000110000010010001101010100011001000111011100110010000010111110001110001100011
