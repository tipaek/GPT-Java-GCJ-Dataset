import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = scanner.nextInt();
            String[] strings = new String[N];
            int maxLength = 0;
            int maxLengthIndex = 0;
            
            for (int i = 0; i < N; i++) {
                strings[i] = scanner.next();
                if (strings[i].length() > maxLength) {
                    maxLength = strings[i].length();
                    maxLengthIndex = i;
                }
            }
            
            boolean isValid = true;
            for (int i = 0; i < N; i++) {
                String substring = strings[i].substring(1);
                if (!strings[maxLengthIndex].contains(substring)) {
                    isValid = false;
                    break;
                }
            }
            
            String result = "*";
            if (isValid) {
                result = strings[maxLengthIndex].substring(1);
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
        
        scanner.close();
    }
}