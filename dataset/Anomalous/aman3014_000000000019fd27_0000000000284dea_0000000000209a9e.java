import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            ArrayList<Integer> bitsArray = new ArrayList<>();
            for (int j = 0; j < bitLength; j++) {
                bitsArray.add(0);
            }

            System.out.println(1);
            bitsArray.set(0, scanner.nextInt());

            int knownBits = 1, queryCount = 1;

            while (knownBits < bitLength) {
                if (queryCount % 10 != 0) {
                    int index = knownBits % 2 == 0 ? (knownBits / 2) + 1 : bitLength - (knownBits / 2);
                    System.out.println(index);
                    bitsArray.set(index - 1, scanner.nextInt());
                    queryCount++;
                    knownBits++;
                } else {
                    HashMap<ArrayList<Integer>, Integer> candidateMap = generateCandidates(bitsArray);
                    int possibleCombinations = 0;

                    for (Map.Entry<ArrayList<Integer>, Integer> entry : candidateMap.entrySet()) {
                        possibleCombinations += 1 << entry.getValue();
                    }

                    int index = 0;
                    while (possibleCombinations != 0b1000 && possibleCombinations != 0b0100 && possibleCombinations != 0b0010 && possibleCombinations != 0b0001) {
                        queryCount++;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possibleCombinations = updatePossibleCombinations(candidateMap, index, bit, possibleCombinations);
                        index++;
                    }

                    Map<Integer, ArrayList<Integer>> invertedMap = candidateMap.entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

                    switch (possibleCombinations) {
                        case 0b1000:
                            bitsArray = invertedMap.get(3);
                            break;
                        case 0b0100:
                            bitsArray = invertedMap.get(2);
                            break;
                        case 0b0010:
                            bitsArray = invertedMap.get(1);
                            break;
                        default:
                            bitsArray = invertedMap.get(0);
                    }
                }
            }

            for (int bit : bitsArray) {
                System.out.print(bit);
            }
            System.out.println();
        }
    }

    public static int updatePossibleCombinations(HashMap<ArrayList<Integer>, Integer> candidateMap, int index, int bit, int possibleCombinations) {
        for (Map.Entry<ArrayList<Integer>, Integer> entry : candidateMap.entrySet()) {
            ArrayList<Integer> array = entry.getKey();
            int candidateIndex = entry.getValue();
            if (((possibleCombinations >> candidateIndex) & 1) == 1 && array.get(index) != bit) {
                possibleCombinations -= 1 << candidateIndex;
            }
        }
        return possibleCombinations;
    }

    public static HashMap<ArrayList<Integer>, Integer> generateCandidates(ArrayList<Integer> array) {
        int length = array.size();

        ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            candidates.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            candidates.get(0).add(1 - array.get(i));
            candidates.get(1).add(array.get(length - i - 1));
            candidates.get(2).add(1 - candidates.get(1).get(i));
            candidates.get(3).add(array.get(i));
        }

        HashMap<ArrayList<Integer>, Integer> candidateMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            candidateMap.put(candidates.get(i), i);
        }

        return candidateMap;
    }
}