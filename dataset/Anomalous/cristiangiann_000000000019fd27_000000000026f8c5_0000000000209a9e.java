import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        int nTests = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);

        if (B == 10) {
            for (int test = 0; test < nTests; test++) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < B; i++) {
                    System.out.println(i + 1);
                    result.append(scanner.nextLine());
                }
                System.out.println(result.toString());
                String serverResponse = scanner.nextLine();
                if ("N".equals(serverResponse)) {
                    return;
                }
            }
        }
    }
}