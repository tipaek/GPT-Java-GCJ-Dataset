import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            ArrayList<Integer> bitArray = new ArrayList<>();
            for (int i = 0; i < bitLength; i++) {
                bitArray.add(0);
            }

            System.out.println(1);
            bitArray.set(0, scanner.nextInt());

            int knownBits = 1, queryCount = 1;

            while (knownBits < bitLength) {
                if (queryCount % 10 != 0) {
                    int index = knownBits % 2 == 0 ? (knownBits / 2) + 1 : bitLength - (knownBits / 2);
                    System.out.println(index);
                    bitArray.set(index - 1, scanner.nextInt());
                    queryCount++;
                    knownBits++;
                } else {
                    HashMap<ArrayList<Integer>, Integer> candidateMap = generateCandidates(bitArray);
                    int possibleCombinations = 0;

                    for (Map.Entry<ArrayList<Integer>, Integer> entry : candidateMap.entrySet()) {
                        possibleCombinations += 1 << entry.getValue();
                    }

                    int index = bitLength;
                    while (possibleCombinations != 0b1000 && possibleCombinations != 0b0100 && possibleCombinations != 0b0010 && possibleCombinations != 0b0001) {
                        index = findFirstDiffIndex(candidateMap, possibleCombinations, index, bitLength);
                        queryCount++;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possibleCombinations = updatePossibleCombinations(candidateMap, index, bit, possibleCombinations);
                    }

                    Map<Integer, ArrayList<Integer>> reversedMap = candidateMap.entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

                    switch (possibleCombinations) {
                        case 0b1000:
                            bitArray = reversedMap.get(3);
                            break;
                        case 0b0100:
                            bitArray = reversedMap.get(2);
                            break;
                        case 0b0010:
                            bitArray = reversedMap.get(1);
                            break;
                        default:
                            bitArray = reversedMap.get(0);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int bit : bitArray) {
                result.append(bit);
            }
            System.out.println(result);
            scanner.nextLine();
            scanner.next();
        }
    }

    private static int updatePossibleCombinations(HashMap<ArrayList<Integer>, Integer> candidateMap, int index, int bit, int possibleCombinations) {
        for (Map.Entry<ArrayList<Integer>, Integer> entry : candidateMap.entrySet()) {
            ArrayList<Integer> array = entry.getKey();
            int combinationIndex = entry.getValue();

            if (((possibleCombinations >> combinationIndex) & 1) == 1 && array.get(index) != bit) {
                possibleCombinations -= 1 << combinationIndex;
            }
        }
        return possibleCombinations;
    }

    private static int findFirstDiffIndex(HashMap<ArrayList<Integer>, Integer> candidateMap, int possibleCombinations, int checkedIndex, int bitLength) {
        ArrayList<ArrayList<Integer>> candidateArrays = new ArrayList<>(candidateMap.keySet());

        int index = getNextIndex(checkedIndex, bitLength);
        while (true) {
            HashSet<Integer> possibleValues = new HashSet<>();
            for (ArrayList<Integer> array : candidateArrays) {
                possibleValues.add(array.get(index));
            }

            if (possibleValues.size() > 1) {
                return index;
            }
            index = getNextIndex(checkedIndex, bitLength);
        }
    }

    private static int getNextIndex(int checkedIndex, int bitLength) {
        return checkedIndex < bitLength / 2 ? bitLength - checkedIndex - 1 : bitLength - checkedIndex;
    }

    private static HashMap<ArrayList<Integer>, Integer> generateCandidates(ArrayList<Integer> array) {
        int bitLength = array.size();
        ArrayList<ArrayList<Integer>> candidateArrays = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            candidateArrays.add(new ArrayList<>());
        }

        for (int i = 0; i < bitLength; i++) {
            candidateArrays.get(0).add(1 - array.get(i));
            candidateArrays.get(1).add(array.get(bitLength - i - 1));
            candidateArrays.get(2).add(1 - candidateArrays.get(1).get(i));
            candidateArrays.get(3).add(array.get(i));
        }

        HashMap<ArrayList<Integer>, Integer> candidateMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            candidateMap.put(candidateArrays.get(i), i);
        }
        return candidateMap;
    }
}