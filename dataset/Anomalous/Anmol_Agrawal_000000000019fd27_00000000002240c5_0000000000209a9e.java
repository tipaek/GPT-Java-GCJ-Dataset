import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            StringBuilder result = new StringBuilder();
            int queryCount = 1;
            int currentIndex = 1;
            
            while (result.length() < bitLength) {
                System.out.println(currentIndex);
                String bit = scanner.next();
                
                if (queryCount % 10 != 1) {
                    result.append(bit);
                    currentIndex++;
                }
                queryCount++;
            }
            
            System.out.println(result.toString());
            char response = scanner.next().charAt(0);
            
            if (response != 'Y') {
                System.exit(0);
            }
        }
    }
}