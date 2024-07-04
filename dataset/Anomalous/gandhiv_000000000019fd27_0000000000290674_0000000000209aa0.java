import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<String> permutations = generatePermutations(n);
            List<List<String>> validPermutations = filterValidPermutations(permutations, n, k);

            System.out.print("Case #" + testCase + ": ");
            if (!validPermutations.isEmpty()) {
                System.out.println("POSSIBLE");
                List<String> result = validPermutations.get(validPermutations.size() - 1);
                for (String row : result) {
                    for (int i = 0; i < n; i++) {
                        System.out.print(row.charAt(i) + (i == n - 1 ? "\n" : " "));
                    }
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static List<String> generatePermutations(int n) {
        List<String> permutations = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            s.append(i);
        }
        permute(s.toString(), 0, n - 1, permutations);
        return permutations;
    }

    private static void permute(String str, int l, int r, List<String> permutations) {
        if (l == r) {
            permutations.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r, permutations);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    private static List<List<String>> filterValidPermutations(List<String> permutations, int n, int k) {
        List<List<String>> validPermutations = new ArrayList<>();
        for (String perm : permutations) {
            List<String> permList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                permList.add(perm.substring(i * n, (i + 1) * n));
            }
            if (isValidPermutation(permList, k)) {
                validPermutations.add(permList);
            }
        }
        return validPermutations;
    }

    private static boolean isValidPermutation(List<String> permList, int k) {
        int trace = 0;
        for (int i = 0; i < permList.size(); i++) {
            trace += Character.getNumericValue(permList.get(i).charAt(i));
        }
        return trace == k;
    }
}