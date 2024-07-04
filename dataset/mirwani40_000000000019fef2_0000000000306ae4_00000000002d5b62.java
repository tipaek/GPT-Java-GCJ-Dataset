import java.util.Scanner;

public class Solution {

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            String result="";int j;String fresult="";
            int e=0,w=0,n=0,s=0;
            int sum=0;
            int x=sc.nextInt();
            int y=sc.nextInt();
            sum=x+y;
            if(sum%2==0)
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else
            { j=1;int x1=x; int y1=y;int flag1=0;int flag2=0;
            if(x<0)
                x=0-x;
            if(y<0)
                y=0-y;
                if(y==0)
                flag1=1;
                if(x==0)
                flag2=1;
                 while(flag1==0 || flag2==0)
                 { if(flag1==0 && n+j-s==y)
                   {result=result+"N";flag1=1;
                     
                   }
                 else if(flag2==0 && e+j-w==x) {
                     result=result+"E";flag2=1;
                 } else if(x%2==0 && flag1==0)
                 {
                     if(n+j-s==y)
                     {result=result+"N";flag1=1;}
                     else if(n+j+(2*j)-s+x<=y)
                     { n=n+j;result=result+"N";}
                     else
                     {s=s+j;result=result+"S";}
                 }
                 else if(flag2==0)
                 {
                     if(e+j-w==x)
                     {result=result+"E";flag2=1;}
                     if(e+j+(2*j)-w+y<=x)
                     {
                         e=e+j;result=result+"E";}
                     else
                     {
                         w=w+j;result=result+"W";}
                 }
                 else {
                     result=result+"E";flag2=1;
                 }
                 if(j>=65536)
                 {
                     result="IMPOSSIBLE";break;
                 }
                
                 j=j*2;
                             }
                 if(x1<0)
                 {
                     for(int k=0;k<result.length();k++)
                     {
                         if(result.charAt(k)=='E')
                             fresult=fresult+'W';
                         else if(result.charAt(k)=='W')
                             fresult+='E';
                         else
                             fresult+=result.charAt(k);
                     }
                     result=fresult; fresult="";}
                     
                 
            if(y1<0)
                 {
                     for(int k=0;k<result.length();k++)
                     {
                         if(result.charAt(k)=='N')
                             fresult=fresult+'S';
                         else if(result.charAt(k)=='S')
                             fresult+='N';
                         else
                             fresult+=result.charAt(k);
                     }
                     result=fresult; }
                     
                 }
            
            System.out.println("Case #"+(i+1)+": "+result);
        }
    }
    
}
