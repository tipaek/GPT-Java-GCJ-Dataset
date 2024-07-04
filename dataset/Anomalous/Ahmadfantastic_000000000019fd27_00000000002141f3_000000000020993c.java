import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static int[] primes;

    public static void main(String[] args) {
        int T = Integer.parseInt(in.nextLine());
        generatePrimes(100);
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            in.nextLine();

            int trace = 0;
            int[] rowProducts = new int[N];
            int[] colProducts = new int[N];

            Arrays.fill(rowProducts, 1);
            Arrays.fill(colProducts, 1);

            int totalProduct = Arrays.stream(primes).limit(N).reduce(1, (a, b) -> a * b);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = in.nextInt();
                    rowProducts[i] *= primes[value - 1];
                    colProducts[j] *= primes[value - 1];
                    if (i == j) {
                        trace += value;
                    }
                }
                if (in.hasNextLine()) {
                    in.nextLine();
                }
            }

            int rowCount = 0, colCount = 0;
            for (int i = 0; i < N; i++) {
                if (rowProducts[i] != totalProduct) {
                    rowCount++;
                }
                if (colProducts[i] != totalProduct) {
                    colCount++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowCount + " " + colCount);
        }
    }

    private static void generatePrimes(int size) {
        primes = new int[size];
        int num = 2;
        int counter = 0;
        while (counter < size) {
            if (isPrime(num)) {
                primes[counter++] = num;
            }
            num++;
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2, sqrt = (int) Math.sqrt(num); i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}