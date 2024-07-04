import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static void send(String str) {
        System.out.println(str);
        System.out.flush();
    }

    private static boolean process(Scanner scanner, int B) throws IOException {
        StringBuilder result = new StringBuilder();
        
        for (int i = 1; i <= 10; i++) {
            send(String.valueOf(i));
            char response = scanner.next().charAt(0);
            result.append(response);
        }

        send(result.toString());
        char finalResponse = scanner.next().charAt(0);
        return finalResponse == 'Y';
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            int B = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                if (!process(scanner, B)) {
                    break;
                }
            }
        }
    }
}