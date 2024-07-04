import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            char[] directions = tokenizer.nextToken().toCharArray();
            
            boolean reached = false;
            writer.print("Case #" + caseNumber + ": ");
            
            for (int i = 0; i < directions.length; i++) {
                switch (directions[i]) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                }
                
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    writer.println(i + 1);
                    reached = true;
                    break;
                }
            }
            
            if (!reached) {
                writer.println("IMPOSSIBLE");
            }
        }
        
        reader.close();
        writer.close();
    }
}