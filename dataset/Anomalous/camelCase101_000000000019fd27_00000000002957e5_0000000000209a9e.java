import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        System.out.flush();

        for (int i = 1; i <= testCases; i++) {
            String base = scanner.next();
            System.out.println(base);

            if (scanner.next().equals("N")) {
                String complement = getComplement(base);
                System.out.println(complement);

                if (scanner.next().equals("N")) {
                    String reversedBase = new StringBuilder(base).reverse().toString();
                    System.out.println(reversedBase);

                    if (scanner.next().equals("N")) {
                        String reversedComplement = new StringBuilder(complement).reverse().toString();
                        System.out.println(reversedComplement);
                    }
                }
            }
        }
    }

    private static String getComplement(String input) {
        StringBuilder complement = new StringBuilder();
        for (char c : input.toCharArray()) {
            complement.append(c == '0' ? '1' : '0');
        }
        return complement.toString();
    }
}