import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int testCases = Integer.parseInt(tokenizer.nextToken());
        int numBits = Integer.parseInt(tokenizer.nextToken());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringBuilder answerBuilder = new StringBuilder();
            
            for (int bitIndex = 1; bitIndex <= numBits; bitIndex++) {
                System.out.println(bitIndex);
                int bitValue = Integer.parseInt(reader.readLine());
                answerBuilder.append(bitValue);
            }
            
            System.out.println(answerBuilder.toString());
            char result = reader.readLine().charAt(0);
            
            if (result != 'Y') {
                System.exit(0);
            }
        }
    }
}