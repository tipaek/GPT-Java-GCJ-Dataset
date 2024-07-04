import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T,i,j,k,d,d_old,cnt;
        String S,newS;
        T=Integer.parseInt(sc.nextLine());
        for(i=1;i<=T;i++)
        {
            S=sc.nextLine();
            newS=""; d_old=0; cnt=0;
            for(j=0;j<S.length();j++,d_old=d)
            {
                d=Integer.parseInt(S.charAt(j)+"");
                for(k=0;k<d-d_old;k++,cnt++) newS+="(";
                for(k=0;k<d_old-d;k++,cnt--) newS+=")";
                newS+=d;
            }
            for(k=0;k<cnt;k++) newS+=")";
            System.out.println("Case #"+i+": "+newS);
        }
    }
}