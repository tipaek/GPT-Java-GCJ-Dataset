import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            writer.print("Case #" + caseNum + ": ");
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String directions = tokenizer.nextToken();
            boolean reached = false;
            
            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'S': y--; break;
                    case 'W': x--; break;
                }
                
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    reached = true;
                    writer.println(i + 1);
                    break;
                }
            }
            
            if (!reached) {
                writer.println("IMPOSSIBLE");
            }
        }
        
        writer.flush();
        writer.close();
    }
}