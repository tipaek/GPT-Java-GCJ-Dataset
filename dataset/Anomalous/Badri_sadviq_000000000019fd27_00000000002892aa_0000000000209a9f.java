import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.next();
            int length = inputString.length();
            char[] characters = new char[length];

            for (int q = 0; q < length; q++) {
                characters[q] = inputString.charAt(q);
            }

            for (int j = 0; j < length; j++) {
                if (characters[j] == '1') {
                    System.out.print("(" + characters[j] + ")");
                } else {
                    System.out.print(characters[j]);
                }
            }
            System.out.println(); // To move to the next line after each test case
        }
    }
}