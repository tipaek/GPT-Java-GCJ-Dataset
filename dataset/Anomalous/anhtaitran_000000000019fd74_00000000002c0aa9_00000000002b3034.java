import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }
            
            int[][] pointers = new int[n][2];
            for (int i = 0; i < n; i++) {
                pointers[i][0] = 0;
                pointers[i][1] = strings[i].length() - 1;
            }
            
            boolean continueProcessing = true;
            StringBuilder resultFront = new StringBuilder();
            boolean isInvalid = false;
            String endString = "";
            boolean isEnd = false;
            
            // Traverse from front
            while (continueProcessing) {
                continueProcessing = false;
                char previousChar = ' ';
                
                for (int i = 0; i < n; i++) {
                    if (pointers[i][0] > strings[i].length() - 1) {
                        isEnd = true;
                        endString = strings[i];
                        continue;
                    }
                    
                    char currentChar = strings[i].charAt(pointers[i][0]);
                    if (currentChar == '*') continue;
                    
                    if (previousChar != ' ' && previousChar != currentChar) {
                        isInvalid = true;
                        break;
                    }
                    
                    pointers[i][0]++;
                    continueProcessing = true;
                    previousChar = currentChar;
                }
                
                if (isInvalid) break;
                if (previousChar != ' ') resultFront.append(previousChar);
            }
            
            if (isInvalid) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }
            
            continueProcessing = true;
            isInvalid = false;
            StringBuilder resultBack = new StringBuilder();
            
            // Traverse from back
            while (continueProcessing) {
                continueProcessing = false;
                char previousChar = ' ';
                
                for (int i = 0; i < n; i++) {
                    if (pointers[i][1] <= pointers[i][0]) continue;
                    
                    char currentChar = strings[i].charAt(pointers[i][1]);
                    if (currentChar == '*') continue;
                    
                    if (previousChar != ' ' && previousChar != currentChar) {
                        isInvalid = true;
                        break;
                    }
                    
                    pointers[i][1]--;
                    continueProcessing = true;
                    previousChar = currentChar;
                }
                
                if (isInvalid) break;
                if (previousChar != ' ') resultBack.insert(0, previousChar);
            }
            
            if (isInvalid) {
                System.out.println("Case #" + (t + 1) + ": *");
                continue;
            }
            
            StringBuilder resultMiddle = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = pointers[i][0]; j <= pointers[i][1]; j++) {
                    char currentChar = strings[i].charAt(j);
                    if (currentChar != '*') {
                        resultMiddle.append(currentChar);
                    }
                }
            }
            
            String result;
            if (isEnd) {
                result = endString;
            } else {
                result = resultFront.toString() + resultMiddle.toString() + resultBack.toString();
            }
            
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        
        scanner.close();
    }
}