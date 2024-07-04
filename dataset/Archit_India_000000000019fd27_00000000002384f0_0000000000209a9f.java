import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
      // System.out.println();
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();sc.nextLine();
        for(int i=1;i<=t;i++)
        {
            String s=sc.nextLine();
            char[] stack=new char[2000];int top=-1;
            int ele;                  
              int n=Integer.parseInt(""+s.charAt(0));
              ele=n;
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
                stack[++top]='0';ele=0;
            }
            
            else if(a<=ele)    
            {
            stack[top-(a-1)]=s.charAt(j);
            stack[++top]=')';   ele=a;         
            }           
            else
            {
            ele=a;
              for(int k=0;k<a;k++)
                stack[++top]='(';
              stack[++top]=s.charAt(j);
              for(int k=0;k<a;k++)
                stack[++top]=')';                
            }
            
           // System.out.println(Arrays.toString(stack));
            }
            
            
           char[] stack2=new char[top+1];int tpp=0;stack2[tpp]=stack[0];
            
           for(int j=1;j<=top;j++)
           {
               if(stack2[tpp]==')' && stack[j]=='(')
               tpp--;
               else
               stack2[++tpp]=stack[j];                       
            }
           
            
           String ans="";
            for(int j=0;j<=top;j++)
            {
                ans+=stack2[j];}
            System.out.println("Case #"+i+": "+ans);
        }
    }
}