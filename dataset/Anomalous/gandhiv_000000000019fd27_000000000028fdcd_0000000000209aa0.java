import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            List<Integer> sequence = generateSequence(n);
            List<String> permutations = generatePermutations(sequence, n);

            List<List<String>> validPermutations = filterPermutations(permutations, k, n);

            System.out.print("Case #" + testCase + ": ");
            if (!validPermutations.isEmpty()) {
                System.out.println("POSSIBLE");
                printPermutation(validPermutations.get(0), n);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static List<Integer> generateSequence(int n) {
        List<Integer> sequence = new ArrayList<>();
        int p = n + 1;

        for (int i = 1; i <= n; i++) {
            for (int temp = p; temp <= n; temp++) {
                sequence.add(temp);
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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sequence.size(); i++) {
            sb.append(sequence.get(i));
            if ((i + 1) % n == 0) {
                permutations.add(sb.toString());
                sb.setLength(0);
            }
        }

        return permutations;
    }

    private static List<List<String>> filterPermutations(List<String> permutations, int k, int n) {
        List<List<String>> validPermutations = new ArrayList<>();
        List<List<String>> allPermutations = permute(permutations.toArray(new String[0]));

        for (List<String> perm : allPermutations) {
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += Character.getNumericValue(perm.get(i).charAt(i));
            }

            if (trace == k) {
                validPermutations.add(new ArrayList<>(perm));
            }
        }

        List<List<String>> finalValidPermutations = new ArrayList<>();
        for (List<String> perm : validPermutations) {
            List<Integer> original = new ArrayList<>();
            List<Integer> sorted = new ArrayList<>();

            for (String s : perm) {
                for (int i = 0; i < n; i++) {
                    original.add(Character.getNumericValue(s.charAt(i)));
                }
            }

            sorted.addAll(original);
            Collections.sort(sorted, Collections.reverseOrder());

            if (original.equals(sorted)) {
                finalValidPermutations.add(perm);
            }
        }

        return finalValidPermutations;
    }

    private static void printPermutation(List<String> permutation, int n) {
        for (String row : permutation) {
            for (int i = 0; i < n; i++) {
                System.out.print(row.charAt(i));
                if (i < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static List<List<String>> permute(String[] array) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (String s : array) {
            List<List<String>> current = new ArrayList<>();

            for (List<String> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    List<String> temp = new ArrayList<>(l);
                    temp.add(j, s);
                    current.add(temp);
                }
            }

            result = current;
        }

        return result;
    }
}