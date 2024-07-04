import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Solution {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer data = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(data.nextToken());
        int b = Integer.parseInt(data.nextToken());
        for (int i = 0; i < t; i++) {
            StringBuilder binStr = new StringBuilder("");
            for (int j = 0; j < 10; j++) {
                System.out.println(j + 1);
                System.out.flush();
                binStr.append(in.readLine());
            }
            System.out.println(binStr);
            System.out.flush();
            String answer = in.readLine();
            if (answer.equals("N")) System.exit(0);
        }
        
    }
    
}
