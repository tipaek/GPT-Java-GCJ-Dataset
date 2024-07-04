import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            String[] responses = new String[B];
            int index = 1;

            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                responses[j - 1] = scanner.next();
            }

            System.out.println(1);
            scanner.next();

            for (int j = 1; j < B; j += 10) {
                System.out.println(j);
                responses[j - 1] = scanner.next();
            }

            System.out.println(String.join("", responses));
        }
    }
}