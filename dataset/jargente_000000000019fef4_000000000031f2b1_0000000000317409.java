import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            String path = in.nextLine();
            path = path.substring(0, path.length()-1);
            char[] movements= path.toCharArray();
            int minutes = x;
            if(minutes <= movements.length) {
                for (int j = 0; j < x; j++)
                    y = movements[j] == 'N' ? y + 1 : y - 1;
                while (Math.abs(y) > 0 && minutes < movements.length) {
                    if (y > 0)
                        y = Math.max(movements[minutes] == 'N' ? y : y - 2, 0);
                    else
                        y = Math.min(movements[minutes] == 'N' ? y + 2 : y, 0);
                    minutes++;
                }
                String result = (y == 0) ? "" + minutes : "IMPOSSIBLE";
                System.out.println("Case #" + i + ": " + result);
            }else
                System.out.println("Case #" + i + ": IMPOSSIBLE");
        }
    }

}


