import java.util.*;

public class Solution {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int s = in.nextInt();
            int n = r * s;
            int tr = r;
            int ans = (s-1) * (r - 1);
            System.out.println("Case #"+i+": "+ans);
            while(n > s){
                int tn = n+1;
                
                for(int j = 1;j < s;j++){
                    tn--;
                    System.out.print(tn-tr);
                    System.out.print(" ");
                    System.out.println(tr-1);
                }
                tr--;
                n -= s;
            }
            
           
        }
        in.close();
    }
}