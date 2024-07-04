import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= numberOfTestCases; i++) {
            String[] input = br.readLine().split(" ");
            int size = Integer.parseInt(input[0]);
            int targetSum = Integer.parseInt(input[1]);

            matrix = new int[size][size];
            constructMatrix(size);

            int[] sequence = new int[size];
            for (int j = 0; j < size; j++) {
                sequence[j] = j + 1;
            }

            ArrayList<Integer> permutations = new ArrayList<>();
            generatePermutations(sequence, 0, permutations);

            boolean found = false;
            for (int perm : permutations) {
                String permStr = Integer.toString(perm);
                int sum = 0;
                for (int k = 0; k < permStr.length(); k++) {
                    int index = Character.getNumericValue(permStr.charAt(k)) - 1;
                    sum += matrix[index][k];
                }
                if (sum == targetSum) {
                    found = true;
                    System.out.println("Case #" + i + ": POSSIBLE");
                    for (char ch : permStr.toCharArray()) {
                        int index = Character.getNumericValue(ch) - 1;
                        for (int j = 0; j < size; j++) {
                            System.out.print(matrix[index][j]);
                            if (j < size - 1) {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    static void fillRemaining(int i, int j, int n) {
        int x = 2;
        for (int k = i + 1; k < n; k++) {
            matrix[k][j] = x++;
        }
        for (int k = 0; k < i; k++) {
            matrix[k][j] = x++;
        }
    }

    static void constructMatrix(int n) {
        int right = n - 1, left = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                matrix[i][right] = 1;
                fillRemaining(i, right, n);
                right--;
            } else {
                matrix[i][left] = 1;
                fillRemaining(i, left, n);
                left++;
            }
        }
    }

    static void generatePermutations(int[] array, int k, ArrayList<Integer> list) {
        if (k == array.length) {
            StringBuilder sb = new StringBuilder();
            for (int value : array) {
                sb.append(value);
            }
            list.add(Integer.parseInt(sb.toString()));
        } else {
            for (int i = k; i < array.length; i++) {
                swap(array, k, i);
                generatePermutations(array, k + 1, list);
                swap(array, k, i);
            }
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}