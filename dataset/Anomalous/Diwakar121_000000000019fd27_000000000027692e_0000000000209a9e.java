import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            StringBuilder str = new StringBuilder();

            for (int j = 0; j < b; j++) {
                System.out.println(j + 1);
                System.out.flush();

                char c = scanner.next().charAt(0);
                str.append(c);
            }

            System.out.println(str);
            System.out.flush();

            char response = scanner.next().charAt(0);
            if (response == 'N') {
                break;
            }
        }

        scanner.close();
    }
}