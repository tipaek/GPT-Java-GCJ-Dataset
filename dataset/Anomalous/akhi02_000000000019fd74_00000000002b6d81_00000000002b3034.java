import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int arraySize = scanner.nextInt();
            String[] strings = new String[arraySize];
            
            for (int i = 0; i < arraySize; i++) {
                strings[i] = scanner.next();
            }
        }
        
        scanner.close();
    }
}