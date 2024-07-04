import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            int[] array = new int[size];
            
            for (int j = 0; j < size; j++) {
                System.out.println(j + 1);
                System.out.flush();
                array[j] = scanner.nextInt();
            }
            
            StringBuilder result = new StringBuilder();
            for (int value : array) {
                if (value == 1) {
                    result.append("1");
                } else {
                    result.append("0");
                }
            }
            
            System.out.println(result);
            System.out.flush();
            
            char response = scanner.next().charAt(0);
            if (response == 'N') {
                break;
            }
        }
        
        scanner.close();
    }
}