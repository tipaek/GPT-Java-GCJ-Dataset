import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            long[] X = new long[size];
            long[] Y = new long[size];

            for (int i = 0; i < size; i++) {
                X[i] = scanner.nextInt();
                Y[i] = scanner.nextInt();
            }

            long maxPoints = 1;

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int[] index = new int[size];
                    int[] count = new int[size];
                    int singlePoints = 0;
                    int multiplePoints = 0;

                    for (int k = 0; k < size; k++) {
                        if (index[k] != 0) continue;

                        for (int l = k; l < size; l++) {
                            if ((X[k] - X[l]) * (Y[i] - Y[j]) == (X[i] - X[j]) * (Y[k] - Y[l])) {
                                index[l] = k + 1;
                            }
                        }
                    }

                    for (int k = 0; k < size; k++) {
                        count[index[k] - 1]++;
                    }

                    for (int k = 0; k < size; k++) {
                        if (count[k] == 1) {
                            singlePoints++;
                        } else {
                            multiplePoints += count[k];
                        }
                    }

                    long currentPoints = multiplePoints + Math.min(singlePoints, 2 - multiplePoints % 2);
                    if (currentPoints > maxPoints) {
                        maxPoints = currentPoints;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + maxPoints);
        }
    }
}