import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        for (int i = 1; i <= amount; i++) {
            int size = scanner.nextInt();
            int[][] array = new int[size][size];

            for (int a = 0; a < size; a++) {
                for (int b = 0; b < size; b++) {
                    array[a][b] = scanner.nextInt();
                }
            }

            //row
            int row = 0;
            for (int a = 0; a < size; a++) {
                if (hasRepeated(array[a]))
                    row++;
            }

            //column
            int column = 0;
            for (int a = 0; a < size; a++) {
                int[] line = new int[size];
                for (int b = 0; b < size; b++) {
                    line[b] = array[b][a];
                }
                if (hasRepeated(line))
                    column++;
            }

            //trace
            int trace = 0;
            for (int a = 0; a < size; a++) {
                trace += array[a][a];
            }

            System.out.println("case #" + i + ": " + trace + " " + row + " " + column);
        }
    }

    private static boolean hasRepeated(int[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (line[i] == line[j])
                    return true;
            }
        }
        return false;
    }

}
