import java.util.Scanner;
import java.util.Hashtable;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int traceValue = calculateTrace(matrix, size);
            int rowDuplicates = countRowDuplicates(matrix, size);
            int colDuplicates = countColumnDuplicates(matrix, size);
            
            System.out.println("Case #" + testCase + ": " + traceValue + " " + rowDuplicates + " " + colDuplicates);
        }
        
        scanner.close();
    }

    public static int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Integer> hashtable = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (hashtable.containsKey(matrix[i][j])) {
                    duplicateCount++;
                    break;
                } else {
                    hashtable.put(matrix[i][j], 1);
                }
            }
        }
        return duplicateCount;
    }

    public static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Hashtable<Integer, Integer> hashtable = new Hashtable<>();
            for (int j = 0; j < size; j++) {
                if (hashtable.containsKey(matrix[j][i])) {
                    duplicateCount++;
                    break;
                } else {
                    hashtable.put(matrix[j][i], 1);
                }
            }
        }
        return duplicateCount;
    }
}