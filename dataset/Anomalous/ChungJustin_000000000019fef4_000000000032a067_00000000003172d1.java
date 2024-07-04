import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int result;
            int numCakes = scanner.nextInt();
            int divisor = scanner.nextInt();

            result = divisor - 1;
            BigInteger[] cakes = new BigInteger[numCakes];
            for (int i = 0; i < numCakes; i++) {
                cakes[i] = scanner.nextBigInteger();
            }

            if (divisor == 2) {
                for (int i = 0; i < numCakes; i++) {
                    for (int j = i + 1; j < numCakes; j++) {
                        if (cakes[i].equals(cakes[j])) {
                            result = 0;
                            break;
                        }
                    }
                }
            } else if (divisor == 3) {
                for (int i = 0; i < numCakes; i++) {
                    for (int j = i + 1; j < numCakes; j++) {
                        for (int k = j + 1; k < numCakes; k++) {
                            if (cakes[i].equals(cakes[j]) && cakes[j].equals(cakes[k])) {
                                result = 0;
                                break;
                            }
                        }
                        if (result == 0) break;
                    }
                    if (result == 0) break;
                }

                if (result != 0) {
                    for (int i = 0; i < numCakes; i++) {
                        for (int j = i + 1; j < numCakes; j++) {
                            if (cakes[i].equals(cakes[j].multiply(BigInteger.valueOf(2))) || 
                                cakes[j].equals(cakes[i].multiply(BigInteger.valueOf(2)))) {
                                result = 1;
                                break;
                            }
                        }
                        if (result == 1) break;
                    }
                }
            }

            System.out.printf("Case #%d: %d%n", t + 1, result);
        }

        scanner.close();
    }
}