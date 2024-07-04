import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();
            for (ArrayList<Integer> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    list.add(j, num);
                    current.add(new ArrayList<>(list));
                    list.remove(j);
                }
            }
            result = current;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int ts = 1; ts <= t; ts++) {
            int n = scanner.nextInt();
            int reqSum = scanner.nextInt();

            int[] generateArr = new int[n];
            for (int i = 0; i < n; i++) {
                generateArr[i] = i + 1;
            }

            ArrayList<ArrayList<Integer>> permutations = permute(generateArr);
            int[][] generateMat = new int[permutations.size()][n];

            for (int i = 0; i < permutations.size(); i++) {
                for (int j = 0; j < n; j++) {
                    generateMat[i][j] = permutations.get(i).get(j);
                }
            }

            boolean found = false;

            for (int g = 0; g < permutations.size(); g++) {
                int[][] arr = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        arr[i][j] = generateMat[(i + j) % n][g];
                    }
                }

                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += arr[i][i];
                }

                if (sum == reqSum) {
                    System.out.println("Case #" + ts + ": POSSIBLE");
                    for (int[] row : arr) {
                        for (int val : row) {
                            System.out.print(val + " ");
                        }
                        System.out.println();
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Case #" + ts + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }
}