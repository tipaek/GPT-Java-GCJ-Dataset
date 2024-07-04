import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        scanner.close();

        for (int i = 0; i < noOfTestCases; i++) {
            try {
                if (!processBitArray(arraySize)) {
                    return;
                }
            } catch (IOException e) {
                return;
            }
        }
    }

    private static boolean processBitArray(int arraySize) throws IOException {
        InputStream inputStream = System.in;
        int[] bitArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.write(i);
            System.out.flush();
            bitArray[i] = inputStream.read();
        }

        outputArray(bitArray, arraySize);
        char response = (char) inputStream.read();

        return response == 'Y';
    }

    private static void outputArray(int[] bitArray, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            System.out.write(bitArray[i]);
        }
        System.out.flush();
    }
}