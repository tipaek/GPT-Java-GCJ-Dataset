import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.next());
        for(int p = 1 ; p <= t ; p++){
            int n = Integer.parseInt(s.next());
            String st[] = new String[n];
            int lon = 0;
            String ans = "";
            for(int i = 0 ; i < n ; i++){
                st[i] = s.next();
                if(st[i].length() > lon){
                lon = st[i].length();
                ans = st[i];
                }
            }
            ans = ans.substring(1,lon);
            lon--;
            int flag = 0;
            for(int i = 0 ; i < n ; i++){
                String demo = st[i];
                int l = st[i].length();
                String sub = demo.substring(1,l);
                String piv = ans.substring(lon-l+1,lon);
                //System.out.println(sub+" "+piv);
                if(!sub.equals(piv)){
                    flag = 1;
                    //System.out.println(flag);
                    break;
                }
            }

            System.out.print("Case #"+p+": ");
            if(flag == 0)
            System.out.println(ans);
            else
            System.out.println("*");
            //int ans = st[i].substring()
        }
    }
}