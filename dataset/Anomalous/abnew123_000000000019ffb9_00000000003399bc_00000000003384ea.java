import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
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
            System.out.println("Case #" + caseNumber + ": " + customer + " " + left + " " + right);
        }
    }
}