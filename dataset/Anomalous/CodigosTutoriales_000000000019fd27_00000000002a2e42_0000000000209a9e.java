import java.util.Scanner;

/**
 * Made and solved successfully by the Prodigy Programmer
 * Author: Julian Paniagua
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            byte[] bitArray = new byte[arrayLength];
            int queries = 0;

            for (int i = 0; i < arrayLength; i++) {
                queries++;
                System.out.println(i + 1);
                System.out.flush();

                byte bit = scanner.nextByte();
                if (queries % 10 == 1) {
                    i--; // Skip this query and redo the current index
                } else {
                    bitArray[i] = bit;
                }
            }

            for (byte bit : bitArray) {
                System.out.print(bit);
            }
            System.out.println();
            System.out.flush();

            String response = scanner.next();
            if (response.equals("N")) {
                System.exit(0);
            }
        }
    }
}