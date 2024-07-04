import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.next());
        for(int p = 1 ; p <= t ; p++){
            int n = Integer.parseInt(s.next());
         System.out.println("Case #"+p+": ");
            if(n <= 500){
                for(int i = 1 ; i <= n ; i++)
                System.out.println(i+" 1");
            }else if(n == 501){
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                for(int i = 3 ; i < n ; i++)
                System.out.println(i+" 1");
            }
        }
    }
}