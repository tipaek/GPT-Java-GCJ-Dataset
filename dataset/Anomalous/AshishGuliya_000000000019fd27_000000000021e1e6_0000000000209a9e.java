import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            esab(scanner);
        }
    }

    private static void esab(Scanner scanner) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            StringBuilder array = new StringBuilder();

            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                System.out.flush();
                array.append(scanner.nextInt());
            }

            System.out.println(array.toString());
            System.out.flush();

            String result = scanner.next();
            if ("N".equals(result)) {
                break;
            }
        }
    }
}