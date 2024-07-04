import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<String> permutations = generatePermutations(n);

            List<List<String>> validPermutations = new ArrayList<>();
            for (List<String> perm : permutations) {
                if (calculateTrace(perm) == k) {
                    validPermutations.add(perm);
                }
            }

            System.out.print("Case #" + t + ": ");
            if (!validPermutations.isEmpty()) {
                System.out.println("POSSIBLE");
                List<String> solution = validPermutations.get(0);
                for (String row : solution) {
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
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        permute(nums, 0, permutations);
        return permutations;
    }

    private static void permute(int[] nums, int start, List<String> result) {
        if (start == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1, result);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int calculateTrace(List<String> matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.size(); i++) {
            trace += Character.getNumericValue(matrix.get(i).charAt(i));
        }
        return trace;
    }

    private static List<List<String>> permute(String[] array) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (String s : array) {
            List<List<String>> current = new ArrayList<>();
            for (List<String> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    List<String> temp = new ArrayList<>(list);
                    temp.add(j, s);
                    current.add(temp);
                }
            }
            result = current;
        }

        return result;
    }
}