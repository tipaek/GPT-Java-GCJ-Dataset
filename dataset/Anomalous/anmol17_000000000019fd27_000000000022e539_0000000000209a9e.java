import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            try {
                solution.processTestCase(bitLength, scanner);
            } catch (Exception e) {
                return;
            }
        }
    }

    private void processTestCase(int bitLength, Scanner scanner) throws Exception {
        List<Integer> bits = new ArrayList<>(Collections.nCopies(bitLength, -1));
        Map<CombinationType, List<Integer>> combinationMap = new HashMap<>();
        int decidedCount = 0;

        for (int i = 0; i < 150; i++) {
            if (i != 0 && i % 10 == 0) {
                int[] loopVar = {i};
                FluctuationType fluctuation = detectFluctuation(combinationMap, scanner, bits, loopVar);
                applyFluctuation(fluctuation, bits);
                i = loopVar[0];
            } else {
                fetchNextBit(decidedCount, bits, bitLength, scanner, combinationMap);
                decidedCount++;
            }
            if (decidedCount == bitLength) {
                break;
            }
        }
        System.out.println(convertBitsToString(bits));
        if (scanner.next().equals("N")) {
            throw new Exception();
        }
    }

    private void applyFluctuation(FluctuationType fluctuation, List<Integer> bits) {
        switch (fluctuation) {
            case REVERSE:
                Collections.reverse(bits);
                break;
            case COMPLIMENT:
                for (int i = 0; i < bits.size(); i++) {
                    if (bits.get(i) != -1) {
                        bits.set(i, bits.get(i) ^ 1);
                    }
                }
                break;
            case REVERSE_AND_COMPLIMENT:
                Collections.reverse(bits);
                for (int i = 0; i < bits.size(); i++) {
                    if (bits.get(i) != -1) {
                        bits.set(i, bits.get(i) ^ 1);
                    }
                }
                break;
            case NOTHING:
            default:
                break;
        }
    }

    private FluctuationType detectFluctuation(Map<CombinationType, List<Integer>> combinationMap, Scanner scanner, List<Integer> bits, int[] loopVar) {
        List<Integer> sameIndices = getIndices(combinationMap, CombinationType.ONE_ONE, CombinationType.ZERO_ZERO);
        List<Integer> diffIndices = getIndices(combinationMap, CombinationType.ONE_ZERO, CombinationType.ZERO_ONE);

        if (sameIndices == null) {
            int original = bits.get(diffIndices.get(0));
            System.out.println(diffIndices.get(0) + 1);
            int newValue = scanner.nextInt();
            return (newValue == original) ? FluctuationType.NOTHING : FluctuationType.REVERSE;
        } else if (diffIndices == null) {
            int original = bits.get(sameIndices.get(0));
            System.out.println(sameIndices.get(0) + 1);
            int newValue = scanner.nextInt();
            return (newValue == original) ? FluctuationType.NOTHING : FluctuationType.COMPLIMENT;
        } else {
            int originalSame = bits.get(sameIndices.get(0));
            int originalDiff = bits.get(diffIndices.get(0));
            System.out.println(sameIndices.get(0) + 1);
            int newSame = scanner.nextInt();
            System.out.println(diffIndices.get(0) + 1);
            int newDiff = scanner.nextInt();
            loopVar[0]++;
            if (newSame == originalSame && newDiff == originalDiff) {
                return FluctuationType.NOTHING;
            } else if (newSame == originalSame) {
                return FluctuationType.REVERSE;
            } else if (newDiff == originalDiff) {
                return FluctuationType.REVERSE_AND_COMPLIMENT;
            } else {
                return FluctuationType.COMPLIMENT;
            }
        }
    }

    private List<Integer> getIndices(Map<CombinationType, List<Integer>> combinationMap, CombinationType type1, CombinationType type2) {
        return combinationMap.getOrDefault(type1, combinationMap.get(type2));
    }

    private void fetchNextBit(int decidedCount, List<Integer> bits, int bitLength, Scanner scanner, Map<CombinationType, List<Integer>> combinationMap) {
        int index = (decidedCount % 2 == 0) ? decidedCount / 2 : bitLength - (decidedCount + 1) / 2;
        System.out.println(index + 1);
        bits.set(index, scanner.nextInt());

        if (decidedCount % 2 == 1) {
            int upperIndex = (decidedCount + 1) / 2 - 1;
            int lowerIndex = bitLength - upperIndex - 1;
            int upperValue = bits.get(upperIndex);
            int lowerValue = bits.get(lowerIndex);

            CombinationType combination = determineCombinationType(upperValue, lowerValue);
            combinationMap.put(combination, Arrays.asList(upperIndex, lowerIndex));
        }
    }

    private CombinationType determineCombinationType(int val1, int val2) {
        if (val1 == 1 && val2 == 1) return CombinationType.ONE_ONE;
        if (val1 == 0 && val2 == 0) return CombinationType.ZERO_ZERO;
        if (val1 == 1 && val2 == 0) return CombinationType.ONE_ZERO;
        return CombinationType.ZERO_ONE;
    }

    private String convertBitsToString(List<Integer> bits) {
        StringBuilder result = new StringBuilder(bits.size());
        for (int bit : bits) {
            result.append(bit);
        }
        return result.toString();
    }

    private enum CombinationType {
        ONE_ONE, ZERO_ZERO, ONE_ZERO, ZERO_ONE;
    }

    private enum FluctuationType {
        REVERSE, COMPLIMENT, REVERSE_AND_COMPLIMENT, NOTHING;
    }
}