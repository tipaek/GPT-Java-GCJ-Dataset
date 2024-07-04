import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; ++i) {
            List<Integer> array = new ArrayList<>(Collections.nCopies(b, 0));
            System.out.println(1);
            array.set(0, scanner.nextInt());

            int known = 1, queries = 1;

            while (known < b) {
                if (queries % 10 != 0) {
                    int index = known % 2 == 0 ? (known / 2) + 1 : b - (known / 2);
                    System.out.println(index);
                    array.set(index - 1, scanner.nextInt());
                    ++queries;
                    ++known;
                } else {
                    Map<List<Integer>, Integer> candidates = generateCandidates(array);
                    int possible = 0;

                    for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
                        possible += 1 << entry.getValue();
                    }

                    int checked = -1;
                    while (!isSingleBitSet(possible)) {
                        int index = getFirstDiffIndex(candidates, possible, checked);
                        ++queries;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possible = updatePossibleCandidates(candidates, index, bit, possible);
                        ++checked;
                    }

                    Map<Integer, List<Integer>> inverseMap = candidates.entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

                    array = inverseMap.get(Integer.numberOfTrailingZeros(possible));
                }
            }

            System.out.println(array.stream().map(String::valueOf).collect(Collectors.joining()));
            scanner.next();
        }
    }

    private static boolean isSingleBitSet(int possible) {
        return (possible & (possible - 1)) == 0;
    }

    private static int updatePossibleCandidates(Map<List<Integer>, Integer> candidates, int index, int bit, int possible) {
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            List<Integer> array = entry.getKey();
            int i = entry.getValue();
            if (((possible >> i) & 1) == 1 && array.get(index) != bit) {
                possible -= 1 << i;
            }
        }
        return possible;
    }

    private static int getFirstDiffIndex(Map<List<Integer>, Integer> candidates, int possible, int checked) {
        List<List<Integer>> candidateLists = new ArrayList<>(Collections.nCopies(candidates.size(), new ArrayList<>()));

        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            candidateLists.set(entry.getValue(), entry.getKey());
        }

        int index = checked + 1;
        while (true) {
            Set<Integer> uniqueBits = candidateLists.stream()
                    .map(list -> list.get(index))
                    .collect(Collectors.toSet());

            if (uniqueBits.size() > 1) return index;
            ++index;
        }
    }

    private static Map<List<Integer>, Integer> generateCandidates(List<Integer> array) {
        int b = array.size();
        List<List<Integer>> candidates = Arrays.asList(
                new ArrayList<>(b),
                new ArrayList<>(b),
                new ArrayList<>(b),
                new ArrayList<>(b)
        );

        for (int i = 0; i < b; ++i) {
            candidates.get(0).add(1 - array.get(i));
            candidates.get(1).add(array.get(b - i - 1));
            candidates.get(2).add(1 - candidates.get(1).get(i));
            candidates.get(3).add(array.get(i));
        }

        Map<List<Integer>, Integer> candidateMap = new HashMap<>();
        for (int i = 0; i < candidates.size(); ++i) {
            candidateMap.put(candidates.get(i), i);
        }
        return candidateMap;
    }
}