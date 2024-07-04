import java.util.*;

class Solution{
    
    
    
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        s.nextLine();
        for(int i=0;i<t;i++)
        {
            String input=s.nextLine();
            int x=input.charAt(0)-'0';
            String ans="";
            for(int j=0;j<x;j++)
            {
                ans+="(";
            }
            ans+=input.charAt(0);
            for(int j=1;j<input.length();j++)
            {
                if(input.charAt(j-1)==input.charAt(j))
                {
                    ans+=input.charAt(j);
                }
                else if(input.charAt(j-1)-'0' > input.charAt(j)-'0')
                {
                    int y=(input.charAt(j-1)-'0')-(input.charAt(j)-'0');
                    while(y>0)
                    {
                        ans+=")";
                        y--;
                    }
                    ans+=input.charAt(j);
                }
                else if(input.charAt(j-1)-'0' < input.charAt(j)-'0')
                {
                    int y=(input.charAt(j)-'0')-(input.charAt(j-1)-'0');
                    while(y>0)
                    {
                       ans+="(";
                       y--;
                    }
                      ans+=input.charAt(j);
                }
            }
            int count=0;
            for(int j=0;j<ans.length();j++)
            {
                if(ans.charAt(j)=='(')
                {
                    count++;
                }
                else if(ans.charAt(j)==')')
                {
                    count--;
                }
            }
            for(int j=0;j<count;j++)
            {
                ans+=')';
            }
            int caseNum=i+1;
            System.out.println("Case #" + caseNum + ":" + " "+ ans);
        }
        
        
    }
}