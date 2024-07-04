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
            path = path.substring(1);
            char[] movements= path.toCharArray();
            int totalMinutes = x+y;
            int j = 0;
            while(totalMinutes > 0 && j <movements.length){
                switch (movements[j]){
                    case 'N' :
                         y++;
                        break;
                    case 'S' :
                         y--;
                        break;
                    case 'E' :
                         x++;
                        break;
                    case 'W' :
                         x--;
                        break;
                }
                j++;
                totalMinutes = Math.abs(x)+Math.abs(y) -j;
            }
            System.out.println("Case #" + i + ": "+((totalMinutes<=0)?""+j:"IMPOSSIBLE"));

        }
    }

}