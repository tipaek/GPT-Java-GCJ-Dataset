import java.util.Scanner;

class CodeJam {

    public int calculateTrace(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public int countRowRepeats(int[][] matrix, int size) {
        int rowCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }
        return rowCount;
    }

    public int countColumnRepeats(int[][] matrix, int size) {
        int colCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }
        return colCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CodeJam codeJam = new CodeJam();
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int trace = codeJam.calculateTrace(matrix, size);
            int rowRepeats = codeJam.countRowRepeats(matrix, size);
            int colRepeats = codeJam.countColumnRepeats(matrix, size);
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}