import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            for (int i = 0; i < 150; i++) {
                System.out.println(0);
                String response = scanner.next();
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < bitLength; i++) {
                answer.append("0");
            }
            System.out.print(answer.toString());
        }
    }
}