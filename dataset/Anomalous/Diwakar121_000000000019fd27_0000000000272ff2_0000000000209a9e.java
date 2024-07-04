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
                array[j] = scanner.nextInt();
            }
            
            StringBuilder binaryString = new StringBuilder();
            for (int j = 0; j < size; j++) {
                if (array[j] == 1) {
                    binaryString.append("1");
                } else {
                    binaryString.append("0");
                }
            }
            
            System.out.println(binaryString);
            
            char nextAction = scanner.next().charAt(0);
            if (nextAction == 'N') {
                break;
            }
        }
        
        scanner.close();
    }
}