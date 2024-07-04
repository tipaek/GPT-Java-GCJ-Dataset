import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            String moves = tokenizer.nextToken();
            
            boolean reached = false;
            int distance = 0;
            int steps = 0;
            
            for (steps = 0; steps < moves.length(); steps++) {
                char move = moves.charAt(steps);
                switch (move) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                
                distance = Math.abs(x) + Math.abs(y);
                if (steps + 1 >= distance) {
                    reached = true;
                    break;
                }
            }
            
            System.out.print("Case #" + testCase + ": ");
            System.out.println(reached ? (steps + 1) : "IMPOSSIBLE");
        }
    }
}