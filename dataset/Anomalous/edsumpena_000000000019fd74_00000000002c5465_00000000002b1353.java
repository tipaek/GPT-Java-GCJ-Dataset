import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int value = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");

            if (value != 501) {
                for (int i = 0; i < value; i++) {
                    System.out.println((i + 1) + " " + 1);
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 2");
                for (int i = 1; i < value; i++) {
                    System.out.println((i + 1) + " " + 1);
                }
            }
        }
    }
}