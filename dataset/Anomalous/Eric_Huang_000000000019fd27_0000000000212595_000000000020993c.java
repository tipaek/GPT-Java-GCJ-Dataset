import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            boolean[][] rowCheck = new boolean[n][n + 1];
            boolean[][] colCheck = new boolean[n][n + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                boolean rowHasRepeat = false;
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    
                    // Calculate trace
                    if (i == j) {
                        trace += value;
                    }

                    // Check for row repeats
                    if (rowCheck[i][value]) {
                        if (!rowHasRepeat) {
                            rowRepeats++;
                            rowHasRepeat = true;
                        }
                    } else {
                        rowCheck[i][value] = true;
                    }

                    // Check for column repeats
                    if (colCheck[j][value]) {
                        if (!colCheck[j][0]) {
                            colRepeats++;
                            colCheck[j][0] = true;
                        }
                    } else {
                        colCheck[j][value] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, trace, rowRepeats, colRepeats);
        }
        scanner.close();
    }
}