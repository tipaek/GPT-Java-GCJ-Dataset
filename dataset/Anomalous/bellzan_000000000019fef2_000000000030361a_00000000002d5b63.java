import java.util.*;
import java.io.*;

public class Solution {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer(reader.readLine());
        
        int T = Integer.parseInt(tokenizer.nextToken());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < T; i++) {
            boolean foundCenter = false;

            for (int j = 0; j < 121; j++) {
                int x = j / 11 - 5;
                int y = j % 11 - 5;
                
                System.out.println(x + " " + y);
                System.out.flush();
                
                tokenizer = new StringTokenizer(reader.readLine());
                String verdict = tokenizer.nextToken();
                
                if (verdict.equals("CENTER")) {
                    foundCenter = true;
                    break;
                }
            }
        }
    }
}