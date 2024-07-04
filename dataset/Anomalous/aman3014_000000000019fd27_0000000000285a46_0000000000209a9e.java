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

        for (int t = 0; t < testCases; t++) {
            ArrayList<Integer> bitArray = new ArrayList<>();
            for (int j = 0; j < bitLength; j++) {
                bitArray.add(0);
            }

            System.out.println(1);
            bitArray.set(0, scanner.nextInt());

            int knownBits = 1;
            int queryCount = 1;

            while (knownBits < bitLength) {
                if (queryCount % 10 != 0) {
                    int index = (knownBits % 2 == 0) ? (knownBits / 2) + 1 : bitLength - (knownBits / 2);
                    System.out.println(index);
                    bitArray.set(index - 1, scanner.nextInt());
                    queryCount++;
                    knownBits++;
                } else {
                    HashMap<ArrayList<Integer>, Integer> possibleCandidates = generateCandidates(bitArray);
                    int possibleStates = 0;

                    for (Map.Entry<ArrayList<Integer>, Integer> entry : possibleCandidates.entrySet()) {
                        possibleStates += 1 << entry.getValue();
                    }

                    int index = 0;
                    while (possibleStates != 0b1000 && possibleStates != 0b0100 && possibleStates != 0b0010 && possibleStates != 0b0001) {
                        queryCount++;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possibleStates = updatePossibleStates(possibleCandidates, index, bit, possibleStates);
                        index++;
                    }

                    Map<Integer, ArrayList<Integer>> reversedMap = possibleCandidates.entrySet()
                            .stream()
                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

                    switch (possibleStates) {
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

    public static int updatePossibleStates(HashMap<ArrayList<Integer>, Integer> candidates, int index, int bit, int possibleStates) {
        for (Map.Entry<ArrayList<Integer>, Integer> entry : candidates.entrySet()) {
            ArrayList<Integer> candidateArray = entry.getKey();
            int candidateIndex = entry.getValue();
            if (((possibleStates >> candidateIndex) & 1) == 1 && candidateArray.get(index) != bit) {
                possibleStates -= 1 << candidateIndex;
            }
        }
        return possibleStates;
    }

    public static HashMap<ArrayList<Integer>, Integer> generateCandidates(ArrayList<Integer> array) {
        int length = array.size();
        ArrayList<ArrayList<Integer>> candidateArrays = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            candidateArrays.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            candidateArrays.get(0).add(1 - array.get(i));
            candidateArrays.get(1).add(array.get(length - i - 1));
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