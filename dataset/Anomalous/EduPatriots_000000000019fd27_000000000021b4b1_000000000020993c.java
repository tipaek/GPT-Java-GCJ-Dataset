import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMatrices = scanner.nextInt();
        Matrix[] matrices = new Matrix[numMatrices];
        
        for (int i = 0; i < numMatrices; i++) {
            int size = scanner.nextInt();
            matrices[i] = new Matrix(size);
            matrices[i].readValues(scanner);
        }
        
        for (int i = 0; i < numMatrices; i++) {
            matrices[i].printOutput(i + 1);
        }
    }
    
    static class Matrix {
        int size;
        List<Integer> values;

        Matrix(int size) {
            this.size = size;
            this.values = new ArrayList<>();
        }

        void readValues(Scanner scanner) {
            for (int i = 0; i < size * size; i++) {
                values.add(scanner.nextInt());
            }
        }

        void printOutput(int caseNumber) {
            int trace = calculateTrace();
            int duplicateRows = countDuplicateRows();
            int duplicateColumns = countDuplicateColumns();
            
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateColumns, duplicateRows);
        }

        int calculateTrace() {
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += values.get(i * (size + 1));
            }
            return trace;
        }

        int countDuplicateRows() {
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                int[] row = new int[size];
                for (int j = 0; j < size; j++) {
                    row[j] = values.get(i * size + j);
                }
                if (hasDuplicates(row)) {
                    duplicateRows++;
                }
            }
            return duplicateRows;
        }

        int countDuplicateColumns() {
            int duplicateColumns = 0;
            for (int i = 0; i < size; i++) {
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = values.get(j * size + i);
                }
                if (hasDuplicates(column)) {
                    duplicateColumns++;
                }
            }
            return duplicateColumns;
        }

        boolean hasDuplicates(int[] array) {
            quickSort(array, 0, array.length - 1);
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == array[i + 1]) {
                    return true;
                }
            }
            return false;
        }

        void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                quickSort(array, low, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, high);
            }
        }

        int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    swap(array, i, j);
                }
            }
            swap(array, i + 1, high);
            return i + 1;
        }

        void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}