import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            List<String> permutations = generatePermutations(n);
            List<List<String>> validPermutations = filterPermutations(permutations, n, k);

            System.out.print("Case #" + testCase + ": ");
            if (!validPermutations.isEmpty()) {
                System.out.println("POSSIBLE");
                printPermutation(validPermutations.get(validPermutations.size() - 1), n);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static List<String> generatePermutations(int n) {
        List<String> permutations = new ArrayList<>();
        int p = n + 1;

        for (int i = 1; i <= n; i++) {
            List<Integer> tempList = new ArrayList<>();
            int temp = p;

            while (temp <= n) {
                tempList.add(temp++);
            }

            for (int j = 1; j < p; j++) {
                tempList.add(j);
            }

            p--;
            permutations.add(listToString(tempList));
        }

        return permutations;
    }

    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static List<List<String>> filterPermutations(List<String> permutations, int n, int k) {
        List<List<String>> allPermutations = permute(permutations.toArray(new String[0]));
        List<List<String>> validPermutations = new ArrayList<>();

        for (List<String> perm : allPermutations) {
            if (calculateTrace(perm, n) == k) {
                if (isSortedDescending(perm)) {
                    validPermutations.add(new ArrayList<>(perm));
                }
            }
        }

        return validPermutations;
    }

    private static int calculateTrace(List<String> perm, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += Character.getNumericValue(perm.get(i).charAt(i));
        }
        return trace;
    }

    private static boolean isSortedDescending(List<String> perm) {
        List<Integer> originalList = new ArrayList<>();
        for (String s : perm) {
            for (char c : s.toCharArray()) {
                originalList.add(Character.getNumericValue(c));
            }
        }

        List<Integer> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList, Collections.reverseOrder());

        return originalList.equals(sortedList);
    }

    private static void printPermutation(List<String> perm, int n) {
        for (int i = perm.size() - 1; i >= 0; i--) {
            String row = perm.get(i);
            for (int j = n - 1; j >= 0; j--) {
                System.out.print(row.charAt(j) + (j == 0 ? "\n" : " "));
            }
        }
    }

    public static List<List<String>> permute(String[] array) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (String s : array) {
            List<List<String>> current = new ArrayList<>();
            for (List<String> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    l.add(j, s);
                    current.add(new ArrayList<>(l));
                    l.remove(j);
                }
            }
            result = current;
        }

        return result;
    }
}