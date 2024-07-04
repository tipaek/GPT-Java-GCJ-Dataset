import java.util.*;

public class Vest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rowRepeats = 0;
            int colRepeats = 0;
            int diagonalSum = 0;
            int cubeSize = scanner.nextInt();

            int[][] matrix = new int[cubeSize][cubeSize];
            ArrayList<Set<Integer>> rowSets = new ArrayList<>();
            ArrayList<Set<Integer>> colSets = new ArrayList<>();

            int[] rowRepeatFlags = new int[cubeSize];
            int[] colRepeatFlags = new int[cubeSize];

            for (int i = 0; i < cubeSize; i++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
            }

            for (int i = 0; i < cubeSize; i++) {
                for (int j = 0; j < cubeSize; j++) {
                    int value = scanner.nextInt();
                    matrix[i][j] = value;

                    if (i == j) {
                        diagonalSum += value;
                    }

                    if (!rowSets.get(i).add(value) && rowRepeatFlags[i] == 0) {
                        rowRepeats++;
                        rowRepeatFlags[i] = 1;
                    }

                    if (!colSets.get(j).add(value) && colRepeatFlags[j] == 0) {
                        colRepeats++;
                        colRepeatFlags[j] = 1;
                    }
                }
            }

            System.out.println("Case: #" + testCase + " " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}