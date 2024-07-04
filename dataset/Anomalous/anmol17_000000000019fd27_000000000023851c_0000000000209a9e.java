import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitsCount = scanner.nextInt();
        Solution solution = new Solution();

        for (int i = 0; i < testCases; i++) {
            try {
                solution.processTestCase(bitsCount, scanner);
            } catch (Exception e) {
                return;
            }
        }
    }

    private void processTestCase(int bitsCount, Scanner scanner) throws Exception {
        List<Integer> bits = new ArrayList<>(Collections.nCopies(bitsCount, -1));
        Map<CombinationType, List<Integer>> combinationMap = new HashMap<>();
        int receivedBits = 0;

        for (int i = 0; i < 150 && receivedBits < bitsCount; i++) {
            if (i > 0 && i % 10 == 0) {
                int[] iteration = {i};
                FluctuationType fluctuation = detectFluctuation(combinationMap, scanner, bits, iteration);
                applyFluctuation(fluctuation, bits);
                i = iteration[0];
            } else {
                requestNextBit(receivedBits, bits, bitsCount, scanner, combinationMap);
                receivedBits++;
            }
        }

        System.out.println(bitsToString(bits));
        if (!scanner.next().equals("Y")) {
            throw new Exception();
        }
    }

    private void requestNextBit(int receivedBits, List<Integer> bits, int bitsCount, Scanner scanner, Map<CombinationType, List<Integer>> combinationMap) {
        int index = findNextIndex(bits, bitsCount, receivedBits);
        System.out.println(index + 1);
        bits.set(index, scanner.nextInt());

        int pairIndex = bitsCount - index - 1;
        if (bits.get(pairIndex) != -1) {
            updateCombinationMap(bits, index, pairIndex, combinationMap);
        }
    }

    private int findNextIndex(List<Integer> bits, int bitsCount, int receivedBits) {
        if (receivedBits % 2 == 0) {
            for (int i = 0; i < bitsCount; i++) {
                if (bits.get(i) == -1) return i;
            }
        } else {
            for (int i = bitsCount - 1; i >= 0; i--) {
                if (bits.get(i) == -1) return i;
            }
        }
        return -1;
    }

    private void updateCombinationMap(List<Integer> bits, int index, int pairIndex, Map<CombinationType, List<Integer>> combinationMap) {
        int val1 = bits.get(index);
        int val2 = bits.get(pairIndex);

        CombinationType combinationType = (val1 == val2) ?
            (val1 == 1 ? CombinationType.ONE_ONE : CombinationType.ZERO_ZERO) :
            (val1 == 1 ? CombinationType.ONE_ZERO : CombinationType.ZERO_ONE);

        combinationMap.put(combinationType, Arrays.asList(index, pairIndex));
    }

    private FluctuationType detectFluctuation(Map<CombinationType, List<Integer>> combinationMap, Scanner scanner, List<Integer> bits, int[] iteration) {
        List<Integer> sameValueIndices = combinationMap.getOrDefault(CombinationType.ONE_ONE, combinationMap.get(CombinationType.ZERO_ZERO));
        List<Integer> differentValueIndices = combinationMap.getOrDefault(CombinationType.ONE_ZERO, combinationMap.get(CombinationType.ZERO_ONE));

        if (sameValueIndices == null) {
            return checkFluctuation(scanner, bits, differentValueIndices, FluctuationType.REVERSE);
        } else if (differentValueIndices == null) {
            return checkFluctuation(scanner, bits, sameValueIndices, FluctuationType.COMPLIMENT);
        } else {
            return checkBothFluctuations(scanner, bits, sameValueIndices, differentValueIndices, iteration);
        }
    }

    private FluctuationType checkFluctuation(Scanner scanner, List<Integer> bits, List<Integer> indices, FluctuationType fluctuationType) {
        int index = indices.get(0);
        int originalValue = bits.get(index);
        System.out.println(index + 1);
        int newValue = scanner.nextInt();

        return (newValue == originalValue) ? FluctuationType.NOTHING : fluctuationType;
    }

    private FluctuationType checkBothFluctuations(Scanner scanner, List<Integer> bits, List<Integer> sameValueIndices, List<Integer> differentValueIndices, int[] iteration) {
        int sameIndex = sameValueIndices.get(0);
        int diffIndex = differentValueIndices.get(0);

        int originalSameValue = bits.get(sameIndex);
        int originalDiffValue = bits.get(diffIndex);

        System.out.println(sameIndex + 1);
        int newSameValue = scanner.nextInt();
        System.out.println(diffIndex + 1);
        int newDiffValue = scanner.nextInt();
        iteration[0]++;

        if (newSameValue == originalSameValue && newDiffValue == originalDiffValue) {
            return FluctuationType.NOTHING;
        } else if (newSameValue == originalSameValue) {
            return FluctuationType.REVERSE;
        } else if (newDiffValue == originalDiffValue) {
            return FluctuationType.REVERSE_AND_COMPLIMENT;
        } else {
            return FluctuationType.COMPLIMENT;
        }
    }

    private void applyFluctuation(FluctuationType fluctuation, List<Integer> bits) {
        if (fluctuation == FluctuationType.REVERSE || fluctuation == FluctuationType.REVERSE_AND_COMPLIMENT) {
            Collections.reverse(bits);
        }
        if (fluctuation == FluctuationType.COMPLIMENT || fluctuation == FluctuationType.REVERSE_AND_COMPLIMENT) {
            for (int i = 0; i < bits.size(); i++) {
                if (bits.get(i) != -1) {
                    bits.set(i, 1 - bits.get(i));
                }
            }
        }
    }

    private String bitsToString(List<Integer> bits) {
        StringBuilder result = new StringBuilder(bits.size());
        for (int bit : bits) {
            result.append(bit);
        }
        return result.toString();
    }

    private enum CombinationType {
        ONE_ONE, ZERO_ZERO, ONE_ZERO, ZERO_ONE
    }

    private enum FluctuationType {
        REVERSE, COMPLIMENT, REVERSE_AND_COMPLIMENT, NOTHING
    }
}