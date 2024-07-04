import java.sql.SQLOutput;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.next());
        for(int t = 1 ; t <= T ; t++) {
            int x = Integer.parseInt(s.next());
            int y = Integer.parseInt(s.next());

            String tour = s.next();
            //int ans = -1;

            if (x == 0 && y == 0) {
                System.out.print("Case #" + t + ": ");
                System.out.println(0);
                continue;
            }
            int ans = 1000000;
            for (int i = 0; i < tour.length(); i++) {
                char c = tour.charAt(i);

                if (c == 'N')
                    y++;
                else if (c == 'S')
                    y--;
                else if (c == 'E')
                    x++;
                else
                    x--;
                int dist = Math.abs(x) + Math.abs(y);
                if(dist <= (i+1)) {
                    ans = i + 1;
                    break;
                }
            }

            System.out.print("Case #"+t+": ");
            if(ans == 1000000){
                System.out.print("IMPOSSIBLE");
            }else{
                System.out.print(ans);
            }
            System.out.println();
        }
    }
}
