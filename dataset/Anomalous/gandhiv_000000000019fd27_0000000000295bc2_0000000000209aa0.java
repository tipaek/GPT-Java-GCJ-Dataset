import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> sequence = generateSequence(n);

            List<String> permutations = generatePermutations(sequence, n);
            List<List<String>> validPermutations = filterPermutations(permutations, n, k);

            System.out.print("Case #" + caseNum + ": ");
            if (!validPermutations.isEmpty()) {
                System.out.println("POSSIBLE");
                printResult(validPermutations.get(validPermutations.size() - 1), n);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static List<Integer> generateSequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        int p = n + 1;

        for (int i = 1; i <= n; i++) {
            int temp = p;
            while (temp <= n) {
                sequence.add(temp);
                temp++;
            }
            for (int j = 1; j < p; j++) {
                sequence.add(j);
            }
            p--;
        }

        return sequence;
    }

    private static List<String> generatePermutations(List<Integer> sequence, int n) {
        List<String> permutations = new ArrayList<>();
        String s = "";
        int count = 1;

        for (int num : sequence) {
            s += num;
            if (count % n == 0) {
                permutations.add(s);
                s = "";
            }
            count++;
        }

        return permutations;
    }

    private static List<List<String>> filterPermutations(List<String> permutations, int n, int k) {
        List<List<String>> validPermutations = new ArrayList<>();
        List<List<String>> allPermutations = permute(permutations.toArray(new String[0]));

        for (List<String> perm : allPermutations) {
            if (calculateTrace(perm) == k) {
                validPermutations.add(new ArrayList<>(perm));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> perm : validPermutations) {
            if (isValidPermutation(perm)) {
                result.add(new ArrayList<>(perm));
            }
        }

        return result;
    }

    private static int calculateTrace(List<String> perm) {
        int trace = 0;
        for (int i = 0; i < perm.size(); i++) {
            trace += Character.getNumericValue(perm.get(i).charAt(i));
        }
        return trace;
    }

    private static boolean isValidPermutation(List<String> perm) {
        List<Integer> original = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        for (String s : perm) {
            for (char c : s.toCharArray()) {
                original.add(Character.getNumericValue(c));
            }
        }

        sorted.addAll(original);
        Collections.sort(sorted, Collections.reverseOrder());

        return original.equals(sorted);
    }

    private static void printResult(List<String> result, int n) {
        for (int j = result.size() - 1; j >= 0; j--) {
            String row = result.get(j);
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(Character.getNumericValue(row.charAt(i)) + (i == 0 ? "\n" : " "));
            }
        }
    }

    public static ArrayList<ArrayList<String>> permute(String[] num) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (String s : num) {
            ArrayList<ArrayList<String>> current = new ArrayList<>();
            for (ArrayList<String> l : result) {
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