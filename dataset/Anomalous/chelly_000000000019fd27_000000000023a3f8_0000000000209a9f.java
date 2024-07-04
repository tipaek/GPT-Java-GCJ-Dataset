import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    
    public static void solve(int testCaseNumber) throws IOException {
        String inputString = nextToken();
        char[] characters = inputString.toCharArray();
        int openParenthesesCount = 0;
        
        System.out.print("Case #" + testCaseNumber + ": ");
        
        for (char ch : characters) {
            int digit = ch - '0';
            
            while (openParenthesesCount > digit) {
                System.out.print(')');
                openParenthesesCount--;
            }
            
            while (openParenthesesCount < digit) {
                System.out.print('(');
                openParenthesesCount++;
            }
            
            System.out.print(digit);
        }
        
        while (openParenthesesCount > 0) {
            System.out.print(')');
            openParenthesesCount--;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException {
        int testCases = readInt();
        
        for (int i = 1; i <= testCases; i++) {
            solve(i);
        }
    }
    
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;

    private static String nextToken() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine().trim());
        }
        return stringTokenizer.nextToken();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}