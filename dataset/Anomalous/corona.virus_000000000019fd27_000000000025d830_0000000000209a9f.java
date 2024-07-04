import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int T = Integer.parseInt(br.readLine());
            int caseNumber = 1;
            
            while (T-- > 0) {
                String input = br.readLine();
                bw.write("Case #" + caseNumber + ": " + processInput(input));
                if (T > 0) {
                    bw.newLine();
                }
                caseNumber++;
            }
        }
    }
    
    private static String processInput(String input) {
        StringBuilder result = new StringBuilder();
        int openBrackets = 0;
        
        for (char c : input.toCharArray()) {
            int currentDigit = Character.getNumericValue(c);
            int balance = currentDigit - openBrackets;
            
            while (balance > 0) {
                result.append("(");
                balance--;
            }
            while (balance < 0) {
                result.append(")");
                balance++;
            }
            
            result.append(c);
            openBrackets = currentDigit;
        }
        
        while (openBrackets > 0) {
            result.append(")");
            openBrackets--;
        }
        
        return result.toString();
    }
}