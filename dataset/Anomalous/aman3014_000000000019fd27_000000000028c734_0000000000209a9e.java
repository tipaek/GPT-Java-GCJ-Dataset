import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            List<Integer> array = new ArrayList<>(Collections.nCopies(b, 0));
            System.out.println(1);
            array.set(0, scanner.nextInt());

            int known = 1;
            int queries = 1;

            while (known < b) {
                if (queries % 10 != 0) {
                    int index = known % 2 == 0 ? (known / 2) + 1 : b - (known / 2);
                    System.out.println(index);
                    array.set(index - 1, scanner.nextInt());
                    queries++;
                    known++;
                } else {
                    Map<List<Integer>, Integer> candidates = generateCandidates(array);
                    int possible = 0;

                    for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
                        possible += 1 << entry.getValue();
                    }

                    int index = b;
                    while (possible != 0b1000 && possible != 0b0100 && possible != 0b0010 && possible != 0b0001) {
                        index = findFirstDiffIndex(candidates, possible, index, b);
                        queries++;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possible = updatePossibleCandidates(candidates, index, bit, possible);
                    }

                    Map<Integer, List<Integer>> reversedCandidates = candidates.entrySet().stream()
                            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

                    switch (possible) {
                        case 0b1000:
                            array = reversedCandidates.get(3);
                            break;
                        case 0b0100:
                            array = reversedCandidates.get(2);
                            break;
                        case 0b0010:
                            array = reversedCandidates.get(1);
                            break;
                        default:
                            array = reversedCandidates.get(0);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int n : array) {
                result.append(n);
            }

            System.out.println(result);
            scanner.nextLine();
            scanner.next();
        }
    }

    private static int updatePossibleCandidates(Map<List<Integer>, Integer> candidates, int index, int bit, int possible) {
        for (Map.Entry<List<Integer>, Integer> entry : candidates.entrySet()) {
            int position = entry.getValue();
            if (((possible >> position) & 1) == 1 && !entry.getKey().get(index).equals(bit)) {
                possible -= 1 << position;
            }
        }
        return possible;
    }

    private static int findFirstDiffIndex(Map<List<Integer>, Integer> candidates, int possible, int checked, int b) {
        int index = getNextIndex(checked, b);
        while (true) {
            Set<Integer> possibleValues = new HashSet<>();
            for (List<Integer> array : candidates.keySet()) {
                possibleValues.add(array.get(index));
            }
            if (possibleValues.size() > 1) {
                return index;
            }
            index = getNextIndex(checked, b);
        }
    }

    private static int getNextIndex(int checked, int b) {
        return checked < b / 2 ? b - checked - 1 : b - checked;
    }

    private static Map<List<Integer>, Integer> generateCandidates(List<Integer> array) {
        int b = array.size();
        List<List<Integer>> candidates = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            candidates.add(new ArrayList<>());
        }

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