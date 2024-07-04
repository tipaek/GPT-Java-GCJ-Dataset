import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int[] bits = new int[b];
            for (int j = 0; j < b; j++) {
                System.out.println(j + 1);
                bits[j] = scanner.nextInt();
            }

            StringBuilder ans = new StringBuilder();
            for (int bit : bits) {
                ans.append(bit);
            }
            System.out.println(ans.toString());

            String response = scanner.next();
            if (response.equals("N")) {
                break;
            }
        }
    }
}