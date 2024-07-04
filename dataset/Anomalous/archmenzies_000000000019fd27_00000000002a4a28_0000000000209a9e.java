import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int[] tAndB = Arrays.stream(inputReader.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

            int testCases = tAndB[0];
            int arrLength = tAndB[1];

            for (int t = 1; t <= testCases; t++) {
                int sameIndex = -1;
                boolean[] sameBit = new boolean[1];
                int diffIndex = -1;
                boolean[] diffBit = new boolean[1];

                int queryCount = 0;
                Boolean[] array = new Boolean[arrLength];
                for (int i = 0; i < arrLength / 2; i++) {
                    array[i] = query(i);
                    queryCount++;

                    if (queryCount % 10 == 1 && queryCount != 1) {
                        array = quantumUpdate(array, sameIndex, sameBit, diffIndex, diffBit);
                        queryCount += 2;
                    }

                    array[arrLength - 1 - i] = query(arrLength - 1 - i);
                    queryCount++;

                    if (array[i] == null) {
                        throw new IOException("NPE: " + Arrays.toString(array));
                    }

                    boolean equalBits = array[i].equals(array[arrLength - 1 - i]);
                    if (sameIndex == -1 && equalBits) {
                        sameIndex = i;
                        sameBit[0] = array[i];
                    }
                    if (diffIndex == -1 && !equalBits) {
                        diffIndex = i;
                        diffBit[0] = array[i];
                    }
                }

                if (!guess(array)) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static boolean query(int index) throws IOException {
        System.out.println(index + 1);
        System.out.flush();
        String response = inputReader.readLine();
        if ("N".equals(response)) {
            throw new IOException(String.format("Bad Query at index %d (Sent index %d)", index, index + 1));
        }
        return "1".equals(response);
    }

    private static boolean guess(Boolean[] array) throws IOException {
        String result = Arrays.stream(array)
                              .map(bit -> bit ? "1" : "0")
                              .collect(Collectors.joining());
        System.out.println(result);
        System.out.flush();
        return "Y".equals(inputReader.readLine());
    }

    private static Boolean[] reverse(Boolean[] array) {
        Boolean[] reversed = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - 1 - i] = array[i];
        }
        return reversed;
    }

    private static Boolean[] complement(Boolean[] array) {
        Boolean[] complement = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            complement[i] = array[i] == null ? null : !array[i];
        }
        return complement;
    }

    private static Boolean[] reverseComplement(Boolean[] array) {
        Boolean[] reversed = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[array.length - 1 - i] = array[i] == null ? null : !array[i];
        }
        return reversed;
    }

    private static Boolean[] quantumUpdate(Boolean[] oldArray, int sameIndex, boolean[] sameBit, int diffIndex, boolean[] diffBit) throws IOException {
        try {
            boolean sameChanged = false;
            if (sameIndex != -1) {
                boolean newSameBit = query(sameIndex);
                sameChanged = newSameBit != sameBit[0];
                sameBit[0] = newSameBit;
            } else {
                query(0); // Keep number of queries even
            }

            boolean diffChanged = false;
            if (diffIndex != -1) {
                boolean newDiffBit = query(diffIndex);
                diffChanged = newDiffBit != diffBit[0];
                diffBit[0] = newDiffBit;
            } else {
                query(0); // Keep number of queries even
            }

            if (sameChanged && diffChanged) {
                return complement(oldArray);
            } else if (sameChanged) {
                return reverseComplement(oldArray);
            } else if (diffChanged) {
                return reverse(oldArray);
            } else {
                return oldArray;
            }
        } catch (IOException e) {
            throw new IOException(String.format("Quantum Update Failed with sameIndex = %d, diffIndex = %d", sameIndex, diffIndex), e);
        }
    }
}