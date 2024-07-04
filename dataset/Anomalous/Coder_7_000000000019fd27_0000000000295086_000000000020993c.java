import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        int caseNumber = 1;

        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] columnCheck = new int[size][size];
            int[] colRepeatCheck = new int[size];

            for (int j = 0; j < size; j++) {
                int[] rowCheck = new int[size];
                String[] rowValues = scanner.nextLine().split(" ");
                boolean rowFlag = false;

                for (int k = 0; k < size; k++) {
                    int value = Integer.parseInt(rowValues[k]);

                    rowCheck[value - 1]++;
                    if (rowCheck[value - 1] > 1 && !rowFlag) {
                        rowRepeats++;
                        rowFlag = true;
                    }

                    columnCheck[k][value - 1]++;
                    if (colRepeatCheck[k] != 1 && columnCheck[k][value - 1] > 1) {
                        colRepeats++;
                        colRepeatCheck[k] = 1;
                    }

                    if (k == j) {
                        trace += value;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
        }
        scanner.close();
    }
}