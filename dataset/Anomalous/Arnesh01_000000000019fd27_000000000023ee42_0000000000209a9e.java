import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        
        for (int t = 1; t <= T; t++) {
            if (B == 10) {
                StringBuilder result = new StringBuilder();
                
                for (int i = 1; i <= B; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int digit = br.readLine().charAt(0) - '0';
                    result.append(digit);
                }
                
                System.out.println(result);
                System.out.flush();
                
                // Read the final character (presumably a response or confirmation)
                br.readLine().charAt(0);
            }
        }
    }
}