import java.util.Scanner;

class Mod2 {
    private int[][] matrix;
    private int[] count = new int[2];

    public Mod2(int size) {
        matrix = new int[size][size];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }
}

public class Mod1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Mod2[] mod2Array = new Mod2[testCases];
        int[] diagonalSums = new int[testCases];

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            mod2Array[i] = new Mod2(size);
            int[][] matrix = mod2Array[i].getMatrix();
            int diagonalSum = 0;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }
            diagonalSums[i] = diagonalSum;
        }

        Mod1 mod1 = new Mod1();
        for (int i = 0; i < testCases; i++) {
            mod2Array[i].setCount(mod1.checkRepeats(mod2Array[i].getMatrix()));
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + diagonalSums[i] + " " + mod2Array[i].getCount()[0] + " " + mod2Array[i].getCount()[1]);
        }
    }

    public int[] checkRepeats(int[][] matrix) {
        int[] count = new int[2];
        int size = matrix.length;

        // Check for repeated elements in rows
        for (int i = 0; i < size; i++) {
            boolean hasRepeat = false;
            for (int j = 0; j < size - 1; j++) {
                if (matrix[i][j] == matrix[i][j + 1]) {
                    hasRepeat = true;
                    break;
                }
            }
            if (hasRepeat) {
                count[0]++;
            }
        }

        // Check for repeated elements in columns
        for (int i = 0; i < size; i++) {
            boolean hasRepeat = false;
            for (int j = 0; j < size - 1; j++) {
                if (matrix[j][i] == matrix[j + 1][i]) {
                    hasRepeat = true;
                    break;
                }
            }
            if (hasRepeat) {
                count[1]++;
            }
        }

        return count;
    }
}