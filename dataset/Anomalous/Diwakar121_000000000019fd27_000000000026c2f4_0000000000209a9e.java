import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int b = scanner.nextInt();
            int[] arr = new int[b];

            for (int j = 0; j < b; j++) {
                System.out.println(j + 1);
                System.out.flush();
                arr[j] = scanner.nextInt();
            }

            StringBuilder str = new StringBuilder();
            for (int j = 0; j < b; j++) {
                if (arr[j] == 1) {
                    str.append("1");
                } else {
                    str.append("0");
                }
            }

            System.out.println(str);
            System.out.flush();

            char z = scanner.next().charAt(0);
            if (z == 'N') {
                break;
            }
        }

        scanner.close();
    }
}