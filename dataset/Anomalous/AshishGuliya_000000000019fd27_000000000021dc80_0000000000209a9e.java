import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        processQueries();
    }

    private static void processQueries() {
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int[] array = new int[arraySize];
            
            for (int j = 0; j < arraySize; j++) {
                System.out.println(j + 1);
                System.out.flush();
                array[j] = scanner.nextInt();
            }
            
            for (int digit : array) {
                System.out.print(digit);
            }
            System.out.println();
            System.out.flush();
            
            String result = scanner.next();
            if (result.equals("N")) {
                break;
            }
        }
    }
}