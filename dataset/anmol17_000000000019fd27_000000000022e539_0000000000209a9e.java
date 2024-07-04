import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 0; i < t; i++) {
            try {
                solution.processCase(b, in);
            } catch (Exception ex) {
                return;
            }
        }
    }

    private void processCase(int b, Scanner in) throws Exception {
        List<Integer> bits = new ArrayList<>(b);
        for(int i = 0; i < b; i++) {
            bits.add(-1);
        }
        Map<CombinationType, List<Integer>> combinationToIndicesMap = new HashMap<>();
        int totalDecided = 0;

        for (int i = 0; i < 150; i++) {
            if (i != 0 && i % 10 == 0) {
                int[] loopVar = {i};
                FluctuationType fluctuationType = getFluctuationType(combinationToIndicesMap, in, bits, loopVar);
                processFluctuation(fluctuationType, bits);
                i = loopVar[0];
            } else {
                getNextValue(totalDecided, bits, b, in, combinationToIndicesMap);
                totalDecided++;
            }
            if (totalDecided == b) {
                break;
            }
        }
        System.out.println(getStringFromBits(bits, b));
        String result = in.next();
        if (result.equals("N")) {
            throw new Exception();
        }
    }

    private void processFluctuation(FluctuationType fluctuationType, List<Integer> bits) {
        switch (fluctuationType) {
            case REVERSE:
                reverse(bits);
                break;
            case COMPLIMENT:
                compliment(bits);
                break;
            case REVERSE_AND_COMPLIMENT:
                reverse(bits);
                compliment(bits);
                break;
            case NOTHING:
            default:
                break;
        }
    }

    private FluctuationType getFluctuationType(Map<CombinationType, List<Integer>> combinationToIndicesMap, Scanner in, List<Integer> bits, int[] loopVar) {
        List<Integer> sameValueIndices = getSameValueIndices(combinationToIndicesMap);
        List<Integer> differentValueIndices = getDifferentValueIndices(combinationToIndicesMap);

        if(sameValueIndices == null) {
            int val1 = bits.get(differentValueIndices.get(0));
            System.out.println(differentValueIndices.get(0) + 1);
            int newVal1 = in.nextInt();
            if(newVal1 == val1) {
                return FluctuationType.NOTHING;
            } else {
                return FluctuationType.REVERSE;
            }
        } else if (differentValueIndices == null){
            int val1 = bits.get(sameValueIndices.get(0));
            System.out.println(sameValueIndices.get(0) + 1);
            int newVal1 = in.nextInt();
            if(newVal1 == val1) {
                return FluctuationType.NOTHING;
            } else {
                return FluctuationType.COMPLIMENT;
            }
        } else {
            int val1 = bits.get(sameValueIndices.get(0));
            int val2 = bits.get(differentValueIndices.get(0));
            System.out.println(sameValueIndices.get(0) + 1);
            int newVal1 = in.nextInt();
            System.out.println(differentValueIndices.get(0) + 1);
            int newVal2 = in.nextInt();
            loopVar[0]++;
            if(newVal1 == val1 && newVal2 == val2) {
                return FluctuationType.NOTHING;
            } else if (newVal1 == val1) {
                return FluctuationType.REVERSE;
            } else if(newVal2 == val2) {
                return FluctuationType.REVERSE_AND_COMPLIMENT;
            } else {
                return FluctuationType.COMPLIMENT;
            }
        }
    }

    private List<Integer> getDifferentValueIndices(Map<CombinationType, List<Integer>> combinationToIndicesMap) {
        if(combinationToIndicesMap.containsKey(CombinationType.ONE_ZERO)) {
            return combinationToIndicesMap.get(CombinationType.ONE_ZERO);
        } else {
            return combinationToIndicesMap.get(CombinationType.ZERO_ONE);
        }
    }

    private List<Integer> getSameValueIndices(Map<CombinationType, List<Integer>> combinationToIndicesMap) {
        if(combinationToIndicesMap.containsKey(CombinationType.ONE_ONE)) {
            return combinationToIndicesMap.get(CombinationType.ONE_ONE);
        } else {
            return combinationToIndicesMap.get(CombinationType.ZERO_ZERO);
        }
    }

    private void getNextValue(int totalDecided, List<Integer> bits, int b, Scanner in, Map<CombinationType, List<Integer>> combinationToIndicesMap) {
        int indexToRequest;
        if (totalDecided % 2 == 0) {
            indexToRequest = totalDecided / 2;
        } else {
            indexToRequest = b - (totalDecided + 1) / 2;
        }
        System.out.println(indexToRequest + 1);
        int newVal = in.nextInt();
        bits.set(indexToRequest, newVal);

        if (totalDecided % 2 == 1) {
            int upperIndex = (totalDecided + 1) / 2;
            upperIndex--;
            int lowerIndex = b - upperIndex - 1;
            int val1 = bits.get(upperIndex);
            int val2 = bits.get(lowerIndex);

            CombinationType combinationType;
            if (val1 == 1 && val2 == 1) {
                combinationType = CombinationType.ONE_ONE;
            } else if (val1 == 0 && val2 == 0) {
                combinationType = CombinationType.ZERO_ZERO;
            } else if (val1 == 1 && val2 == 0) {
                combinationType = CombinationType.ONE_ZERO;
            } else {
                combinationType = CombinationType.ZERO_ONE;
            }

            List<Integer> indices = new ArrayList<>();
            indices.add(upperIndex);
            indices.add(lowerIndex);
            combinationToIndicesMap.put(combinationType, indices);
        }
    }

    private void reverse(List<Integer> bits) {
        Collections.reverse(bits);
    }

    private void compliment(List<Integer> bits) {
        for (int i = 0; i < bits.size(); i++) {
            if(bits.get(i) != -1) {
                bits.set(i, Math.abs(bits.get(i) - 1));
            }
        }
    }

    private String getStringFromBits(List<Integer> bits, int b) {
        StringBuilder builder = new StringBuilder(b);
        for (Integer bit : bits) {
            builder.append(bit);
        }
        return builder.toString();
    }

    private enum CombinationType {
        ONE_ONE,
        ZERO_ZERO,
        ONE_ZERO,
        ZERO_ONE;
    }

    private enum FluctuationType {
        REVERSE,
        COMPLIMENT,
        REVERSE_AND_COMPLIMENT,
        NOTHING;
    }
}
