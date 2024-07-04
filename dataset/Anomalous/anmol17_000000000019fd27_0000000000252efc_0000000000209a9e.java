import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        Solution solution = new Solution();
        
        for (int i = 0; i < testCases; i++) {
            try {
                solution.solveCase(bitLength, scanner);
            } catch (Exception e) {
                return;
            }
        }
    }

    private void solveCase(int bitLength, Scanner scanner) throws Exception {
        List<Integer> bits = new ArrayList<>(Collections.nCopies(bitLength, -1));
        Map<CombinationType, List<Integer>> combinationMap = new HashMap<>();
        int receivedBits = 0;
        
        for (int i = 0; i < 150; i++) {
            if (receivedBits == bitLength) {
                break;
            }
            
            if (i != 0 && i % 10 == 0) {
                int[] currentIndex = {i};
                FluctuationType fluctuation = determineFluctuation(combinationMap, scanner, bits, currentIndex);
                applyFluctuation(fluctuation, bits);
                i = currentIndex[0];
            } else {
                if (receivedBits % 2 == 0 && (i + 1) % 10 == 0) {
                    requestBit(1, scanner);
                    continue;
                }
                fetchAndProcessBit(receivedBits, bits, bitLength, scanner, combinationMap);
                receivedBits++;
            }
        }
        
        System.out.println(bitsToString(bits));
        if (scanner.next().equals("N")) {
            throw new Exception();
        }
    }

    private void fetchAndProcessBit(int receivedBits, List<Integer> bits, int bitLength, Scanner scanner, Map<CombinationType, List<Integer>> combinationMap) {
        int index = findNextIndex(bits, bitLength, receivedBits);
        int bitValue = requestBit(index + 1, scanner);
        bits.set(index, bitValue);
        
        int pairIndex = bitLength - index - 1;
        if (bits.get(pairIndex) != -1) {
            updateCombinationMap(bits, index, pairIndex, combinationMap);
        }
    }

    private int findNextIndex(List<Integer> bits, int bitLength, int receivedBits) {
        if (receivedBits % 2 == 0) {
            for (int i = 0; i < bitLength; i++) {
                if (bits.get(i) == -1) {
                    return i;
                }
            }
        } else {
            for (int i = bitLength - 1; i >= 0; i--) {
                if (bits.get(i) == -1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void updateCombinationMap(List<Integer> bits, int index, int pairIndex, Map<CombinationType, List<Integer>> combinationMap) {
        int bit1 = bits.get(index);
        int bit2 = bits.get(pairIndex);
        CombinationType type = determineCombinationType(bit1, bit2);
        
        combinationMap.put(type, Arrays.asList(index, pairIndex));
    }

    private CombinationType determineCombinationType(int bit1, int bit2) {
        if (bit1 == 1 && bit2 == 1) {
            return CombinationType.ONE_ONE;
        } else if (bit1 == 0 && bit2 == 0) {
            return CombinationType.ZERO_ZERO;
        } else if (bit1 == 1 && bit2 == 0) {
            return CombinationType.ONE_ZERO;
        } else {
            return CombinationType.ZERO_ONE;
        }
    }

    private int requestBit(int index, Scanner scanner) {
        System.out.println(index);
        return scanner.nextInt();
    }

    private FluctuationType determineFluctuation(Map<CombinationType, List<Integer>> combinationMap, Scanner scanner, List<Integer> bits, int[] currentIndex) {
        List<Integer> sameValueIndices = getIndices(combinationMap, CombinationType.ONE_ONE, CombinationType.ZERO_ZERO);
        List<Integer> diffValueIndices = getIndices(combinationMap, CombinationType.ONE_ZERO, CombinationType.ZERO_ONE);

        if (sameValueIndices == null) {
            return checkFluctuation(bits, diffValueIndices, scanner);
        } else if (diffValueIndices == null) {
            return checkFluctuation(bits, sameValueIndices, scanner);
        } else {
            return checkDoubleFluctuation(bits, sameValueIndices, diffValueIndices, scanner, currentIndex);
        }
    }

    private List<Integer> getIndices(Map<CombinationType, List<Integer>> combinationMap, CombinationType... types) {
        for (CombinationType type : types) {
            if (combinationMap.containsKey(type)) {
                return combinationMap.get(type);
            }
        }
        return null;
    }

    private FluctuationType checkFluctuation(List<Integer> bits, List<Integer> indices, Scanner scanner) {
        int originalValue = bits.get(indices.get(0));
        int newValue = requestBit(indices.get(0) + 1, scanner);
        return (newValue == originalValue) ? FluctuationType.NOTHING : FluctuationType.COMPLIMENT;
    }

    private FluctuationType checkDoubleFluctuation(List<Integer> bits, List<Integer> sameIndices, List<Integer> diffIndices, Scanner scanner, int[] currentIndex) {
        int sameOriginal = bits.get(sameIndices.get(0));
        int diffOriginal = bits.get(diffIndices.get(0));
        int sameNew = requestBit(sameIndices.get(0) + 1, scanner);
        int diffNew = requestBit(diffIndices.get(0) + 1, scanner);
        currentIndex[0]++;

        if (sameNew == sameOriginal && diffNew == diffOriginal) {
            return FluctuationType.NOTHING;
        } else if (sameNew == sameOriginal) {
            return FluctuationType.REVERSE;
        } else if (diffNew == diffOriginal) {
            return FluctuationType.REVERSE_AND_COMPLIMENT;
        } else {
            return FluctuationType.COMPLIMENT;
        }
    }

    private void applyFluctuation(FluctuationType fluctuation, List<Integer> bits) {
        switch (fluctuation) {
            case REVERSE:
                Collections.reverse(bits);
                break;
            case COMPLIMENT:
                bits.replaceAll(bit -> (bit == -1) ? -1 : 1 - bit);
                break;
            case REVERSE_AND_COMPLIMENT:
                Collections.reverse(bits);
                bits.replaceAll(bit -> (bit == -1) ? -1 : 1 - bit);
                break;
            default:
                break;
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