import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();  // Number of test cases
        int b = scanner.nextInt();  // Unused variable, but kept to maintain functionality

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();  // Number of cakes
            int D = scanner.nextInt();  // Number of divisions

            int result = D - 1;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BigInteger[] cakes = new BigInteger[10000];

            // Reading cake values
            for (int i = 0; i < N; i++) {
                cakes[i] = new BigInteger(bufferedReader.readLine());
            }

            // Check for pairs of identical cakes if D == 2
            if (D == 2) {
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (cakes[i].equals(cakes[j])) {
                            result = 0;
                        }
                    }
                }
            }

            // Check for triplets of identical cakes or special conditions if D == 3
            if (D == 3) {
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        for (int k = j + 1; k < N; k++) {
                            if (cakes[i].equals(cakes[j]) && cakes[j].equals(cakes[k])) {
                                result = 0;
                            }
                        }
                        if ((cakes[i].equals(cakes[j].multiply(BigInteger.valueOf(2)))
                                || cakes[j].equals(cakes[i].multiply(BigInteger.valueOf(2)))) && result != 0) {
                            result = 1;
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d%n", t + 1, result);
        }

        scanner.close();
    }
}