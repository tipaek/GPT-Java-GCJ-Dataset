import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int k = 1; k <= t; k++) {
            StringBuilder sb = new StringBuilder();

            String[] s_n = bf.readLine().trim().split(" ");
            int x = Integer.parseInt(s_n[0]);
            int y = Integer.parseInt(s_n[1]);
            String direc = s_n[2];
            int count = findAns(x, y , direc);
            if(count==-1)
                System.out.println("Case #"+k+": IMPOSSIBLE");
            else
                System.out.println("Case #"+k+": "+count+sb.toString());

        }

    }
   public static int findAns(int x, int y, String direction){
        int n = direction.length();
        int count = -1;
        for(int i=1;i<=n;i++){
            // at any step if mod(x)+mod(y) == i
            if(direction.charAt(i-1)=='N')
                y = y+1;
            if(direction.charAt(i-1)=='S')
                y = y-1;
            if(direction.charAt(i-1)=='E')
                x = x+1;
            if(direction.charAt(i-1)=='W')
                x = x-1;
            if(Math.abs(x)+Math.abs(y)<=i) {
                count = i;
                break;
            }
        }
        return count;
   }
}
