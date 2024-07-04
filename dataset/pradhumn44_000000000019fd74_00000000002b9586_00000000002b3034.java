import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.next());
        for(int p = 1 ; p <= t ; p++){
            int n = Integer.parseInt(s.next());
            String st[] = new String[n];
            String lt[] = new String[n];
            String rt[] = new String[n];
            int llon = 0,rlon = 0 ;
            String right = "",left="";
            for(int i = 0 ; i < n ; i++){
                st[i] = s.next();
                String splut[] = st[i].split("\\*");

                lt[i] = splut[0]+"*";
                rt[i] = "*"+splut[1];

                if(lt[i].length() > llon){
                llon = lt[i].length();
                left = lt[i];
                }

                if(rt[i].length() > rlon){
                rlon = rt[i].length();
                right = rt[i];
                }
            }
            right = right.substring(1,rlon);
            rlon--;

            //RIGHT
            int flag = 0;
            for(int i = 0 ; i < n ; i++){
                String demo = rt[i];
                int l = rt[i].length();
                String sub = demo.substring(1,l);
                String piv = right.substring(rlon-l+1,rlon);
                //System.out.println(sub+" "+piv);
                if(!sub.equals(piv)){
                    flag = 1;
                    //System.out.println(flag);
                    break;
                }
            }

            //LEFT
            left = left.substring(0,llon-1);
            llon--;
            //int flag = 0;
            for(int i = 0 ; i < n ; i++){
                String demo = lt[i];
                int l = lt[i].length();
                String sub = demo.substring(0,l-1);
                String piv = left.substring(0,l-1);
                //System.out.println(sub+" "+piv);
                if(!sub.equals(piv)){
                    flag = 1;
                    //System.out.println(flag);
                    break;
                }
            }

            System.out.print("Case #"+p+": ");
            if(flag == 0)
            System.out.println(left+right);
            else
            System.out.println("*");
            //int right = st[i].substring()
        }
    }
}