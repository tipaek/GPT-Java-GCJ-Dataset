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
            int N = scanner.nextInt();
            int D = scanner.nextInt();

            result = D - 1;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BigInteger[] cakes = new BigInteger[N];
            
            for (int i = 0; i < N; i++) {
                cakes[i] = new BigInteger(bufferedReader.readLine());
            }

            if (D == 2) {
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (cakes[i].equals(cakes[j])) {
                            result = 0;
                            break;
                        }
                    }
                    if (result == 0) break;
                }
            } else if (D == 3) {
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        for (int k = j + 1; k < N; k++) {
                            if (cakes[i].equals(cakes[j]) && cakes[j].equals(cakes[k])) {
                                result = 0;
                                break;
                            }
                        }
                        if (result == 0) break;
                        if ((cakes[i].equals(cakes[j].multiply(BigInteger.valueOf(2))) || 
                             cakes[j].equals(cakes[i].multiply(BigInteger.valueOf(2)))) && result != 0) {
                            result = 1;
                        }
                    }
                    if (result == 0) break;
                }
            }

            System.out.printf("Case #%d: %d%n", t + 1, result);
        }
        
        scanner.close();
    }
}