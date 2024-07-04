import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] array = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();

            boolean found = false;

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextLong();
                frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);

                if (frequencyMap.get(array[i]) >= d) {
                    System.out.println("Case #" + caseNumber + ": 0");
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (d == 2) {
                    System.out.println("Case #" + caseNumber + ": 1");
                } else {
                    Arrays.sort(array);
                    for (int i = 0; i < n; i++) {
                        if (found) break;

                        if ((frequencyMap.get(array[i]) == 2 && i != n - 1 && array[i] != array[n - 1]) ||
                            frequencyMap.containsKey(array[i] / 2)) {
                            System.out.println("Case #" + caseNumber + ": 1");
                            found = true;
                            break;
                        }

                        for (int j = 0; j < n; j++) {
                            if (array[j] == array[i] * 2) {
                                System.out.println("Case #" + caseNumber + ": 1");
                                found = true;
                                break;
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Case #" + caseNumber + ": 2");
                    }
                }
            }
        }
    }
}