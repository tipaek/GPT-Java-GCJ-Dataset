import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            int[][] container = new int[1441][2];
            for (int i = 1; i <= t; i++) {
                int n = in.nextInt();
                in.nextLine();
                boolean isImpossible = false;

                // Reset container
                for (int[] row : container) {
                    row[0] = 0;
                    row[1] = 0;
                }

                for (int a = 1; a <= n; a++) {
                    String[] times = in.nextLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);

                    for (int m = start; m < end; m++) {
                        if (m >= container.length) break;
                        if (container[m][0] == 0) {
                            container[m][0] = a;
                        } else if (container[m][1] == 0) {
                            container[m][1] = a;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                    if (isImpossible) break;
                }

                if (isImpossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];
                    for (int x = 1; x < container.length; x++) {
                        if (container[x - 1][1] == container[x][0] && container[x][0] != 0) {
                            int tmp = container[x][0];
                            container[x][0] = container[x][1];
                            container[x][1] = tmp;
                        } else if (container[x - 1][0] == container[x][1] && container[x][1] != 0) {
                            int tmp = container[x][1];
                            container[x][1] = container[x][0];
                            container[x][0] = tmp;
                        }
                        if (container[x - 1][0] != container[x][0] && container[x - 1][0] != 0) {
                            result[container[x - 1][0] - 1] = 'C';
                        }
                        if (container[x - 1][1] != container[x][1] && container[x - 1][1] != 0) {
                            result[container[x - 1][1] - 1] = 'J';
                        }
                    }
                    System.out.println("Case #" + i + ": " + new String(result));
                }
            }
        }
    }
}