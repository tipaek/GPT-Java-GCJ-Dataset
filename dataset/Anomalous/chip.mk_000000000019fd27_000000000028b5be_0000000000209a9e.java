import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();
            int bitLength = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                StringBuilder result = new StringBuilder();

                if (bitLength == 10) {
                    for (int i = 1; i <= bitLength; i++) {
                        System.out.println(i);
                        System.out.flush();
                        int bit = scanner.nextInt();
                        result.append(bit);
                    }
                } else if (bitLength == 20) {
                    boolean[] differences = new boolean[10];
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i + 1);
                        System.out.flush();
                        int leftBit = scanner.nextInt();
                        System.out.println(20 - i);
                        System.out.flush();
                        int rightBit = scanner.nextInt();
                        differences[i] = leftBit != rightBit;
                    }
                    int[] output = new int[20];
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i + 1);
                        System.out.flush();
                        int leftBit = scanner.nextInt();
                        output[i] = leftBit;
                        output[19 - i] = differences[i] ? 1 - leftBit : leftBit;
                    }
                    for (int bit : output) {
                        result.append(bit);
                    }
                } else {
                    break;
                }

                System.out.println(result.toString());
                System.out.flush();
                if (!scanner.next().equalsIgnoreCase("Y")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}