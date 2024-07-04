import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 0;
        
        while (t-- > 0) {
            caseNumber++;
            int n = sc.nextInt();
            String[] arr = new String[n];
            int maxLength = 0;
            String longestString = "";
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
                int length = arr[i].length();
                if (length > maxLength) {
                    maxLength = length;
                    longestString = arr[i];
                }
            }
            
            String result = longestString.substring(1);
            int matchCount = 0;
            
            for (String s : arr) {
                if (longestString.contains(s)) {
                    matchCount++;
                }
            }
            
            if (matchCount == n) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }
        }
        
        sc.close();
    }
}