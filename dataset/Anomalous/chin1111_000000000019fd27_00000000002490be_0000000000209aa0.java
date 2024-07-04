import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine().trim());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String[] input = reader.readLine().split(" ");
            int dimension = Integer.parseInt(input[0]);
            int requiredSum = Integer.parseInt(input[1]);

            matrix = new int[dimension][dimension];
            constructMatrix(dimension);

            int[] sequence = new int[dimension];
            for (int i = 0; i < dimension; i++) {
                sequence[i] = i + 1;
            }

            ArrayList<Integer> permutations = new ArrayList<>();
            generatePermutations(sequence, 0, permutations);

            int validPermutationIndex = -1;
            for (int i = 0; i < permutations.size(); i++) {
                int permutation = permutations.get(i);
                String permutationStr = String.valueOf(permutation);
                int sum = 0;
                for (int j = 0; j < permutationStr.length(); j++) {
                    int index = Character.getNumericValue(permutationStr.charAt(j));
                    sum += matrix[index - 1][j];
                }
                if (sum == requiredSum) {
                    validPermutationIndex = i;
                    break;
                }
            }

            if (validPermutationIndex == -1) {
                System.out.print("Case #" + testCase + ": IMPOSSIBLE");
                if (testCase < numberOfTestCases) {
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                String validPermutationStr = String.valueOf(permutations.get(validPermutationIndex));
                for (int i = 0; i < validPermutationStr.length(); i++) {
                    int index = Character.getNumericValue(validPermutationStr.charAt(i));
                    for (int j = 0; j < dimension; j++) {
                        System.out.print(matrix[index - 1][j]);
                        if (j < dimension - 1) {
                            System.out.print(" ");
                        }
                    }
                    if (testCase < numberOfTestCases || i < validPermutationStr.length() - 1) {
                        System.out.println();
                    }
                }
            }
        }
    }

    static void fillRemaining(int row, int col, int size) {
        int value = 2;
        for (int i = row + 1; i < size; i++) {
            matrix[i][col] = value++;
        }
        for (int i = 0; i < row; i++) {
            matrix[i][col] = value++;
        }
    }

    static void constructMatrix(int size) {
        int right = size - 1, left = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                matrix[i][right] = 1;
                fillRemaining(i, right, size);
                right--;
            } else {
                matrix[i][left] = 1;
                fillRemaining(i, left, size);
                left++;
            }
        }
    }

    static void generatePermutations(int[] array, int start, ArrayList<Integer> permutations) {
        if (start == array.length) {
            StringBuilder temp = new StringBuilder();
            for (int value : array) {
                temp.append(value);
            }
            permutations.add(Integer.parseInt(temp.toString()));
        } else {
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                generatePermutations(array, start + 1, permutations);
                swap(array, start, i);
            }
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}