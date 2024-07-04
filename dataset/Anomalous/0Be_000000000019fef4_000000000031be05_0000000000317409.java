import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();
        
        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");
            
            String[] input = reader.readLine().split("\\s+");
            int X = Integer.parseInt(input[0]);
            int Y = Integer.parseInt(input[1]);
            char[] moves = input[2].toCharArray();
            
            int result = -1;
            for (int i = 0; i < moves.length; i++) {
                if (Math.abs(X) + Math.abs(Y) <= i) {
                    result = i;
                    break;
                }
                switch (moves[i]) {
                    case 'N': Y++; break;
                    case 'S': Y--; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                }
            }
            
            if (result == -1 && Math.abs(X) + Math.abs(Y) <= moves.length) {
                result = moves.length;
            }
            
            if (result == -1) {
                output.append("IMPOSSIBLE");
            } else {
                output.append(result);
            }
            
            output.append('\n');
        }
        
        writer.print(output);
        reader.close();
        writer.close();
    }
}