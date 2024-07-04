import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Attempt2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMatrices = scanner.nextInt();
        Matrix[] matrices = new Matrix[numMatrices];

        for (int i = 0; i < numMatrices; i++) {
            matrices[i] = new Matrix(scanner.nextInt());
            matrices[i].readValues(scanner);
        }

        for (int i = 0; i < numMatrices; i++) {
            matrices[i].printResult(i + 1);
        }

        scanner.close();
    }

    static class Matrix {
        int size;
        List<Integer> values;

        public Matrix(int size) {
            this.size = size;
            this.values = new ArrayList<>();
        }

        public void readValues(Scanner scanner) {
            for (int i = 0; i < size * size; i++) {
                values.add(scanner.nextInt());
            }
        }

        public void printResult(int caseNumber) {
            int trace = calculateTrace();
            int duplicateRows = countDuplicateRows();
            int duplicateColumns = countDuplicateColumns();
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateColumns + " " + duplicateRows);
        }

        private int calculateTrace() {
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += values.get(i * (size + 1));
            }
            return trace;
        }

        private int countDuplicateRows() {
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                int[] row = new int[size];
                for (int j = 0; j < size; j++) {
                    row[j] = values.get(i * size + j);
                }
                duplicateRows += hasDuplicates(row) ? 1 : 0;
            }
            return duplicateRows;
        }

        private int countDuplicateColumns() {
            int duplicateColumns = 0;
            for (int i = 0; i < size; i++) {
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = values.get(j * size + i);
                }
                duplicateColumns += hasDuplicates(column) ? 1 : 0;
            }
            return duplicateColumns;
        }

        private boolean hasDuplicates(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    return true;
                }
            }
            return false;
        }

        private void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        private int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}