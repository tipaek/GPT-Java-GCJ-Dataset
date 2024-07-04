import java.util.*;
public class Solution {
    public static void main(String rpn[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        A:for(int i=1;i<=t;i++) {
            String s0=sc.next();
            String s1="";
            B:for(int x=0;x<s0.length();) {
                boolean temp=true;
                int y=s0.charAt(x)-'0';
                for(int z=0;z<y;z++)
                    s1+="(";
                s1+=y;
                C:for(int z=x+1;z<s0.length();z++) {
                    if(s0.charAt(x)!=s0.charAt(z)) {
                        //x++;
                        break C;
                    }
                    else {
                        s1+=s0.charAt(z);
                        x=z;
                        //temp=false;
                    }
                }
                for(int z=0;z<y;z++)
                    s1+=")";
                if(temp)
                    x++;
            }
            System.out.println("Case #"+(i)+": "+s1);
        }
        /*char ch='5';
        int y=ch-'0';
        System.out.println(y);*/
    }
}