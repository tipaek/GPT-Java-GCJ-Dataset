import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);
        
        for (int h = 1; h <= t; h++) {
            for (int p = -50; p <= 50; p++) {
                for (int l = -50; l <= 50; l++) {
                    System.out.println((1000000000 - p) + " " + (1000000000 - l));
                    String response = br.readLine();
                    if ("HIT".equalsIgnoreCase(response)) {
                        System.out.println(p + " " + l);
                    }
                }
            }
            br.readLine(); // read the final input for the test case
        }
    }
}