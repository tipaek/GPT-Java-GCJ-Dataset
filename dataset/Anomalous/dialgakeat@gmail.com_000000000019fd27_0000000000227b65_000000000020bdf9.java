import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            boolean isImpossible = false;
            boolean[] cOccupied = new boolean[1440];
            boolean[] jOccupied = new boolean[1440];
            StringBuilder result = new StringBuilder();

            for (int a = 0; a < n; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignC = true;
                boolean canAssignJ = true;

                for (int x = start; x < end; x++) {
                    if (cOccupied[x]) {
                        canAssignC = false;
                        break;
                    }
                }

                if (canAssignC) {
                    for (int x = start; x < end; x++) {
                        cOccupied[x] = true;
                    }
                } else {
                    for (int x = start; x < end; x++) {
                        if (jOccupied[x]) {
                            canAssignJ = false;
                            break;
                        }
                    }
                    if (canAssignJ) {
                        for (int x = start; x < end; x++) {
                            jOccupied[x] = true;
                        }
                    }
                }

                if (canAssignC) {
                    result.append('C');
                } else if (canAssignJ) {
                    result.append('J');
                } else {
                    isImpossible = true;
                }
            }

            System.out.print("Case #" + i + ": ");
            if (isImpossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                System.out.print(result.toString());
            }
            System.out.println();
        }
    }
}