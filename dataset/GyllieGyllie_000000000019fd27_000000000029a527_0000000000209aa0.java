import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int amountCases = in.nextInt();

        for (int i = 1; i <= amountCases; ++i) {
            int gridSize = in.nextInt();
            int trace = in.nextInt();

            int totalSum = 0;
            for (int j = 1; j <= gridSize; j++) {
                totalSum += j;
            }

            if (totalSum == trace && gridSize > 2) {
                System.out.println("CASE #" + i + ": POSSIBLE");

                for (int l = 1; l <= gridSize; l++) {
                    for (int r = 1; r <= gridSize; r++) {
                        int num = l + r;

                        if (num > gridSize) {
                            num -= gridSize;
                        }

                        System.out.print(num);
                    }

                    System.out.println();
                }
            } else {

                int useNumber = 1;
                boolean possible = false;

                while (useNumber <= gridSize) {
                    if (useNumber * gridSize == trace) {
                        possible = true;
                    } else {
                        useNumber++;
                    }
                }

                if (possible) {
                    System.out.println("CASE #" + i + ": POSSIBLE");

                    for (int l = 1; l <= gridSize; l++) {
                        for (int r = 1; r <= gridSize; r++) {
                            int num = l + r + (useNumber - 1);

                            if (num > gridSize) {
                                num -= gridSize;
                            }

                            System.out.print(num);
                        }

                        System.out.println();
                    }
                } else {
                    System.out.println("CASE #" + i + ": IMPOSSIBLE");
                }
            }
        }
    }
}
