import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int i_t = 1; i_t <= t; i_t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String directions = input[2];
            
            int steps = 0;
            boolean found = false;
            
            for (int i = 0; i < directions.length(); i++) {
                int distance = Math.abs(x) + Math.abs(y);
                
                if (distance <= i) {
                    steps = i;
                    found = true;
                    break;
                }
                
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
            }
            
            if (found) {
                System.out.println("Case #" + i_t + ": " + steps);
            } else {
                int finalDistance = Math.abs(x) + Math.abs(y);
                if (finalDistance <= directions.length()) {
                    System.out.println("Case #" + i_t + ": " + directions.length());
                } else {
                    System.out.println("Case #" + i_t + ": IMPOSSIBLE");
                }
            }
        }
    }
}