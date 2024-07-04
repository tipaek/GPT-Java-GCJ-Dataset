import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        
        int testCases = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);
        
        for (int t = 1; t <= testCases; t++) {
            boolean hitFound = false;
            
            for (int i = -50; i <= 50 && !hitFound; i++) {
                for (int j = -50; j <= 50 && !hitFound; j++) {
                    System.out.println((x - i) + " " + (y - j));
                    String response = reader.readLine();
                    
                    if (response.equalsIgnoreCase("HIT")) {
                        System.out.println(i + " " + j);
                        hitFound = true;
                    }
                }
            }
            
            reader.readLine(); // Read the remaining input for the current test case
        }
    }
}