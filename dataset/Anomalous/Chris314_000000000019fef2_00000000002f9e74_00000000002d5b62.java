import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        String[][] directions = {{"E", "W"}, {"N", "S"}};
        
        for (int i = 1; i <= t; ++i) {
            int[] coordinates = {in.nextInt(), in.nextInt()};
            int k = findOddCoordinate(coordinates);

            if (k < 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder result = new StringBuilder();
            while (coordinates[0] != 0 || coordinates[1] != 0) {
                if (coordinates[0] == 0 && Math.abs(coordinates[1]) == 1) {
                    result.append(coordinates[1] == 1 ? "N" : "S");
                    break;
                }
                if (coordinates[1] == 0 && Math.abs(coordinates[0]) == 1) {
                    result.append(coordinates[0] == 1 ? "E" : "W");
                    break;
                }

                int other = (k + 1) % 2;
                if (isOdd(coordinates[other] / 2)) {
                    if (isOdd((coordinates[k] + 1) / 2)) {
                        result.append(directions[k][1]);
                    } else {
                        result.append(directions[k][0]);
                    }
                    coordinates[k] = (coordinates[k] + 1) / 2 - isOdd((coordinates[k] + 1) / 2);
                } else {
                    if (isOdd((coordinates[k] + 1) / 2)) {
                        result.append(directions[k][1]);
                    } else {
                        result.append(directions[k][0]);
                    }
                    coordinates[k] = (coordinates[k] - 1) / 2 + isOdd((coordinates[k] - 1) / 2 + 1);
                }

                coordinates[other] /= 2;
                k = findOddCoordinate(coordinates);
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static int findOddCoordinate(int[] arr) {
        if (isOdd(arr[0]) && !isOdd(arr[1])) return 0;
        if (isOdd(arr[1]) && !isOdd(arr[0])) return 1;
        return -1;
    }

    public static boolean isOdd(int x) {
        return x % 2 != 0;
    }
}