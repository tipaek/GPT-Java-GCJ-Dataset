import java.util.Scanner;
import java.io.IOException;

public class Solution {

    public static void printArray(char[] array) {
        for (char c : array) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            char[] bitString = new char[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                System.out.println(i + 1);
                bitString[i] = scanner.next().charAt(0);
            }

            printArray(bitString);
            char result = scanner.next().charAt(0);
            if (result == 'N') {
                System.exit(0);
            }
        }
    }
}