import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();
            int[][] container = new int[1441][2];

            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                boolean isImpossible = false;

                for (int x = 0; x < 1441; x++) {
                    container[x][0] = 0;
                    container[x][1] = 0;
                }

                for (int a = 1; a <= n; a++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();

                    for (int m = start; m < end; m++) {
                        if (container[m][0] == 0) {
                            container[m][0] = a;
                        } else if (container[m][1] == 0) {
                            container[m][1] = a;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }

                    if (isImpossible) {
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];
                    int[] assigned = new int[n + 1];

                    for (int x = 1; x < 1441; x++) {
                        if (container[x - 1][1] == container[x][0] && container[x][0] != 0) {
                            swap(container, x, 0, 1);
                        } else if (container[x - 1][0] == container[x][1] && container[x][1] != 0) {
                            swap(container, x, 1, 0);
                        }

                        if (container[x - 1][0] != 0 && assigned[container[x - 1][0]] == 0) {
                            assigned[container[x - 1][0]] = 'C';
                        }

                        if (container[x - 1][1] != 0 && assigned[container[x - 1][1]] == 0) {
                            assigned[container[x - 1][1]] = 'J';
                        }
                    }

                    for (int a = 1; a <= n; a++) {
                        result[a - 1] = (char) assigned[a];
                    }

                    System.out.println("Case #" + i + ": " + new String(result));
                }
            }
        }
    }

    private static void swap(int[][] container, int x, int a, int b) {
        int temp = container[x][a];
        container[x][a] = container[x][b];
        container[x][b] = temp;
    }
}