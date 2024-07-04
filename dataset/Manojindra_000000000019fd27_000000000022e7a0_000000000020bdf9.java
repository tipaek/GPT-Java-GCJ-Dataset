import java.io.*;
import java.lang.*;
import java.util.*;
class myclass{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int out=1;
        while(t-->0)
        {
            int n=s.nextInt();
            int c_p=0,j_p=0,c_s=0,j_s=0;
            String str="";
            for(int i=0;i<n;i++)
            {
                int st=s.nextInt();
                int e=s.nextInt();
                String s1;
                boolean flag1=true;
                boolean flag2=true;
                if(st>c_s && st<c_p || e>c_s && e<c_p )
                {
                    //if(e>=c_s && e<=c_p)
                    //{
                     flag1=false;    
                    //}
                }
                if(st>j_s && st<j_p || e>j_s && e<j_p)
                {
                  //  if(e>=j_s && e<=j_p)
                    //{
                     flag2=false;    
                    //}
                }
                if(flag1==true || i==0)
                {
                    s1="C";
                    str=str.concat(s1);
                    //System.out.println(str);
                    c_p=e;
                    c_s=st;
                    
                }
                else  if(flag2==true || i==0)
                {
                    s1="J";
                    str=str.concat(s1);
                    //System.out.println(str);
                    j_p=e;
                    j_s=st;
                }
                else{
                    str="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+out+": "+str);
        }
    }
}
