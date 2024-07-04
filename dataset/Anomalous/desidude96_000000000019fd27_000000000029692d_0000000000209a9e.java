import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while (true) {
            int numCases = scanner.nextInt();
            int arraySize = scanner.nextInt();
            int[] array = new int[arraySize];
            
            for (int i = 0; i < numCases; i++) {
                fillArray(array, scanner);
                StringBuilder result = new StringBuilder();
                
                for (int j = 0; j < array.length; j++) {
                    result.append(array[j]);
                }
                
                System.out.println(result.toString());
                
                if (scanner.next().equals("N")) {
                    break;
                }
            }
        }
    }

    private static void fillArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + 1);
            array[i] = scanner.nextInt();
        }
    }
}