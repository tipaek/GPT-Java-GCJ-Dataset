import java.util.*;
class Solution
{
    private static char[] ans;    
    private static int top=-1,tp=-1;
    private static String[] stack;
    
    public static void main(String[] args)
    {
       //System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
          int X=sc.nextInt();int Y=sc.nextInt();
          ans=new char[100];
          stack=new String[100];
          findNode(0,0,X,Y,1);
          int minl=Integer.MAX_VALUE;String ans="IMPOSSIBLE";
          for(int j=0;j<=tp;j++)
          {             
            int l=stack[j].length();
            if(l<minl)
            {minl=l;ans=stack[j];}    
          }
          
          
             System.out.println("Case #"+i+": "+ans);
             tp=-1;top=-1;
            }            
        }
        
    private static void findNode(int currx,int curry,int tx,int ty,int I)    
    {
    if(currx==tx&&curry==ty)    
    {
    String s="";
        for(int j=0;j<=top;j++)
        s+=ans[j];
        stack[++tp]=s;
    return;
    }
    if(currx>100||currx<-100||curry>100||curry<-100)
    return;    
    int units=(int)Math.pow(2,I-1);
    ans[++top]='N';
    findNode(currx,curry+units,tx,ty,I+1);
    top--;
    ans[++top]='S';
    findNode(currx,curry-units,tx,ty,I+1);
    top--;
    ans[++top]='E';
    findNode(currx+units,curry,tx,ty,I+1);
    top--;
    ans[++top]='W';
    findNode(currx-units,curry,tx,ty,I+1);
    top--;
    }    
    }
