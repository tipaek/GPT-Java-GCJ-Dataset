import java.util.*;

public class Solution{
    public static void main(String ard[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            String n=sc.next(),res="";
            int c=0;
            int diff=0;
            for(int i=0;i<n.length();i++){
                diff=n.charAt(i)-48-c;
                if(diff>=0)
                    for(int j=0;j<diff;j++)
                        res+="(";
                else
                    for(int j=0;j<-diff;j++)
                        res+=")";
                res+=n.charAt(i);
                c=n.charAt(i)-48;
            }
            for(int j=0;j<n.charAt(n.length()-1)-48;j++)
                        res+=")";
            System.out.println("Case #"+tt+": "+res);
        }
    }
}