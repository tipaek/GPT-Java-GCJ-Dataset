import java.util.*;
import java.io.*;
public class Solution
{
	

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int s=1;
        while(t>0)
        {
            String str=sc.nextLine();
            char ch[]=str.toCharArray();
            int m=str.length(); 
            Stack<String> stack=new Stack<String>();int i=0;
            for(i=0;i<str.length();i++)
            {
                if(stack.empty())
                {
                int j=Character.getNumericValue(ch[i]);
                while(j>0)
                {
                    stack.push("(");
                    j--;
                }
                stack.push("ch[i]");
                }
                else
                {
                    if(ch[i]<ch[i-1])
                    {
                        int k=Character.getNumericValue(ch[i-1])-Character.getNumericValue(ch[i]);
                        while(k>0)
                        {
                            stack.push(")");
                            k--;
                        }
                        stack.push("ch[i]");
                    }
                    else
                    {
                        int p=Character.getNumericValue(ch[i])-Character.getNumericValue(ch[i-1]);
                        while(p>0)
                        {
                            stack.push("(");
                            p--;
                        }
                        stack.push("ch[i]");
                        
                    }
                }
            }
            int l=Character.getNumericValue(ch[m-1]);
            while(l>0)
            {
                stack.push(")");
                l--;
            }
            System.out.println("Case #"+s+": "+stack);
            s++;
            t--;
        }
    }

}