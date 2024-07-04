import java.util.*;

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
                    int index = (known % 2 == 0) ? (known / 2) + 1 : b - (known / 2);
                    System.out.println(index);
                    array.set(index - 1, scanner.nextInt());
                    ++queries;
                    ++known;
                } else {
                    Map<List<Integer>, Integer> candidates = generateCandidates(array);
                    int possible = candidates.values().stream().mapToInt(v -> 1 << v).sum();

                    int checked = -1;
                    while (possible != 0b1000 && possible != 0b0100 && possible != 0b0010 && possible != 0b0001) {
                        int index = findFirstDiffIndex(candidates, possible, checked);
                        ++queries;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possible = updatePossible(candidates, index, bit, possible);
                        checked = index;
                    }

                    Map<Integer, List<Integer>> invertedMap = new HashMap<>();
                    for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
                        invertedMap.put(entry.getValue(), entry.getKey());
                    }

                    switch (possible) {
                        case 0b1000:
                            array = invertedMap.get(3);
                            break;
                        case 0b0100:
                            array = invertedMap.get(2);
                            break;
                        case 0b0010:
                            array = invertedMap.get(1);
                            break;
                        default:
                            array = invertedMap.get(0);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int n : array) {
                result.append(n);
            }
            System.out.println(result.toString());
            scanner.nextLine();
            scanner.next();
        }
    }

    private static int updatePossible(Map<List<Integer>, Integer> candidates, int index, int bit, int possible) {
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            List<Integer> array = entry.getKey();
            int i = entry.getValue();
            if (((possible >> i) & 1) == 1 && array.get(index) != bit) {
                possible -= 1 << i;
            }
        }
        return possible;
    }

    private static int findFirstDiffIndex(Map<List<Integer>, Integer> candidates, int possible, int checked) {
        List<List<Integer>> candidateArrays = new ArrayList<>(Collections.nCopies(candidates.size(), null));
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            candidateArrays.set(entry.getValue(), entry.getKey());
        }

        int index = checked + 1;
        while (true) {
            Set<Integer> valuesAtIndex = new HashSet<>();
            for (List<Integer> candidate : candidateArrays) {
                valuesAtIndex.add(candidate.get(index));
            }

            if (valuesAtIndex.size() > 1) return index;
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

        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; ++i) {
            map.put(candidates.get(i), i);
        }
        return map;
    }
}