import java.util.*;
class Solution
{

    public static void main(String[] args)
    {
        //System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
          int X=sc.nextInt();int Y=sc.nextInt();String s=sc.next();
          int l=s.length();String ans="IMPOSSIBLE";int[] stack=new int[l];int top=-1;
          if(Math.abs(X)+Math.abs(Y)<=0)
          stack[++top]=1;
          for(int j=0;j<l;j++)
          {
            char c=s.charAt(j);
            if(c=='N')
            Y++;
            else if(c=='S')
            Y--;
            else if(c=='E')
            X++;
            else
            X--;
            
            if(Math.abs(X)+Math.abs(Y)<=j+1)
            {stack[++top]=j+1;}
           }
       
           int min=Integer.MAX_VALUE; 
            for(int j=0;j<=top;j++)
            {
            if(min>stack[j])
            min=stack[j];
            }
            if(top!=-1)
            ans=Integer.toString(min);
            
             System.out.println("Case #"+i+": "+ans);           
            }            
        }
    }
