import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; ++i) {
            ArrayList<Integer> array = new ArrayList<>();
            for (int j = 0; j < b; ++j) {
                array.add(0);
            }

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
                    HashMap<ArrayList<Integer>, Integer> candidates = generateCandidates(array);
                    int possible = 0;

                    for (Map.Entry<ArrayList<Integer>, Integer> entry : candidates.entrySet()) {
                        possible += 1 << entry.getValue();
                    }

                    int index = 0;
                    while (possible != 0b1000 && possible != 0b0100 && possible != 0b0010 && possible != 0b0001) {
                        ++queries;
                        System.out.println(index + 1);
                        int bit = scanner.nextInt();
                        possible = updatePossible(candidates, index, bit, possible);
                        ++index;
                    }

                    Map<Integer, ArrayList<Integer>> invertedMap = 
                            candidates.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

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
            System.out.println(result);
        }
    }

    public static int updatePossible(HashMap<ArrayList<Integer>, Integer> candidates, int index, int bit, int possible) {
        for (Map.Entry<ArrayList<Integer>, Integer> entry : candidates.entrySet()) {
            ArrayList<Integer> array = entry.getKey();
            int i = entry.getValue();
            if (((possible >> i) & 1) == 1 && array.get(index) != bit) {
                possible -= 1 << i;
            }
        }
        return possible;
    }

    public static HashMap<ArrayList<Integer>, Integer> generateCandidates(ArrayList<Integer> array) {
        int b = array.size();
        ArrayList<ArrayList<Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            candidates.add(new ArrayList<>());
        }

        for (int i = 0; i < b; ++i) {
            candidates.get(0).add(1 - array.get(i));
            candidates.get(1).add(array.get(b - i - 1));
            candidates.get(2).add(1 - candidates.get(1).get(i));
            candidates.get(3).add(array.get(i));
        }

        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; ++i) {
            map.put(candidates.get(i), i);
        }

        return map;
    }
}