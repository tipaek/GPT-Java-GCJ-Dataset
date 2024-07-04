import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<Model> models = new ArrayList<>(t);
        Vestigium vestigium = new Vestigium();

        for (int testCase = 0; testCase < t; testCase++) {
            Model model = vestigium.new Model();
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            model.setN(n);
            model.setArr(matrix);
            models.add(model);
        }
        scanner.close();

        // Solve the problem
        for (int i = 0; i < models.size(); i++) {
            Model model = models.get(i);
            System.out.println("Case #" + (i + 1) + ": " 
                + calculateTrace(model) + " " 
                + countRowDuplicates(model) + " " 
                + countColDuplicates(model));
        }
    }

    private static int countColDuplicates(Model model) {
        int duplicateCount = 0;
        int n = model.getN();
        int[][] matrix = model.getArr();

        for (int j = 0; j < n; j++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != n) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countRowDuplicates(Model model) {
        int duplicateCount = 0;
        int n = model.getN();
        int[][] matrix = model.getArr();

        for (int[] row : matrix) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() != n) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int calculateTrace(Model model) {
        int trace = 0;
        int[][] matrix = model.getArr();
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public class Model {
        private int n;
        private int[][] arr;

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int[][] getArr() {
            return arr;
        }

        public void setArr(int[][] arr) {
            this.arr = arr;
        }

        public Model(int n, int[][] arr) {
            this.n = n;
            this.arr = arr;
        }

        public Model() {
        }
    }
}