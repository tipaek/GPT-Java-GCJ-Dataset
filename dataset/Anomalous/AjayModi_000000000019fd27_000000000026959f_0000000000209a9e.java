import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int[] array = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                System.out.println(i + 1);
                array[i] = scanner.nextInt();
            }

            for (int i = 0; i < arraySize; i++) {
                System.out.print(array[i]);
            }
            System.out.println(); // To move to the next line after printing the array

            if (scanner.next().equals("N")) {
                break;
            }
        }
    }
}