import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            int customer = 1;

            while (customer <= left || customer <= right) {
                if (left >= right) {
                    left -= customer;
                } else {
                    right -= customer;
                }
                customer++;
            }
            customer--;

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, customer, left, right);
        }
    }
}