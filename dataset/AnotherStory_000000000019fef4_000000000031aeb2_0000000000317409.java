import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int ts = 1; ts <= t; ts++) {
            int x = in.nextInt();
            int y = in.nextInt();

            boolean answer = false;

            String path = in.next();

            for(int i = 0; i < path.length(); i++) {
                if(path.charAt(i) == 'S')
                    y--;
                else if(path.charAt(i) == 'N')
                    y++;
                else if(path.charAt(i) == 'E')
                    x++;
                else if(path.charAt(i) == 'W')
                    x--;

                int dist = Math.abs(x) + Math.abs(y);

                if(dist <= (i+1)){
                    System.out.println("Case #" + ts + ": " + (i+1));
                    answer = true;
                    break;
                }
            }

            if(!answer)
                System.out.println("Case #" + ts + ": IMPOSSIBLE");
        }
    }
}