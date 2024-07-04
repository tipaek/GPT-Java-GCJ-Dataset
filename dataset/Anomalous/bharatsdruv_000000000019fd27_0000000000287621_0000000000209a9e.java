import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int B = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                answer.append(scanner.nextInt());
            }

            System.out.println(answer.toString());
            char response = scanner.next().charAt(0);
            if (response == 'N') {
                break;
            }
        }
    }
}