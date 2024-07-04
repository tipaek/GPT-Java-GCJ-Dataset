import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            processTestCase(scanner, bitLength);
        }
    }

    private static void processTestCase(Scanner scanner, int bitLength) {
        int[] bits = new int[bitLength];
        int currentIndex = 0;
        for (int i = 0; i < 150; i++) {
            if (currentIndex >= bitLength) {
                break;
            }
            bits[currentIndex] = makeQuery(scanner, currentIndex + 1);
            if ((i + 1) % 10 == 1 && i != 0) {
                bits[currentIndex] = makeQuery(scanner, currentIndex + 1);
                currentIndex++;
                i++;
            } else {
                currentIndex++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int bit : bits) {
            result.append(bit);
        }
        System.out.println(result.toString());
        System.out.flush();
        scanner.next();
    }

    private static int makeQuery(Scanner scanner, int position) {
        System.out.println(position);
        System.out.flush();
        return scanner.nextInt();
    }
}