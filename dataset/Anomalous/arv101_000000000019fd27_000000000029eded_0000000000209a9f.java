import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        
        for (int q = 1; q <= T; q++) {
            String line = in.readLine();
            int[] numbers = new int[line.length()];
            
            for (int i = 0; i < line.length(); i++) {
                numbers[i] = Character.getNumericValue(line.charAt(i));
            }
            
            StringBuilder answer = new StringBuilder();
            for (int num : numbers) {
                answer.append("(".repeat(num)).append(num).append(")".repeat(num));
            }
            
            boolean continueProcessing = true;
            while (continueProcessing) {
                continueProcessing = false;
                for (int i = 0; i < answer.length() - 1; i++) {
                    if (answer.charAt(i) == ')' && answer.charAt(i + 1) == '(') {
                        answer.delete(i, i + 2);
                        continueProcessing = true;
                        break;
                    }
                }
            }
            
            System.out.println(answer);
        }
    }
}