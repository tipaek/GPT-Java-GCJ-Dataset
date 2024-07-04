import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bits = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            List<Integer> bitArray = new ArrayList<>(Collections.nCopies(bits, 0));
            System.out.println(1);
            bitArray.set(0, scanner.nextInt());

            int knownBits = 1;
            int queries = 1;

            while (knownBits < bits) {
                if (queries % 10 != 0) {
                    int index = (knownBits % 2 == 0) ? (knownBits / 2) + 1 : bits - (knownBits / 2);
                    System.out.println(index);
                    bitArray.set(index - 1, scanner.nextInt());
                    queries++;
                    knownBits++;
                } else {
                    Map<List<Integer>, Integer> candidates = generateCandidates(bitArray);
                    int possible = 0;

                    for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
                        possible += 1 << entry.getValue();
                    }

                    int checked = bits;
                    while (possible != 0b1000 && possible != 0b0100 && possible != 0b0010 && possible != 0b0001) {
                        int index = findFirstDifferentIndex(candidates, possible, checked, bits);
                        queries++;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possible = updatePossibleCandidates(candidates, index, bit, possible);
                        checked = index;
                    }

                    Map<Integer, List<Integer>> invertedMap = candidates.entrySet()
                            .stream()
                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

                    bitArray = invertedMap.get(Integer.numberOfTrailingZeros(possible));
                }
            }

            StringBuilder result = new StringBuilder();
            for (int bit : bitArray) {
                result.append(bit);
            }

            System.out.println(result.toString());
            scanner.nextLine();
            scanner.next();
        }
    }

    private static int updatePossibleCandidates(Map<List<Integer>, Integer> candidates, int index, int bit, int possible) {
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            List<Integer> array = entry.getKey();
            int candidateIndex = entry.getValue();

            if (((possible >> candidateIndex) & 1) == 1 && array.get(index) != bit) {
                possible -= 1 << candidateIndex;
            }
        }
        return possible;
    }

    private static int findFirstDifferentIndex(Map<List<Integer>, Integer> candidates, int possible, int checked, int bits) {
        List<List<Integer>> candidateLists = new ArrayList<>(Collections.nCopies(candidates.size(), new ArrayList<>()));

        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            candidateLists.set(entry.getValue(), entry.getKey());
        }

        int index = getNextIndex(checked, bits);
        while (true) {
            Set<Integer> uniqueBits = new HashSet<>();
            for (List<Integer> candidate : candidateLists) {
                uniqueBits.add(candidate.get(index));
            }

            if (uniqueBits.size() > 1) return index;
            index = getNextIndex(checked, bits);
        }
    }

    private static int getNextIndex(int checked, int bits) {
        return (checked < bits / 2) ? bits - checked - 1 : bits - checked;
    }

    private static Map<List<Integer>, Integer> generateCandidates(List<Integer> array) {
        int bits = array.size();
        List<List<Integer>> candidateLists = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Collections.nCopies(bits, 0)),
                new ArrayList<>(Collections.nCopies(bits, 0)),
                new ArrayList<>(Collections.nCopies(bits, 0)),
                new ArrayList<>(Collections.nCopies(bits, 0))
        ));

        for (int i = 0; i < bits; i++) {
            candidateLists.get(0).set(i, 1 - array.get(i));
            candidateLists.get(1).set(i, array.get(bits - i - 1));
            candidateLists.get(2).set(i, 1 - candidateLists.get(1).get(i));
            candidateLists.get(3).set(i, array.get(i));
        }

        Map<List<Integer>, Integer> candidateMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            candidateMap.put(candidateLists.get(i), i);
        }

        return candidateMap;
    }
}