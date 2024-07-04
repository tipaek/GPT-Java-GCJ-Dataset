import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            List<Integer> array = new ArrayList<>(Collections.nCopies(b, 0));
            System.out.println(1);
            array.set(0, scanner.nextInt());

            int knownBits = 1;
            int queries = 1;

            while (knownBits < b) {
                if (queries % 10 != 0) {
                    int index = (knownBits % 2 == 0) ? (knownBits / 2) + 1 : b - (knownBits / 2);
                    System.out.println(index);
                    array.set(index - 1, scanner.nextInt());
                    queries++;
                    knownBits++;
                } else {
                    Map<List<Integer>, Integer> candidatesMap = generateCandidates(array);
                    int possible = candidatesMap.values().stream().mapToInt(v -> 1 << v).sum();

                    while (possible != 0b1000 && possible != 0b0100 && possible != 0b0010 && possible != 0b0001) {
                        int index = findFirstDiffIndex(candidatesMap, possible);
                        queries++;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possible = updatePossibleCandidates(candidatesMap, index, bit, possible);
                    }

                    array = candidatesMap.entrySet().stream()
                            .filter(entry -> (1 << entry.getValue()) == possible)
                            .findFirst()
                            .map(Map.Entry::getKey)
                            .orElse(array);
                }
            }

            System.out.println(array.stream().map(String::valueOf).collect(Collectors.joining()));
            scanner.nextLine();
            scanner.next();
        }
    }

    private static int updatePossibleCandidates(Map<List<Integer>, Integer> candidates, int index, int bit, int possible) {
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            if (((possible >> entry.getValue()) & 1) == 1 && !entry.getKey().get(index).equals(bit)) {
                possible -= 1 << entry.getValue();
            }
        }
        return possible;
    }

    private static int findFirstDiffIndex(Map<List<Integer>, Integer> candidates, int possible) {
        List<List<Integer>> candidateLists = new ArrayList<>(Collections.nCopies(4, new ArrayList<>()));
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            candidateLists.set(entry.getValue(), entry.getKey());
        }

        int index = 0;
        while (true) {
            Set<Integer> uniqueBits = new HashSet<>();
            for (List<Integer> candidate : candidateLists) {
                uniqueBits.add(candidate.get(index));
            }
            if (uniqueBits.size() > 1) return index;
            index++;
        }
    }

    private static Map<List<Integer>, Integer> generateCandidates(List<Integer> array) {
        int b = array.size();
        List<List<Integer>> candidates = Arrays.asList(
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );

        for (int i = 0; i < b; i++) {
            candidates.get(0).add(1 - array.get(i));
            candidates.get(1).add(array.get(b - i - 1));
            candidates.get(2).add(1 - candidates.get(1).get(i));
            candidates.get(3).add(array.get(i));
        }

        Map<List<Integer>, Integer> candidateMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            candidateMap.put(candidates.get(i), i);
        }
        return candidateMap;
    }
}