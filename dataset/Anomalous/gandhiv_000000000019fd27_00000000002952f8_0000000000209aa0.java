import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<String> permutations = generatePermutations(n);

            List<List<String>> validPermutations = new ArrayList<>();
            for (String permutation : permutations) {
                if (calculateTrace(permutation, n) == k) {
                    validPermutations.add(Arrays.asList(permutation.split("")));
                }
            }

            List<List<String>> sortedValidPermutations = new ArrayList<>();
            for (List<String> permutation : validPermutations) {
                if (isSortedDescending(permutation)) {
                    sortedValidPermutations.add(permutation);
                }
            }

            System.out.print("Case #" + testCase + ": ");
            if (!sortedValidPermutations.isEmpty()) {
                System.out.println("POSSIBLE");
                List<String> result = sortedValidPermutations.get(sortedValidPermutations.size() - 1);
                for (int i = result.size() - 1; i >= 0; i--) {
                    System.out.print(result.get(i) + (i == 0 ? "\n" : " "));
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static List<String> generatePermutations(int n) {
        List<String> result = new ArrayList<>();
        permute("", n, result);
        return result;
    }

    private static void permute(String prefix, int n, List<String> result) {
        if (prefix.length() == n) {
            result.add(prefix);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!prefix.contains(String.valueOf(i))) {
                permute(prefix + i, n, result);
            }
        }
    }

    private static int calculateTrace(String permutation, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += Character.getNumericValue(permutation.charAt(i));
        }
        return trace;
    }

    private static boolean isSortedDescending(List<String> permutation) {
        List<Integer> original = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        for (String s : permutation) {
            int value = Integer.parseInt(s);
            original.add(value);
            sorted.add(value);
        }
        Collections.sort(sorted, Collections.reverseOrder());
        return original.equals(sorted);
    }
}