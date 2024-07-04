import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Attempt3 {

    public static class Matrix {
        int size;
        List<Integer> values = new ArrayList<>();

        public void readValues() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < size * size; i++) {
                values.add(scanner.nextInt());
            }
        }

        public void printResult(int caseNumber) {
            int trace = 0, rowDuplicates = 0, columnDuplicates = 0;

            for (int i = 0; i < size; i++) {
                trace += values.get(i * (size + 1));
            }

            for (int i = 0; i < size; i++) {
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = values.get(j * size + i);
                }
                columnDuplicates += hasDuplicates(column);
            }

            for (int i = 0; i < size; i++) {
                int[] row = new int[size];
                for (int j = 0; j < size; j++) {
                    row[j] = values.get(i * size + j);
                }
                rowDuplicates += hasDuplicates(row);
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + columnDuplicates + " " + rowDuplicates);
        }

        private int hasDuplicates(int[] array) {
            quickSort(array, 0, array.length - 1);
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == array[i + 1]) {
                    return 1;
                }
            }
            return 0;
        }

        private void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                quickSort(array, low, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, high);
            }
        }

        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;
            return i + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        Matrix[] matrices = new Matrix[numCases];

        for (int i = 0; i < numCases; i++) {
            matrices[i] = new Matrix();
            matrices[i].size = scanner.nextInt();
            matrices[i].readValues();
        }

        for (int i = 0; i < numCases; i++) {
            matrices[i].printResult(i + 1);
        }
    }
}