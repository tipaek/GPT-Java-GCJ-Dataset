import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        esab(scanner);
    }

    private static void esab(Scanner scanner) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        int[] array = new int[B];
        
        for (int t = 1; t <= T; t++) {
            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                array[j - 1] = scanner.nextInt();
            }
            for (int digit : array) {
                System.out.print(digit);
            }
            System.out.println();
            String result = scanner.next();
            if (result.equals("N")) {
                break;
            }
        }
    }
}