import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int arraySize = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int[] array = new int[arraySize];
            int index = 1;
            
            while (index <= 100) {
                System.out.println(index);
                array[index - 1] = scanner.nextInt();
                
                if (index == arraySize) {
                    System.out.println(Arrays.toString(array));
                    char response = scanner.next().charAt(0);
                    if (response == 'N') {
                        System.exit(0);
                    }
                }
                index++;
            }
        }
    }
}