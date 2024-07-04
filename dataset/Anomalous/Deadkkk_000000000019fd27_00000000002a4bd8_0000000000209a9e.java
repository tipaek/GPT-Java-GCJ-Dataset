import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int i = 0; i < noOfTestCases; i++) {
            try {
                if (!processTestCase(arraySize)) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean processTestCase(int arraySize) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] bitArray = new int[arraySize];
        
        if (arraySize <= 10) {
            for (int i = 0; i < arraySize; i++) {
                System.out.println(i + 1);
                System.out.flush();
                bitArray[i] = scanner.nextInt();
            }
            displayArray(bitArray);
            if (!isResponseCorrect()) {
                return false;
            }
        } else {
            int j = 1;
            for (int i = 0; i < arraySize; ) {
                if (j % 40 < 10) {
                    System.out.println(i + 1);
                    System.out.flush();
                    bitArray[i] = scanner.nextInt();
                    i++;
                } else {
                    System.out.println(1);
                    scanner.nextInt();
                }
                j++;
            }
            displayArray(bitArray);
            if (!isResponseCorrect()) {
                return false;
            }
        }
        return true;
    }

    private static void displayArray(int[] bitArray) {
        for (int bit : bitArray) {
            System.out.print(bit);
        }
        System.out.println();
        System.out.flush();
    }

    private static boolean isResponseCorrect() throws IOException {
        char response = (char) System.in.read();
        return response == 'Y';
    }
}