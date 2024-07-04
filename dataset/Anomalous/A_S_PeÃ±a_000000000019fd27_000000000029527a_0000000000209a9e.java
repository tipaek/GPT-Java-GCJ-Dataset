import java.util.Scanner;

public class Solution {
    
    static final Scanner SCANNER = new Scanner(System.in);
    
    static String processArray(int size) {
        
        int[] array = new int[size];
        int matchIndex = -1;
        int diffIndex = -1;
        int queryCount = 0;
        
        for (int i = 0; i < size / 2; i++) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                if (matchIndex > -1) {
                    System.out.printf("%d", matchIndex);
                    int temp = SCANNER.nextInt();
                    queryCount++;
                    if (array[matchIndex] != temp) {
                        for (int j = 0; j < i; j++) {
                            array[j] = ~array[j];
                            array[size - j - 1] = ~array[size - j - 1];
                        }
                    }
                }
                
                if (diffIndex > -1) {
                    System.out.printf("%d", diffIndex);
                    int temp = SCANNER.nextInt();
                    queryCount++;
                    if (array[diffIndex] != temp) {
                        for (int j = 0; j < i; j++) {
                            int tempValue = array[j];
                            array[j] = array[size - j - 1];
                            array[size - j - 1] = tempValue;
                        }
                    }
                }
                
                if (queryCount % 2 == 1) {
                    System.out.printf("%d", diffIndex);
                    SCANNER.nextInt();
                }
            }
            
            System.out.printf("%d", i);
            array[i] = SCANNER.nextInt();
            
            System.out.printf("%d", size - i - 1);
            array[size - i - 1] = SCANNER.nextInt();
            
            if (matchIndex < 0 && array[i] == array[size - i - 1]) {
                matchIndex = i;
            } else if (diffIndex < 0 && array[i] != array[size - i - 1]) {
                diffIndex = i;
            }
            
            queryCount += 2;
        }
        
        StringBuilder result = new StringBuilder(size);
        for (int value : array) {
            result.append(value);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        int size = SCANNER.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String result = processArray(size);
            System.out.printf("Case #%d: %s\n", i, result);
            String response = SCANNER.next();
            if (response.equals("N")) {
                System.exit(1);
            }
        }
        
        SCANNER.close();
    }
}