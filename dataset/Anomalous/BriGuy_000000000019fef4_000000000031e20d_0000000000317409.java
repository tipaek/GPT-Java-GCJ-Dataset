import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(in.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            String tour = st.nextToken();
            
            boolean possible = false;
            
            for (int i = 0; i < tour.length(); i++) {
                char direction = tour.charAt(i);
                switch (direction) {
                    case 'N': Y++; break;
                    case 'S': Y--; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                }
                
                if (Math.abs(X) + Math.abs(Y) <= i + 1) {
                    System.out.println("Case #" + t + ": " + (i + 1));
                    possible = true;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}