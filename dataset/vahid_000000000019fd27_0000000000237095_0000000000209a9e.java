import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {

    private static final int FLUCTUTION_FREQUENCY = 10;
    private static Scanner scanner = new Scanner(new BufferedInputStream(System.in, 64 * 1024));
    private int readCounter;

    public static void main(String[] args) {
        new Solution().solveProblem();
    }

    private void solveProblem() {
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            readCounter = 0;
            solveCase(b);
        }
    }

    private void solveCase(int b) {
        Cell[] cells = new Cell[b];
        for (int i = 0; i < (b / FLUCTUTION_FREQUENCY); i++) {
            for (int j = 0; j < FLUCTUTION_FREQUENCY / 2; j++) {
                int index = FLUCTUTION_FREQUENCY / 2 * i + j;
                int value1 = readValue(index);
                int value2 = readValue(b - index - 1);
                cells[index] = new Cell(value1, value1 == value2);
                cells[b - index - 1] = new Cell(value2, value1 == value2);
            }
        }

        int firstEqualIndex = sync(cells, b, true);
        int firstNotEqualIndex = sync(cells, b, false);

        while (readCounter < 140) {
            readValue(1);
        }

        int equalValue = -1;
        if (firstEqualIndex >= 0) {
            equalValue = readValue(firstEqualIndex);
        }

        int notEqualValue = -1;
        if (firstNotEqualIndex >= 0) {
            notEqualValue = readValue(firstNotEqualIndex);
        }

        while (readCounter < 150) {
            readValue(1);
        }

        char[] result = new char[b];

        for (int i = 0; i < b; i++) {
            if (cells[i].equal) {
                int r = (equalValue == cells[firstEqualIndex].value) ? cells[i].value : 1 - cells[i].value;
                result[i] = String.valueOf(r).charAt(0);
            } else {
                int r = (notEqualValue == cells[firstNotEqualIndex].value) ? cells[i].value : 1 - cells[i].value;
                result[i] = String.valueOf(r).charAt(0);
            }
        }

        System.out.println(String.valueOf(result));
        while (!"Y".equals(scanner.nextLine().trim()));
    }

    private int sync(Cell[] cells, int b, boolean equalPair) {
        int i = 0;
        while (cells[i].equal != equalPair && i < b / 2) {
            i++;
        }
        if (i >= b / 2) {
            return -1;
        }
        int group = i / (b / 2);
        for (int otherGroups = group + 1; otherGroups < b / FLUCTUTION_FREQUENCY; otherGroups++) {
            int matchedIndex = -1;
            boolean complement = false;
            for (int j = 0; j < FLUCTUTION_FREQUENCY / 2; j++) {
                int newIndex = FLUCTUTION_FREQUENCY / 2 * otherGroups + j;
                if (cells[i].equal == cells[newIndex].equal) {
                    if (matchedIndex == -1) {
                        matchedIndex = j;
                        int value1 = readValue(i);
                        int value2 = readValue(newIndex);
                        complement = (value1 == cells[i].value) != (value2 == cells[newIndex].value);
                    }
                    if (complement) {
                        cells[newIndex].value = 1 - cells[newIndex].value;
                        cells[b - (newIndex) - 1].value = 1 - cells[b - (newIndex) - 1].value;
                    }
                }
            }
        }

        return i;
    }

    private int readValue(int index) {
        readCounter++;
        System.out.println(index + 1);
        return scanner.nextInt();
    }

    class Cell {
        int value;
        boolean equal;

        public Cell(int value, boolean equal) {
            this.value = value;
            this.equal = equal;
        }
    }
}
