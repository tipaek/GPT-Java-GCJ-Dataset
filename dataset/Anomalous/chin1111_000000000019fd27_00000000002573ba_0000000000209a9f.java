import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= numberOfTestCases; i++) {
            if (i > 1) {
                System.out.println();
            }
            
            String input = br.readLine().trim();
            StringBuilder output = new StringBuilder();
            boolean isStart = false;
            
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                
                if (currentChar == '1') {
                    if (!isStart) {
                        output.append('(').append(currentChar);
                        isStart = true;
                    } else {
                        output.append(currentChar);
                    }
                } else {
                    if (isStart) {
                        output.append(')');
                        isStart = false;
                    }
                    output.append(currentChar);
                }
            }
            
            if (isStart) {
                output.append(')');
            }
            
            System.out.print("Case #" + i + ": " + output);
        }
    }
}