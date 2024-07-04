import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static int[][] mat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= numberOfTestCases; i++) {
            String[] input = br.readLine().split(" ");
            int numberOfRandC = Integer.parseInt(input[0]);
            int sumRequired = Integer.parseInt(input[1]);

            mat = new int[numberOfRandC][numberOfRandC];
            constructMatrix(numberOfRandC);

            int[] sequence = new int[numberOfRandC];
            for (int j = 0; j < numberOfRandC; j++) {
                sequence[j] = j + 1;
            }

            ArrayList<Integer> permutations = new ArrayList<>();
            generatePermutations(sequence, 0, permutations);

            int validPermutationIndex = findValidPermutation(permutations, sumRequired, numberOfRandC);
            printResult(i, validPermutationIndex, numberOfTestCases, permutations, numberOfRandC);
        }
    }

    static void generatePermutations(int[] array, int index, ArrayList<Integer> permutations) {
        if (index == array.length) {
            StringBuilder temp = new StringBuilder();
            for (int value : array) {
                temp.append(value);
            }
            permutations.add(Integer.parseInt(temp.toString()));
        } else {
            for (int i = index; i < array.length; i++) {
                swap(array, index, i);
                generatePermutations(array, index + 1, permutations);
                swap(array, index, i);
            }
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int findValidPermutation(ArrayList<Integer> permutations, int sumRequired, int numberOfRandC) {
        for (int i = 0; i < permutations.size(); i++) {
            String str = permutations.get(i).toString();
            int sum = 0;
            for (int j = 0; j < str.length(); j++) {
                int index = Character.getNumericValue(str.charAt(j));
                sum += mat[index - 1][j];
            }
            if (sum == sumRequired) {
                return i;
            }
        }
        return -1;
    }

    static void printResult(int testCaseNumber, int validPermutationIndex, int totalTestCases, ArrayList<Integer> permutations, int numberOfRandC) {
        if (validPermutationIndex == -1) {
            System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
        } else {
            System.out.println("Case #" + testCaseNumber + ": POSSIBLE");
            String validPermutation = permutations.get(validPermutationIndex).toString();
            for (int i = 0; i < validPermutation.length(); i++) {
                int index = Character.getNumericValue(validPermutation.charAt(i));
                for (int j = 0; j < numberOfRandC; j++) {
                    System.out.print(mat[index - 1][j]);
                    if (j < numberOfRandC - 1) {
                        System.out.print(" ");
                    }
                }
                if (i < validPermutation.length() - 1) {
                    System.out.println();
                }
            }
        }
    }

    static void fillRemaining(int row, int col, int size) {
        int value = 2;
        for (int i = row + 1; i < size; i++) {
            mat[i][col] = value++;
        }
        for (int i = 0; i < row; i++) {
            mat[i][col] = value++;
        }
    }

    static void constructMatrix(int size) {
        int right = size - 1, left = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                mat[i][right] = 1;
                fillRemaining(i, right, size);
                right--;
            } else {
                mat[i][left] = 1;
                fillRemaining(i, left, size);
                left++;
            }
        }
    }
}