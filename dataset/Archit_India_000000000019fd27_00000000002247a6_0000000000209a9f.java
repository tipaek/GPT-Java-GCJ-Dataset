import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        //System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();sc.nextLine();
        for(int i=1;i<=t;i++)
        {
            String s=sc.nextLine();
            char[] stack=new char[200];int top=-1;
            int[] ele=new int[200];
            int tt=-1;                    
              int n=Integer.parseInt(""+s.charAt(0));
              ele[++tt]=n;
              for(int k=0;k<n;k++)
               stack[++top]='(';
              
              stack[++top]=s.charAt(0);
              
              for(int k=0;k<n;k++)
               stack[++top]=')';    
            
            
            for(int j=1;j<s.length();j++)
            {
                
            int a=Integer.parseInt(""+s.charAt(j));            
            if(a==0)
            {            
                stack[++top]='0';ele[++tt]=0;
            }
            else if(a<=ele[tt])    
            {
            stack[top-(a-1)]=s.charAt(j);
            stack[++top]=')';            
            }           
            else
            {
            ele[++tt]=a;
              for(int k=0;k<a;k++)
                stack[++top]='(';
              stack[++top]=s.charAt(j);
              for(int k=0;k<a;k++)
                stack[++top]=')';                
            }
            
            }
            
           String ans="";
            for(int j=0;j<=top;j++)
            ans+=stack[j];
            System.out.println("Case #"+i+": "+ans);
        }
    }
}