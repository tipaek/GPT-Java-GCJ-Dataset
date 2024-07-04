import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            List<Integer> array = new ArrayList<>(Collections.nCopies(arraySize, 0));
            System.out.println(1);
            array.set(0, scanner.nextInt());

            int knownBits = 1;
            int queryCount = 1;

            while (knownBits < arraySize) {
                if (queryCount % 10 != 0) {
                    int index = (knownBits % 2 == 0) ? (knownBits / 2) + 1 : arraySize - (knownBits / 2);
                    System.out.println(index);
                    array.set(index - 1, scanner.nextInt());
                    queryCount++;
                    knownBits++;
                } else {
                    Map<List<Integer>, Integer> candidates = generateCandidates(array);
                    int possibleStates = 0;

                    for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
                        possibleStates += 1 << entry.getValue();
                    }

                    int checkedIndex = -1;
                    while (possibleStates != 0b1000 && possibleStates != 0b0100 && possibleStates != 0b0010 && possibleStates != 0b0001) {
                        int diffIndex = findFirstDiffIndex(candidates, possibleStates, checkedIndex, arraySize);
                        queryCount++;
                        System.out.println(diffIndex + 1);
                        int bit = scanner.nextInt();
                        possibleStates = updatePossibleStates(candidates, diffIndex, bit, possibleStates);
                        checkedIndex = diffIndex;
                    }

                    Map<Integer, List<Integer>> invertedCandidates = candidates.entrySet()
                            .stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

                    switch (possibleStates) {
                        case 0b1000:
                            array = invertedCandidates.get(3);
                            break;
                        case 0b0100:
                            array = invertedCandidates.get(2);
                            break;
                        case 0b0010:
                            array = invertedCandidates.get(1);
                            break;
                        default:
                            array = invertedCandidates.get(0);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int bit : array) {
                result.append(bit);
            }

            System.out.println(result);
            scanner.nextLine();
            scanner.next();
        }
    }

    private static int updatePossibleStates(Map<List<Integer>, Integer> candidates, int index, int bit, int possibleStates) {
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            List<Integer> array = entry.getKey();
            int candidateIndex = entry.getValue();

            if (((possibleStates >> candidateIndex) & 1) == 1 && array.get(index) != bit) {
                possibleStates -= 1 << candidateIndex;
            }
        }

        return possibleStates;
    }

    private static int findFirstDiffIndex(Map<List<Integer>, Integer> candidates, int possibleStates, int checkedIndex, int arraySize) {
        List<List<Integer>> candidateArrays = new ArrayList<>(Collections.nCopies(candidates.size(), new ArrayList<>()));
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            candidateArrays.set(entry.getValue(), entry.getKey());
        }

        int index = getNextIndex(checkedIndex, arraySize);
        while (true) {
            Set<Integer> possibleValues = new HashSet<>();
            for (List<Integer> candidateArray : candidateArrays) {
                possibleValues.add(candidateArray.get(index));
            }

            if (possibleValues.size() > 1) return index;
            index = getNextIndex(checkedIndex, arraySize);
        }
    }

    private static int getNextIndex(int checkedIndex, int size) {
        return (checkedIndex < size / 2) ? size - checkedIndex - 1 : size - checkedIndex;
    }

    private static Map<List<Integer>, Integer> generateCandidates(List<Integer> array) {
        int size = array.size();
        List<List<Integer>> candidateArrays = new ArrayList<>(Collections.nCopies(4, new ArrayList<>()));

        for (int i = 0; i < 4; i++) {
            candidateArrays.set(i, new ArrayList<>(Collections.nCopies(size, 0)));
        }

        for (int i = 0; i < size; i++) {
            candidateArrays.get(0).set(i, 1 - array.get(i));
            candidateArrays.get(1).set(i, array.get(size - i - 1));
            candidateArrays.get(2).set(i, 1 - candidateArrays.get(1).get(i));
            candidateArrays.get(3).set(i, array.get(i));
        }

        Map<List<Integer>, Integer> candidateMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            candidateMap.put(candidateArrays.get(i), i);
        }

        return candidateMap;
    }
}